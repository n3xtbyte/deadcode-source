/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 */
package i.gishreloaded.deadcode.hacks.thread;

import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;

public class ShieldBreaker
extends Thread {
    public final /* synthetic */ i.gishreloaded.deadcode.hacks.combat.ShieldBreaker a;

    public ShieldBreaker(i.gishreloaded.deadcode.hacks.combat.ShieldBreaker shieldBreaker) {
        this.a = shieldBreaker;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10L);
            if (this.a.a != -2) {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(this.a.a));
                this.a.a = -2;
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("breakShield: ", exception);
        }
    }
}

