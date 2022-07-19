/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.player;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AntiFall
extends Hack {
    public ModeValue a;
    public boolean b;
    public double c;

    public AntiFall(String string) {
        super(string, HackCategory.Player);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("Matrix"), new Mode("Matrix2"));
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Gives you zero damage on fall.";
    }

    @Override
    public void onDisable() {
        if (this.a.getModeByIndex(1).isToggled() && this.b) {
            this.b = false;
        }
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.a.getModeByIndex(0).isToggled()) {
            if ((double)entityPlayerSP.fallDistance > 2.5) {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer(true));
            }
        } else if (this.a.getModeByIndex(2).isToggled()) {
            if ((double)entityPlayerSP.fallDistance > 2.5 && entityPlayerSP.fallDistance < 10.0f) {
                ef.a(true);
            } else if (entityPlayerSP.onGround) {
                ef.l();
            }
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (!this.a.getModeByIndex(1).isToggled()) {
            return;
        }
        if (!Wrapper.INSTANCE.getLocalPlayer().onGround && Wrapper.INSTANCE.getLocalPlayer().fallDistance > 2.0f && eS.b(Wrapper.INSTANCE.getLocalPlayer().getPosition().down()) == Blocks.AIR) {
            this.b = true;
        }
        if (this.b) {
            Wrapper.INSTANCE.getLocalPlayer().onGround = false;
        }
        super.onPlayerTickEvent(playerTickEvent);
    }
}

