/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Debug
extends Hack {
    public static boolean toggled;

    public Debug(String string) {
        super(string, HackCategory.Other);
    }

    @Override
    public String getDescription() {
        return "Show debug messages.";
    }

    @Override
    public void onDisable() {
        toggled = false;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        toggled = true;
        super.onClientTickEvent(clientTickEvent);
    }
}

