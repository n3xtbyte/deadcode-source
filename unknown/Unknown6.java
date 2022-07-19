/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package unknown;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import org.lwjgl.input.Keyboard;

public class Unknown6
extends Component {
    public final String a;
    public Hack b;
    public boolean c;
    public boolean d;
    public eC e;
    public eC f;
    public eC g;
    public aB h;

    public Unknown6(int n2, int n3, int n4, int n5, Component component, Hack hack) {
        super(n2, n3, n4, n5, ComponentType.o, component);
        this.b = hack;
        \u00a0\u00a0 \u00a0\u00a02 = \u2007\u2008\u00a0.f.if();
        this.a = String.format("%s@%s~$: cd %s/%s", \u00a0\u00a02.if(), "DeadCode".toLowerCase(), hack.getCategory().toString().toLowerCase(), hack.getName().toLowerCase());
        this.e = \u2007\u2008\u00a0.n.a("Other", "Setting-Enabled");
        this.f = \u2007\u2008\u00a0.n.a("Other", "Setting-Disabled");
        this.g = \u2007\u2008\u00a0.n.a("Other", "Close");
        this.c = hack.getSettings().size() < 1;
        this.h = new aB(20L, true);
    }

    @Override
    public void c() {
        if (Keyboard.getEventKeyState() && this.d) {
            if (Keyboard.getEventKey() == 211) {
                this.b.setKey(-1);
                this.b.d(-1);
            } else {
                this.b.d(-1);
                this.b.setKey(Keyboard.getEventKey());
            }
            this.d = false;
        }
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        switch (n4) {
            case 0: {
                this.b.toggle();
                break;
            }
            case 1: {
                if (this.c) break;
                this.h.a(this.a);
                \u2007\u2008\u00a0.s.if().k().d().a = this;
                break;
            }
            case 2: {
                this.d = !this.d;
                break;
            }
            default: {
                if (!this.d) break;
                this.b.setKey(-1);
                this.b.d(n4);
                this.d = false;
            }
        }
        super.onMousePress(n2, n3, n4);
    }
}

