/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;

public class eW
extends ComponentRenderer {
    public eW(Theme theme) {
        super(ComponentType.v, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        fp fp2 = (fp)component;
        int n4 = fp2.getX();
        int n5 = fp2.getY();
        int n6 = fp2.getWidth();
        int n7 = fp2.getHeight();
        aX.b(n4, n5, n4 + n6, n5 + n7);
        Wrapper.INSTANCE.n().a(fp2.b.getName(), n4 + 4, n5 + 5, aX.h);
        float f2 = n5 + 17;
        String string = "Drag slider.";
        Wrapper.INSTANCE.o().a(string, n4 + 4, f2, aX.m);
        float f3 = f2 + 10.0f;
        float f4 = 5.0f;
        float f5 = 19.0f;
        long l2 = System.currentTimeMillis();
        double d2 = fp2.g;
        double d3 = fp2.n + (d2 - fp2.n) * Math.pow((double)(l2 - fp2.m) / 125.0, 0.5);
        RenderUtils.a((float)(n4 + n6) - f5 - 8.0f, f3, f5, (float)d3, true, aX.f, aX.i);
        float f6 = fp2.i;
        float f7 = f3 + f4 + 4.0f;
        float f8 = 9.0f;
        if (fp2.c) {
            String string2 = String.format("~$: v=%s", fp2.b.getObjectValue());
            float f9 = Wrapper.INSTANCE.o().a(string2);
            RenderUtils.a((double)f6, (double)f7, (double)(f6 + f9 + 10.0f), (double)(f7 + f8), (double)f8, aX.n);
            Wrapper.INSTANCE.o().a(string2, f6 + 2.0f, f7 + 3.0f, aX.h);
        } else {
            String string3 = RenderUtils.a(fp2.g, 2);
            String string4 = "~$: 0-";
            String string5 = "-1";
            float f10 = 19.0f;
            float f11 = Wrapper.INSTANCE.o().a(string3);
            float f12 = 6.0f;
            RenderUtils.a((double)f6, (double)f7, (double)(f6 + (f10 + f11 + f12) + 10.0f), (double)(f7 + f8), (double)f8, aX.n);
            Wrapper.INSTANCE.o().a(string4, f6 + 2.0f, f7 + 3.0f, aX.h);
            Wrapper.INSTANCE.o().a(string3, f6 + 2.0f + f10, f7 + 3.0f, aX.i);
            Wrapper.INSTANCE.o().a(string5, f6 + 2.0f + f10 + f11, f7 + 3.0f, aX.h);
        }
        fp2.n = d3;
        fp2.m = l2;
    }
}

