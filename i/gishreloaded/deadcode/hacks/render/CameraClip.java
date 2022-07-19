/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class CameraClip
extends Hack {
    public static boolean a;
    public static DoubleValue b;
    public static DoubleValue c;
    public static DoubleValue d;

    public CameraClip(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        b = new DoubleValue("FOV", 90.0, 40.0, 160.0);
        c = new DoubleValue("X", 0.1, 0.1, 5.0);
        d = new DoubleValue("Y", 0.1, 0.1, 5.0);
        this.a(b, c, d);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Camera clip.";
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

