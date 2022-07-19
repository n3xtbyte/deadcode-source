/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 */
package i.gishreloaded.deadcode.hacks.thread;

import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;

public class ClickPearl
extends Thread {
    public final /* synthetic */ EntityPlayerSP a;
    public final /* synthetic */ i.gishreloaded.deadcode.hacks.combat.ClickPearl b;

    public ClickPearl(i.gishreloaded.deadcode.hacks.combat.ClickPearl clickPearl, EntityPlayerSP entityPlayerSP) {
        this.b = clickPearl;
        this.a = entityPlayerSP;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(400L);
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(this.a.inventory.currentItem));
        }
        catch (Exception exception) {
            ChatUtils.exception("ClickPearl: ", exception);
        }
    }
}

