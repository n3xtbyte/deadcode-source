/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  org.lwjgl.opengl.GL11
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.ColorValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

public class Trails
extends Hack {
    public BooleanValue a;
    public ColorValue b;
    public ColorValue c;
    public static IntegerValue d;
    public ArrayList e;

    public Trails(String string) {
        super(string, HackCategory.Render);
        d = new IntegerValue("Ticks", 60, 10, 100);
        this.a = new BooleanValue("Custom color", false);
        this.b = new ColorValue("Color top", aX.i);
        this.c = new ColorValue("Color bottom", aX.j);
        this.b("General");
        this.a(this.b, this.c, this.a, d);
        this.b("Other");
        this.e = new ArrayList();
    }

    @Override
    public String getDescription() {
        return "Trails when walking.";
    }

    @Override
    public void onEnable() {
        this.e.clear();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.e.clear();
        super.onDisable();
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        double d2;
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
        double d3 = renderManager.viewerPosX;
        double d4 = renderManager.viewerPosY;
        double d5 = renderManager.viewerPosZ;
        float[] fArray = null;
        float[] fArray2 = null;
        if (((Boolean)this.a.getObjectValue()).booleanValue()) {
            fArray = er.a(this.b.getValue());
            fArray2 = er.a(this.c.getValue());
        } else {
            fArray = er.a(er.c(1000, 10L, 0.4f));
            fArray2 = er.a(er.d(1100, 11L, 0.4f));
        }
        if (dV.a((Entity)entityPlayerSP)) {
            double d6 = entityPlayerSP.lastTickPosX + (entityPlayerSP.posX - entityPlayerSP.lastTickPosX) * (double)renderWorldLastEvent.getPartialTicks();
            double d7 = entityPlayerSP.lastTickPosY + (entityPlayerSP.posY - entityPlayerSP.lastTickPosY) * (double)renderWorldLastEvent.getPartialTicks();
            d2 = entityPlayerSP.lastTickPosZ + (entityPlayerSP.posZ - entityPlayerSP.lastTickPosZ) * (double)renderWorldLastEvent.getPartialTicks();
            Vec3d vec3d = new Vec3d(d6, d7, d2);
            Vec3d vec3d2 = new Vec3d((double)fArray2[0], (double)fArray2[1], (double)fArray2[2]);
            this.e.add(new b_0(vec3d, vec3d2));
        }
        GL11.glPushMatrix();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GL11.glDisable((int)3008);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glShadeModel((int)7425);
        GL11.glBegin((int)8);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int n2 = 0;
        float f2 = entityPlayerSP.isSneaking() ? 1.5f : 1.8f;
        for (b_0 b_03 : this.e) {
            d2 = b_03.b.x - d3;
            double d8 = b_03.b.y - d4;
            double d9 = b_03.b.z - d5;
            float f3 = (float)n2 * 0.01f * (0.8f - (float)(b_03.a / d.getValue()));
            GL11.glColor4f((float)((float)b_03.c.x), (float)((float)b_03.c.y), (float)((float)b_03.c.z), (float)f3);
            GL11.glVertex3d((double)d2, (double)d8, (double)d9);
            GL11.glColor4f((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)f3);
            GL11.glVertex3d((double)d2, (double)(d8 + (double)f2), (double)d9);
            ++n2;
        }
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GL11.glEnable((int)3008);
        GL11.glShadeModel((int)7424);
        GL11.glEnable((int)2884);
        GL11.glPopMatrix();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.e.removeIf(b_02 -> b_02.a());
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

