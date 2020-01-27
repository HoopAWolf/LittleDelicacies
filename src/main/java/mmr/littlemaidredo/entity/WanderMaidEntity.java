package mmr.littlemaidredo.entity;

import mmr.littlemaidredo.entity.ai.CustomRangedBowAttackGoal;
import mmr.littlemaidredo.entity.ai.NotInvisibleTargetGoal;
import mmr.littlemaidredo.entity.ai.UseOffhandItemGoal;
import mmr.littlemaidredo.init.LittleEntitys;
import mmr.littlemaidredo.init.MaidTrades;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class WanderMaidEntity extends AbstractVillagerEntity implements IRangedAttackMob {
    @Nullable
    private BlockPos wanderTarget;
    private int despawnDelay;

    public WanderMaidEntity(EntityType<? extends WanderMaidEntity> p_i50185_1_, World p_i50185_2_) {
        super(p_i50185_1_, p_i50185_2_);
        this.forceSpawn = true;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(0, new UseOffhandItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.STRONG_HEALING), SoundEvents.ENTITY_GENERIC_DRINK, (p_213733_1_) -> {
            return this.world.rand.nextFloat() < 0.0052F && this.getHealth() < this.getMaxHealth();
        }));
        this.goalSelector.addGoal(0, new UseOffhandItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.INVISIBILITY), SoundEvents.ENTITY_GENERIC_DRINK, (p_213733_1_) -> {
            return !this.world.isDaytime() && !p_213733_1_.isInvisible();
        }));
        this.goalSelector.addGoal(0, new UseOffhandItemGoal<>(this, new ItemStack(Items.MILK_BUCKET), SoundEvents.ENTITY_GENERIC_DRINK, (p_213736_1_) -> {
            return this.world.isDaytime() && p_213736_1_.isInvisible();
        }));
        this.goalSelector.addGoal(1, new TradeWithPlayerGoal(this));
        this.goalSelector.addGoal(1, new LookAtCustomerGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this,0.5D,true){
            @Override
            public boolean shouldExecute() {
                return !isBowInMainhand() && super.shouldExecute();
            }

            @Override
            public boolean shouldContinueExecuting() {
                return !isBowInMainhand() && super.shouldContinueExecuting();
            }

            protected boolean isBowInMainhand() {
                ItemStack main = getHeldItemMainhand();
                ItemStack off  = getHeldItemOffhand();
                return main.getItem() instanceof BowItem || off.getItem() instanceof BowItem;
            }
        });
        this.goalSelector.addGoal(2, new CustomRangedBowAttackGoal<>(this,0.45D,20,16.0F));
        this.goalSelector.addGoal(2, new MoveToGoal(this, 3.0D, 0.5D));
        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.65D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NotInvisibleTargetGoal<>(this, AbstractIllagerEntity.class, true));
        this.targetSelector.addGoal(3, new NotInvisibleTargetGoal<>(this, VexEntity.class, true));
        this.targetSelector.addGoal(3, new NotInvisibleTargetGoal<>(this, ZombieEntity.class, true));
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(28.0D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.0D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    public boolean func_213705_dZ() {
        return false;
    }

    @Override
    protected void func_213713_b(MerchantOffer p_213713_1_) {
        if (p_213713_1_.func_222221_q()) {
            int i = 3 + this.rand.nextInt(6);
            this.world.addEntity(new ExperienceOrbEntity(this.world, this.posX, this.posY + 0.5D, this.posZ, i));
        }
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("DespawnDelay", this.despawnDelay);
        if (this.wanderTarget != null) {
            compound.put("WanderTarget", NBTUtil.writeBlockPos(this.wanderTarget));
        }

    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("DespawnDelay", 99)) {
            this.despawnDelay = compound.getInt("DespawnDelay");
        }

        if (compound.contains("WanderTarget")) {
            this.wanderTarget = NBTUtil.readBlockPos(compound.getCompound("WanderTarget"));
        }

        this.setGrowingAge(Math.max(0, this.getGrowingAge()));
    }

    public void livingTick() {
        super.livingTick();
        if (!this.world.isRemote) {
            this.func_222821_eh();
        }

    }

    private void func_222821_eh() {
        if (this.despawnDelay > 0 && !this.func_213716_dX() && --this.despawnDelay == 0) {
            this.remove();
        }

    }

    public void setDespawnDelay(int p_213728_1_) {
        this.despawnDelay = p_213728_1_;
    }

    public int getDespawnDelay() {
        return this.despawnDelay;
    }

    public void func_213726_g(@Nullable BlockPos p_213726_1_) {
        this.wanderTarget = p_213726_1_;
    }

    @Nullable
    private BlockPos func_213727_eh() {
        return this.wanderTarget;
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = itemstack.getItem() == Items.NAME_TAG;
        if (flag) {
            itemstack.interactWithEntity(player, this, hand);
            return true;
        } else if (itemstack.getItem() != Items.VILLAGER_SPAWN_EGG && this.isAlive() && !this.func_213716_dX() && !this.isChild()) {
            if (hand == Hand.MAIN_HAND) {
                player.addStat(Stats.TALKED_TO_VILLAGER);
            }

            if (this.getOffers().isEmpty()) {
                return super.processInteract(player, hand);
            } else {
                if (!this.world.isRemote) {
                    this.setCustomer(player);
                    this.func_213707_a(player, this.getDisplayName(), 1);
                }

                return true;
            }
        } else {
            return super.processInteract(player, hand);
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setHeldItem(Hand.MAIN_HAND,new ItemStack(Items.BOW));
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }



    @Override
    protected void populateTradeData() {
        VillagerTrades.ITrade[] avillagertrades$itrade = MaidTrades.field_221240_b.get(1);
        VillagerTrades.ITrade[] avillagertrades$itrade1 = MaidTrades.field_221240_b.get(2);
        if (avillagertrades$itrade != null && avillagertrades$itrade1 != null) {
            MerchantOffers merchantoffers = this.getOffers();
            this.addTrades(merchantoffers, avillagertrades$itrade, 4);
            int i = this.rand.nextInt(avillagertrades$itrade1.length);
            this.addTrades(merchantoffers, avillagertrades$itrade1, 2);
        }
    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return null;
    }

    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        ItemStack itemstack = this.findAmmo(this.getHeldItem(ProjectileHelper.getHandWith(this, Items.BOW)));
        AbstractArrowEntity abstractarrowentity = this.func_213624_b(itemstack, distanceFactor);
        if (this.getHeldItemMainhand().getItem() instanceof BowItem)
            abstractarrowentity = ((BowItem)this.getHeldItemMainhand().getItem()).customeArrow(abstractarrowentity);
        double d0 = target.posX - this.posX;
        double d1 = target.getBoundingBox().minY + (double)(target.getHeight() / 3.0F) - abstractarrowentity.posY;
        double d2 = target.posZ - this.posZ;
        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        abstractarrowentity.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.world.getDifficulty().getId() * 4));
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(abstractarrowentity);
    }

    protected AbstractArrowEntity func_213624_b(ItemStack p_213624_1_, float p_213624_2_) {
        return ProjectileHelper.func_221272_a(this, p_213624_1_, p_213624_2_);
    }

    protected SoundEvent func_213721_r(boolean p_213721_1_) {
        return null;
    }

    public SoundEvent func_213714_ea() {
        return null;
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return target.getType() != LittleEntitys.WANDERMAID && super.canAttack(target);
    }

    class MoveToGoal extends Goal {
        final WanderMaidEntity field_220847_a;
        final double field_220848_b;
        final double field_220849_c;

        MoveToGoal(WanderMaidEntity p_i50459_2_, double p_i50459_3_, double p_i50459_5_) {
            this.field_220847_a = p_i50459_2_;
            this.field_220848_b = p_i50459_3_;
            this.field_220849_c = p_i50459_5_;
            this.setMutexFlags(EnumSet.of(Flag.MOVE));
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.field_220847_a.func_213726_g((BlockPos)null);
            WanderMaidEntity.this.navigator.clearPath();
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute() {
            BlockPos blockpos = this.field_220847_a.func_213727_eh();
            return blockpos != null && this.func_220846_a(blockpos, this.field_220848_b);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            BlockPos blockpos = this.field_220847_a.func_213727_eh();
            if (blockpos != null && WanderMaidEntity.this.navigator.noPath()) {
                if (this.func_220846_a(blockpos, 10.0D)) {
                    Vec3d vec3d = (new Vec3d((double)blockpos.getX() - this.field_220847_a.posX, (double)blockpos.getY() - this.field_220847_a.posY, (double)blockpos.getZ() - this.field_220847_a.posZ)).normalize();
                    Vec3d vec3d1 = vec3d.scale(10.0D).add(this.field_220847_a.posX, this.field_220847_a.posY, this.field_220847_a.posZ);
                    WanderMaidEntity.this.navigator.tryMoveToXYZ(vec3d1.x, vec3d1.y, vec3d1.z, this.field_220849_c);
                } else {
                    WanderMaidEntity.this.navigator.tryMoveToXYZ((double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ(), this.field_220849_c);
                }
            }

        }

        private boolean func_220846_a(BlockPos p_220846_1_, double p_220846_2_) {
            return !p_220846_1_.withinDistance(this.field_220847_a.getPositionVec(), p_220846_2_);
        }
    }
}
