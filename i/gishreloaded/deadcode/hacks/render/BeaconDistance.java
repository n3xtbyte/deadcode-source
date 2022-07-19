/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityBeacon
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  org.lwjgl.opengl.GL11
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.ColorUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

public class BeaconDistance
extends Hack {
    public BeaconDistance(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Shows the distance of the beacon.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        for (TileEntity tileEntity : Wrapper.INSTANCE.getWorld().loadedTileEntityList) {
            TileEntityBeacon tileEntityBeacon;
            if (!(tileEntity instanceof TileEntityBeacon) || (tileEntityBeacon = (TileEntityBeacon)tileEntity).getLevels() == -1) continue;
            int n2 = 20;
            boolean bl = true;
            int n3 = er.e;
            int n4 = 100;
            RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
            double d2 = (double)tileEntityBeacon.getPos().getX() - renderManager.viewerPosX;
            double d3 = (double)tileEntityBeacon.getPos().getY() - renderManager.viewerPosY;
            double d4 = (double)tileEntityBeacon.getPos().getZ() - renderManager.viewerPosZ;
            switch (tileEntityBeacon.getLevels()) {
                case 1: {
                    n2 = 20;
                    break;
                }
                case 2: {
                    n2 = 34;
                    break;
                }
                case 3: {
                    n2 = 45;
                    break;
                }
                case 4: {
                    n2 = 52;
                    n3 = er.c(1000, 16L, 0.4f);
                }
            }
            GL11.glPushMatrix();
            GL11.glEnable((int)3042);
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
            GL11.glLineWidth((float)((float)bl));
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)2848);
            ColorUtils.setColor(n3);
            GL11.glBegin((int)3);
            for (int i2 = 0; i2 <= n4; ++i2) {
                GL11.glVertex3d((double)(d2 + (double)n2 * Math.cos((double)i2 * (Math.PI * 2) / (double)n4)), (double)d3, (double)(d4 + (double)n2 * Math.sin((double)i2 * (Math.PI * 2) / (double)n4)));
            }
            GL11.glEnd();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDepthMask((boolean)true);
            GL11.glDisable((int)2848);
            GL11.glEnable((int)2929);
            GL11.glEnable((int)2896);
            GL11.glEnable((int)3553);
            GL11.glDisable((int)3042);
            GL11.glPopMatrix();
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

