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

public class ViewModel
extends Hack {
    public static boolean a;
    public static DoubleValue b;
    public static DoubleValue c;
    public static DoubleValue d;
    public static DoubleValue e;
    public static DoubleValue f;
    public static DoubleValue g;

    public ViewModel(String string) {
        super(string, HackCategory.Render);
        b = new DoubleValue("Left-X", 1.0, 0.0, 2.0);
        c = new DoubleValue("Left-Y", 1.0, 0.0, 2.0);
        d = new DoubleValue("Left-Z", 1.0, 0.0, 2.0);
        e = new DoubleValue("Right-X", 1.0, 0.0, 2.0);
        f = new DoubleValue("Right-Y", 1.0, 0.0, 2.0);
        g = new DoubleValue("Right-Z", 1.0, 0.0, 2.0);
        this.b("LeftHand");
        this.a(b, c, d);
        this.b("RightHand");
        this.a(e, f, g);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "View model.";
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

