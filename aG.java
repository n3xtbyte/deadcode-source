/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.ui.ComponentRenderer;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.ui.theme.Theme;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import unknown.Unknown6;

public class aG
extends ComponentRenderer {
    public aG(Theme theme) {
        super(ComponentType.o, theme);
    }

    @Override
    public void drawComponent(Component component, int n2, int n3) {
        Unknown6 unknown6 = (Unknown6)component;
        int n4 = unknown6.getX();
        int n5 = unknown6.getY();
        int n6 = unknown6.getWidth();
        int n7 = unknown6.getHeight();
        aD aD2 = \u2007\u2008\u00a0.s.if().k().a().a;
        int n8 = unknown6.b.isToggled() ? aD2.h : aX.h;
        aX.c(n4, n5, n4 + n6, n5 + n7);
        Wrapper.INSTANCE.m().a(unknown6.b.getName(), n4 + 3, n5 + 5, n8);
        float f2 = n4 + n6 - 14 + 2;
        float f3 = n5 + n7 - 14 + 2;
        boolean bl = unknown6.b.hasBind();
        int n9 = bl ? aX.h : er.a(20, 20, 20, 55);
        int n10 = bl ? aX.n : aX.g;
        float f4 = f2;
        float f5 = f3 - 11.0f;
        String string = unknown6.d ? "?" : (bl ? unknown6.b.getKeyString() : "/");
        float f6 = 0.0f;
        if (!bl || unknown6.d) {
            f6 = 0.5f;
        }
        if (bl || unknown6.d) {
            if (string.length() > 1 && bl) {
                f4 -= (float)Wrapper.INSTANCE.k().a(unknown6.b.getKeyString());
                f4 += unknown6.f.a() / 2.0f;
            }
            ShaderManager.c().a(f4 + 0.5f, f5, f2 + unknown6.f.a(), f5 + unknown6.f.b(), 2.0f, n9);
            Wrapper.INSTANCE.k().a(string, f4 + 2.5f + f6, f5 + 3.0f, n10);
        } else {
            RenderUtils.a(unknown6.g.e(), f4 + 0.5f, f5, unknown6.g.a(), unknown6.g.b(), true, unknown6.g.hashCode());
        }
        if (unknown6.c) {
            RenderUtils.a(unknown6.f.e(), f2, f3, unknown6.f.a(), unknown6.f.b(), true, unknown6.f.hashCode());
        } else {
            RenderUtils.a(unknown6.e.e(), f2, f3, unknown6.e.a(), unknown6.e.b(), true, unknown6.e.hashCode());
        }
        RenderUtils.a(0.0, 0.0, 0.0, 0.0, 0);
        String string2 = unknown6.b.getDescription();
        if (string2 == null) {
            return;
        }
        int n11 = 1;
        String string3 = " ";
        int n12 = 0;
        int n13 = n6 / 5 - string3.length();
        String[] stringArray = string2.split("(?<=\\G.{" + n13 + "})");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string4 = stringArray[i2];
            if (i2 > n11) break;
            if (i2 != stringArray.length - 1) {
                string4 = i2 > n11 - 1 ? string4 + "..." : string4 + string3;
            }
            Wrapper.INSTANCE.o().a(string4, n4 + 3, n5 + 20 + n12, aX.m);
            n12 += 9;
        }
    }
}

