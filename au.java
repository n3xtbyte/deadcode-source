/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 */
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import java.util.ArrayList;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import unknown.Unknown6;

public class au
extends dp {
    public int a = 16;
    public eC b = \u2007\u2008\u00a0.n.a("Other", "Arrows2");

    public au(int n2, int n3, int n4, int n5, Component component) {
        super(n2, n3, n4, n5, ComponentType.e, component);
    }

    public boolean a() {
        aD aD2 = \u2007\u2008\u00a0.s.if().k().a().a;
        return aD2 == null || aD2.e == null;
    }

    @Override
    public void a(int n2, int n3) {
        GL11.glEnable((int)3089);
        int n4 = 2;
        if (Display.getWidth() < 640 || Display.getHeight() < 480) {
            n4 = 1;
        }
        GL11.glScissor((int)(this.getX() * n4), (int)(Display.getHeight() - (this.getY() + this.getHeight()) * n4), (int)(this.getWidth() * n4), (int)((this.getHeight() - (this.a + 4)) * n4));
        ArrayList arrayList = new ArrayList(this.b());
        arrayList.sort(new cg(this));
        for (Component component : arrayList) {
            component.c(n2, n3);
        }
        GL11.glDisable((int)3089);
    }

    @Override
    public ArrayList b() {
        Unknown6 unknown6 = \u2007\u2008\u00a0.s.if().k().d().a;
        if (unknown6 == null) {
            return new ArrayList();
        }
        return unknown6.b();
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        if (!this.a()) {
            return;
        }
        for (Component component : this.b()) {
            if (!component.isMouseOver(n2, n3)) continue;
            component.onMousePress(n2, n3, n4);
            break;
        }
        super.onMousePress(n2, n3, n4);
    }

    @Override
    public void onMouseDrag(int n2, int n3) {
        for (Component component : this.b()) {
            if (!component.isMouseOver(n2, n3)) continue;
            component.onMouseDrag(n2, n3);
        }
        super.onMouseDrag(n2, n3);
    }

    @Override
    public void onMouseRelease(int n2, int n3, int n4) {
        for (Component component : this.b()) {
            component.onMouseRelease(n2, n3, n4);
        }
        super.onMouseRelease(n2, n3, n4);
    }

    @Override
    public void c(int n2, int n3) {
        this.d();
        super.c(n2, n3);
    }

    @Override
    public void c() {
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

    public void d() {
        this.o();
        int n2 = this.getX();
        int n3 = 0;
        int n4 = 0;
        int n5 = 8;
        int n6 = 3;
        int n7 = 0;
        int n8 = 0;
        ArrayList<Component> arrayList = new ArrayList<Component>();
        for (int i2 = 0; i2 < this.b().size(); ++i2) {
            Component component = (Component)this.b().get(i2);
            Component component2 = null;
            Component component3 = null;
            if (i2 < this.b().size() - 1) {
                component2 = (Component)this.b().get(i2 + 1);
            }
            if (i2 > 0) {
                component3 = (Component)this.b().get(i2 - 1);
            }
            if (i2 == 0) {
                n4 += component.getHeight() + n5;
                n3 = n2;
            }
            if (component instanceof ag_0 || component3 instanceof ag_0) {
                n3 = n2;
                n7 = 0;
                if (component3 instanceof ag_0) {
                    n8 = component.getHeight();
                }
                arrayList.clear();
            }
            int n9 = this.getY() + n4;
            component.b(n9);
            component.setXY(n3, (int)((double)component.g() + this.s));
            if (component.getHeight() > n8) {
                n8 = component.getHeight();
            }
            if (n7 < n6) {
                if (!(component instanceof ag_0)) {
                    arrayList.add(component);
                }
                n3 += component.getWidth() + n5;
                if (++n7 >= n6) {
                    n3 = n2;
                    n7 = 0;
                    if (!(component2 instanceof ag_0)) {
                        n4 = arrayList.size() >= n6 ? (n4 += ((Component)arrayList.get(n7)).getHeight() + n5) : (n4 += component.getHeight() + n5);
                    }
                }
            }
            if (component2 instanceof ag_0) {
                n4 += n8 + n5;
            }
            if (!(component instanceof ag_0)) continue;
            n4 += component.getHeight() + n5;
        }
        this.t = n4;
    }
}

