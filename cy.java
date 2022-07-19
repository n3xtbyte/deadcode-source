/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.MathHelper
 */
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;

public class cy {
    private final double a;
    private final double b;
    private int c;
    private int d;
    private int e;

    public cy(Minecraft minecraft) {
        this.c = minecraft.displayWidth;
        this.d = minecraft.displayHeight;
        this.e = 1;
        boolean bl = minecraft.isUnicode();
        int n2 = 2;
        if (n2 == 0) {
            n2 = 1000;
        }
        while (this.e < n2 && this.c / (this.e + 1) >= 320 && this.d / (this.e + 1) >= 240) {
            ++this.e;
        }
        if (bl && this.e % 2 != 0 && this.e != 1) {
            --this.e;
        }
        this.a = (double)this.c / (double)this.e;
        this.b = (double)this.d / (double)this.e;
        this.c = MathHelper.ceil((double)this.a);
        this.d = MathHelper.ceil((double)this.b);
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public double c() {
        return this.a;
    }

    public double d() {
        return this.b;
    }

    public int e() {
        return this.e;
    }
}

