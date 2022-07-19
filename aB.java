/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.utils.TimerUtils;

public class aB {
    private TimerUtils a = new TimerUtils();
    private String b;
    private int c;
    private int d;
    private long e;
    private boolean f;
    private boolean g;

    public aB(long l2, boolean bl) {
        this.e = l2;
        this.f = bl;
    }

    public boolean a() {
        return this.g;
    }

    public void a(String string) {
        this.b = string;
        this.e();
    }

    public String b() {
        if (this.b == null) {
            return "null";
        }
        return this.b;
    }

    public String c() {
        if (this.g || this.b == null) {
            return this.b();
        }
        String string = this.b.substring(this.c, this.d);
        String string2 = this.b.substring(0, this.c);
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c = string.charAt(i2);
            string2 = string2 + "\u00a7k" + c + "\u00a7r";
        }
        string2 = string2 + this.b.substring(this.d, this.b.length());
        return string2;
    }

    public void d() {
        if (this.b != null && !this.g && this.a.isReached(this.e)) {
            ++this.c;
            if (this.d < this.b.length()) {
                ++this.d;
            }
            if (this.c >= this.b.length()) {
                this.e();
                if (this.f) {
                    this.g = true;
                }
            }
            this.a.resetTime();
        }
    }

    public void e() {
        this.c = 0;
        this.d = this.b.length() / 2;
        this.g = false;
    }
}

