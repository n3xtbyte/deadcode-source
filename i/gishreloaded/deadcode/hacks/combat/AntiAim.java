/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.apache.commons.lang3.RandomUtils
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.combat.BowAimBot;
import i.gishreloaded.deadcode.hacks.combat.KillAura;
import i.gishreloaded.deadcode.hacks.combat.TriggerBot;
import i.gishreloaded.deadcode.utils.MathUtils1;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.commons.lang3.RandomUtils;

public class AntiAim
extends Hack {
    public ModeValue a;
    public ModeValue b;
    public IntegerValue c;
    public BooleanValue d;
    public float e;
    public float f;
    public TimerUtils g;
    public TimerUtils h;

    public AntiAim(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.a = new ModeValue("Rotation yaw", new Mode("Spin", true), new Mode("Right"), new Mode("Left"), new Mode("Right/Left"), new Mode("Random"), new Mode("Null"));
        this.b = new ModeValue("Rotation pitch", new Mode("Down", true), new Mode("Up"), new Mode("Down/Up"), new Mode("Random"), new Mode("Null"));
        this.c = new IntegerValue("Speed", 20, 0, 30);
        this.d = new BooleanValue("Stop on Attack", true);
        this.a(this.a, this.b, this.c, this.d);
        this.b("Other");
        this.g = new TimerUtils();
        this.h = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Moves differently to make it harder for the enemy to hit.";
    }

    @Override
    public void onEnable() {
        ef.j();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        ef.j();
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (this.a.getMode("Spin").isToggled()) {
            this.e += (float)this.c.getValue().intValue();
            if (this.e > 180.0f) {
                this.e = -180.0f;
            }
            if (this.e < -180.0f) {
                this.e = 180.0f;
            }
        } else if (this.a.getMode("Random").isToggled()) {
            double d2 = Math.min(MathUtils1.a(-180.0, 180.0), (double)this.c.getValue().intValue());
            this.e = (float)d2;
        } else if (this.a.getMode("Right").isToggled()) {
            this.e = Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 90.0f;
        } else if (this.a.getMode("Left").isToggled()) {
            this.e = Wrapper.INSTANCE.getLocalPlayer().rotationYaw - 90.0f;
        } else if (this.a.getMode("Right/Left").isToggled()) {
            boolean bl = RandomUtils.nextBoolean();
            this.e = bl ? Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 90.0f : Wrapper.INSTANCE.getLocalPlayer().rotationYaw - 90.0f;
        } else if (this.a.getMode("Null").isToggled()) {
            this.e = Wrapper.INSTANCE.getLocalPlayer().rotationYaw;
        }
        if (this.b.getMode("Down").isToggled()) {
            this.f = 90.0f;
        } else if (this.b.getMode("Up").isToggled()) {
            this.f = -90.0f;
        } else if (this.b.getMode("Random").isToggled()) {
            this.f = (float)MathUtils1.a(-90.0, 90.0);
        } else if (this.b.getMode("Down/Up").isToggled()) {
            boolean bl = RandomUtils.nextBoolean();
            this.f = bl ? -90.0f : 90.0f;
        } else if (this.b.getMode("Null").isToggled()) {
            this.f = Wrapper.INSTANCE.getLocalPlayer().rotationPitch;
        }
        float f2 = Wrapper.INSTANCE.getGameSettings().mouseSensitivity * 0.6f + 0.2f;
        float f3 = f2 * f2 * f2 * 1.2f;
        this.e -= this.e % f3;
        this.f -= this.f % f3;
        if (Float.isNaN(this.e) && Float.isNaN(this.f)) {
            return;
        }
        if (!this.b()) {
            this.g.resetTime();
            return;
        }
        if (!this.g.isReached(10L)) {
            return;
        }
        ef.a(this.e, this.f);
        Wrapper.INSTANCE.getLocalPlayer().renderYawOffset = this.e;
        Wrapper.INSTANCE.getLocalPlayer().rotationYawHead = this.e;
        if (this.h.isReached(1L)) {
            Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
        }
        if (this.h.isReached(2L)) {
            Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw - 2.0E-4);
            this.h.resetTime();
        }
        super.onClientTickEvent(clientTickEvent);
    }

    public boolean b() {
        if (((Boolean)this.d.getObjectValue()).booleanValue() && (Wrapper.INSTANCE.getGameSettings().keyBindAttack.isKeyDown() || Wrapper.INSTANCE.getGameSettings().keyBindUseItem.isKeyDown() || KillAura.J != null || TriggerBot.f != null)) {
            return false;
        }
        if (BowAimBot.b != null) {
            return false;
        }
        return !KillAura.B() || KillAura.J == null;
    }
}

