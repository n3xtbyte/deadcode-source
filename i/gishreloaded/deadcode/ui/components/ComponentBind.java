/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.ui.components;

import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;

public class ComponentBind
extends ComponentRenderer {
    public ComponentBind(Theme theme) {
        super(ComponentType.BIND, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        String string;
        fF fF2 = (fF)component;
        int n4 = fF2.getX();
        int n5 = fF2.getY();
        int n6 = fF2.getWidth();
        int n7 = fF2.getHeight();
        aX.b(n4, n5, n4 + n6, n5 + n7);
        Wrapper.INSTANCE.n().a("Bind", n4 + 4, n5 + 5, aX.h);
        String string2 = "Press on box to bind.";
        Wrapper.INSTANCE.o().a(string2, n4 + 4, n5 + 17, aX.m);
        int n8 = 4;
        int n9 = 18;
        int n10 = n4 + n6 - n9 - n8 / 2 - 2;
        int n11 = n5 + n8;
        RenderUtils.a((double)n10, (double)n11, (double)(n4 + n6 - n8), (double)(n5 + n7 - n8), aX.f);
        int n12 = fF2.a.hasBind() ? aX.h : aX.l;
        int n13 = 3;
        int n14 = er.b(n12, 0.2f);
        ShaderManager.b().a(n10 + n13, n11 + n13, n4 + n6 - n8 - n13, n5 + n7 - n8 - n13, 13.0f, 3, n14);
        ShaderManager.c().a(n10 + n13, n11 + n13, n4 + n6 - n8 - n13, n5 + n7 - n8 - n13, 3.0f, n12);
        String string3 = string = fF2.b ? "?" : fF2.a.getKeyString();
        if (fF2.a.hasBind() || fF2.b) {
            if (!fF2.b && string.length() > 1) {
                Wrapper.INSTANCE.l().a(string, n10 + n13, (float)(n11 + n13) + 6.5f, aX.g);
            } else {
                float f2 = fF2.b ? 0.5f : 0.0f;
                int n15 = Wrapper.INSTANCE.j().a(string) / 2;
                Wrapper.INSTANCE.j().a(string, (float)(n10 + n13 + 6) - f2 - (float)n15, n11 + n13 + 3, aX.g);
            }
        } else {
            RenderUtils.a(fF2.c.e(), (float)(n10 + n13), (float)(n11 + n13), fF2.c.a(), fF2.c.b(), true, fF2.c.hashCode());
            RenderUtils.a(0.0, 0.0, 0.0, 0.0, 0);
        }
    }
}

