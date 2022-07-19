/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.ReflectionUtils;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoJumpDelay
extends Hack {
    public NoJumpDelay(String string) {
        super(string, HackCategory.Movement);
    }

    @Override
    public String getDescription() {
        return "Remove jump delay.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        ReflectionUtils.resetJumpTicks();
        super.onClientTickEvent(clientTickEvent);
    }
}

