/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.utils;

import java.util.Random;

public class RandomUtils {
    public static int randomInt(int n2, int n3) {
        if (n2 == n3 || n3 - n2 <= 0) {
            return n2;
        }
        return n2 + RandomUtils.getRandom().nextInt(n3 - n2);
    }

    public static double randomDouble(double d2, double d3) {
        if (d2 == d3 || d3 - d2 <= 0.0) {
            return d2;
        }
        return d2 + (d3 - d2) * Math.random();
    }

    public static float randomFloat(float f2, float f3) {
        if (f2 == f3 || f3 - f2 <= 0.0f) {
            return f2;
        }
        return (float)((double)f2 + (double)(f3 - f2) * Math.random());
    }

    public static long randomLong(int n2, int n3) {
        return (long)(Math.random() * (double)(1000 / n2 - 1000 / n3 + 1) + (double)(1000 / n3));
    }

    public static String randomStringNumber(int n2) {
        return RandomUtils.randomStringFromSourceString(n2, "0123456789");
    }

    public static String randomString(int n2) {
        return RandomUtils.randomStringFromSourceString(n2, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    }

    public static String randomStringFromSourceString(int n2, String string) {
        return RandomUtils.randomStringFromChars(n2, string.toCharArray());
    }

    public static String randomStringFromChars(int n2, char[] cArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(cArray[RandomUtils.getRandom().nextInt(cArray.length)]);
        }
        return stringBuilder.toString();
    }

    public static Random getRandom() {
        return new Random();
    }
}

