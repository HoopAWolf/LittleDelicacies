package mmr.maidmodredo.client.maidmodel.animal.squrriel;//Made with Blockbench
//Paste this code into your mod.

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mmr.maidmodredo.api.IMaidAnimation;
import mmr.maidmodredo.client.maidmodel.MaidModelRenderer;
import mmr.maidmodredo.client.maidmodel.ModelMultiMMMBase;
import mmr.maidmodredo.entity.LittleMaidBaseEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;

public class ModelSqurrielMaid_Squrrielmaid<T extends LittleMaidBaseEntity> extends ModelMultiMMMBase<T> {
    public MaidModelRenderer Squirrel;
    public MaidModelRenderer head;
    public MaidModelRenderer headFace;
    public MaidModelRenderer Ears;
    public MaidModelRenderer Hair;
    public MaidModelRenderer ahoge;
    public MaidModelRenderer hair;
    public MaidModelRenderer hairheadLayer;
    public MaidModelRenderer lefttail;
    public MaidModelRenderer leftchignon;
    public MaidModelRenderer righttail;
    public MaidModelRenderer rightchignon;
    public MaidModelRenderer backchignon;
    public MaidModelRenderer hairtail;
    public MaidModelRenderer body;
    public MaidModelRenderer Tail;
    public MaidModelRenderer bone2;
    public MaidModelRenderer bone3;
    public MaidModelRenderer bone4;
    public MaidModelRenderer bone5;
    public MaidModelRenderer bone6;
    public MaidModelRenderer skirt;
    public MaidModelRenderer legL;
    public MaidModelRenderer legL2;
    public MaidModelRenderer LegOverlay;
    public MaidModelRenderer legR;
    public MaidModelRenderer legR2;
    public MaidModelRenderer LegOverlay2;
    public MaidModelRenderer handR;
    public MaidModelRenderer handR2;
    public MaidModelRenderer ArmOverlay2;
    public MaidModelRenderer handL;
    public MaidModelRenderer handR4;
    public MaidModelRenderer ArmOverlay3;


    public ModelSqurrielMaid_Squrrielmaid() {
        this(0.0F);
    }

    public ModelSqurrielMaid_Squrrielmaid(float psize) {
        this(psize, 0.0F, 64, 64);
    }

    public ModelSqurrielMaid_Squrrielmaid(float psize, float pyoffset, int pTextureWidth, int pTextureHeight) {
        super(psize, 0.0F, 64, 64);
    }

    @Override
    public void initModel(float psize, float pyoffset) {
        textureWidth = 64;
        textureHeight = 64;

        Squirrel = new MaidModelRenderer(this);
        Squirrel.setRotationPoint(0.0F, 24.0F, 0.0F);

        head = new MaidModelRenderer(this);
        head.setRotationPoint(0.0F, -7.26F, 0.0F);
        Squirrel.addChild(head);
        head.addBox(head, 0, 0, -2.032F, -3.1728F, -2.068F, 4, 4, 4, 0.0F, false);
        head.addBox(head, 0, 13, -2.25F, -4.2F, -2.1F, 4, 1, 0, 0.0F, false);

        headFace = new MaidModelRenderer(this);
        headFace.setRotationPoint(0.0F, 0.4224F, 0.0F);
        head.addChild(headFace);
        headFace.addBox(headFace, 8, 22, -2.032F, -3.5952F, -2.0724F, 4, 4, 0, 0.0F, false);

        Ears = new MaidModelRenderer(this);
        Ears.setRotationPoint(0.0F, 7.26F, 0.0F);
        head.addChild(Ears);
        Ears.addBox(Ears, 0, 0, 1.2F, -11.2F, -1.8F, 1, 1, 1, 0.0F, false);
        Ears.addBox(Ears, 22, 5, -2.15F, -11.2F, -1.8F, 1, 1, 1, 0.0F, false);

        Hair = new MaidModelRenderer(this);
        Hair.setRotationPoint(0.11F, 7.8672F, 0.0F);
        head.addChild(Hair);

        ahoge = new MaidModelRenderer(this);
        ahoge.setRotationPoint(0.0F, -10.7536F, 0.0F);
        setRotationAngle(ahoge, 0.0F, 2.3562F, 0.0F);
        Hair.addChild(ahoge);
        ahoge.addBox(ahoge, 21, 15, -0.4521F, -2.1724F, -0.5582F, 2, 2, 2, 0.0F, false);

        hair = new MaidModelRenderer(this);
        hair.setRotationPoint(0.0F, -7.4448F, 0.0F);
        setRotationAngle(hair, 0.0873F, 0.0F, 0.0F);
        Hair.addChild(hair);
        hair.addBox(hair, 23, 11, -2.032F, 0.5408F, 1.8242F, 4, 4, 0, 0.0F, false);

        hairheadLayer = new MaidModelRenderer(this);
        hairheadLayer.setRotationPoint(0.0F, -7.4448F, 0.0F);
        Hair.addChild(hairheadLayer);
        hairheadLayer.addBox(hairheadLayer, 0, 14, -1.8647F, -2.6114F, -1.8853F, 3, 3, 3, 0.5F, false);

        lefttail = new MaidModelRenderer(this);
        lefttail.setRotationPoint(0.0F, -7.4448F, 0.0F);
        setRotationAngle(lefttail, 0.0F, 0.0F, -0.0873F);
        Hair.addChild(lefttail);
        lefttail.addBox(lefttail, 29, 29, 2.3728F, -2.9873F, -0.4568F, 1, 4, 1, 0.0F, false);

        leftchignon = new MaidModelRenderer(this);
        leftchignon.setRotationPoint(0.0F, -7.4448F, 0.0F);
        Hair.addChild(leftchignon);
        leftchignon.addBox(leftchignon, 5, 34, 1.8816F, -3.4132F, -0.6636F, 0, 2, 2, 0.0F, false);

        righttail = new MaidModelRenderer(this);
        righttail.setRotationPoint(0.0F, -7.4448F, 0.0F);
        setRotationAngle(righttail, 0.0F, 0.0F, 0.0873F);
        Hair.addChild(righttail);
        righttail.addBox(righttail, 18, 28, -3.5812F, -2.9699F, -0.4568F, 1, 4, 1, 0.0F, false);

        rightchignon = new MaidModelRenderer(this);
        rightchignon.setRotationPoint(0.0F, -7.4448F, 0.0F);
        Hair.addChild(rightchignon);
        rightchignon.addBox(rightchignon, 5, 34, -2.668F, -3.4132F, -0.6636F, 0, 2, 2, 0.0F, false);

        backchignon = new MaidModelRenderer(this);
        backchignon.setRotationPoint(0.0F, -7.4448F, 0.0F);
        Hair.addChild(backchignon);
        backchignon.addBox(backchignon, 26, 19, -1.1628F, -3.4132F, 1.8612F, 2, 2, 1, 0.0F, false);

        hairtail = new MaidModelRenderer(this);
        hairtail.setRotationPoint(0.0F, -7.4448F, 0.0F);
        setRotationAngle(hairtail, 0.0873F, 0.0F, 0.0F);
        Hair.addChild(hairtail);
        hairtail.addBox(hairtail, 0, 29, -0.8696F, -3.035F, 2.4816F, 1, 4, 1, 0.0F, false);

        body = new MaidModelRenderer(this);
        body.setRotationPoint(0.0F, -7.04F, 0.0F);
        Squirrel.addChild(body);
        body.addBox(body, 12, 17, -1.514F, 0.31F, -1.042F, 3, 3, 2, 0.0F, false);
        body.addBox(body, 0, 20, -1.264F, 0.31F, -0.792F, 2, 3, 2, 0.0F, false);

        Tail = new MaidModelRenderer(this);
        Tail.setRotationPoint(0.0F, 6.44F, 0.55F);
        setRotationAngle(Tail, -0.0175F, 0.0F, 0.0F);
        body.addChild(Tail);

        bone2 = new MaidModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone2, 0.1745F, 0.0F, 0.0F);
        Tail.addChild(bone2);
        bone2.addBox(bone2, 25, 0, -0.5F, -4.25F, 1.0F, 1, 1, 2, 0.0F, false);

        bone3 = new MaidModelRenderer(this);
        bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone3, 0.6981F, 0.0F, 0.0F);
        Tail.addChild(bone3);
        bone3.addBox(bone3, 20, 20, -1.0F, -2.3687F, 4.0712F, 2, 2, 2, 0.0F, false);

        bone4 = new MaidModelRenderer(this);
        bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone4, 1.0996F, 0.0F, 0.0F);
        Tail.addChild(bone4);
        bone4.addBox(bone4, 13, 5, -1.5F, -0.825F, 5.7517F, 3, 3, 3, 0.0F, false);

        bone5 = new MaidModelRenderer(this);
        bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone5, 1.309F, 0.0F, 0.0F);
        Tail.addChild(bone5);
        bone5.addBox(bone5, 11, 11, -1.5F, 0.8926F, 8.0837F, 3, 3, 3, 0.0F, false);

        bone6 = new MaidModelRenderer(this);
        bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone6, 1.309F, 0.0F, 0.0F);
        Tail.addChild(bone6);
        bone6.addBox(bone6, 12, 0, -1.0F, 1.6398F, 10.2903F, 2, 2, 1, 0.0F, false);

        skirt = new MaidModelRenderer(this);
        skirt.setRotationPoint(0.0F, -4.18F, 0.11F);
        Squirrel.addChild(skirt);
        skirt.addBox(skirt, 16, 0, -1.742F, -0.084F, -1.334F, 3, 2, 3, 0.0F, false);
        skirt.addBox(skirt, 0, 8, -2.242F, 1.666F, -1.634F, 4, 2, 3, 0.0F, false);

        legL = new MaidModelRenderer(this);
        legL.setRotationPoint(0.44F, -3.96F, 0.0F);
        Squirrel.addChild(legL);

        legL2 = new MaidModelRenderer(this);
        legL2.setRotationPoint(0.0F, 0.0F, 0.0F);
        legL.addChild(legL2);
        legL2.addBox(legL2, 24, 26, -0.404F, 0.004F, -0.792F, 1, 2, 2, 0.0F, false);
        legL2.addBox(legL2, 6, 26, -0.404F, 2.004F, -0.792F, 1, 2, 2, 0.0F, false);

        LegOverlay = new MaidModelRenderer(this);
        LegOverlay.setRotationPoint(-0.44F, 3.96F, 0.0F);
        legL2.addChild(LegOverlay);
        LegOverlay.addBox(LegOverlay, 0, 25, -0.114F, -3.956F, -1.042F, 1, 2, 2, 0.0F, false);
        LegOverlay.addBox(LegOverlay, 16, 22, -0.114F, -1.956F, -1.042F, 1, 2, 2, 0.0F, false);

        legR = new MaidModelRenderer(this);
        legR.setRotationPoint(-0.44F, -3.96F, 0.0F);
        Squirrel.addChild(legR);

        legR2 = new MaidModelRenderer(this);
        legR2.setRotationPoint(0.0F, 0.0F, 0.0F);
        legR.addChild(legR2);
        legR2.addBox(legR2, 26, 22, -0.822F, 0.004F, -0.792F, 1, 2, 2, 0.0F, false);
        legR2.addBox(legR2, 12, 26, -0.822F, 2.004F, -0.792F, 1, 2, 2, 0.0F, false);

        LegOverlay2 = new MaidModelRenderer(this);
        LegOverlay2.setRotationPoint(0.44F, 3.96F, 0.0F);
        legR2.addChild(LegOverlay2);
        LegOverlay2.addBox(LegOverlay2, 25, 5, -1.386F, -3.956F, -1.042F, 1, 2, 2, 0.0F, false);
        LegOverlay2.addBox(LegOverlay2, 20, 24, -1.386F, -1.956F, -1.042F, 1, 2, 2, 0.0F, false);

        handR = new MaidModelRenderer(this);
        handR.setRotationPoint(-1.32F, -6.39F, 0.0F);
        setRotationAngle(handR, 0.0F, 0.0F, 0.2618F);
        Squirrel.addChild(handR);
        handR.addBox(handR, 22, 30, -0.6888F, -0.0755F, -0.396F, 1, 2, 1, 0.0F, false);

        handR2 = new MaidModelRenderer(this);
        handR2.setRotationPoint(0.132F, 0.638F, 0.0F);
        handR.addChild(handR2);
        handR2.addBox(handR2, 4, 30, -0.8208F, 0.8705F, -0.396F, 1, 2, 1, 0.0F, false);

        ArmOverlay2 = new MaidModelRenderer(this);
        ArmOverlay2.setRotationPoint(1.298F, 5.94F, 0.0F);
        handR.addChild(ArmOverlay2);
        ArmOverlay2.addBox(ArmOverlay2, 29, 3, -2.1373F, -5.9585F, -0.646F, 1, 2, 1, 0.0F, false);
        ArmOverlay2.addBox(ArmOverlay2, 25, 9, -2.1373F, -3.5585F, -0.646F, 1, 1, 1, 0.0F, false);

        handL = new MaidModelRenderer(this);
        handL.setRotationPoint(1.32F, -6.49F, 0.0F);
        setRotationAngle(handL, 0.0F, 0.0F, -0.2618F);
        Squirrel.addChild(handL);
        handL.addBox(handL, 22, 30, -0.3112F, -0.0755F, -0.396F, 1, 2, 1, 0.0F, true);

        handR4 = new MaidModelRenderer(this);
        handR4.setRotationPoint(-0.132F, 0.638F, 0.0F);
        handL.addChild(handR4);
        handR4.addBox(handR4, 4, 30, -0.1792F, 0.8705F, -0.396F, 1, 2, 1, 0.0F, true);

        ArmOverlay3 = new MaidModelRenderer(this);
        ArmOverlay3.setRotationPoint(-1.298F, 5.94F, 0.0F);
        handL.addChild(ArmOverlay3);
        ArmOverlay3.addBox(ArmOverlay3, 29, 3, 0.6373F, -5.9585F, -0.646F, 1, 2, 1, 0.0F, true);
        ArmOverlay3.addBox(ArmOverlay3, 25, 9, 0.6373F, -3.5585F, -0.646F, 1, 1, 1, 0.0F, true);
    }

    @Override
    public float getHeight() {
        return 1.55F;
    }

    @Override
    public float getWidth() {
        return 0.6F;
    }

    @Override
    public float getyOffset() {
        return getHeight() * 0.9F;
    }

    @Override
    public float getMountedYOffset() {
        return 0.35F;
    }

    @Override
    public void renderItems(MatrixStack stack, boolean left) {
        if (left) {
            this.handL.setAnglesAndRotation(stack);
        } else {
            this.handR.setAnglesAndRotation(stack);
        }
    }

    @Override
    public float[] getArmorModelsSize() {
        return new float[]{0.1F, 0.5F};
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.Squirrel).forEach((p_228292_8_) -> {
            p_228292_8_.render(matrixStack, iVertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setLivingAnimations(T entity, float par2, float par3, float pRenderPartialTicks) {
        super.setLivingAnimations(entity, par2, par3, pRenderPartialTicks);

        float f3 = entity.ticksExisted + pRenderPartialTicks + entity.entityIdFactor;

        // 目パチ
        if (entity.isSleeping()) {
            headFace.setVisible(false);
        } else if (0 > mh_sin(f3 * 0.05F) + mh_sin(f3 * 0.13F) + mh_sin(f3 * 0.7F) + 2.55F) {
            headFace.setVisible(false);
        } else {
            headFace.setVisible(true);
        }
    }

    @Override
    public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                       float pHeadYaw, float pHeadPitch) {
        setDefaultPause(entity, limbSwing, limbSwingAmount, ageInTicks, pHeadYaw, pHeadPitch);

        if (entity.isPassenger() && (entity.getRidingEntity() != null && entity.getRidingEntity().shouldRiderSit())) {
            // 乗り物に乗っている
            handR.addRotateAngleX(-0.6283185F);
            handL.addRotateAngleX(-0.6283185F);
            legR.setRotateAngleX(-1.256637F);
            legL.setRotateAngleX(-1.256637F);
            legR.setRotateAngleY(0.3141593F);
            legL.setRotateAngleY(-0.3141593F);
//			mainFrame.rotationPointY += 5.00F;
        }

        /*//カスタム設定
        //お座りモーションの場合はモデル側で位置を調整する
        if (motionSitting && entity.isPassenger() && (entity.getRidingEntity() != null && entity.getRidingEntity().shouldRiderSit()) {
            mainFrame.rotationPointY += 5.00F;
        }*/

        if (this.swingProgress > 0.0F) {
            HandSide handside = this.getMainHand(entity);
            MaidModelRenderer modelrenderer = this.getArmForSide(handside);
            float f1 = this.swingProgress;
            this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
            if (handside == HandSide.LEFT) {
                this.body.rotateAngleY *= -1.0F;
            }


            this.handR.rotateAngleY += this.body.rotateAngleY;
            this.handL.rotateAngleY += this.body.rotateAngleY;
            this.handL.rotateAngleX += this.body.rotateAngleY;
            f1 = 1.0F - this.swingProgress;
            f1 = f1 * f1;
            f1 = f1 * f1;
            f1 = 1.0F - f1;
            float f2 = MathHelper.sin(f1 * (float) Math.PI);
            float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            modelrenderer.rotateAngleX = (float) ((double) modelrenderer.rotateAngleX - ((double) f2 * 1.2D + (double) f3));
            modelrenderer.rotateAngleY += this.body.rotateAngleY * 2.0F;
            modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
        }

        if (entity.isMaidWait()) {
            //待機状態の特別表示
            float lx = mh_sin(ageInTicks * 0.067F) * 0.05F - 0.7F;
            handR.setRotateAngle(lx, 0.0F, -0.4F);
            handL.setRotateAngle(lx, 0.0F, 0.4F);
        } else {
            float la, lb, lc;

            if (entity.isShooting()) {
                if (entity.isCharging()) {
                    this.handR.rotateAngleY = -0.8F;
                    this.handR.rotateAngleX = -0.97079635F;
                    this.handL.rotateAngleX = -0.97079635F;
                    float f2 = MathHelper.clamp(entity.getItemInUseMaxCount(), 0.0F, 25.0F);
                    this.handL.rotateAngleY = MathHelper.lerp(f2 / 25.0F, 0.4F, 0.85F);
                    this.handL.rotateAngleX = MathHelper.lerp(f2 / 25.0F, this.handL.rotateAngleX, (-(float) Math.PI / 2F));
                } else {
                    // 弓構え
                    float lonGround = getMainHand(entity).ordinal();
                    float f6 = mh_sin(lonGround * 3.141593F);
                    float f7 = mh_sin((1.0F - (1.0F - lonGround) * (1.0F - lonGround)) * 3.141593F);
                    la = 0.1F - f6 * 0.6F;
                    handR.setRotateAngle(-1.470796F, -la, 0.0F);
                    handL.setRotateAngle(-1.470796F, la, 0.0F);
                    la = head.rotateAngleX;
                    lb = mh_sin(ageInTicks * 0.067F) * 0.05F;
                    lc = f6 * 1.2F - f7 * 0.4F;
                    handR.addRotateAngleX(la + lb - lc);
                    handL.addRotateAngleX(la - lb - lc);
                    la = head.rotateAngleY;
                    handR.addRotateAngleY(la);
                    handL.addRotateAngleY(la);
                    la = mh_cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
                    handR.addRotateAngleZ(la);
                    handL.addRotateAngleZ(-la);
                }
            } else if (entity.isHolding(Items.CROSSBOW)) {
                this.handR.rotateAngleY = -0.3F + this.head.rotateAngleY;
                this.handL.rotateAngleY = 0.6F + this.head.rotateAngleY;
                this.handR.rotateAngleX = (-(float) Math.PI / 2F) + this.head.rotateAngleX + 0.1F;
                this.handL.rotateAngleX = -1.5F + this.head.rotateAngleX;
            } else {
                // 通常
                la = mh_sin(ageInTicks * 0.067F) * 0.05F;
                lc = 0.5F + mh_cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
                handR.addRotateAngleX(la);
                handL.addRotateAngleX(-la);
                handR.addRotateAngleZ(lc);
                handL.addRotateAngleZ(-lc);
            }
        }

        float f2 = -(float) Math.PI / 1.5F;

        if (entity.isRotationAttack()) {
            this.handR.setRotateAngle(f2, 0.0F, -f2);
            this.handL.setRotateAngle(f2, 0.0F, f2);
        }

        if (entity.isGuard()) {
            this.handR.setRotateAngle(-0.95F, -0.77F, 0.0F);
        }

        if (entity instanceof IMaidAnimation) {
            setAnimations(limbSwing, limbSwingAmount, ageInTicks, pHeadYaw, pHeadPitch, entity, ((IMaidAnimation) entity));
        }
    }

    public void setAnimations(float par1, float par2, float ageInTicks, float pHeadYaw, float pHeadPitch, T pEntityCaps, IMaidAnimation animation) {


        animator.update(animation);
        if (animation.getAnimation() == LittleMaidBaseEntity.TALK_ANIMATION) {
            handR.setRotateAngle(0.0F, 0.0F, 0.0F);
            handL.setRotateAngle(0.0F, 0.0F, 0.0F);

            animator.setAnimation(LittleMaidBaseEntity.TALK_ANIMATION);
            animator.startKeyframe(5);

            this.handR.setRotateAngleZ(0.0F);
            this.handL.setRotateAngleZ(0.0F);

            animator.rotate(this.handR, -1.2F, 0, 0);
            animator.rotate(this.handL, -1.2F, 0, 0);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.handR, 0.2F, 0, 0);
            animator.rotate(this.handL, 0.2F, 0, 0);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.handR, -0.2F, 0, 0);
            animator.rotate(this.handL, -0.2F, 0, 0);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.handR, 0.2F, 0, 0);
            animator.rotate(this.handL, 0.2F, 0, 0);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.handR, -0.2F, 0, 0);
            animator.rotate(this.handL, -0.2F, 0, 0);
            animator.endKeyframe();
            animator.setStaticKeyframe(45);
            animator.resetKeyframe(10);
        }

        if (animation.getAnimation() == LittleMaidBaseEntity.PET_ANIMATION) {
            animator.setAnimation(LittleMaidBaseEntity.PET_ANIMATION);
            animator.startKeyframe(10);
            animator.rotate(this.head, 0.4F, -0.2F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.head, 0.4F, 0.2F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.head, 0.4F, -0.2F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.head, 0.4F, 0.2F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.head, 0.4F, -0.2F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.head, 0.4F, 0.2F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.head, 0.4F, -0.2F, 0.0F);
            animator.endKeyframe();

            animator.startKeyframe(10);
            animator.rotate(this.head, 0.4F, 0.2F, 0.0F);
            animator.endKeyframe();

            animator.setStaticKeyframe(10);
            animator.resetKeyframe(10);
        }

        if (animation.getAnimation() == LittleMaidBaseEntity.FARM_ANIMATION) {
            animator.setAnimation(LittleMaidBaseEntity.FARM_ANIMATION);
            animator.startKeyframe(10);
            animator.rotate(this.body, 0.4F, 0.0F, 0.0F);
            animator.rotate(this.handR, -0.4F, 0.0F, 0.0F);
            animator.rotate(this.handL, -0.4F, 0.0F, 0.0F);
            animator.endKeyframe();


            animator.resetKeyframe(5);
        }

        if (animation.getAnimation() == LittleMaidBaseEntity.EAT_ANIMATION) {
            handR.setRotateAngle(0.0F, 0.0F, 0.0F);
            handL.setRotateAngle(0.0F, 0.0F, 0.0F);

            animator.setAnimation(LittleMaidBaseEntity.EAT_ANIMATION);
            animator.startKeyframe(2);
            animator.rotate(this.handR, -1.6F, -0.6F, 0.0F);
            animator.rotate(this.handL, -1.6F, 0.6F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.handR, -1.8F, -0.6F, 0.0F);
            animator.rotate(this.handL, -1.8F, 0.6F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.handR, -1.6F, -0.6F, 0.0F);
            animator.rotate(this.handL, -1.6F, 0.6F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.handR, -1.8F, -0.6F, 0.0F);
            animator.rotate(this.handL, -1.8F, 0.6F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(2);
            animator.rotate(this.handR, -1.6F, -0.6F, 0.0F);
            animator.rotate(this.handL, -1.6F, 0.6F, 0.0F);
            animator.endKeyframe();


            animator.resetKeyframe(4);
        }

        if (animation.getAnimation() == LittleMaidBaseEntity.RUSHING_ANIMATION) {
            handR.setRotateAngle(0.0F, 0.0F, 0.0F);
            handL.setRotateAngle(0.0F, 0.0F, 0.0F);
            legR.setRotateAngle(0.0F, 0.0F, 0.0F);
            legL.setRotateAngle(0.0F, 0.0F, 0.0F);

            animator.setAnimation(LittleMaidBaseEntity.RUSHING_ANIMATION);
            animator.startKeyframe(4);
            animator.rotate(this.handR, -0.95F, -0.77F, 0.0F);
            animator.rotate(this.handL, 1.0471975511965976F, 0.6F, -0.27314402793711257F);
            animator.rotate(this.legR, 0.5F, 0.0F, 0.0F);
            animator.rotate(this.legL, 0.5F, 0.0F, 0.0F);
            animator.endKeyframe();
            animator.startKeyframe(72);
            animator.rotate(this.handR, -0.95F, -0.77F, 0.0F);
            animator.rotate(this.handL, 1.0471975511965976F, 0.6F, -0.27314402793711257F);
            animator.rotate(this.legR, 0.5F, 0.0F, 0.0F);
            animator.rotate(this.legL, 0.5F, 0.0F, 0.0F);
            animator.endKeyframe();

            animator.resetKeyframe(4);
        }
    }

    public void setDefaultPause(T entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                                float pHeadYaw, float pHeadPitch) {
        this.head.rotateAngleY = pHeadYaw * ((float) Math.PI / 180F);
        this.head.rotateAngleX = pHeadPitch * ((float) Math.PI / 180F);

        this.body.rotateAngleY = 0.0F;

        this.handR.rotateAngleY = 0.0F;
        this.handL.rotateAngleY = 0.0F;
        this.handR.rotateAngleZ = 0.0F;
        this.handL.rotateAngleZ = 0.0F;

        this.body.rotateAngleY = 0.0F;

        this.legR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.legL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.legR.rotateAngleY = 0.0F;
        this.legL.rotateAngleY = 0.0F;

        if (entity.isMaidWait()) {
            handR.rotateAngleZ = -0.4F;
            handL.rotateAngleZ = 0.4F;
            handR.rotateAngleX = -0.4F;
            handL.rotateAngleX = -0.4F;
        } else {
            this.handR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / 1.0F;
            this.handL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / 1.0F;
        }

        this.handR.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.handL.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.handR.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.handL.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotationAngle(MaidModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    protected MaidModelRenderer getArmForSide(HandSide side) {
        return side == HandSide.LEFT ? this.handL : this.handR;
    }

    protected HandSide getMainHand(T entityIn) {
        HandSide handside = entityIn.getPrimaryHand();
        return entityIn.swingingHand == Hand.MAIN_HAND ? handside : handside.opposite();
    }
}