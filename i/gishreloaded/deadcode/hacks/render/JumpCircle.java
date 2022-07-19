/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingJumpEvent
 *  org.lwjgl.opengl.GL11
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.ColorUtils;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import org.lwjgl.opengl.GL11;

public class JumpCircle
extends Hack {
    public IntegerValue a;
    public List b;

    public JumpCircle(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        this.a = new IntegerValue("Existed time", 120, 20, 120);
        this.a(this.a);
        this.b("Other");
        this.b = new ArrayList();
    }

    @Override
    public String getDescription() {
        return "Shows effects when jumping.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        double d2 = -(entityPlayerSP.lastTickPosX + (entityPlayerSP.posX - entityPlayerSP.lastTickPosX) * (double)renderWorldLastEvent.getPartialTicks());
        double d3 = -(entityPlayerSP.lastTickPosY + (entityPlayerSP.posY - entityPlayerSP.lastTickPosY) * (double)renderWorldLastEvent.getPartialTicks());
        double d4 = -(entityPlayerSP.lastTickPosZ + (entityPlayerSP.posZ - entityPlayerSP.lastTickPosZ) * (double)renderWorldLastEvent.getPartialTicks());
        GL11.glPushMatrix();
        GL11.glTranslated((double)d2, (double)d3, (double)d4);
        GL11.glDisable((int)2884);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)3008);
        GL11.glDisable((int)2929);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glShadeModel((int)7425);
        Collections.reverse(this.b);
        GlStateManager.disableLighting();
        for (d_0 d_03 : this.b) {
            float f2 = (float)d_03.c() / (float)this.a.getValue().intValue();
            double d5 = d_03.a().x;
            double d6 = d_03.a().y - (double)f2 * 0.5;
            double d7 = d_03.a().z;
            float f3 = f2;
            float f4 = f3 + 1.0f - f2;
            GL11.glBegin((int)8);
            for (int i2 = 0; i2 <= 360; i2 += 5) {
                ColorUtils.setColor((float)d_03.b().x, (float)d_03.b().y, (float)d_03.b().z, 0.4f * (1.0f - f2));
                GL11.glVertex3d((double)(d5 + Math.cos(Math.toRadians(i2 * 6)) * (double)f3), (double)d6, (double)(d7 + Math.sin(Math.toRadians(i2 * 6)) * (double)f3));
                ColorUtils.setColor(1.0f, 1.0f, 1.0f, 0.01f * (1.0f - f2));
                GL11.glVertex3d((double)(d5 + Math.cos(Math.toRadians(i2)) * (double)f4), (double)(d6 + Math.sin(f2 * 8.0f) * 0.5), (double)(d7 + Math.sin(Math.toRadians(i2) * (double)f4)));
            }
            GL11.glEnd();
        }
        GlStateManager.enableLighting();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        Collections.reverse(this.b);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glShadeModel((int)7424);
        GL11.glEnable((int)2884);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3008);
        GL11.glPopMatrix();
        this.b.removeIf(d_02 -> d_02.d());
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    @Override
    public void onJumpEvent(LivingEvent.LivingJumpEvent livingJumpEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (livingJumpEvent.getEntity() == entityPlayerSP && entityPlayerSP.onGround && !entityPlayerSP.isInWater() && !entityPlayerSP.isInLava()) {
            this.a(livingJumpEvent.getEntity());
        }
        super.onJumpEvent(livingJumpEvent);
    }

    public void a(Entity entity) {
        Color color = er.a(10, 20L, 1.0f);
        float[] fArray = er.a(color.getRGB());
        Vec3d vec3d = new Vec3d((double)fArray[0], (double)fArray[1], (double)fArray[2]);
        this.b.add(new d_0(entity.getPositionVector(), vec3d, this.a.getValue()));
    }
}

