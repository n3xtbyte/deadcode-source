/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 */
package i.gishreloaded.deadcode.hacks.thread;

import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import net.minecraft.client.entity.EntityPlayerSP;

public class HighJump
extends Thread {
    public final /* synthetic */ EntityPlayerSP a;
    public final /* synthetic */ i.gishreloaded.deadcode.hacks.movement.HighJump b;

    public HighJump(i.gishreloaded.deadcode.hacks.movement.HighJump highJump, EntityPlayerSP entityPlayerSP) {
        this.b = highJump;
        this.a = entityPlayerSP;
    }

    @Override
    public void run() {
        this.a.motionY = 9.0;
        try {
            HighJump.sleep(240L);
        }
        catch (Exception exception) {
            ChatUtils.exception("HighJump", exception);
        }
        this.a.motionY = 8.742f;
        super.run();
    }
}

