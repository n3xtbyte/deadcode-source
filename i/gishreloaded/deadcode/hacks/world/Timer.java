/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.world;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.ReflectionUtils;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Timer
extends Hack {
    public DoubleValue a;

    public Timer(String string) {
        super(string, HackCategory.World);
        this.b("General");
        this.a = new DoubleValue("Timer", 1.0, 0.1, 10.0);
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Changes the game time of the client.";
    }

    @Override
    public void onDisable() {
        ReflectionUtils.setTimerSpeedD(1.0);
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        ReflectionUtils.setTimerSpeedD(this.a.getValue());
        super.onClientTickEvent(clientTickEvent);
    }
}

