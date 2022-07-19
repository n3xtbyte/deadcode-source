/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 */
import net.minecraft.util.math.Vec3d;

/*
 * Renamed from D
 */
public class d_0 {
    public final Vec3d a;
    public final Vec3d b;
    public byte c;
    public byte d;

    public d_0(Vec3d vec3d, Vec3d vec3d2, int n2) {
        this.a = vec3d;
        this.b = vec3d2;
        this.d = (byte)n2;
    }

    public Vec3d a() {
        return this.a;
    }

    public Vec3d b() {
        return this.b;
    }

    public byte c() {
        return this.c;
    }

    public boolean d() {
        this.c = (byte)(this.c + 1);
        return this.c > this.d;
    }
}

