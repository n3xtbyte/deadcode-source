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

public class NoGuiEvents
extends Hack {
    public static boolean a;

    public NoGuiEvents(String string) {
        super(string, HackCategory.Other);
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

    @Override
    public String getDescription() {
        return "Disables events when the GUI is open.";
    }
}

