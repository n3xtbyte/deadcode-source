/*
 * Decompiled with CFR 0.152.
 */
public class dH {
    private String a;
    private String b;

    public dH(String string, String string2) {
        this.a = string.replaceAll("&", "\u00a7");
        this.b = string2.replaceAll("&", "\u00a7");
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }
}

