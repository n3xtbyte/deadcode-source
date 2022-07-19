/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;

/*
 * Renamed from dX
 */
public class dx_0
extends ComponentRenderer {
    public dx_0(Theme theme) {
        super(ComponentType.c, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        es_0 es_02 = (es_0)component;
        int n4 = es_02.getX();
        int n5 = es_02.getY();
        int n6 = es_02.getWidth();
        int n7 = es_02.getHeight();
        aX.a(n4, n5, n4 + n6, n5 + n7);
        aX.b(n4 + 3, n5 + 42, n4 + n6 - 3, n5 + n7 - 132);
        aX.b(n4 + 3, n5 + 202, n4 + n6 - 3, n5 + n7 - 52);
        es_02.a(n2, n3);
    }
}

