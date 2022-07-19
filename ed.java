/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 */
import i.gishreloaded.deadcode.hacks.other.Sleep;
import i.gishreloaded.deadcode.hacks.render.HUD;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import net.minecraft.client.gui.ScaledResolution;

public class ed {
    public ArrayList a = new ArrayList();

    public void a(String string, String string2, int n2, int n3, double d2) {
        if (!((Boolean)HUD.h.getObjectValue()).booleanValue() || Sleep.a) {
            if (!this.a.isEmpty()) {
                this.a.clear();
            }
            return;
        }
        this.a.add(new ai(string, string2, n2, n3, d2));
    }

    public void a() {
        if (this.a.isEmpty()) {
            return;
        }
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        long l2 = System.currentTimeMillis();
        float f2 = 25.0f;
        float f3 = scaledResolution.getScaledWidth() - 20;
        float f4 = scaledResolution.getScaledHeight() - 40;
        if (HUD.w) {
            f4 -= 20.0f;
        }
        try {
            for (ai ai2 : this.a) {
                if (ai2.k != ai2.k || ai2.m != ai2.m) {
                    ai2.a();
                }
                double d2 = ai2.m + ((double)f4 - ai2.m) * Math.pow((double)(l2 - ai2.l) / 1000.0, 0.5);
                double d3 = ai2.k + ((double)f3 - ai2.k) * Math.pow((double)(l2 - ai2.j) / 1000.0, 0.5);
                ai2.a((float)d3, (float)d2);
                if (ai2.i) {
                    this.a.remove(ai2);
                }
                ai2.k = d3;
                ai2.j = l2;
                ai2.m = d2;
                ai2.l = l2;
                f4 -= f2;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

