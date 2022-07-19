/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 */
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.ScaledResolution;

public class ai {
    public static final int a = 20;
    public d b;
    public int c;
    public int d;
    public String e;
    public String f;
    public int g;
    public int h;
    public boolean i;
    public long j;
    public double k;
    public long l;
    public double m;

    public ai(String string, String string2, int n2, int n3, double d2) {
        this.e = string;
        this.f = string2;
        this.g = n2;
        this.h = n3;
        this.b = new d(d2, 1.0);
        this.a();
    }

    public void a(float f2, float f3) {
        if (this.c == 0) {
            this.c = Wrapper.INSTANCE.i().a(this.e);
        }
        if (this.d == 0) {
            this.d = Wrapper.INSTANCE.p().a(this.f);
        }
        int n2 = 20;
        int n3 = n2 / 4;
        float f4 = (float)this.b.b();
        int n4 = er.b(aX.f, f4 / 1.5f);
        int n5 = er.b(this.g, f4);
        int n6 = er.b(this.h, f4);
        if (RenderUtils.a()) {
            ShaderManager.b().a(f2 - (float)this.c - (float)(n3 * 2), f3, f2, f3 + 20.0f, 16.0f, 3, n4);
            ShaderManager.b().a(f2 - (float)this.c - (float)n2 - (float)this.d - (float)n3, f3, f2 - (float)this.c - (float)n2 + (float)n3, f3 + 20.0f, 14.0f, 3, n4);
        }
        RenderUtils.a(f2, (double)f3, (double)(f2 - (float)this.c - (float)(n3 * 2)), (double)(f3 + 20.0f), n4);
        RenderUtils.a(f2 - (float)this.c - (float)n2 + (float)n3, (double)f3, (double)(f2 - (float)this.c - (float)n2 - (float)this.d - (float)n3), (double)(f3 + 20.0f), n4);
        Wrapper.INSTANCE.i().a(this.e, f2 - (float)this.c - (float)n3, f3 + 4.0f, n5);
        Wrapper.INSTANCE.p().a(this.f, f2 - (float)this.c - (float)n2 - (float)this.d, f3 + 7.0f, n6);
        this.b.a(false);
        this.i = (double)f4 <= 0.1;
    }

    public void a() {
        long l2 = System.currentTimeMillis();
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        this.k = scaledResolution.getScaledWidth();
        this.m = -20.0;
        this.j = l2;
        this.l = l2;
    }
}

