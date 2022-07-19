/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import unknown.Unknown6;

public class bf
extends ComponentRenderer {
    public bf(Theme theme) {
        super(ComponentType.e, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        au au2 = (au)component;
        int n4 = au2.getX();
        int n5 = au2.getY();
        int n6 = au2.getWidth();
        int n7 = au2.getHeight();
        if (!au2.a()) {
            return;
        }
        aD aD2 = \u2007\u2008\u00a0.s.if().k().a().a;
        Unknown6 unknown6 = \u2007\u2008\u00a0.s.if().k().d().a;
        if (unknown6 == null) {
            if (aD2 == null) {
                return;
            }
            float f2 = au2.b.a() + 10.0f;
            float f3 = au2.b.b();
            float f4 = (float)(n4 + n6 / 2) - f2 / 2.0f;
            float f5 = (float)(n5 + n7 / 2) - f3 / 2.0f;
            RenderUtils.a(au2.b.e(), f4, f5, f2, f3, true, au2.b.hashCode());
            aX.c(f4, f5, (float)(n4 + n6 / 2) + f2 / 2.0f, (float)(n5 + n7 / 2) + f3 / 2.0f);
            String string = "Use sidebar to view setting of the";
            String string2 = "desired function.";
            String string3 = "Use LBM to turn on or off the function.";
            String string4 = "Use MBM to set bind or to open settings.";
            Wrapper.INSTANCE.p().a(string, f4 + f2 / 2.0f - (float)(Wrapper.INSTANCE.p().a(string) / 2), f5 + 8.0f, aX.h);
            Wrapper.INSTANCE.p().a(string2, f4 + f2 / 2.0f - (float)(Wrapper.INSTANCE.p().a(string2) / 2), f5 + 20.0f, aX.h);
            Wrapper.INSTANCE.p().a(string3, f4 + f2 / 2.0f - (float)(Wrapper.INSTANCE.p().a(string3) / 2), f5 + 34.0f, aX.h);
            Wrapper.INSTANCE.p().a(string4, f4 + f2 / 2.0f - (float)(Wrapper.INSTANCE.p().a(string4) / 2), f5 + 47.0f, aX.h);
            return;
        }
        int n8 = \u2007\u2008\u00a0.s.if().k().e().a;
        String string = unknown6.h.c();
        RenderUtils.a((double)n4, (double)n5, (double)(n4 + n6 - 4), (double)(n5 + n8), (double)n8, aX.n);
        Wrapper.INSTANCE.n().a(string, n4 + 4, n5 + 5, aX.h);
        aX.a(au2, n2, n3, -2.0f, n8 + 4);
        unknown6.h.d();
    }
}

