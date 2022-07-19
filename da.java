/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;

public class da
extends ComponentRenderer {
    public da(Theme theme) {
        super(ComponentType.b, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        fu fu2 = (fu)component;
        fu2.a(n2, n3);
    }
}

