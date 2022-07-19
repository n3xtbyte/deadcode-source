/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AimBot
extends Hack {
    public ModeValue a;
    public DoubleValue b;
    public IntegerValue c;
    public BooleanValue d;
    public static EntityLivingBase e;
    public TimerUtils f;

    public AimBot(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.a = new ModeValue("Priority", false, new Mode("Closest", true), new Mode("Health"));
        this.d = new BooleanValue("Through walls", false);
        this.b = new DoubleValue("Range", 3.4, 1.0, 7.0);
        this.c = new IntegerValue("FOV", 360, 1, 360);
        this.a(this.a, this.d, this.b, this.c);
        this.b("Other");
        this.f = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Automatically points towards player.";
    }

    @Override
    public void onDisable() {
        e = null;
        super.onDisable();
    }

    @Override
    public void onEnable() {
        e = null;
        super.onEnable();
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        this.c();
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        this.b();
        super.onPlayerTickEvent(playerTickEvent);
    }

    public void b() {
        if (e == null) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        float[] fArray = MathUtils.a((Entity)e, cy_0.a);
        entityPlayerSP.rotationYaw = fArray[0];
        entityPlayerSP.rotationPitch = fArray[1];
        e = null;
    }

    public void c() {
        for (Object e : et.b()) {
            EntityLivingBase entityLivingBase;
            if (!(e instanceof EntityLivingBase) || !this.c(entityLivingBase = (EntityLivingBase)e)) continue;
            AimBot.e = entityLivingBase;
        }
    }

    public boolean a(EntityLivingBase entityLivingBase) {
        return this.a.getModeByIndex(0).isToggled() && eQ.c(entityLivingBase, e) || this.a.getModeByIndex(1).isToggled() && eQ.a(entityLivingBase, e);
    }

    public boolean b(EntityLivingBase entityLivingBase) {
        return entityLivingBase.getDistance((Entity)Wrapper.INSTANCE.getLocalPlayer()) <= this.d();
    }

    public float d() {
        return (float)(Wrapper.INSTANCE.getLocalPlayer().isSprinting() ? (double)this.b.getValue().floatValue() - 0.2 : (double)this.b.getValue().floatValue());
    }

    public boolean c(EntityLivingBase entityLivingBase) {
        return !(entityLivingBase instanceof EntityPlayerSP) && !eQ.a((Entity)entityLivingBase) && eQ.a() && entityLivingBase != Wrapper.INSTANCE.getLocalPlayer() && !entityLivingBase.isDead && entityLivingBase.deathTime <= 0 && eQ.a(entityLivingBase) && eQ.c(entityLivingBase) && this.b(entityLivingBase) && MathUtils.a((Entity)entityLivingBase, (double)this.c.getValue().intValue()) && eQ.b(entityLivingBase) && ((Boolean)this.d.getObjectValue() != false || Wrapper.INSTANCE.getLocalPlayer().canEntityBeSeen((Entity)entityLivingBase)) && this.a(entityLivingBase);
    }
}

