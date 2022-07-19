/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.wrappers.Wrapper;

public class L
extends ComponentRenderer {
    public L(Theme theme) {
        super(ComponentType.m, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        bi bi2 = (bi)component;
        int n4 = bi2.getX();
        int n5 = bi2.getY();
        Wrapper.INSTANCE.n().a(bi2.a, n4, n5, aX.h);
    }
}

