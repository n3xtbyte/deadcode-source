/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AntiBadEffects
extends Hack {
    public static boolean a;

    public AntiBadEffects(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Disable bad effects.";
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

