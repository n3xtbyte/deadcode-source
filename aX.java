/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.hacks.render.UserInterface;
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;

public class aX {
    public static final String a = "Background";
    public static final String b = "Selected";
    public static final String c = "Unselected";
    public static final String d = "Other";
    public static final int e = er.a(36, 36, 36, 76);
    public static final int f = er.a(31, 31, 31, 168);
    public static final int g = er.a(53, 53, 53, 255);
    public static final int h = er.a(245, 245, 245, 255);
    public static final int i = er.a(5, 171, 240, 255);
    public static final int j = er.a(247, 104, 2, 255);
    public static final int k = er.a(131, 48, 164, 255);
    public static final int l = er.a(219, 44, 1, 255);
    public static final int m = er.a(221, 221, 221, 127);
    public static final int n = er.a(0, 0, 0, 255);

    public static void a(float f2, float f3, float f4, float f5) {
        ShaderManager.b().a(f2, f3, f4, f5, 10.0f, 3, er.a(0, 0, 0, 35));
        RenderUtils.a(f2, (double)f3, (double)f4, (double)f5, er.a(86, 86, 86, 35));
    }

    public static void b(float f2, float f3, float f4, float f5) {
        if (((Boolean)UserInterface.b.getObjectValue()).booleanValue()) {
            ShaderManager.b().a(f2, f3, f4, f5, 5.0f, 2, er.a(0, 0, 0, 35));
        }
        RenderUtils.a(f2, (double)f3, (double)f4, (double)f5, f);
    }

    public static void c(float f2, float f3, float f4, float f5) {
        es_0 es_02 = \u2007\u2008\u00a0.s.if().k().a();
        int n2 = er.b(f, es_02.d / 1.5f);
        if (((Boolean)UserInterface.b.getObjectValue()).booleanValue()) {
            ShaderManager.b().a(f2, f3, f4, f5, 5.0f, 2, er.a(0, 0, 0, 35));
        }
        RenderUtils.a(f2, (double)f3, (double)f4, (double)f5, n2);
    }

    public static void a(dp dp2, int n2, int n3, float f2, float f3) {
        int n4 = dp2.getWidth();
        int n5 = dp2.getHeight();
        float f4 = dp2.t;
        float f5 = 4.0f;
        float f6 = (float)n5 * ((float)n5 / f4);
        double d2 = (double)((float)n5 - f3 - f6) * (dp2.s / (double)dp2.p());
        d2 += (double)((float)dp2.getY() + f3);
        dp2.a(n2, n3);
        if (!(f6 >= (float)n5)) {
            float f7 = (float)(dp2.getX() + n4) + f2;
            aX.b(f7 - 1.0f + f2, (float)dp2.getY() + f3, f7 + f2 + f5, dp2.getY() + n5);
            RenderUtils.a(f7 - 1.0f + f2, d2, (double)(f7 + f2 + f5), d2 + (double)f6, g);
        }
    }
}

