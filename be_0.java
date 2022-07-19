/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;

/*
 * Renamed from bE
 */
public class be_0
extends Component {
    public eC a;
    public String b;
    public String c;
    public bh d;
    public bh e;

    public be_0(int n2, int n3, int n4, int n5, Component component, eC eC2, String string) {
        super(n2, n3, n4, n5, ComponentType.l, component);
        this.a = eC2;
        this.b = string;
    }

    public String a() {
        return "";
    }

    public boolean d() {
        return false;
    }

    @Override
    public void c(int n2, int n3) {
        this.e();
        super.c(n2, n3);
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        if (this.d != null && this.d.isMouseOver(n2, n3)) {
            this.d.onMousePress(n2, n3, n4);
        }
        if (this.e != null && this.e.isMouseOver(n2, n3)) {
            this.e.onMousePress(n2, n3, n4);
        }
        super.onMousePress(n2, n3, n4);
    }

    public void e() {
        if (this.d == null) {
            return;
        }
        int n2 = 4;
        int n3 = this.getX() + this.getWidth() - n2 - this.d.getWidth() - 2;
        int n4 = this.getY() + this.getHeight() / 2 - this.d.getHeight() / 2;
        this.d.setXY(n3, n4);
        if (this.e == null) {
            return;
        }
        this.e.setXY(n3 - n2 * 2 - this.e.getWidth() + 2, n4);
    }
}

