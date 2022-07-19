/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.hacks.render.UserInterface;
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;

public class fr
extends ComponentRenderer {
    public fr(Theme theme) {
        super(ComponentType.g, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        dl dl2 = (dl)component;
        int n4 = dl2.getX();
        int n5 = dl2.getY();
        int n6 = dl2.getWidth();
        int n7 = dl2.getHeight();
        if (((Boolean)UserInterface.b.getObjectValue()).booleanValue()) {
            ShaderManager.b().a(n4, n5, n4 + n6, n5 + n7, 5.0f, 2, er.a(0, 0, 0, 35));
        }
        RenderUtils.a((double)n4, (double)n5, (double)(n4 + n6), (double)(n5 + n7), aX.h);
        int n8 = 3;
        int n9 = 37;
        fd_0 fd_02 = ShaderManager.f();
        if (fd_02.d && dl2.a) {
            fd_02.startUseShader();
            fd_02.uniform1f("radius", 0.5f);
            fd_02.uniform1f("glow", 0.08f);
            RenderUtils.b(\u2007\u2008\u00a0.n.a, n4 + n8 + 5, n5 + n8, dl2.c.a(), dl2.c.b(), false);
            fd_02.stopUseShader();
        } else {
            RenderUtils.a(dl2.c.e(), (float)(n4 + n8 + 5), (float)(n5 + n8), dl2.c.a(), dl2.c.b(), false, dl2.c.hashCode());
        }
        RenderUtils.a(dl2.b.e(), (float)(n4 + n8) - 8.0f + 5.0f, (float)(n5 + n8) - 8.0f, dl2.b.a(), dl2.b.b(), false, dl2.b.hashCode());
        RenderUtils.a(dl2.d.e(), (float)(n4 + n6) - dl2.d.a() + 1.5f, (float)n5 + 2.5f, dl2.d.a(), dl2.d.b(), true, dl2.d.hashCode());
        RenderUtils.a(0.0, 0.0, 0.0, 0.0, 0);
        \u00a0\u00a0 \u00a0\u00a02 = \u2007\u2008\u00a0.f.if();
        int n10 = n4 + n8 * 2 + n9 + 2;
        int n11 = n5 + n8 * 2;
        int n12 = Wrapper.INSTANCE.h().a(\u00a0\u00a02.if());
        Wrapper.INSTANCE.h().a(\u00a0\u00a02.if(), n10, n11, aX.n);
        Wrapper.INSTANCE.m().a(et.b(\u00a0\u00a02.if().toString()), n10 + n12 + n8, n11, aX.n);
        Wrapper.INSTANCE.p().a("UID: " + \u00a0\u00a02.if(), n10, n11 + 15, aX.n);
    }
}

