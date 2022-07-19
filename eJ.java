/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 */
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.io.File;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class eJ
extends dp {
    public int a = 20;
    public int b = this.a + 8;
    private eC d;
    private eC e;
    private eC f;
    private bh g;
    private bh h;
    public eg c;

    public eJ(int n2, int n3, int n4, int n5, Component component) {
        super(n2, n3, n4, n5, ComponentType.h, component);
        bu bu2 = Wrapper.INSTANCE.n();
        this.c = new eg(bu2, n2, n3, n4, this.a, "Type your config name...");
        this.c.a("Search in config list...");
        this.c.b(false);
        this.d = \u2007\u2008\u00a0.n.a("Other", "Save");
        this.e = \u2007\u2008\u00a0.n.a("Other", "Delete");
        this.f = \u2007\u2008\u00a0.n.a("Other", "Load");
        eC eC2 = \u2007\u2008\u00a0.n.a("Other", "Add");
        this.g = new df(this, n2, n3, 62, 16, this, eC2, "New config", aX.h);
        eC2 = \u2007\u2008\u00a0.n.a("Other", "Search");
        this.h = new eX(this, n2, n3, 16, 16, this, eC2, null, aX.h);
    }

    public void a(bh bh2) {
        this.c.b(!this.c.j());
        if (this.c.j()) {
            bh2.d = "Press enter";
        } else {
            bh2.d = "New config";
            this.a();
        }
    }

    public void a() {
        String string = this.c.b().trim();
        this.a(string);
        this.c.b("");
        this.c.b(false);
    }

    public void a(String string) {
        if (et.a(string)) {
            return;
        }
        try {
            cL cL2 = \u2007\u2008\u00a0.s.if().k();
            int n2 = cL2.getX();
            int n3 = cL2.getY();
            \u2001\u2000\u00a0.true(string);
            cL2 = \u2007\u2008\u00a0.s.if().k();
            es_0 es_02 = cL2.a();
            int n4 = es_02.getX() + 5;
            int n5 = es_02.getY() + es_02.getHeight() - 80;
            es_02.onMousePress(n4, n5, 0);
            cL2.setXY(n2, n3);
        }
        catch (Exception exception) {
            ChatUtils.exception("ConfigManager: load", exception);
        }
    }

    public boolean d() {
        aD aD2 = \u2007\u2008\u00a0.s.if().k().a().a;
        return aD2 != null && aD2.e == aT.b;
    }

    public void e() {
        try {
            int n2 = 3;
            int n3 = 30;
            for (File file : \u2001\u2000\u00a0.b.listFiles()) {
                Object object222;
                if (file.getName().equals(\u2001\u2000\u00a0.c.getName())) continue;
                boolean bl = false;
                for (Object object222 : super.b()) {
                    if (!(object222 instanceof be_0)) continue;
                    be_0 be_02 = (be_0)object222;
                    if (!be_02.b.equals(file.getName())) continue;
                    bl = true;
                    break;
                }
                if (bl) continue;
                Object object3 = "Created on ";
                object222 = fn.a(file, "dd/MM/yyyy");
                object3 = object222 != null ? (String)object3 + (String)object222 : (String)object3 + "null";
                Object object = object3;
                dk dk2 = new dk(this, this.getX() + n2, 0, this.getWidth() - n2 * 2, n3, this, this.d, file.getName(), (String)object);
                dk2.c = \u200b\u2000.void()[4];
                dk2.d = new r(this, dk2.getX(), dk2.getY(), 16, 16, dk2, this.e, null, aX.l, file);
                dk2.d.f = 0.7f;
                dk2.e = new cn(this, dk2.getX(), dk2.getY(), 16, 16, dk2, this.f, null, aX.h, file);
                dk2.e.f = 0.7f;
                dk2.e.g = 0.5f;
                this.a(dk2);
            }
            for (Component component : super.b()) {
                if (!(component instanceof be_0)) continue;
                be_0 be_02 = (be_0)component;
                boolean bl = false;
                for (File file : \u2001\u2000\u00a0.b.listFiles()) {
                    if (!be_02.b.equals(file.getName())) continue;
                    bl = true;
                }
                if (bl) continue;
                this.b(component);
                break;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void a(int n2, int n3) {
        this.g.c(n2, n3);
        this.h.c(n2, n3);
        GL11.glEnable((int)3089);
        int n4 = 2;
        if (Display.getWidth() < 640 || Display.getHeight() < 480) {
            n4 = 1;
        }
        GL11.glScissor((int)(this.getX() * n4), (int)(Display.getHeight() - (this.getY() + this.getHeight()) * n4), (int)(this.getWidth() * n4), (int)((this.getHeight() - (this.b + 4)) * n4));
        for (Component component : this.b()) {
            component.c(n2, n3);
        }
        GL11.glDisable((int)3089);
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        if (!this.d()) {
            return;
        }
        for (Component component : this.b()) {
            if (!component.isMouseOver(n2, n3)) continue;
            component.onMousePress(n2, n3, n4);
        }
        if (this.g.isMouseOver(n2, n3)) {
            this.g.onMousePress(n2, n3, n4);
        }
        if (this.h.isMouseOver(n2, n3)) {
            this.h.onMousePress(n2, n3, n4);
        }
        if (this.c.j()) {
            this.c.a(n2, n3, n4);
        }
        super.onMousePress(n2, n3, n4);
    }

    @Override
    public void onKeyReleased(int n2, char c) {
        if (!this.d()) {
            return;
        }
        if (n2 == 28) {
            this.a(this.g);
            return;
        }
        this.c.a(c, n2);
        super.onKeyReleased(n2, c);
    }

    @Override
    public void c(int n2, int n3) {
        this.f();
        super.c(n2, n3);
    }

    @Override
    public void c() {
        this.e();
        for (Component component : this.b()) {
            component.c();
        }
        super.c();
    }

    @Override
    public void c(int n2, int n3, int n4) {
        this.c(n4);
        super.c(n2, n3, n4);
    }

    public void f() {
        int n2 = 4;
        int n3 = this.getX() + this.getWidth() - n2 * 2 - this.h.getWidth();
        int n4 = this.getY() + n2 + 1;
        this.h.setXY(n3, n4);
        this.g.setXY(n3 - n2 - this.g.getWidth() - 2, n4);
        this.c.a = this.getX() + n2;
        this.c.b = this.getY() + 3;
        this.c.c = this.getWidth() - n2 * 2;
        this.o();
        int n5 = 0;
        for (Component component : this.b()) {
            int n6 = this.getY() + (n5 += component.getHeight() + n2);
            component.b(n6);
            component.setXY(this.getX() + n2, (int)((double)component.g() + this.s));
        }
    }
}

