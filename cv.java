/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EnumPlayerModelParts
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.text.TextFormatting
 */
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;

public class cv {
    public dR a;

    public void a(EntityPlayer entityPlayer, double d2, double d3, double d4, float f2, float f3) {
        double d5 = d3;
        if (entityPlayer.isSneaking()) {
            d5 = d3 - 0.125;
        }
        this.b(entityPlayer, d2, d5, d4, f2, f3);
    }

    public void a(EntityPlayer entityPlayer, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (this.a == null) {
            this.a = new dR();
        }
        this.a.a(entityPlayer, f2, f3, f4, f5, f6, f7, f8);
    }

    public void b(EntityPlayer entityPlayer, double d2, double d3, double d4, float f2, float f3) {
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        boolean bl = entityPlayer.isRiding() && entityPlayer.getRidingEntity() != null && entityPlayer.getRidingEntity().shouldRiderSit();
        try {
            float f4;
            float f5 = this.a(entityPlayer.prevRenderYawOffset, entityPlayer.renderYawOffset, f3);
            float f6 = this.a(entityPlayer.prevRotationYawHead, entityPlayer.rotationYawHead, f3);
            float f7 = f6 - f5;
            if (bl && entityPlayer.getRidingEntity() instanceof EntityLivingBase) {
                EntityLivingBase entityLivingBase = (EntityLivingBase)entityPlayer.getRidingEntity();
                f5 = this.a(entityLivingBase.prevRenderYawOffset, entityLivingBase.renderYawOffset, f3);
                f7 = f6 - f5;
                f4 = MathHelper.wrapDegrees((float)f7);
                if (f4 < -85.0f) {
                    f4 = -85.0f;
                }
                if (f4 >= 85.0f) {
                    f4 = 85.0f;
                }
                f5 = f6 - f4;
                if (f4 * f4 > 2500.0f) {
                    f5 += f4 * 0.2f;
                }
                f7 = f6 - f5;
            }
            float f8 = entityPlayer.prevRotationPitch + (entityPlayer.rotationPitch - entityPlayer.prevRotationPitch) * f3;
            f4 = this.a((EntityLivingBase)entityPlayer, f3);
            this.a((EntityLivingBase)entityPlayer, f5, f3);
            float f9 = this.a((EntityLivingBase)entityPlayer);
            float f10 = 0.0f;
            float f11 = 0.0f;
            if (!entityPlayer.isRiding()) {
                f10 = entityPlayer.prevLimbSwingAmount + (entityPlayer.limbSwingAmount - entityPlayer.prevLimbSwingAmount) * f3;
                f11 = entityPlayer.limbSwing - entityPlayer.limbSwingAmount * (1.0f - f3);
                if (entityPlayer.isChild()) {
                    f11 *= 3.0f;
                }
                if (f10 > 1.0f) {
                    f10 = 1.0f;
                }
                f7 = f6 - f5;
            }
            GlStateManager.enableAlpha();
            GlStateManager.disableLighting();
            this.a(entityPlayer, f11, f10, f3, f4, f7, f8, f9);
            GlStateManager.enableLighting();
            GlStateManager.disableRescaleNormal();
        }
        catch (Exception exception) {
            ChatUtils.exception("Couldn't render entity", exception);
        }
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
        GlStateManager.enableCull();
        GlStateManager.popMatrix();
    }

    public float a(float f2, float f3, float f4) {
        float f5;
        for (f5 = f3 - f2; f5 < -180.0f; f5 += 360.0f) {
        }
        while (f5 >= 180.0f) {
            f5 -= 360.0f;
        }
        return f2 + f4 * f5;
    }

    public void a(EntityLivingBase entityLivingBase, float f2, float f3) {
        GlStateManager.rotate((float)(180.0f - f2), (float)0.0f, (float)1.0f, (float)0.0f);
        if (entityLivingBase.deathTime > 0) {
            float f4 = ((float)entityLivingBase.deathTime + f3 - 1.0f) / 20.0f * 1.6f;
            if ((f4 = MathHelper.sqrt((float)f4)) > 1.0f) {
                f4 = 1.0f;
            }
            GlStateManager.rotate((float)(f4 * this.a()), (float)0.0f, (float)0.0f, (float)1.0f);
        } else {
            String string = TextFormatting.getTextWithoutFormattingCodes((String)entityLivingBase.getName());
            if (string != null && ("Dinnerbone".equals(string) || "Grumm".equals(string)) && (!(entityLivingBase instanceof EntityPlayer) || ((EntityPlayer)entityLivingBase).isWearing(EnumPlayerModelParts.CAPE))) {
                GlStateManager.translate((float)0.0f, (float)(entityLivingBase.height + 0.1f), (float)0.0f);
                GlStateManager.rotate((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
            }
        }
    }

    public float a() {
        return 90.0f;
    }

    public float a(EntityLivingBase entityLivingBase, float f2) {
        return (float)entityLivingBase.ticksExisted + f2;
    }

    public float a(EntityLivingBase entityLivingBase) {
        float f2 = entityLivingBase.isSneaking() ? -1.101f : -1.401f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale((float)-1.0f, (float)-1.0f, (float)1.0f);
        GlStateManager.translate((float)0.0f, (float)f2, (float)0.0f);
        return 0.0625f;
    }
}

