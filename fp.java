/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
import i.gishreloaded.deadcode.excluded.UIScreen;
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.Value;
import org.lwjgl.input.Mouse;

public class fp
extends Component {
    public Hack a;
    public Value b;
    public boolean c;
    public double d;
    public double e;
    public double f;
    public double g;
    public Number h;
    public int i;
    public int j;
    public int k;
    public int l;
    public long m = -1L;
    public double n = -1.0;

    public fp(int n2, int n3, int n4, int n5, Number number, Number number2, Number number3, Component component, Hack hack, Value value) {
        super(n2, n3, n4, n5, ComponentType.v, component);
        this.b = value;
        this.a = hack;
        this.h = number3;
        this.d = number.doubleValue();
        this.e = number2.doubleValue();
        this.f = number3.doubleValue();
        this.g = this.f / this.e;
        this.m = System.currentTimeMillis();
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        if (n2 > this.i) {
            this.i(n2, n3);
            this.c = true;
        }
    }

    @Override
    public void c(int n2, int n3) {
        this.d();
        super.c(n2, n3);
    }

    public void a() {
        this.b.setValue(this.f);
    }

    public void d() {
        this.i = this.getX() + 3;
        this.j = this.getWidth() - 6;
        this.k = this.getY() + 4;
        this.l = this.getHeight() - 4;
    }

    public double f(int n2, int n3) {
        n3 -= this.k;
        n3 = this.l - n3;
        return (double)n3 / (double)this.l;
    }

    public double g(int n2, int n3) {
        n2 -= this.i;
        n2 = this.j - n2;
        return (double)n2 / (double)this.j;
    }

    public double h(int n2, int n3) {
        return (double)(n2 -= this.i) / (double)this.j;
    }

    public void i(int n2, int n3) {
        double d2 = this.h(n2, n3);
        double d3 = this.getY() + this.getHeight() / 2;
        if (n2 > this.getX() + this.getWidth() - 20) {
            d2 = (double)n3 > d3 ? this.g(n2, n3) : this.h(n2, n3);
        } else {
            if ((double)n3 > d3 - 2.0) {
                d2 = this.f(n2, n3);
            }
            if ((double)n3 > d3 + 4.0) {
                d2 = this.g(n2, n3);
            }
        }
        double d4 = this.a((this.e - this.d) * d2 + this.d, 2);
        if (d4 > this.e) {
            return;
        }
        this.g = d2;
        this.f = d4;
        this.a();
        this.a.a(this);
    }

    public boolean j(int n2, int n3) {
        int n4 = this.j;
        int n5 = this.l;
        int n6 = this.i;
        int n7 = this.k;
        return n2 >= n6 && n3 >= n7 && n2 <= n6 + n4 && n3 <= n7 + n5;
    }

    @Override
    public void onMouseRelease(int n2, int n3, int n4) {
        this.c = false;
    }

    @Override
    public void c() {
        int[] nArray = UIScreen.c;
        this.c = false;
        if (this.c && !this.j(nArray[0], nArray[1])) {
            if (nArray[0] <= this.i) {
                this.g = 0.0;
                this.f = this.d;
                this.a();
            } else {
                this.g = 0.5;
                this.f = this.e;
                this.a();
            }
        }
        if (Mouse.isButtonDown((int)0) && this.j(nArray[0], nArray[1])) {
            this.c = true;
        }
    }

    @Override
    public void onMouseDrag(int n2, int n3) {
        if (this.c && n2 > this.i) {
            this.i(n2, n3);
        }
    }

    public String e() {
        if (this.h instanceof Integer) {
            return RenderUtils.a(this.f, 0);
        }
        return RenderUtils.a(this.f, 2);
    }

    private /* synthetic */ double a(double d2, int n2) {
        double d3 = Math.pow(10.0, n2);
        double d4 = d2 * d3;
        return (double)Math.round(d4) / d3;
    }
}

