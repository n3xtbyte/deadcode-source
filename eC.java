/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class eC {
    public float a;
    public float b;
    public String c;
    public String d;
    public String e;
    public String f;

    public eC(float f2, float f3, String string, String string2, String string3) {
        this.a = f2;
        this.b = f3;
        this.c = string;
        this.d = string2 + string3;
        this.e = string2 + string3 + File.separator + string + \u200b\u2000.void()[3];
        this.f = string3;
    }

    public void a(float f2) {
        this.a = f2;
    }

    public void b(float f2) {
        this.b = f2;
    }

    public float a() {
        return this.a;
    }

    public float b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.f;
    }
}

