/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.utils;

public class MathUtils1 {
    public static int a(int n2, int n3) {
        return (n2 + n3) / 2;
    }

    public static int a(int n2, int n3, int n4) {
        return n2 < n3 ? n3 : (n2 > n4 ? n4 : n2);
    }

    public static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : (f2 > f4 ? f4 : f2);
    }

    public static double a(double d2, double d3, double d4) {
        return d2 < d3 ? d3 : Math.min(d2, d4);
    }

    public static double a(double d2, double d3) {
        return Math.random() * (d3 - d2) + d2;
    }

    public static double a(double d2, int n2) {
        return (double)Math.round(d2 * Math.pow(10.0, n2)) / Math.pow(10.0, n2);
    }
}

