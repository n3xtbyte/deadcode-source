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
import java.awt.Color;

public class ComponentColorPicker
extends ComponentRenderer {
    public ComponentColorPicker(Theme theme) {
        super(ComponentType.COLOR_PICKER, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        ei ei2 = (ei)component;
        int n4 = ei2.getX();
        int n5 = ei2.getY();
        int n6 = ei2.getWidth();
        int n7 = ei2.getHeight();
        aX.b(n4, n5, n4 + n6, n5 + n7);
        Wrapper.INSTANCE.n().a(ei2.a.getName(), n4 + 4, n5 + 5, aX.h);
        float f2 = n5 + 17;
        String string = "Drag mouse for choice color.";
        Wrapper.INSTANCE.o().a(string, n4 + 4, f2, aX.m);
        RenderUtils.a(ei2.e, ei2.g, ei2.f, ei2.h, er.e, ei2.k, 1, aY.c);
        RenderUtils.a(ei2.e, ei2.g, ei2.f, ei2.h, er.q, er.d, 1, aY.b);
        if (ei2.i && ei2.f(n2, n3)) {
            RenderUtils.a((double)(n2 - 2), (double)(n3 - 3), (double)(n2 + 2), (double)(n3 + 1), er.a(255, 255, 255, 100));
        }
        long l2 = System.currentTimeMillis();
        ei2.c.f(55, 87);
        float f3 = ei2.h + 12;
        float f4 = 5.0f;
        int n8 = (int)((double)ei2.c.j * ei2.c.g);
        double d2 = ei2.c.n + ((double)n8 - ei2.c.n) * Math.pow((double)(l2 - ei2.c.m) / 125.0, 0.5);
        Wrapper.INSTANCE.o().a(ei2.c.b.getName(), ei2.c.i + 1, f3 - 7.0f, aX.m);
        RenderUtils.a((double)ei2.c.i, (double)f3, (double)(ei2.c.i + ei2.c.j), (double)(f3 + f4), aX.f);
        for (int i2 = 0; i2 < ei2.c.j; ++i2) {
            float[] fArray = er.b(er.a(i2, 0.0f, ei2.c.j, 0.0f, 360.0f), 1.0f, 1.0f);
            Color color = new Color(fArray[0], fArray[1], fArray[2]);
            RenderUtils.a((double)(ei2.c.i + i2), (double)(f3 + 1.0f), (double)(ei2.c.i + i2 + 1), (double)(f3 + f4 - 1.0f), color.getRGB());
        }
        RenderUtils.a((double)ei2.c.i + d2 - 2.0, (double)(f3 - 1.0f), (double)ei2.c.i + d2 + 1.0, (double)(f3 + f4 + 1.0f), aX.h);
        ei2.d.f(73, 0);
        float f5 = f3 + f4 + 11.0f;
        float f6 = 5.0f;
        int n9 = (int)((double)ei2.d.j * ei2.d.g);
        double d3 = ei2.d.n + ((double)n9 - ei2.d.n) * Math.pow((double)(l2 - ei2.d.m) / 125.0, 0.5);
        Wrapper.INSTANCE.o().a(ei2.d.b.getName(), ei2.d.i + 1, f5 - 7.0f, aX.m);
        RenderUtils.a((double)ei2.d.i, (double)f5, (double)(ei2.d.i + ei2.d.j), (double)(f5 + f6), aX.f);
        int n10 = er.b(aX.i, 0.3f);
        ShaderManager.b().a(ei2.d.i + 1, f5 + 1.0f, (float)((double)ei2.d.i + d3 - 1.0), f5 + f6 - 1.0f, 14.0f, 4, n10);
        RenderUtils.a((double)(ei2.d.i + 1), (double)(f5 + 1.0f), (double)ei2.d.i + d3 - 1.0, (double)(f5 + f6 - 1.0f), aX.i);
        RenderUtils.a((double)ei2.d.i + d3 - 2.0, (double)(f5 - 1.0f), (double)ei2.d.i + d3 + 1.0, (double)(f5 + f6 + 1.0f), aX.h);
        float f7 = ei2.c.i;
        float f8 = f5 + 10.0f;
        float f9 = 9.0f;
        Color color = new Color(ei2.a.getValue());
        String string2 = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
        String string3 = String.format("~$: %s // %s,%s,%s", string2, color.getRed(), color.getGreen(), color.getBlue());
        RenderUtils.a((double)f7, (double)f8, (double)(f7 + (float)n6 - 8.0f), (double)(f8 + f9), (double)f9, aX.n);
        Wrapper.INSTANCE.o().a(string3, f7 + 2.0f, f8 + 3.0f, aX.h);
        ei2.c.n = d2;
        ei2.c.m = l2;
        ei2.d.n = d3;
        ei2.d.m = l2;
    }
}

