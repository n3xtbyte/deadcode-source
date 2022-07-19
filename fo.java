/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.value.types.BooleanValue;

public class fo
extends Component {
    public BooleanValue a;
    public Hack b;
    public eC c;
    public eC d;
    public d e;
    public float f;

    public fo(int n2, int n3, int n4, int n5, Component component, Hack hack, BooleanValue booleanValue) {
        super(n2, n3, n4, n5, ComponentType.MODULE_SWITCHER, component);
        this.b = hack;
        this.a = booleanValue;
        this.c = \u2007\u2008\u00a0.n.a("Other", "On");
        this.d = \u2007\u2008\u00a0.n.a("Other", "Off");
        this.e = new d(0.02);
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        this.e.a();
        this.a.setValue((Boolean)this.a.getObjectValue() == false);
        super.onMousePress(n2, n3, n4);
    }

    @Override
    public void c(int n2, int n3) {
        this.e.a(true);
        this.f = (float)this.e.b();
        super.c(n2, n3);
    }
}

