/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.combat.KillAura;
import i.gishreloaded.deadcode.hacks.player.NoSlow;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TargetStrafe
extends Hack {
    public ModeValue a = new ModeValue("Mode", true, new Mode("Default", true), new Mode("Spiral"), new Mode("Static"), new Mode("Reverse"));
    public ModeValue b = new ModeValue("Priority", false, new Mode("Closest", true), new Mode("Health"));
    public BooleanValue c = new BooleanValue("Render circle", true);
    public BooleanValue d = new BooleanValue("Third view", true);
    public BooleanValue e = new BooleanValue("Auto jump", true);
    public DoubleValue f = new DoubleValue("Distance to entity", 8.5, 6.0, 20.0);
    public DoubleValue g;
    public DoubleValue h = new DoubleValue("Strafe radius", 2.5, 0.5, 6.0);
    public DoubleValue i;
    public BooleanValue j;
    public DoubleValue k;
    public static EntityLivingBase l;
    public TimerUtils m;
    public TimerUtils n;
    public int o;
    public double p;

    public TargetStrafe(String string) {
        super(string, HackCategory.Combat);
        this.g = new DoubleValue("Speed", 0.23, 0.1, 1.0);
        this.i = new DoubleValue("Spiral speed", 0.28, 0.1, 1.0);
        this.j = new BooleanValue("Damage boost", false);
        this.k = new DoubleValue("Boost speed", 0.5, 0.1, 1.0);
        this.b("Move");
        this.a(this.a, this.e, this.h, this.g, this.i);
        this.b("Target");
        this.a(this.b, this.f);
        this.b("Render");
        this.a(this.c, this.d);
        this.b("Damage");
        this.a(this.j, this.k);
        this.b("Other");
        this.m = new TimerUtils();
        this.n = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Whirls in a circle of entity.";
    }

    @Override
    public void onEnable() {
        l = null;
        this.o = 1;
        this.p = 0.0;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        l = null;
        if (((Boolean)this.d.getObjectValue()).booleanValue()) {
            Wrapper.INSTANCE.getGameSettings().thirdPersonView = 0;
        }
        super.onDisable();
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        this.c();
        if (!((Boolean)this.c.getObjectValue()).booleanValue()) {
            return;
        }
        if (l != null) {
            RenderUtils.a((Entity)l, this.p, 40, 1.0f, er.e, renderWorldLastEvent.getPartialTicks());
        }
        if (this.p < this.h.getValue() && this.n.isReached(1L)) {
            this.p += 0.1;
            this.n.resetTime();
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (l == null || !this.d()) {
            return;
        }
        if (((Boolean)this.d.getObjectValue()).booleanValue()) {
            Wrapper.INSTANCE.getGameSettings().thirdPersonView = 1;
        }
        if (((Boolean)this.e.getObjectValue()).booleanValue() && entityPlayerSP.onGround) {
            entityPlayerSP.jump();
        }
        if (Wrapper.INSTANCE.getGameSettings().keyBindLeft.isKeyDown()) {
            this.o = -1;
        } else if (Wrapper.INSTANCE.getGameSettings().keyBindRight.isKeyDown()) {
            this.o = 1;
        }
        if (this.m.isReached(10L) && Wrapper.INSTANCE.getLocalPlayer().collidedHorizontally) {
            this.o = this.o == 1 ? -1 : 1;
            this.m.resetTime();
        }
        if (this.b() && l != null) {
            double d2;
            float f2 = MathUtils.a((Entity)l, cy_0.b, 0.0f)[0];
            boolean bl = entityPlayerSP.getDistance((Entity)l) > this.e();
            double d3 = d2 = bl ? 1.0 : 0.0;
            if (this.a.getModeByIndex(2).isToggled()) {
                double d4 = d2 = bl ? 0.0 : -1.0;
            }
            if (this.a.getModeByIndex(3).isToggled()) {
                d2 = -1.0;
            }
            this.a(f2, this.g(), d2, this.o);
        } else if (this.a.getModeByIndex(1).isToggled()) {
            this.a((Entity)l, this.g(), (double)this.i.getValue(), this.o);
        }
        if (!this.c(l)) {
            l = null;
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    public boolean b() {
        return this.a.getModeByIndex(0).isToggled() || this.a.getModeByIndex(2).isToggled() || this.a.getModeByIndex(3).isToggled();
    }

    private /* synthetic */ double g() {
        return (Boolean)this.j.getObjectValue() != false && Wrapper.INSTANCE.getLocalPlayer().hurtTime > 5 && (double)Wrapper.INSTANCE.getLocalPlayer().fallDistance > 0.2 ? this.k.getValue() : this.g.getValue();
    }

    private /* synthetic */ void a(Entity entity, double d2, double d3, int n2) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        double d4 = (entityPlayerSP.posX - entity.posX) / Math.sqrt(Math.pow(entityPlayerSP.posX - entity.posX, 2.0) + Math.pow(entityPlayerSP.posZ - entity.posZ, 2.0));
        double d5 = (entityPlayerSP.posZ - entity.posZ) / Math.sqrt(Math.pow(entityPlayerSP.posX - entity.posX, 2.0) + Math.pow(entityPlayerSP.posZ - entity.posZ, 2.0));
        double d6 = d2 * d5 * (double)n2 - d3 * d2 * d4;
        double d7 = -d2 * d4 * (double)n2 - d3 * d2 * d5;
        if (NoSlow.b()) {
            d6 /= 1.2;
            d7 /= 1.2;
        }
        entityPlayerSP.setVelocity(d6, entityPlayerSP.motionY, d7);
    }

    private /* synthetic */ void a(float f2, double d2, double d3, int n2) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (d3 != 0.0) {
            if (n2 < 0) {
                f2 += (float)(d3 > 0.0 ? -50 : 50);
            } else if (n2 > 0) {
                f2 += (float)(d3 > 0.0 ? 50 : -50);
            }
            n2 = 0;
            if (d3 > 0.0) {
                d3 = 1.0;
            } else if (d3 < 0.0) {
                d3 = -1.0;
            }
        }
        double d4 = d3 * d2 * Math.cos(Math.toRadians(f2 + 90.0f)) - (double)n2 * d2 * Math.sin(Math.toRadians(f2 + 90.0f));
        double d5 = d3 * d2 * Math.sin(Math.toRadians(f2 + 90.0f)) + (double)n2 * d2 * Math.cos(Math.toRadians(f2 + 90.0f));
        if (NoSlow.b()) {
            d4 /= 1.2;
            d5 /= 1.2;
        }
        entityPlayerSP.setVelocity(d4, entityPlayerSP.motionY - 0.001, d5);
    }

    public void c() {
        if (KillAura.J != null && this.c(l)) {
            l = KillAura.J;
            return;
        }
        for (Object e : et.b()) {
            EntityLivingBase entityLivingBase;
            if (!(e instanceof EntityLivingBase) || !this.c(entityLivingBase = (EntityLivingBase)e)) continue;
            l = entityLivingBase;
        }
    }

    public boolean d() {
        return !Wrapper.INSTANCE.getLocalPlayer().isOnLadder() && !Wrapper.INSTANCE.getLocalPlayer().isInWater() && !Wrapper.INSTANCE.getLocalPlayer().isInLava();
    }

    public float e() {
        return this.h.getValue().floatValue();
    }

    public float f() {
        return this.f.getValue().floatValue();
    }

    public boolean a(EntityLivingBase entityLivingBase) {
        return this.b.getModeByIndex(0).isToggled() && eQ.c(entityLivingBase, l) || this.b.getModeByIndex(1).isToggled() && eQ.a(entityLivingBase, l);
    }

    public boolean b(EntityLivingBase entityLivingBase) {
        return entityLivingBase.getDistance((Entity)Wrapper.INSTANCE.getLocalPlayer()) <= this.f();
    }

    public boolean c(EntityLivingBase entityLivingBase) {
        return !(entityLivingBase instanceof EntityPlayerSP) && !(entityLivingBase instanceof EntityArmorStand) && !eQ.a((Entity)entityLivingBase) && eQ.a() && entityLivingBase != Wrapper.INSTANCE.getLocalPlayer() && !entityLivingBase.isDead && entityLivingBase.deathTime <= 0 && eQ.a(entityLivingBase) && eQ.c(entityLivingBase) && this.b(entityLivingBase) && eQ.b(entityLivingBase) && this.a(entityLivingBase);
    }
}

