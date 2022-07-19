/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;

/*
 * Renamed from aE
 */
public class ae_0
extends ComponentRenderer {
    public ae_0(Theme theme) {
        super(ComponentType.h, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        eJ eJ2 = (eJ)component;
        int n4 = eJ2.getX();
        int n5 = eJ2.getY();
        int n6 = eJ2.getWidth();
        int n7 = eJ2.getHeight();
        if (!eJ2.d()) {
            return;
        }
        aX.a(n4, n5, n4 + n6, n5 + n7);
        int n8 = 3;
        int n9 = n4 + n8;
        int n10 = n5 + n8;
        int n11 = n4 + n6 - n8;
        int n12 = 20;
        eJ2.c.f();
        ShaderManager.b().a(n9 + 1, n10 += n12 + 4, n11 - 1, n10 + 1, 15.0f, 3, aX.f);
        RenderUtils.a((double)(n9 + 1), (double)n10, (double)(n11 - 1), (double)(n10 + 1), aX.i);
        eJ2.a(n2, n3);
    }
}

