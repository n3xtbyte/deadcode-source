/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;

public class dx
extends ComponentRenderer {
    public dx(Theme theme) {
        super(ComponentType.j, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        fD fD2 = (fD)component;
        int n4 = fD2.getX();
        int n5 = fD2.getY();
        int n6 = fD2.getWidth();
        int n7 = fD2.getHeight();
        if (!fD2.d()) {
            return;
        }
        int n8 = fD2.c;
        aX.a(n4, n5, n4 + n6, n5 + n7);
        int n9 = n4 + n8;
        int n10 = n5 + n8;
        int n11 = n5 + n7 - fD2.b - n8 * 2;
        aX.c(n9, n10, n4 + n6 - n8, n11);
        fD2.d.f();
        fD2.a(n2, n3);
    }
}

