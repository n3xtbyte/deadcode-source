/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;

/*
 * Renamed from cb
 */
public class cb_0
extends ComponentRenderer {
    public cb_0(Theme theme) {
        super(ComponentType.r, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        ag_0 ag_02 = (ag_0)component;
        int n4 = ag_02.getX();
        int n5 = ag_02.getY();
        int n6 = ag_02.getHeight();
        String string = String.format("~$: cd %s-settings", ag_02.a.getName().toLowerCase());
        int n7 = Wrapper.INSTANCE.p().a(string) + 10;
        RenderUtils.a((double)n4, (double)n5, (double)(n4 + n7), (double)(n5 + n6), (double)n6, aX.n);
        Wrapper.INSTANCE.n().a(string, n4 + 4, (float)n5 + 3.5f, aX.h);
    }
}

