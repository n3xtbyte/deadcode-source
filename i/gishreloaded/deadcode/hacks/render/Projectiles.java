/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderPearl
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.lwjgl.opengl.GL11
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.ColorUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;

public class Projectiles
extends Hack {
    public HashMap a = new HashMap();

    public Projectiles(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Shows the trajectory of the flight of projectiles.";
    }

    @Override
    public void onEnable() {
        this.a.clear();
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        for (Entity entity : et.b()) {
            if (!(entity instanceof EntityEnderPearl)) continue;
            ArrayList arrayList = (ArrayList)this.a.get(entity);
            if (arrayList == null) {
                this.a.put(entity, new ArrayList());
                continue;
            }
            if (entity.isDead) {
                this.a.remove(entity);
                continue;
            }
            double[] dArray = new double[]{entity.posX, entity.posY, entity.posZ};
            arrayList.add(dArray);
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent, Object object) {
        RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
        double d2 = renderManager.viewerPosX;
        double d3 = renderManager.viewerPosY;
        double d4 = renderManager.viewerPosZ;
        GL11.glPushMatrix();
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)2884);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)3008);
        GL11.glDisable((int)2929);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glShadeModel((int)7425);
        Iterator iterator = this.a.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            Entity entity = (Entity)entry.getKey();
            ArrayList arrayList = (ArrayList)entry.getValue();
            float[] fArray = er.a(er.d(arrayList.size() * 20, 15L, 0.5f));
            GL11.glBegin((int)3);
            for (double[] dArray : arrayList) {
                ColorUtils.setColor(fArray[0], fArray[1], fArray[2], 1.0f);
                GL11.glVertex3d((double)(dArray[0] - d2), (double)(dArray[1] - d3), (double)(dArray[2] - d4));
            }
            GL11.glEnd();
            if (Wrapper.INSTANCE.getWorld().getEntityByID(entity.getEntityId()) != null) continue;
            iterator.remove();
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glShadeModel((int)7424);
        GL11.glEnable((int)2884);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3008);
        GL11.glPopMatrix();
        super.onRenderWorldLastEvent(renderWorldLastEvent, object);
    }
}

