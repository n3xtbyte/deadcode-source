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

public class ComponentPointSelector
extends ComponentRenderer {
    public ComponentPointSelector(Theme theme) {
        super(ComponentType.POINT, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        cB cB2 = (cB)component;
        int n4 = cB2.getX();
        int n5 = cB2.getY();
        int n6 = cB2.getWidth();
        int n7 = cB2.getHeight();
        aX.b(n4, n5, n4 + n6, n5 + n7);
        Wrapper.INSTANCE.n().a(cB2.a.getName(), n4 + 4, n5 + 5, aX.h);
        String string = "Select point on the screen.";
        Wrapper.INSTANCE.o().a(string, n4 + 4, n5 + 17, aX.m);
        RenderUtils.a(cB2.c.e(), (float)cB2.d, (float)cB2.f, cB2.c.a(), cB2.c.b(), false, cB2.c.hashCode());
        RenderUtils.a(0.0, 0.0, 0.0, 0.0, 0);
        int n8 = er.b(aX.i, 0.3f);
        long l2 = System.currentTimeMillis();
        double d2 = (float)cB2.e * cB2.i;
        double d3 = cB2.m + (d2 - cB2.m) * Math.pow((double)(l2 - cB2.l) / 125.0, 0.5);
        double d4 = (float)cB2.g * cB2.j;
        double d5 = cB2.n + (d4 - cB2.n) * Math.pow((double)(l2 - cB2.l) / 125.0, 0.5);
        float f2 = 0.5f;
        ShaderManager.b().a(cB2.d, (float)((double)cB2.f + d5), cB2.d + cB2.e, (float)((double)cB2.f + d5 + (double)f2), 18.0f, 4, n8);
        ShaderManager.b().a((float)((double)cB2.d + d3), cB2.f, (float)((double)cB2.d + d3 + (double)f2), cB2.f + cB2.g, 18.0f, 4, n8);
        RenderUtils.a((double)cB2.d, (double)cB2.f + d5, (double)(cB2.d + cB2.e), (double)cB2.f + d5 + (double)f2, aX.i);
        RenderUtils.a((double)cB2.d + d3, (double)cB2.f, (double)cB2.d + d3 + (double)f2, (double)(cB2.f + cB2.g), aX.i);
        float f3 = n4 + 4;
        float f4 = n5 + 60;
        float f5 = 9.0f;
        String string2 = RenderUtils.a(Float.valueOf(cB2.i), 2);
        String string3 = RenderUtils.a(Float.valueOf(cB2.j), 2);
        String string4 = String.format("~$: x=%s, y=%s", string2, string3);
        float f6 = Wrapper.INSTANCE.o().a(string4);
        RenderUtils.a((double)f3, (double)f4, (double)(f3 + f6 + 10.0f), (double)(f4 + f5), (double)f5, aX.n);
        Wrapper.INSTANCE.o().a(string4, f3 + 2.0f, f4 + 3.0f, aX.h);
        cB2.m = d3;
        cB2.n = d5;
        cB2.l = l2;
    }
}

