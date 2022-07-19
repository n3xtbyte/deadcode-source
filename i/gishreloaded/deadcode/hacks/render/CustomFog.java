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
import i.gishreloaded.deadcode.value.types.DoubleValue;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class CustomFog
extends Hack {
    public static boolean a;
    public static ColorValue b;
    public static DoubleValue c;

    public CustomFog(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        c = new DoubleValue("Distance", 0.5, 0.1f, 1.0);
        b = new ColorValue("Color", aX.i);
        this.a(c, b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Custom fog.";
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

