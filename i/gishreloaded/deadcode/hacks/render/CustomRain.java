/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.types.ColorValue;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class CustomRain
extends Hack {
    public static boolean a;
    public static ColorValue b;

    public CustomRain(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        b = new ColorValue("Color", aX.i);
        this.a(b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Custom rain.";
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

