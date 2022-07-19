/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.texture.DynamicTexture
 */
import i.gishreloaded.deadcode.utils.ReflectionUtils;
import java.awt.image.BufferedImage;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;

/*
 * Renamed from cW
 */
public class cw_0 {
    public DynamicTexture a;
    public List b;
    public int c;
    public long d;
    public float e;

    public cw_0(List list) {
        this.b = list;
        this.d = System.currentTimeMillis();
        this.e = ReflectionUtils.getTimerSpeed();
    }

    public void a() {
        if ((float)(System.currentTimeMillis() - this.d) >= this.e / (float)Minecraft.getDebugFPS() * 100.0f) {
            if (this.c > this.b.size() - 1) {
                this.c = 0;
            }
            this.a = new DynamicTexture((BufferedImage)this.b.get(this.c));
            ++this.c;
            this.d = System.currentTimeMillis();
        }
    }

    public DynamicTexture b() {
        return this.a;
    }
}

