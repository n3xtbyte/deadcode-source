/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.MathHelper
 */
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.util.math.MathHelper;

public class d {
    public double a;
    public double b;
    public double c;

    public d() {
        this.a = 0.1;
    }

    public d(double d2) {
        this.a = d2;
    }

    public d(double d2, double d3) {
        this.a = d2;
        this.b = d3;
        this.c = d3;
    }

    public void a() {
        this.b = 0.0;
        this.c = 0.0;
    }

    public void a(boolean bl) {
        this.c = MathHelper.clamp((double)(this.c + (bl ? this.a : -this.a) * (double)Wrapper.INSTANCE.getMinecraft().getTickLength() * (double)1.8f), (double)0.0, (double)1.0);
        this.b = d.a(this.c);
    }

    public double b() {
        return this.b;
    }

    private static /* synthetic */ double a(double d2) {
        return 1.0 - Math.pow(1.0 - d2, 3.0);
    }
}

