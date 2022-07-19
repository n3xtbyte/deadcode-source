/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class ey {
    private ArrayList a = new ArrayList();

    public ey() {
        this.b();
    }

    private /* synthetic */ void b() {
        this.a(\u200b\u2000.goto()[0], \u200b\u2000.goto()[1]);
        this.a(\u200b\u2000.goto()[2], \u200b\u2000.goto()[3]);
        this.a(\u200b\u2000.goto()[4], \u200b\u2000.goto()[5]);
        this.a(\u200b\u2000.goto()[6], \u200b\u2000.goto()[7]);
        this.a(\u200b\u2000.goto()[8], \u200b\u2000.goto()[9]);
        this.a(\u200b\u2000.goto()[10], \u200b\u2000.goto()[11]);
    }

    public void a(String string, String string2) {
        this.a.add(new dH(string, string2));
    }

    public void a(String string) {
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            if (!((dH)this.a.get(i2)).b().equals(string)) continue;
            this.a.remove(i2);
        }
    }

    public boolean b(String string) {
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            if (!((dH)this.a.get(i2)).b().equals(string)) continue;
            return true;
        }
        return false;
    }

    public ArrayList a() {
        return this.a;
    }
}

