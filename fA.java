/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.utils.RandomUtils;
import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class fA {
    private PrintStream c;
    private PrintWriter d;
    public boolean a;
    public boolean b;

    public fA() {
        this.a(false, false);
    }

    public fA(boolean bl, boolean bl2) {
        this.a(bl, bl2);
    }

    public void a(boolean bl, boolean bl2) {
        this.c = new dJ(this, System.out);
        System.setOut(this.c);
        this.b = bl;
        this.a = bl2;
        try {
            if (this.b) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(\u200b\u2000.catch()[0]);
                Date date = Calendar.getInstance().getTime();
                String string = RandomUtils.randomString(6) + "_" + simpleDateFormat.format(date);
                String string2 = System.getProperty(\u200b\u2000.catch()[1]) + File.separator + string + \u200b\u2000.catch()[2];
                this.d = new PrintWriter(string2, \u200b\u2000.catch()[3]);
                this.a(String.format(\u200b\u2000.catch()[4], et.k()));
                this.a(String.format(\u200b\u2000.catch()[5], string2));
            }
        }
        catch (Exception exception) {
            this.a(\u200b\u2000.catch()[6], exception);
        }
    }

    private /* synthetic */ String b(Object object) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = Calendar.getInstance().getTime();
        String string = "[" + simpleDateFormat.format(date) + "] " + object;
        return string;
    }

    public void a(Object object) {
        try {
            String string = this.b(object);
            if (this.d != null) {
                this.d.println(string);
                this.d.flush();
            }
            if (this.a) {
                System.out.println(string);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void a(Object object, Exception exception) {
        try {
            String string = this.b(object);
            if (this.d != null) {
                this.d.println(string);
                exception.printStackTrace(this.d);
                this.d.flush();
            }
            if (this.a) {
                System.out.println(string);
                exception.printStackTrace();
            }
        }
        catch (Exception exception2) {
            // empty catch block
        }
    }

    public void a() {
        if (this.d != null) {
            this.d.close();
        }
    }

    public PrintWriter b() {
        return this.d;
    }
}

