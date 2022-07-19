/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Zoom
extends Hack {
    public static boolean a;
    public static float b;
    public TimerUtils c = new TimerUtils();

    public Zoom(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Simple zoom.";
    }

    @Override
    public void onDisable() {
        a = false;
        b = 1.0f;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (this.c.isReached(15L)) {
            if (b < 4.0f) {
                b += 0.5f;
            }
            this.c.resetTime();
        }
        a = true;
        super.onClientTickEvent(clientTickEvent);
    }

    static {
        b = 1.0f;
    }
}

