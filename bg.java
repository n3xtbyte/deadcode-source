/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 */
import i.gishreloaded.deadcode.managers.FriendManager;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class bg
extends dp {
    public int a = 20;
    public int b = this.a + 8;
    private eC d;
    private eC e;
    private bh f;
    private bh g;
    public eg c;

    public bg(int n2, int n3, int n4, int n5, Component component) {
        super(n2, n3, n4, n5, ComponentType.i, component);
        bu bu2 = Wrapper.INSTANCE.n();
        this.c = new eg(bu2, n2, n3, n4, this.a, "Type your friend name...");
        this.c.a("Search in friend list...");
        this.c.b(false);
        this.d = \u2007\u2008\u00a0.n.a("Other", "Friend");
        this.e = \u2007\u2008\u00a0.n.a("Other", "Delete");
        eC eC2 = \u2007\u2008\u00a0.n.a("Other", "Add");
        this.f = new r_0(this, n2, n3, 62, 16, this, eC2, "New friend", aX.h);
        eC2 = \u2007\u2008\u00a0.n.a("Other", "Search");
        this.g = new bh(n2, n3, 16, 16, this, eC2, null, aX.h);
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
        FriendManager.b(string);
    }

    public boolean d() {
        aD aD2 = \u2007\u2008\u00a0.s.if().k().a().a;
        return aD2 != null && aD2.e == aT.a;
    }

    public void e() {
        try {
            int n2 = 3;
            int n3 = 30;
            for (Object object : FriendManager.a) {
                boolean bl = false;
                for (Object object2 : super.b()) {
                    if (!(object2 instanceof be_0)) continue;
                    Object object3 = (be_0)object2;
                    if (!((be_0)object3).b.equals(object)) continue;
                    bl = true;
                    break;
                }
                if (bl) continue;
                cD cD2 = new cD(this, this.getX() + n2, 0, this.getWidth() - n2 * 2, n3, this, this.d, (String)object, (String)object);
                cD2.d = new ei_0(this, cD2.getX(), cD2.getY(), 16, 16, cD2, this.e, null, aX.l, (String)object);
                cD2.d.f = 0.7f;
                this.a(cD2);
            }
            for (Object object : super.b()) {
                if (!(object instanceof be_0)) continue;
                be_0 be_02 = (be_0)object;
                boolean bl = false;
                for (Object object3 : FriendManager.a) {
                    if (!be_02.b.equals(object3)) continue;
                    bl = true;
                }
                if (bl) continue;
                this.b((Component)object);
                break;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void a(int n2, int n3) {
        this.f.c(n2, n3);
        this.g.c(n2, n3);
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
        if (this.f.isMouseOver(n2, n3)) {
            this.f.onMousePress(n2, n3, n4);
        }
        if (this.g.isMouseOver(n2, n3)) {
            this.g.onMousePress(n2, n3, n4);
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
            this.a(this.f);
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
        int n3 = this.getX() + this.getWidth() - n2 * 2 - this.g.getWidth();
        int n4 = this.getY() + n2 + 1;
        this.g.setXY(n3, n4);
        this.f.setXY(n3 - n2 - this.f.getWidth() - 2, n4);
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

