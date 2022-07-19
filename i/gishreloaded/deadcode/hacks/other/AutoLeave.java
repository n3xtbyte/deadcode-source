/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoLeave
extends Hack {
    public ModeValue a;
    public DoubleValue b;
    public BooleanValue c;

    public AutoLeave(String string) {
        super(string, HackCategory.Other);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Quit", true), new Mode("SelfAttack"), new Mode("SpamPacket"), new Mode("BrokenPacket"));
        this.b = new DoubleValue("Leave health", 4.0, 0.0, 20.0);
        this.c = new BooleanValue("By health", false);
        this.a(this.a, new cs_0("Health"), this.c, this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Automatically leaves the server when your health is low.";
    }

    @Override
    public void onEnable() {
        if (((Boolean)this.c.getObjectValue()).booleanValue() || et.a()) {
            return;
        }
        this.b();
        this.c(false);
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (!((Boolean)this.c.getObjectValue()).booleanValue() || !(Wrapper.INSTANCE.getLocalPlayer().getHealth() <= this.b.getValue().floatValue())) {
            return;
        }
        this.b();
        this.c(false);
        super.onClientTickEvent(clientTickEvent);
    }

    public void b() {
        if (this.a.getMode("Quit").isToggled()) {
            Wrapper.INSTANCE.getWorld().sendQuittingDisconnectingPacket();
            Wrapper.INSTANCE.getMinecraft().loadWorld((WorldClient)null);
            Wrapper.INSTANCE.getMinecraft().displayGuiScreen((GuiScreen)new GuiMainMenu());
        }
        if (this.a.getMode("SelfAttack").isToggled()) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketUseEntity((Entity)Wrapper.INSTANCE.getLocalPlayer()));
        }
        if (this.a.getMode("SpamPacket").isToggled()) {
            for (int i2 = 0; i2 < 19998; ++i2) {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position((double)i2, (double)i2, (double)i2, false));
            }
        }
        if (this.a.getMode("BrokenPacket").isToggled()) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, !Wrapper.INSTANCE.getLocalPlayer().onGround));
        }
    }
}

