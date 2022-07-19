/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;

public class fu
extends dp {
    public fu(int n2, int n3, int n4, int n5, Component component) {
        super(n2, n3, n4, n5, ComponentType.b, component);
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
            component.setXY(this.getX() + component.j(), this.getY() + component.k());
        }
        super.c(n2, n3);
    }
}

