/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerRadar
extends Hack {
    public dr_0 a = new dr_0("Radar position", new eM(200, 20));
    public IntegerValue b = new IntegerValue("Radar size", 100, 50, 300);
    public BooleanValue c = new BooleanValue("Glow", true);
    public BooleanValue d = new BooleanValue("Shadow", true);

    public PlayerRadar(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        this.a(this.a, this.b);
        this.b("Graphic");
        this.a(this.c, this.d);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Show all players around you.";
    }

    @Override
    public void a(float f2) {
        this.a(((eM)this.a.getObjectValue()).a(), ((eM)this.a.getObjectValue()).b(), this.b.getValue(), f2);
        super.a(f2);
    }

    public void a(int n2, int n3, int n4, float f2) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        int n5 = n4 / 2;
        float f3 = (float)((double)n2 + 2.5);
        float f4 = (float)((double)n3 + 2.5);
        float f5 = (float)((double)(n2 + n4) - 2.5);
        float f6 = (float)((double)(n3 + n4) - 2.5);
        int n6 = er.b(aX.f, 0.5f);
        ShaderManager.d().a(f3, f4, f5, f6);
        if (((Boolean)this.d.getObjectValue()).booleanValue() && RenderUtils.a()) {
            ShaderManager.b().a(f3, f4, f5, f6, n4 / 4, 6, n6);
        }
        RenderUtils.a(f3, (double)f4, (double)f5, (double)f6, n6);
        for (EntityPlayer entityPlayer : et.c()) {
            if (entityPlayer.isInvisible()) continue;
            int n7 = !eQ.a((EntityLivingBase)entityPlayer) ? er.b : (entityPlayerSP.canEntityBeSeen((Entity)entityPlayer) ? er.a : aX.i);
            float f7 = (float)(entityPlayer.posX + (entityPlayer.posX - entityPlayer.lastTickPosX) * (double)f2 - entityPlayerSP.posX) * 2.0f;
            float f8 = (float)(entityPlayer.posZ + (entityPlayer.posZ - entityPlayer.lastTickPosZ) * (double)f2 - entityPlayerSP.posZ) * 2.0f;
            float f9 = (float)Math.cos((double)entityPlayerSP.rotationYaw * (Math.PI / 180));
            float f10 = (float)Math.sin((double)entityPlayerSP.rotationYaw * (Math.PI / 180));
            float f11 = -(f8 * f9 - f7 * f10);
            float f12 = -(f7 * f9 + f8 * f10);
            float f13 = 2.0f;
            if (f11 > (float)n5 - 5.0f) {
                f11 = (float)n5 - 5.0f;
            } else if (f11 < -((float)n5 - 5.0f)) {
                f11 = -((float)n5 - 5.0f);
            }
            if (f12 > (float)n5 - 5.0f) {
                f12 = (float)n5 - 5.0f;
            } else if (f12 < -((float)n5 - 5.0f)) {
                f12 = -((float)n5 - 5.0f);
            }
            if (entityPlayer == entityPlayerSP) {
                n7 = er.e;
                f13 = 3.0f;
            }
            float f14 = (float)(n2 + n4 / 2) + f12 - f13;
            float f15 = (float)(n3 + n5) + f11 - f13;
            float f16 = (float)(n2 + n5) + f12 + f13;
            float f17 = (float)(n3 + n5) + f11 + f13;
            if (((Boolean)this.c.getObjectValue()).booleanValue() && RenderUtils.a()) {
                ShaderManager.b().a(f14, f15, f16, f17, f13 * 3.0f, 2, er.b(n7, 0.4f));
            }
            if (RenderUtils.a(ShaderManager.c())) {
                ShaderManager.c().a(f14, f15, f16, f17, f13 * 2.0f, n7);
                continue;
            }
            RenderUtils.a(f14, (double)f15, (double)f16, (double)f17, n7);
        }
    }
}

