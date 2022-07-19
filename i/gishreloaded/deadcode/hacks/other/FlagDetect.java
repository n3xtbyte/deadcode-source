/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.movement.Flight;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.value.Value;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import net.minecraft.network.play.server.SPacketPlayerPosLook;

public class FlagDetect
extends Hack {
    public BooleanValue a;
    public BooleanValue b;
    public BooleanValue c;
    public BooleanValue d;
    public BooleanValue e;
    public IntegerValue f = new IntegerValue("Max flags", 3, 1, 20);
    public int g;

    public FlagDetect(String string) {
        super(string, HackCategory.Other);
        this.a = new BooleanValue("Speed", true);
        this.b = new BooleanValue("Flight", true);
        this.c = new BooleanValue("Jesus", true);
        this.d = new BooleanValue("TargetStrafe", true);
        this.e = new BooleanValue("Teleport", true);
        this.b("General");
        this.a(this.f, this.a, this.b, this.c, this.d, this.e);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Disable hacks when anti-cheat is detected.";
    }

    @Override
    public void onEnable() {
        this.g = 0;
        super.onEnable();
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (object instanceof SPacketPlayerPosLook) {
            for (Value value : this.getSettings()) {
                if (!(value instanceof BooleanValue)) continue;
                this.a((BooleanValue)value);
            }
        }
        return super.a(object, bw2);
    }

    public void a(BooleanValue booleanValue) {
        if (!((Boolean)booleanValue.getObjectValue()).booleanValue()) {
            return;
        }
        String string = booleanValue.getName();
        Hack hack = HackManager.getHack(string);
        if (hack.isToggled()) {
            if (hack instanceof Flight && (Flight.a.getModeByIndex(9).isToggled() || Flight.a.getModeByIndex(5).isToggled() || Flight.a.getModeByIndex(10).isToggled())) {
                return;
            }
            ++this.g;
            if (this.g >= this.f.getValue()) {
                String string2 = "Detecting anti-cheat flag in '" + string + "' hack";
                \u2007\u2008\u00a0.p.a("!", string2, aX.j, aX.j, 0.01);
                hack.toggle();
                this.g = 0;
            }
        }
    }
}

