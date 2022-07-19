/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.other.Sleep;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.GuiScreen;

public class UserInterface
extends Hack {
    public static BooleanValue a;
    public static BooleanValue b;
    public static BooleanValue c;
    public static BooleanValue d;
    public TimerUtils e;

    public UserInterface(String string) {
        super(string, HackCategory.Render);
        this.setKey(54);
        this.d(false);
        a = new BooleanValue("Blur", true);
        b = new BooleanValue("Shadow", true);
        c = new BooleanValue("Glitch", false);
        d = new BooleanValue("Black And White", false);
        this.b("General");
        this.a(a, b, d, c);
        this.b("Other");
        this.e = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Graphical user interface.";
    }

    @Override
    public void onEnable() {
        if (Sleep.a) {
            return;
        }
        Wrapper.INSTANCE.getMinecraft().displayGuiScreen((GuiScreen)\u2007\u2008\u00a0.s.if());
        super.onEnable();
    }
}

