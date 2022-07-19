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
import i.gishreloaded.deadcode.value.Value;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import org.lwjgl.input.Mouse;

public class cB
extends Component {
    public Value a;
    public Hack b;
    public eC c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public float i;
    public float j;
    public eM k;
    public long l = -1L;
    public double m = -1.0;
    public double n = -1.0;

    public cB(int n2, int n3, int n4, int n5, Component component, Hack hack, dr_0 dr_02) {
        super(n2, n3, n4, n5, ComponentType.POINT, component);
        this.b = hack;
        this.a = dr_02;
        this.k = (eM)dr_02.getObjectValue();
        this.i = 0.5f;
        this.j = 0.5f;
        this.c = \u2007\u2008\u00a0.n.a("Other", "Grid");
        this.l = System.currentTimeMillis();
    }

    public void a() {
        this.d = this.getX() + 4;
        this.e = (int)this.c.a();
        this.f = this.getY() + 25;
        this.g = (int)this.c.b();
    }

    @Override
    public void c(int n2, int n3) {
        this.a();
        super.c(n2, n3);
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        if (this.i(n2, n3)) {
            this.h(n2, n3);
            this.h = true;
        }
    }

    public void d() {
        this.a.setValue(this.k);
    }

    public double f(int n2, int n3) {
        return (double)(n2 -= this.d) / (double)this.e;
    }

    public double g(int n2, int n3) {
        return (double)(n3 -= this.f) / (double)this.g;
    }

    public int e() {
        return Wrapper.INSTANCE.getMinecraft().displayWidth / 2;
    }

    public int f() {
        return Wrapper.INSTANCE.getMinecraft().displayHeight / 2;
    }

    public void h(int n2, int n3) {
        int n4 = 0;
        int n5 = this.e();
        int n6 = this.f();
        double d2 = this.f(n2, n3);
        double d3 = this.a((double)(n5 - n4) * d2 + (double)n4, 2);
        double d4 = this.g(n2, n3);
        double d5 = this.a((double)(n6 - n4) * d4 + (double)n4, 2);
        if (d3 < (double)n5) {
            this.i = (float)d2;
            this.k.a((int)d3);
        }
        if (d5 < (double)n6) {
            this.j = (float)d4;
            this.k.b((int)d5);
        }
        this.d();
    }

    public boolean i(int n2, int n3) {
        int n4 = this.e;
        int n5 = this.g;
        int n6 = this.d;
        int n7 = this.f;
        return n2 >= n6 && n3 >= n7 && n2 <= n6 + n4 && n3 <= n7 + n5;
    }

    @Override
    public void onMouseRelease(int n2, int n3, int n4) {
        this.h = false;
    }

    @Override
    public void c() {
        int n2 = this.e();
        int n3 = this.f();
        int[] nArray = UIScreen.c;
        this.h = false;
        if (this.h && !this.i(nArray[0], nArray[1])) {
            if (nArray[0] <= this.d) {
                this.i = 0.0f;
                this.k.a(0);
                this.d();
            } else {
                this.i = 1.0f;
                this.k.a(n2);
                this.d();
            }
            if (nArray[1] <= this.f) {
                this.j = 0.0f;
                this.k.b(0);
                this.d();
            } else {
                this.j = 1.0f;
                this.k.b(n3);
                this.d();
            }
        }
        if (Mouse.isButtonDown((int)0) && this.i(nArray[0], nArray[1])) {
            this.h = true;
        }
    }

    @Override
    public void onMouseDrag(int n2, int n3) {
        if (this.h && this.i(n2, n3)) {
            this.h(n2, n3);
        }
    }

    private /* synthetic */ double a(double d2, int n2) {
        double d3 = Math.pow(10.0, n2);
        double d4 = d2 * d3;
        return (double)Math.round(d4) / d3;
    }
}

