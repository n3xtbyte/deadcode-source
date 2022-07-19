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

public class k
extends ComponentRenderer {
    public k(Theme theme) {
        super(ComponentType.d, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        ch ch2 = (ch)component;
        int n4 = ch2.getX();
        int n5 = ch2.getY();
        int n6 = ch2.getWidth();
        int n7 = ch2.getHeight();
        if (!ch2.a()) {
            return;
        }
        Unknown6 unknown6 = \u2007\u2008\u00a0.s.if().k().d().a;
        if (ch2.b().size() < 1 && unknown6 == null) {
            int n8 = ch2.r().getWidth() - n6 - 8;
            aX.a(n4, n5, n4 + n8, n5 + n7);
            float f2 = ch2.b.a();
            float f3 = ch2.b.b();
            float f4 = (float)(n4 + n8 / 2) - f2 / 2.0f;
            float f5 = (float)(n5 + n7 / 2) - f3 / 2.0f;
            RenderUtils.a(ch2.b.e(), f4, f5, f2, f3, true, ch2.b.hashCode());
            aX.b(f4, f5, (float)(n4 + n8 / 2) + f2 / 2.0f, (float)(n5 + n7 / 2) + f3 / 2.0f);
            String string = "Nothing selected yet.";
            String string2 = "Use sidebar to view the desired";
            String string3 = "category.";
            Wrapper.INSTANCE.p().a(string, f4 + f2 / 2.0f - (float)(Wrapper.INSTANCE.p().a(string) / 2), f5 + 6.0f, aX.h);
            Wrapper.INSTANCE.p().a(string2, f4 + f2 / 2.0f - (float)(Wrapper.INSTANCE.p().a(string2) / 2), f5 + 18.0f, aX.h);
            Wrapper.INSTANCE.p().a(string3, f4 + f2 / 2.0f - (float)(Wrapper.INSTANCE.p().a(string3) / 2), f5 + 30.0f, aX.h);
            return;
        }
        aX.a(n4, n5, n4 + n6, n5 + n7);
        aX.a(ch2, n2, n3, 2.0f, 0.0f);
    }
}

