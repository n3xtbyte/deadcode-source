/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;

public class eU
extends ComponentRenderer {
    public eU(Theme theme) {
        super(ComponentType.n, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        aD aD2 = (aD)component;
        int n4 = aD2.getX();
        int n5 = aD2.getY();
        int n6 = aD2.getHeight();
        float f2 = aD2.a.a();
        float f3 = aD2.a.b();
        float f4 = aD2.c.a();
        float f5 = aD2.c.b();
        float f6 = aD2.b.a();
        float f7 = aD2.b.b();
        if ((double)aD2.r > 0.0) {
            int n7 = 8;
            int n8 = er.b(aD2.h, aD2.r);
            RenderUtils.a((double)(n4 - 3) + aD2.p + (double)n7, (double)n5 + aD2.q + (double)n7, (double)((float)n4 + f2 - 3.0f) + aD2.p + (double)n7, (double)((float)n5 + f3) + aD2.q + (double)n7, n8);
            RenderUtils.a(aD2.a.e(), (float)((double)(n4 - 3) + aD2.p) + (float)n7, (float)((double)n5 + aD2.q) + (float)n7, f2, f3, aD2.r, true, aD2.a.hashCode());
            RenderUtils.a(aD2.b.e(), (float)(n4 + 11) - f6 / 2.0f, (float)(n5 + 13) - f7 / 2.0f, f6, f7, aD2.r, false, aD2.b.hashCode());
            Wrapper.INSTANCE.h().a(aD2.f, n4 + 24, n5 + n6 / 2 - 2, er.b(aD2.i, aD2.r));
        } else {
            RenderUtils.a(aD2.c.e(), (float)(n4 + 11) - f4 / 2.0f, (float)((double)((float)(n5 + 11) - f5 / 2.0f) + aD2.o), f4, f5, false, aD2.c.hashCode());
            Wrapper.INSTANCE.m().a(aD2.f, n4 + 24, (float)((double)(n5 + n6 / 2 - 4) + aD2.o), aX.h);
        }
        RenderUtils.a(0.0, 0.0, 0.0, 0.0, 0);
    }
}

