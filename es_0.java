/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import java.util.ArrayList;
import java.util.List;

/*
 * Renamed from es
 */
public class es_0
extends dp {
    public aD a;
    public int b = 0;
    public d c = new d(0.05f);
    public float d;

    public es_0(int n2, int n3, int n4, int n5, Component component) {
        super(n2, n3, n4, n5, ComponentType.c, component);
    }

    public void a() {
        if (this.a == null) {
            this.d = 0.0f;
            this.c.a();
            this.c.a(false);
        } else {
            this.c.a(true);
            this.d = (float)this.c.b();
        }
    }

    @Override
    public void c() {
        for (Component component : this.b()) {
            component.c();
        }
        super.c();
    }

    @Override
    public void c(int n2, int n3) {
        for (Component component : this.b()) {
            component.setXY(this.r().getX() + component.j(), this.r().getY() + component.k());
        }
        super.c(n2, n3);
        this.a();
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        if (n4 == 0 || n4 == 1) {
            ArrayList arrayList = this.b();
            if (this.a != null) {
                this.a.g = false;
                this.a = null;
                for (Component component : arrayList) {
                    aD aD2 = (aD)component;
                    aD2.m = false;
                    aD2.n = false;
                }
                return;
            }
            ArrayList<aD> arrayList2 = new ArrayList<aD>();
            ArrayList<aD> arrayList3 = new ArrayList<aD>();
            boolean bl = false;
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                aD aD3 = (aD)arrayList.get(i2);
                aD3.n = false;
                aD3.m = false;
                if (aD3.isMouseOver(n2, n3)) {
                    aD3.onMousePress(n2, n3, n4);
                    aD3.g = true;
                    this.a = aD3;
                    this.b = i2;
                    bl = true;
                    for (aD aD4 : arrayList2) {
                        aD4.n = false;
                        aD4.m = true;
                    }
                    continue;
                }
                aD3.g = false;
                if (bl && (i2 < 7 && this.b < 7 || i2 >= 7 && this.b >= 7)) {
                    arrayList3.add(aD3);
                    continue;
                }
                arrayList2.add(aD3);
            }
            for (aD aD3 : arrayList3) {
                aD3.m = false;
                aD3.n = true;
            }
        }
        super.onMousePress(n2, n3, n4);
    }

    @Override
    public void a(int n2, int n3) {
        List list = this.d();
        list.sort(new at_0(this));
        for (aD aD2 : list) {
            aD2.c(n2, n3);
        }
    }

    public List d() {
        ArrayList<aD> arrayList = new ArrayList<aD>();
        for (Component component : this.b()) {
            if (!(component instanceof aD)) continue;
            aD aD2 = (aD)component;
            arrayList.add(aD2);
        }
        return arrayList;
    }
}

