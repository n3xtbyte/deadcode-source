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

public class ComponentModuleSwitcher
extends ComponentRenderer {
    public ComponentModuleSwitcher(Theme theme) {
        super(ComponentType.MODULE_SWITCHER, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        fo fo2 = (fo)component;
        int n4 = fo2.getX();
        int n5 = fo2.getY();
        int n6 = fo2.getWidth();
        int n7 = fo2.getHeight();
        aX.b(n4, n5, n4 + n6, n5 + n7);
        Wrapper.INSTANCE.n().a(fo2.a.getName(), n4 + 4, n5 + 5, aX.h);
        String string = "Click for toggle.";
        float f2 = n5 + 17;
        Wrapper.INSTANCE.o().a(string, n4 + 4, f2, aX.m);
        int n8 = 4;
        int n9 = 18;
        int n10 = n4 + n6 - n9 - n8 / 2 - 2;
        int n11 = n5 + n8;
        RenderUtils.a((double)n10, (double)n11, (double)(n4 + n6 - n8), (double)(n5 + n7 - n8), aX.f);
        int n12 = er.b((Boolean)fo2.a.getObjectValue() != false ? aX.i : aX.l, fo2.f);
        int n13 = 3;
        int n14 = (Boolean)fo2.a.getObjectValue() != false ? er.b(n12, 0.3f) : er.b(n12, 0.5f);
        ShaderManager.b().a(n10 + n13, n11 + n13, n4 + n6 - n8 - n13, n5 + n7 - n8 - n13, 13.0f, 3, n14);
        ShaderManager.c().a(n10 + n13, n11 + n13, n4 + n6 - n8 - n13, n5 + n7 - n8 - n13, 3.0f, n12);
        if (((Boolean)fo2.a.getObjectValue()).booleanValue()) {
            RenderUtils.a(fo2.c.e(), (float)(n10 + n13), (float)(n11 + n13), fo2.c.a(), fo2.c.b(), fo2.f, true, fo2.c.hashCode());
        } else {
            RenderUtils.a(fo2.d.e(), (float)(n10 + n13), (float)(n11 + n13), fo2.d.a(), fo2.d.b(), fo2.f, true, fo2.d.hashCode());
        }
        RenderUtils.a(0.0, 0.0, 0.0, 0.0, 0);
    }
}

