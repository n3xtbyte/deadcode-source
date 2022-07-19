/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import org.lwjgl.input.Keyboard;

public class fF
extends Component {
    public Hack a;
    public boolean b;
    public eC c;

    public fF(int n2, int n3, int n4, int n5, Component component, Hack hack) {
        super(n2, n3, n4, n5, ComponentType.BIND, component);
        this.a = hack;
        this.c = \u2007\u2008\u00a0.n.a("Other", "Off");
    }

    @Override
    public void c() {
        if (Keyboard.getEventKeyState() && this.b) {
            if (Keyboard.getEventKey() == 211) {
                this.a.setKey(-1);
                this.a.d(-1);
            } else {
                this.a.d(-1);
                this.a.setKey(Keyboard.getEventKey());
            }
            this.b = false;
        }
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        if (n4 == 0 || n4 == 1 || n4 == 2) {
            this.b = !this.b;
            return;
        }
        if (this.b) {
            this.a.setKey(-1);
            this.a.d(n4);
            this.b = false;
        }
        super.onMousePress(n2, n3, n4);
    }
}

