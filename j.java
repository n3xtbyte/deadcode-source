/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;

public class j
extends ComponentRenderer {
    public j(Theme theme) {
        super(ComponentType.l, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        be_0 be_02 = (be_0)component;
        int n4 = be_02.getX();
        int n5 = be_02.getY();
        int n6 = be_02.getWidth();
        int n7 = be_02.getHeight();
        aX.c(n4, n5, n4 + n6, n5 + n7);
        int n8 = n4 + 5;
        int n9 = n5 + 4;
        int n10 = 22;
        RenderUtils.a((double)n8, (double)n9, (double)(n8 + n10), (double)(n9 + n10), aX.f);
        RenderUtils.a(be_02.a.e(), (float)(n8 + n10 / 2) - be_02.a.a() / 2.0f, (float)(n9 + 7), be_02.a.a(), be_02.a.b(), true, be_02.a.hashCode());
        RenderUtils.a(0.0, 0.0, 0.0, 0.0, 0);
        int n11 = be_02.d() ? aX.i : aX.h;
        int n12 = n8 + n10 + 5;
        Wrapper.INSTANCE.n().a(be_02.b, n12, n9 + 3, n11);
        Wrapper.INSTANCE.o().a(be_02.a(), n12, n9 + 16, aX.m);
        if (be_02.c != null) {
            Wrapper.INSTANCE.n().a(be_02.c, n12 + Wrapper.INSTANCE.n().a(be_02.b) + 1, n9 + 3, aX.m);
        }
        if (be_02.d != null) {
            be_02.d.c(n2, n3);
        }
        if (be_02.e != null) {
            be_02.e.c(n2, n3);
        }
    }
}

