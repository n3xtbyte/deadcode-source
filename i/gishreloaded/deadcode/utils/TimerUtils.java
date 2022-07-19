/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.utils;

public class TimerUtils {
    private long time = 0L;

    public boolean isReached(long l2) {
        return System.currentTimeMillis() - this.time >= l2;
    }

    public long elapsedSinceLastReset() {
        return System.currentTimeMillis() - this.time;
    }

    public long b() {
        return System.nanoTime() / 1000000L;
    }

    public void resetTime() {
        this.time = System.currentTimeMillis();
    }

    public void setTime(long l2) {
        this.time = l2;
    }

    public int a(int n2) {
        return 1000 / n2;
    }
}

