/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ModeValue;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Teams
extends Hack {
    public static boolean a;
    public ModeValue b;

    public Teams(String string) {
        super(string, HackCategory.Other);
        this.b("General");
        this.b = new ModeValue("Mode", new Mode("NameColor", true), new Mode("Base"), new Mode("ArmorColor"));
        this.a(this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Ignore if player in your team.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        a = true;
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onDisable() {
        a = false;
        super.onDisable();
    }
}

