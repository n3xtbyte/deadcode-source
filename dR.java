/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelPlayer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.MathHelper
 */
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class dR {
    public ModelPlayer a = new ModelPlayer(0.0f, false);

    public void a(EntityPlayer entityPlayer, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        ItemStack itemStack = entityPlayer.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        an an2 = \u2007\u2008\u00a0.o.c();
        int n2 = -1;
        if (an2 != null) {
            n2 = an2.b();
        }
        if (n2 != -1 && itemStack.getItem() != Items.ELYTRA) {
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.bindTexture((int)n2);
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.125f);
            double d2 = entityPlayer.prevChasingPosX + (entityPlayer.chasingPosX - entityPlayer.prevChasingPosX) * (double)f4 - (entityPlayer.prevPosX + (entityPlayer.posX - entityPlayer.prevPosX) * (double)f4);
            double d3 = entityPlayer.prevChasingPosY + (entityPlayer.chasingPosY - entityPlayer.prevChasingPosY) * (double)f4 - (entityPlayer.prevPosY + (entityPlayer.posY - entityPlayer.prevPosY) * (double)f4);
            double d4 = entityPlayer.prevChasingPosZ + (entityPlayer.chasingPosZ - entityPlayer.prevChasingPosZ) * (double)f4 - (entityPlayer.prevPosZ + (entityPlayer.posZ - entityPlayer.prevPosZ) * (double)f4);
            float f9 = entityPlayer.prevRenderYawOffset + (entityPlayer.renderYawOffset - entityPlayer.prevRenderYawOffset) * f4;
            double d5 = MathHelper.sin((float)(f9 * ((float)Math.PI / 180)));
            double d6 = -MathHelper.cos((float)(f9 * ((float)Math.PI / 180)));
            float f10 = (float)d3 * 10.0f;
            f10 = MathHelper.clamp((float)f10, (float)-6.0f, (float)32.0f);
            float f11 = (float)(d2 * d5 + d4 * d6) * 100.0f;
            float f12 = (float)(d2 * d6 - d4 * d5) * 100.0f;
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            float f13 = entityPlayer.prevCameraYaw + (entityPlayer.cameraYaw - entityPlayer.prevCameraYaw) * f4;
            f10 += MathHelper.sin((float)((entityPlayer.prevDistanceWalkedModified + (entityPlayer.distanceWalkedModified - entityPlayer.prevDistanceWalkedModified) * f4) * 6.0f)) * 32.0f * f13;
            if (entityPlayer.isSneaking()) {
                f10 += 25.0f;
            }
            GlStateManager.rotate((float)(6.0f + f11 / 2.0f + f10), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.rotate((float)(f12 / 2.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GlStateManager.rotate((float)(-f12 / 2.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            this.a.renderCape(0.0625f);
            GlStateManager.popMatrix();
        }
    }
}

