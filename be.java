/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ModeValue;
import java.util.ArrayList;

public class be
extends Component {
    public ModeValue a;
    public Hack b;
    public ArrayList c;
    public float d;
    public boolean e;
    public Mode f;
    public d g;
    public float h;
    public eC i;
    public eC j;

    public be(int n2, int n3, int n4, int n5, Component component, Hack hack, ModeValue modeValue) {
        super(n2, n3, n4, n5, ComponentType.COMBO_BOX, component);
        this.b = hack;
        this.a = modeValue;
        this.i = \u2007\u2008\u00a0.n.a("Other", "ComboBox-Arrow1");
        this.j = \u2007\u2008\u00a0.n.a("Other", "ComboBox-Arrow2");
        this.c = new ArrayList();
        for (Mode mode : this.a.getModes()) {
            aR aR2 = new aR(this, String.format("// %s", mode.getName()));
            this.c.add(aR2);
        }
        this.g = new d();
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        boolean bl = this.e = !this.e;
        if (!this.e) {
            for (int i2 = 0; i2 < this.c.size(); ++i2) {
                boolean bl2;
                aR aR2 = (aR)this.c.get(i2);
                boolean bl3 = bl2 = n2 >= this.getX() && (float)n3 >= aR2.b && n2 <= this.getX() + this.getWidth() && (float)n3 <= aR2.b + aR2.c;
                if (!bl2) continue;
                for (Mode mode : this.a.getModes()) {
                    mode.setToggled(false);
                }
                this.a.getModes()[i2].setToggled(true);
                this.b.a(this);
            }
        }
        super.onMousePress(n2, n3, n4);
    }

    @Override
    public boolean isMouseOver(int n2, int n3) {
        if (!this.e) {
            return super.isMouseOver(n2, n3);
        }
        return n2 >= this.getX() && n3 >= this.getY() && n2 <= this.getX() + this.getWidth() && (float)n3 <= this.d;
    }

    @Override
    public void c(int n2, int n3) {
        this.a();
        super.c(n2, n3);
    }

    @Override
    public void c() {
        for (Mode mode : this.a.getModes()) {
            if (!mode.isToggled()) continue;
            this.f = mode;
        }
        super.c();
    }

    public void a() {
        this.g.a(this.e);
        this.h = (float)this.g.b();
    }
}

