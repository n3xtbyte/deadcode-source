/*
 * Decompiled with CFR 0.152.
 */
public final class dT
extends Thread {
    public final /* synthetic */ double a;
    public final /* synthetic */ double b;
    public final /* synthetic */ double c;

    public dT(double d2, double d3, double d4) {
        this.a = d2;
        this.b = d3;
        this.c = d4;
    }

    @Override
    public void run() {
        try {
            dT.sleep(100L);
            et.a(this.a + 5.0, this.b + 1.0, this.c + 5.0);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

