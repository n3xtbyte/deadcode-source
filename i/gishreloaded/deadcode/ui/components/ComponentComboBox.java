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

public class ComponentComboBox
extends ComponentRenderer {
    public ComponentComboBox(Theme theme) {
        super(ComponentType.COMBO_BOX, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        be be2 = (be)component;
        int n4 = be2.getX();
        int n5 = be2.getY();
        int n6 = be2.getWidth();
        int n7 = be2.getHeight();
        aX.b(n4, n5, n4 + n6, n5 + n7);
        Wrapper.INSTANCE.n().a(be2.a.getName(), n4 + 4, n5 + 5, aX.h);
        float f2 = n5 + 17;
        String string = "Click for choice mode.";
        Wrapper.INSTANCE.o().a(string, n4 + 4, f2, aX.m);
        float f3 = 4.0f;
        float f4 = (float)n4 + f3;
        float f5 = f2 + 8.0f;
        float f6 = (float)n6 - f3 * 2.0f;
        float f7 = 9.0f;
        RenderUtils.a(f4, (double)f5, (double)(f4 + f6), (double)(f5 + f7), aX.n);
        float f8 = f4 + f6 - be2.i.a() + 2.0f;
        float f9 = f5 - 3.5f;
        int n8 = er.b(aX.i, 0.3f);
        float f10 = 1.0f - be2.h;
        ShaderManager.b().a(f8 + 6.0f, f9 + 7.0f, f8 + 6.0f + 3.5f, f9 + 7.0f + 2.5f, 12.0f, 4, n8);
        RenderUtils.a(be2.i.e(), f8, f9, be2.i.a(), be2.i.b(), f10, false, be2.i.hashCode());
        RenderUtils.a(be2.j.e(), f8, f9, be2.j.a(), be2.j.b(), be2.h, false, be2.j.hashCode());
        String string2 = String.format("~$: %s", "Null");
        if (be2.f != null) {
            string2 = String.format("~$: %s", be2.f.getName());
        }
        Wrapper.INSTANCE.o().a(string2, f4 + 2.0f, f5 + 3.0f, aX.h);
        if ((double)be2.h > 0.0) {
            f5 += f7 + 3.0f;
            for (aR aR2 : be2.c) {
                aR2.b = f5;
                aR2.c = f7;
                RenderUtils.a(f4, (double)f5, (double)(f4 + f6), (double)(f5 + f7), er.b(aX.n, be2.h));
                Wrapper.INSTANCE.o().a(aR2.a, f4 + 2.0f, f5 + 3.0f, er.b(aX.h, be2.h));
                f5 += f7;
            }
            be2.d = f5;
        }
    }
}

