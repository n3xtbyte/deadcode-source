/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Disconnect
extends Hack {
    public ModeValue a = new ModeValue("Mode", new Mode("Spawn", true), new Mode("Hub"), new Mode("Home"));
    public IntegerValue b = new IntegerValue("Distance", 10, 6, 50);

    public Disconnect(String string) {
        super(string, HackCategory.Other);
        this.b("General");
        this.a(this.a, this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Automatically leaves to home.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        boolean bl = false;
        for (EntityPlayer entityPlayer : et.c()) {
            if (entityPlayer == Wrapper.INSTANCE.getLocalPlayer() || !(Wrapper.INSTANCE.getLocalPlayer().getDistance((Entity)entityPlayer) < (float)this.b.getValue().intValue()) || !eQ.a((EntityLivingBase)entityPlayer)) continue;
            bl = true;
        }
        if (bl) {
            Object object = "";
            if (this.a.getModeByIndex(0).isToggled()) {
                object = "/spawn";
            } else if (this.a.getModeByIndex(1).isToggled()) {
                object = "/hub";
            } else if (this.a.getModeByIndex(2).isToggled()) {
                object = "/home home";
            }
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketChatMessage((String)object));
            this.c(false);
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

