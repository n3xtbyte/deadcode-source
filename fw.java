/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 */
import i.gishreloaded.deadcode.hacks.render.XRayBypass;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import java.util.stream.Stream;
import net.minecraft.util.math.BlockPos;

public class fw
implements Runnable {
    private volatile boolean b = true;
    public final /* synthetic */ XRayBypass a;

    public fw(XRayBypass xRayBypass) {
        this.a = xRayBypass;
    }

    public void a() {
        this.b = false;
    }

    @Override
    public void run() {
        Stream stream = eS.a(this.a.b.getValue(), this.a.c.getValue(), this.a.b.getValue());
        if (stream == null || !this.b) {
            return;
        }
        stream.forEach(blockPos -> {
            if (et.a() || !this.b) {
                this.a.c();
                System.exit(0);
            }
            try {
                if (this.a.h.isReached(2L)) {
                    this.a.a((BlockPos)blockPos);
                    this.a.h.resetTime();
                }
                Thread.sleep(this.a.d.getValue().intValue());
            }
            catch (Exception exception) {
                ChatUtils.exception("XRayBypass-thread: ", exception);
            }
        });
    }
}

