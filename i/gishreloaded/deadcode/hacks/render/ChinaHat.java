/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  org.lwjgl.opengl.GL11
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.ColorUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

public class ChinaHat
extends Hack {
    public BooleanValue a;
    public BooleanValue b;
    public DoubleValue c;

    public ChinaHat(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        this.a = new BooleanValue("Only you", true);
        this.b = new BooleanValue("Only friends", false);
        this.c = new DoubleValue("Radius", 0.7, 0.4, 1.2);
        this.a(this.a, this.b, this.c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Draw a china hat over your head.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        if (((Boolean)this.a.getObjectValue()).booleanValue()) {
            this.a((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), renderWorldLastEvent.getPartialTicks());
            return;
        }
        if (((Boolean)this.b.getObjectValue()).booleanValue()) {
            this.a((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), renderWorldLastEvent.getPartialTicks());
        }
        for (EntityPlayer entityPlayer : et.c()) {
            if (((Boolean)this.b.getObjectValue()).booleanValue() && eQ.a((EntityLivingBase)entityPlayer)) continue;
            this.a(entityPlayer, renderWorldLastEvent.getPartialTicks());
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    public void a(EntityPlayer entityPlayer, float f2) {
        RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
        if (renderManager == null || renderManager.options == null || entityPlayer == Wrapper.INSTANCE.getLocalPlayer() && Wrapper.INSTANCE.getGameSettings().thirdPersonView == 0) {
            return;
        }
        double d2 = renderManager.viewerPosX;
        double d3 = renderManager.viewerPosY;
        double d4 = renderManager.viewerPosZ;
        double d5 = entityPlayer.lastTickPosX + (entityPlayer.posX - entityPlayer.lastTickPosX) * (double)f2 - d2;
        double d6 = entityPlayer.lastTickPosY + (entityPlayer.posY - entityPlayer.lastTickPosY) * (double)f2 + (double)(entityPlayer.height / 2.0f) - d3;
        double d7 = entityPlayer.lastTickPosZ + (entityPlayer.posZ - entityPlayer.lastTickPosZ) * (double)f2 - d4;
        ItemStack itemStack = entityPlayer.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        double d8 = (itemStack.getItem() instanceof ItemArmor ? (entityPlayer.isSneaking() ? -0.18 : 0.04) : (entityPlayer.isSneaking() ? -0.22 : 0.0)) - 0.02;
        GL11.glPushMatrix();
        GL11.glTranslated((double)d5, (double)((float)(d6 + (double)(entityPlayer.height / 2.0f) + d8)), (double)d7);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2884);
        GL11.glRotatef((float)(-entityPlayer.rotationYaw), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glBegin((int)6);
        GL11.glVertex3d((double)0.0, (double)0.3, (double)0.0);
        double d9 = this.c.getValue();
        for (int i2 = 0; i2 < 361; ++i2) {
            ColorUtils.setColor(er.b(er.a(i2, 361, 0.7f), 0.7f));
            GL11.glVertex3d((double)(Math.cos((double)i2 * Math.PI / 180.0) * d9), (double)0.0, (double)(Math.sin((double)i2 * Math.PI / 180.0) * d9));
            GL11.glVertex3d((double)(Math.cos(Math.toRadians(i2)) * d9), (double)0.0, (double)(Math.sin(Math.toRadians(i2)) * d9));
        }
        GL11.glVertex3d((double)0.0, (double)0.3, (double)0.0);
        GL11.glEnd();
        GlStateManager.resetColor();
        GL11.glEnable((int)2884);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2896);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }
}

