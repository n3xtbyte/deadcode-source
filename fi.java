/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import java.io.File;
import java.util.ArrayList;

public class fi {
    public final String a;
    private final String b = \u2001\u2000\u00a0.d.getAbsolutePath() + File.separator;
    private final ArrayList c;
    private final ArrayList d;
    private boolean e;
    private boolean f;
    private int g;

    public fi() {
        this.a = \u2001\u2000\u00a0.f.getAbsolutePath() + File.separator + "avatar";
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e();
        this.f();
    }

    public void a() {
        \u00a0\u00a0 \u00a0\u00a02 = \u2007\u2008\u00a0.f.if();
        String string = \u200b\u2000.void()[0] + \u200b\u2000.void()[10] + \u2008\u2001.if(\u00a0\u00a02.true());
        fn.a(string, this.a, true);
    }

    private /* synthetic */ void e() {
        this.a("Background");
        this.a("Unselected");
        this.a("Selected");
        this.a("Other");
    }

    private /* synthetic */ void f() {
        String string;
        for (HackCategory enum_ : HackCategory.values()) {
            string = et.b(enum_.toString());
            for (String string2 : this.c) {
                if (string2.equals("Other")) continue;
                this.a(10.0f, 10.0f, this.b, string2, string);
            }
        }
        for (Enum enum_ : aT.values()) {
            string = et.b(enum_.toString());
            for (String string2 : this.c) {
                if (string2.equals("Other")) continue;
                this.a(10.0f, 10.0f, this.b, string2, string);
            }
        }
        Object[] objectArray = \u200b\u2000.if();
        this.a(29.0f, 28.0f, this.b, "Other", (String)objectArray[0]);
        this.a(171.0f, 43.0f, this.b, "Other", (String)objectArray[1]);
        this.a(180.0f, 61.0f, this.b, "Other", (String)objectArray[2]);
        this.a(45.0f, 44.0f, this.b, "Other", (String)objectArray[3]);
        this.a(9.5f, 9.0f, this.b, "Other", (String)objectArray[4]);
        this.a(9.5f, 9.0f, this.b, "Other", (String)objectArray[5]);
        this.a(9.0f, 9.0f, this.b, "Other", (String)objectArray[6]);
        this.a(12.0f, 12.0f, this.b, "Other", (String)objectArray[7]);
        this.a(12.0f, 12.0f, this.b, "Other", (String)objectArray[8]);
        this.a(186.0f, 33.0f, this.b, "Other", (String)objectArray[9]);
        this.a(8.0f, 8.0f, this.b, "Other", (String)objectArray[10]);
        this.a(6.0f, 8.0f, this.b, "Other", (String)objectArray[11]);
        this.a(8.0f, 8.0f, this.b, "Other", (String)objectArray[12]);
        this.a(9.0f, 9.0f, this.b, "Other", (String)objectArray[13]);
        this.a(6.0f, 7.0f, this.b, "Other", (String)objectArray[14]);
        this.a(12.0f, 9.0f, this.b, "Other", (String)objectArray[15]);
        this.a(8.0f, 7.0f, this.b, "Other", (String)objectArray[16]);
        this.a(97.0f, 33.0f, this.b, "Other", (String)objectArray[17]);
        this.a(16.0f, 16.0f, this.b, "Other", (String)objectArray[18]);
        this.a(16.0f, 16.0f, this.b, "Other", (String)objectArray[19]);
    }

    public void a(boolean bl) {
        File file;
        if (bl) {
            if (this.e) {
                return;
            }
            this.a();
            this.e = true;
        }
        if (!(file = new File(this.b)).exists()) {
            file.mkdir();
        }
        this.g = 0;
        for (Object object : this.c) {
            file = new File(this.b + (String)object);
            if (file.exists()) continue;
            file.mkdir();
        }
        for (Object object : this.d) {
            file = new File(((eC)object).e(), ((eC)object).c() + \u200b\u2000.void()[3]);
            if (!file.exists()) {
                fn.a(\u200b\u2000.void()[0] + \u200b\u2000.void()[5] + ((eC)object).f() + "/" + ((eC)object).c() + ".png", ((eC)object).d());
                ChatUtils.debug("CImages: file '" + ((eC)object).c() + "' downloaded.");
            }
            ++this.g;
        }
    }

    public void b() {
        if (this.d() && !this.f) {
            for (eC eC2 : this.d) {
                File file = new File(eC2.d());
                if (!file.exists()) continue;
                RenderUtils.a(eC2);
            }
            this.f = true;
        }
    }

    public eC a(String string, String string2) {
        eC eC2 = null;
        for (eC eC3 : this.c()) {
            if (!eC3.f().equals(string) || !eC3.c().equals(string2)) continue;
            eC2 = eC3;
        }
        return eC2;
    }

    private /* synthetic */ void a(String string) {
        this.c.add(string);
    }

    public void a(float f2, float f3, String string, String string2, String string3) {
        this.d.add(new eC(f2, f3, string3, string, string2));
    }

    public ArrayList c() {
        return this.d;
    }

    public boolean d() {
        return this.g == this.c().size();
    }
}

