/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.ui;

import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;

public abstract class ComponentRenderer {
    public Theme a;
    private ComponentType b;

    public ComponentRenderer(ComponentType componentType, Theme theme) {
        this.b = componentType;
        this.a = theme;
    }

    public abstract void drawComponent(Component var1, int var2, int var3);

    public ComponentType a() {
        return this.b;
    }
}

