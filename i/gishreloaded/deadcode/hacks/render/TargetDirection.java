/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.ColorValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TargetDirection
extends Hack {
    public static ColorValue a;
    public dr_0 b;
    public BooleanValue c;
    public static BlockPos d;
    public static Entity e;

    public TargetDirection(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        a = new ColorValue("Color", aX.h);
        this.b = new dr_0("Position", new eM(400, 100));
        this.c = new BooleanValue("Delete on point", true);
        this.a(a, this.b, this.c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Shows the direction to the target.";
    }

    @Override
    public void onEnable() {
        e = null;
        super.onEnable();
    }

    @Override
    public boolean a(Object object, bw bw2) {
        Entity entity;
        CPacketUseEntity cPacketUseEntity;
        if (object instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity)object).getAction() == CPacketUseEntity.Action.ATTACK && (entity = cPacketUseEntity.getEntityFromWorld((World)Wrapper.INSTANCE.getWorld())) != null) {
            e = entity;
        }
        return super.a(object, bw2);
    }

    @Override
    public void a(float f2) {
        if (!this.b() && !this.c()) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        int n2 = er.a(0, 0, 0, 155);
        float f3 = ((eM)this.b.getObjectValue()).a();
        float f4 = ((eM)this.b.getObjectValue()).b();
        float f5 = 34.0f;
        if (this.b()) {
            double d2 = entityPlayerSP.getDistance((double)d.getX(), entityPlayerSP.posY, (double)d.getZ());
            String string = String.format("%sb", RenderUtils.a(d2, 0));
            float f6 = Wrapper.INSTANCE.f().a(string) / 2;
            float f7 = f6 * 2.0f + 5.0f;
            if (f5 < f7) {
                f5 = f7;
            }
            if (RenderUtils.a()) {
                ShaderManager.b().a(f3 - f6 - 2.0f, f4 - 2.0f, f3 + f6 + 2.0f, f4 + 10.0f, 14.0f, 3, n2);
            } else {
                RenderUtils.a(f3 - f6 - 2.0f, (double)(f4 - 2.0f), (double)(f3 + f6 + 2.0f), (double)(f4 + 10.0f), n2);
            }
            Wrapper.INSTANCE.f().a("&q" + string, f3 - f6, f4, er.e);
            RenderUtils.a(f3, f4, (float)d.getX(), (float)d.getZ(), f5, (int)a.getValue(), f2);
            if (((Boolean)this.c.getObjectValue()).booleanValue() && d2 < 1.0) {
                d = null;
            }
            return;
        }
        e = Wrapper.INSTANCE.getWorld().getEntityByID(e.getEntityId());
        if (this.c()) {
            double d3 = entityPlayerSP.getDistance(e);
            String string = String.format("%sb", RenderUtils.a(d3, 1));
            float f8 = Wrapper.INSTANCE.f().a(string) / 2;
            if (RenderUtils.a()) {
                ShaderManager.b().a(f3 - f8 - 2.0f, f4 - 2.0f, f3 + f8 + 2.0f, f4 + 10.0f, 14.0f, 3, n2);
            } else {
                RenderUtils.a(f3 - f8 - 2.0f, (double)(f4 - 2.0f), (double)(f3 + f8 + 2.0f), (double)(f4 + 10.0f), n2);
            }
            Wrapper.INSTANCE.f().a("&q" + string, f3 - f8, f4, er.e);
            RenderUtils.a(f3, f4, e, f5, (int)a.getValue(), f2);
        }
        super.a(f2);
    }

    public boolean b() {
        return d != null;
    }

    public boolean c() {
        return e != null && !TargetDirection.e.isDead;
    }

    public static void a(float f2, float f3) {
        d = new BlockPos((double)f2, 0.0, (double)f3);
    }

    public static void d() {
        d = null;
    }
}

