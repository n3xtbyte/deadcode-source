/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumHand
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.player;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.RandomUtils;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AntiLevitate
extends Hack {
    public DoubleValue a;
    public TimerUtils b;
    public TimerUtils c;
    public EntityShulkerBullet d;

    public AntiLevitate(String string) {
        super(string, HackCategory.Player);
        this.b("General");
        this.a = new DoubleValue("Distance", 4.0, 3.0, 10.0);
        this.a(this.a);
        this.b("Other");
        this.b = new TimerUtils();
        this.c = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Shulker can't leviate you.";
    }

    @Override
    public void onEnable() {
        this.d();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.d();
        super.onDisable();
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        this.b();
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        this.c();
        super.onPlayerTickEvent(playerTickEvent);
    }

    public void b() {
        for (Object e : et.b()) {
            EntityShulkerBullet entityShulkerBullet;
            if (!(e instanceof EntityShulkerBullet) || !this.a(entityShulkerBullet = (EntityShulkerBullet)e)) continue;
            this.d = entityShulkerBullet;
        }
    }

    public void c() {
        if (this.d == null) {
            return;
        }
        if (!this.a(this.d)) {
            this.d();
            return;
        }
        if (!this.b.isReached(100L)) {
            return;
        }
        float f2 = 2.2f - RandomUtils.getRandom().nextFloat();
        float[] fArray = MathUtils.a((Entity)this.d, cy_0.b, f2);
        ef.a(fArray);
        Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
        if (this.c.isReached(1L)) {
            Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
        }
        if (this.c.isReached(2L)) {
            Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw - 2.0E-4);
            this.c.resetTime();
        }
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketUseEntity((Entity)this.d));
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
        this.b.resetTime();
    }

    public void d() {
        this.d = null;
        ef.j();
    }

    public boolean a(EntityShulkerBullet entityShulkerBullet) {
        return !((double)Wrapper.INSTANCE.getLocalPlayer().getDistance((Entity)entityShulkerBullet) >= this.a.getValue()) && !entityShulkerBullet.isDead;
    }
}

