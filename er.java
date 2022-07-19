/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Color;
import java.util.Random;

public class er {
    private static final Random r = new Random();
    public static final int a = new Color(255, 0, 0, 255).getRGB();
    public static final int b = new Color(0, 255, 0, 255).getRGB();
    public static final int c = new Color(0, 0, 255, 255).getRGB();
    public static final int d = new Color(0, 0, 0, 255).getRGB();
    public static final int e = new Color(200, 200, 200, 255).getRGB();
    public static final int f = new Color(255, 255, 255, 155).getRGB();
    public static final int g = new Color(50, 50, 50, 255).getRGB();
    public static final int h = new Color(20, 20, 20, 255).getRGB();
    public static final int i = new Color(120, 120, 120, 200).getRGB();
    public static final int j = new Color(255, 255, 0, 255).getRGB();
    public static final int k = new Color(255, 165, 0, 255).getRGB();
    public static final int l = new Color(255, 0, 255, 255).getRGB();
    public static final int m = new Color(0, 255, 255, 255).getRGB();
    public static final int n = new Color(0, 155, 155, 255).getRGB();
    public static final int o = new Color(155, 20, 20, 255).getRGB();
    public static final int p = new Color(0, 175, 255, 255).getRGB();
    public static final int q = new Color(0, 0, 0, 0).getRGB();

    public static Color a(int n2, long l2, float f2) {
        double d2 = Math.ceil(System.currentTimeMillis() + l2 + (long)n2) / 15.0;
        Color color = er.a((float)((d2 %= 360.0) / 360.0), f2, 1.0f);
        return color;
    }

    public static int b(int n2, long l2, float f2) {
        Color color = er.a(n2, l2, f2);
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).getRGB();
    }

    public static int c(int n2, long l2, float f2) {
        Color color = er.a(n2, l2, f2);
        return new Color(0, color.getGreen(), color.getBlue(), color.getAlpha()).getRGB();
    }

    public static int d(int n2, long l2, float f2) {
        Color color = er.a(n2, l2, f2);
        return new Color(color.getRed(), 0, color.getBlue(), color.getAlpha()).getRGB();
    }

    public static Color a(float f2, float f3, float f4) {
        return Color.getHSBColor(f2, f3, f4);
    }

    public static Color a(int n2, float f2) {
        float f3 = r.nextFloat();
        float f4 = ((float)r.nextInt(n2) + (float)n2) / (float)n2 + (float)n2;
        return er.a(f3, f4, f2);
    }

    public static Color a() {
        return er.a(1000, 0.6f);
    }

    public static int a(int n2, int n3, int n4, int n5) {
        return new Color(n2, n3, n4, n5).getRGB();
    }

    public static int a(float f2, float f3, float f4, float f5) {
        return new Color(f2, f3, f4, f5).getRGB();
    }

    public static float[] a(int n2) {
        float f2 = (float)(n2 >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n2 & 0xFF) / 255.0f;
        return new float[]{f3, f4, f5, f2};
    }

    public static int b(int n2, float f2) {
        float[] fArray = er.a(n2);
        int n3 = er.a(fArray[0], fArray[1], fArray[2], f2);
        return n3;
    }

    public static int a(int n2, int n3, float f2) {
        float f3;
        float f4;
        float f5 = 2900.0f;
        for (f4 = (float)(System.currentTimeMillis() % (long)((int)f5)) + (float)((n3 - n2) * 9); f4 > f5; f4 -= f5) {
        }
        f4 /= f5;
        if ((double)f3 > 0.5) {
            f4 = 0.5f - (f4 - 0.5f);
        }
        return Color.HSBtoRGB(f4 += 0.5f, f2, 1.0f);
    }

    public static float a(float f2, float f3, float f4, float f5, float f6) {
        return (f2 - f3) / (f4 - f3) * (f6 - f5) + f5;
    }

    public static float[] b(float f2, float f3, float f4) {
        float f5 = f4 * f3;
        float f6 = f2 / 60.0f;
        float f7 = f5 * (1.0f - Math.abs(f6 % 2.0f - 1.0f));
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        if (f6 >= 0.0f && f6 <= 1.0f) {
            f8 = f5;
            f9 = f7;
            f10 = 0.0f;
        } else if (f6 >= 1.0f && f6 <= 2.0f) {
            f8 = f7;
            f9 = f5;
            f10 = 0.0f;
        } else if (f6 >= 2.0f && f6 <= 3.0f) {
            f8 = 0.0f;
            f9 = f5;
            f10 = f7;
        } else if (f6 >= 3.0f && f6 <= 4.0f) {
            f8 = 0.0f;
            f9 = f7;
            f10 = f5;
        } else if (f6 >= 4.0f && f6 <= 5.0f) {
            f8 = f7;
            f9 = 0.0f;
            f10 = f5;
        } else if (f6 >= 5.0f && f6 <= 6.0f) {
            f8 = f5;
            f9 = 0.0f;
            f10 = f7;
        }
        float f11 = f4 - f5;
        float f12 = f8 + f11;
        float f13 = f9 + f11;
        float f14 = f10 + f11;
        return new float[]{f12, f13, f14};
    }
}

