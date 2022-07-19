/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;

public class aD
extends Component {
    public eC a;
    public eC b;
    public eC c;
    public HackCategory d;
    public aT e;
    public String f;
    public boolean g;
    public int h;
    public int i;
    public d j;
    public d k;
    public d l;
    public boolean m;
    public boolean n;
    public double o;
    public double p;
    public double q;
    public float r;

    @Override
    public void c(int n2, int n3) {
        this.a();
        super.c(n2, n3);
    }

    public void a() {
        this.k.a(this.g);
        this.r = (float)this.k.b();
        this.l.a(this.g);
        this.p = -((float)(this.l.b() * 8.0));
        this.q = -((float)(this.l.b() * 8.0));
        if (this.m) {
            this.j.a(true);
            this.o = -this.j.b() * 3.0;
        } else if (this.n) {
            this.j.a(true);
            this.o = this.j.b() * 4.0;
        } else {
            this.j.a(false);
            this.o = this.o > 0.0 ? this.j.b() * 3.0 : -this.j.b() * 3.0;
        }
    }

    public aD(int n2, int n3, int n4, int n5, Component component, HackCategory hackCategory) {
        super(n2, n3, n4, n5, ComponentType.n, component);
        this.d = hackCategory;
        this.f = et.b(hackCategory.toString());
        this.a(this.f);
        switch (hackCategory) {
            case Combat: {
                this.c.a(12.0f);
                this.c.b(11.0f);
                this.b.a(15.0f);
                this.b.b(14.0f);
                this.h = aX.j;
                break;
            }
            case World: {
                this.c.a(17.0f);
                this.c.b(17.0f);
                this.b.a(12.0f);
                this.b.b(12.0f);
                this.h = er.a(208, 223, 40, 255);
                break;
            }
            case Render: {
                this.c.a(11.0f);
                this.c.b(11.0f);
                this.b.a(15.0f);
                this.b.b(10.0f);
                this.h = aX.i;
                break;
            }
            case Player: {
                this.c.a(9.0f);
                this.c.b(9.0f);
                this.b.a(12.0f);
                this.b.b(12.0f);
                this.h = aX.l;
                break;
            }
            case Other: {
                this.c.a(11.0f);
                this.c.b(10.0f);
                this.b.a(13.0f);
                this.b.b(11.0f);
                this.h = er.a(237, 229, 31, 255);
                break;
            }
            case Movement: {
                this.c.a(13.0f);
                this.c.b(13.0f);
                this.b.a(21.0f);
                this.b.b(21.0f);
                this.h = er.a(9, 240, 157, 255);
                break;
            }
            case Exploit: {
                this.c.a(9.0f);
                this.c.b(9.0f);
                this.b.a(12.0f);
                this.b.b(12.0f);
                this.h = er.a(222, 9, 240, 255);
                break;
            }
        }
    }

    public aD(int n2, int n3, int n4, int n5, Component component, aT aT2) {
        super(n2, n3, n4, n5, ComponentType.n, component);
        this.e = aT2;
        this.f = et.b(aT2.toString());
        this.a(this.f);
        switch (aT2) {
            case a: {
                this.c.a(11.0f);
                this.c.b(8.0f);
                this.b.a(13.0f);
                this.b.b(10.0f);
                this.h = er.a(237, 31, 118, 255);
                break;
            }
            case b: {
                this.c.a(8.0f);
                this.c.b(8.0f);
                this.b.a(11.0f);
                this.b.b(11.0f);
                this.h = aX.k;
                break;
            }
            case c: {
                this.c.a(10.0f);
                this.c.b(10.0f);
                this.b.a(12.0f);
                this.b.b(12.0f);
                this.h = aX.n;
                this.i = aX.h;
                break;
            }
        }
    }

    public void a(String string) {
        this.a = \u2007\u2008\u00a0.n.a("Background", string);
        this.c = \u2007\u2008\u00a0.n.a("Unselected", string);
        this.b = \u2007\u2008\u00a0.n.a("Selected", string);
        this.a.a(98.0f);
        this.a.b(25.0f);
        this.i = aX.n;
        this.j = new d();
        this.k = new d();
        this.l = new d();
    }

    @Override
    public boolean isMouseOver(int n2, int n3) {
        return n2 >= this.getX() && n3 >= this.getY() && n2 <= this.getX() + this.getWidth() && n3 <= this.getY() + (this.getHeight() - 1);
    }
}

