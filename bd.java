/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.hacks.render.UserInterface;
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;

public class bd
extends ComponentRenderer {
    public bd(Theme theme) {
        super(ComponentType.a, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        cL cL2 = (cL)component;
        int n4 = cL2.getX();
        int n5 = cL2.getY();
        int n6 = cL2.getWidth();
        int n7 = cL2.getHeight();
        int n8 = (Boolean)UserInterface.a.getObjectValue() != false ? aX.e : er.b(aX.e, 0.6f);
        RenderUtils.a((double)n4, (double)n5, (double)(n4 + n6), (double)(n5 + n7), n8);
        cL2.a(n2, n3);
    }
}

