/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Vector2f
 */
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.utils.TimerUtils;
import javax.vecmath.Vector2f;

public class cL
extends dp {
    public int a;
    public boolean b = false;
    public Vector2f c;
    public es_0 d;
    public ch e;
    public au f;
    public fD g;
    public TimerUtils h = new TimerUtils();
    public TimerUtils i = new TimerUtils();
    public boolean j;
    public int k;
    public int l;
    public int m;
    public long n = -1L;
    public double o = -1.0;
    public double p = -1.0;
    public int q = 0;
    public int r = 0;

    public cL(int n2, int n3, int n4, int n5) {
        super(n2, n3, n4, n5, ComponentType.a, null);
        this.c = new Vector2f((float)(0 - this.getX()), (float)(0 - this.getY()));
    }

    public es_0 a() {
        return this.d;
    }

    public ch d() {
        return this.e;
    }

    public au e() {
        return this.f;
    }

    public fD f() {
        return this.g;
    }

    public void n() {
        if (this.j && this.i.isReached(250L)) {
            this.a().onMousePress(this.k, this.l, this.m);
            this.j = false;
            this.i.resetTime();
            this.h.resetTime();
        }
    }

    @Override
    public void a(Component component) {
        if (component instanceof es_0) {
            this.d = (es_0)component;
        }
        if (component instanceof ch) {
            this.e = (ch)component;
        }
        if (component instanceof au) {
            this.f = (au)component;
        }
        if (component instanceof fD) {
            this.g = (fD)component;
        }
        super.a(component);
    }

    @Override
    public void onKeyReleased(int n2, char c) {
        for (Component component : this.b()) {
            component.onKeyReleased(n2, c);
        }
        super.onKeyReleased(n2, c);
    }

    @Override
    public void b(int n2, char c) {
        super.b(n2, c);
    }

    @Override
    public void onMouseDrag(int n2, int n3) {
        if (this.b) {
            this.q = n2;
            this.r = n3;
        }
        for (Component component : this.b()) {
            if (!component.isMouseOver(n2, n3)) continue;
            component.onMouseDrag(n2, n3);
        }
        super.onMouseDrag(n2, n3);
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        if (this.f(n2, n3) && n4 == 0) {
            this.c = new Vector2f((float)(n2 - this.getX()), (float)(n3 - this.getY()));
            this.q = n2;
            this.r = n3;
            this.b = true;
        }
        for (Component component : this.b()) {
            if (!component.isMouseOver(n2, n3)) continue;
            if (component == this.a()) {
                if (!this.h.isReached(100L)) continue;
                boolean bl = this.a().a != null;
                component.onMousePress(n2, n3, n4);
                if (component == this.a() && !this.j && bl) {
                    this.k = n2;
                    this.l = n3;
                    this.m = n4;
                    this.j = true;
                    this.i.resetTime();
                    continue;
                }
                this.h.resetTime();
                continue;
            }
            component.onMousePress(n2, n3, n4);
        }
        super.onMousePress(n2, n3, n4);
    }

    @Override
    public void onMouseRelease(int n2, int n3, int n4) {
        this.b = false;
        for (Component component : this.b()) {
            component.onMouseRelease(n2, n3, n4);
        }
        super.onMouseRelease(n2, n3, n4);
    }

    @Override
    public void c(int n2, int n3, int n4) {
        for (Component component : this.b()) {
            if (!component.isMouseOver(n2, n3)) continue;
            component.c(n2, n3, n4);
        }
        super.c(n2, n3, n4);
    }

    @Override
    public void c(int n2, int n3) {
        long l2 = System.currentTimeMillis();
        int n4 = (int)((float)this.q - this.c.getX());
        int n5 = (int)((float)this.r - this.c.getY());
        n4 = (int)(this.o + ((double)n4 - this.o) * Math.pow((double)(l2 - this.n) / 185.0, 0.5));
        n5 = (int)(this.p + ((double)n5 - this.p) * Math.pow((double)(l2 - this.n) / 185.0, 0.5));
        this.setXY(n4, n5);
        this.o = n4;
        this.p = n5;
        this.n = l2;
        for (Component component : this.b()) {
            component.setXY(this.getX() + component.j(), this.getY() + component.k());
        }
        super.c(n2, n3);
    }

    @Override
    public void c() {
        this.n();
        for (Component component : this.b()) {
            component.c();
        }
        super.c();
    }

    public boolean f(int n2, int n3) {
        return n2 >= this.getX() && n3 >= this.getY() && n2 <= this.getX() + this.getWidth() && n3 <= this.getY() + this.a;
    }
}

