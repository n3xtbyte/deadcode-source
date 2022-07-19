/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Vec3d
 */
import i.gishreloaded.deadcode.hacks.render.Trails;
import net.minecraft.util.math.Vec3d;

/*
 * Renamed from b
 */
public class b_0 {
    public int a;
    public Vec3d b;
    public Vec3d c;

    public b_0(Vec3d vec3d, Vec3d vec3d2) {
        this.b = vec3d;
        this.c = vec3d2;
        this.a = 1;
    }

    public boolean a() {
        ++this.a;
        if (this.a == 0) {
            this.a = 1;
        }
        return this.a > Trails.d.getValue();
    }
}

