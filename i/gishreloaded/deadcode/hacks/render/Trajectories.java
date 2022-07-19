/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemEgg
 *  net.minecraft.item.ItemEnderPearl
 *  net.minecraft.item.ItemFishingRod
 *  net.minecraft.item.ItemLingeringPotion
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.item.ItemSnowball
 *  net.minecraft.item.ItemSplashPotion
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  org.lwjgl.opengl.GL11
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.ColorUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemLingeringPotion;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemSplashPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

public class Trajectories
extends Hack {
    public Trajectories(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Predicts the flight path of arrows and throwable items.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        float f2 = Wrapper.INSTANCE.getLocalPlayer().rotationYaw;
        float f3 = Wrapper.INSTANCE.getLocalPlayer().rotationPitch;
        ItemStack itemStack = entityPlayerSP.inventory.getCurrentItem();
        if (itemStack == null) {
            return;
        }
        Item item = itemStack.getItem();
        if (!(item instanceof ItemBow || item instanceof ItemSnowball || item instanceof ItemEgg || item instanceof ItemEnderPearl || item instanceof ItemSplashPotion || item instanceof ItemLingeringPotion || item instanceof ItemFishingRod)) {
            return;
        }
        boolean bl = entityPlayerSP.inventory.getCurrentItem().getItem() instanceof ItemBow;
        double d2 = entityPlayerSP.lastTickPosX + (entityPlayerSP.posX - entityPlayerSP.lastTickPosX) * (double)renderWorldLastEvent.getPartialTicks() - (double)(MathHelper.cos((float)((float)Math.toRadians(f2))) * 0.16f);
        double d3 = entityPlayerSP.lastTickPosY + (entityPlayerSP.posY - entityPlayerSP.lastTickPosY) * (double)renderWorldLastEvent.getPartialTicks() + (double)entityPlayerSP.getEyeHeight() - 0.1;
        double d4 = entityPlayerSP.lastTickPosZ + (entityPlayerSP.posZ - entityPlayerSP.lastTickPosZ) * (double)renderWorldLastEvent.getPartialTicks() - (double)(MathHelper.sin((float)((float)Math.toRadians(f2))) * 0.16f);
        float f4 = bl ? 1.0f : 0.4f;
        float f5 = (float)Math.toRadians(f2);
        float f6 = (float)Math.toRadians(f3);
        float f7 = -MathHelper.sin((float)f5) * MathHelper.cos((float)f6) * f4;
        float f8 = -MathHelper.sin((float)f6) * f4;
        float f9 = MathHelper.cos((float)f5) * MathHelper.cos((float)f6) * f4;
        double d5 = Math.sqrt(f7 * f7 + f8 * f8 + f9 * f9);
        f7 = (float)((double)f7 / d5);
        f8 = (float)((double)f8 / d5);
        f9 = (float)((double)f9 / d5);
        if (bl) {
            float f10 = (float)(72000 - entityPlayerSP.getItemInUseCount()) / 20.0f;
            if ((f10 = (f10 * f10 + f10 * 2.0f) / 3.0f) > 1.0f) {
                f10 = 1.0f;
            }
            if (f10 <= 0.1f) {
                f10 = 1.0f;
            }
            f7 *= (f10 *= 3.0f);
            f8 *= f10;
            f9 *= f10;
        } else {
            f7 = (float)((double)f7 * 1.5);
            f8 = (float)((double)f8 * 1.5);
            f9 = (float)((double)f9 * 1.5);
        }
        GL11.glPushMatrix();
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)32925);
        GL11.glDepthMask((boolean)false);
        GL11.glLineWidth((float)1.8f);
        RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
        double d6 = bl ? 0.05 : (item instanceof ItemPotion ? 0.4 : (item instanceof ItemFishingRod ? 0.15 : 0.03));
        Vec3d vec3d = new Vec3d(entityPlayerSP.posX, entityPlayerSP.posY + (double)entityPlayerSP.getEyeHeight(), entityPlayerSP.posZ);
        GL11.glColor3d((double)1.0, (double)1.0, (double)1.0);
        GL11.glBegin((int)3);
        for (int i2 = 0; i2 < 1000; ++i2) {
            GL11.glVertex3d((double)(d2 - renderManager.viewerPosX), (double)(d3 - renderManager.viewerPosY), (double)(d4 - renderManager.viewerPosZ));
            f7 = (float)((double)f7 * 0.999);
            f8 = (float)((double)f8 * 0.999);
            f9 = (float)((double)f9 * 0.999);
            f8 = (float)((double)f8 - d6 * 0.1);
            if (Wrapper.INSTANCE.getWorld().rayTraceBlocks(vec3d, new Vec3d(d2 += (double)f7 * 0.1, d3 += (double)f8 * 0.1, d4 += (double)f9 * 0.1)) != null) break;
        }
        GL11.glEnd();
        double d7 = d2 - renderManager.viewerPosX;
        double d8 = d3 - renderManager.viewerPosY;
        double d9 = d4 - renderManager.viewerPosZ;
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d7 - 0.5, d8 - 0.5, d9 - 0.5, d7 + 0.5, d8 + 0.5, d9 + 0.5);
        ColorUtils.setColor(1.0f, 1.0f, 1.0f, 0.15f);
        RenderUtils.a(axisAlignedBB, 1.0f, 1.0f, 1.0f, 0.15f);
        GL11.glColor4d((double)1.0, (double)1.0, (double)1.0, (double)0.5);
        RenderUtils.a(axisAlignedBB);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)32925);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

