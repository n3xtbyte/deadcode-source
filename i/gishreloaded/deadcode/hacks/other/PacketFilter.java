/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CPacketClientStatus
 *  net.minecraft.network.play.client.CPacketCloseWindow
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketInput
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerAbilities
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketVehicleMove
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerAbilities;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;

public class PacketFilter
extends Hack {
    public ModeValue a;
    public BooleanValue b;
    public BooleanValue c;
    public BooleanValue d;
    public BooleanValue e;
    public BooleanValue f;
    public BooleanValue g;
    public BooleanValue h;
    public BooleanValue i;
    public BooleanValue j;
    public BooleanValue k;
    public BooleanValue l;
    public BooleanValue m;
    public BooleanValue n;

    public PacketFilter(String string) {
        super(string, HackCategory.Other);
        this.b("Packet");
        this.b = new BooleanValue("Player", false);
        this.c = new BooleanValue("CloseWindow", false);
        this.d = new BooleanValue("Rotation", false);
        this.e = new BooleanValue("Position", false);
        this.f = new BooleanValue("PositionRotation", false);
        this.g = new BooleanValue("ClientStatus", false);
        this.h = new BooleanValue("Input", false);
        this.i = new BooleanValue("PlayerAbilities", false);
        this.j = new BooleanValue("PlayerDigging", false);
        this.k = new BooleanValue("UseEntity", false);
        this.l = new BooleanValue("VehicleMove", false);
        this.m = new BooleanValue("EntityAction", false);
        this.n = new BooleanValue("ClickWindow", false);
        this.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Client output packet filter.";
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (bw2 == bw.b) {
            return this.a(object);
        }
        return true;
    }

    public boolean a(Object object) {
        return !((Boolean)this.b.getObjectValue() != false && object instanceof CPacketPlayer || (Boolean)this.c.getObjectValue() != false && object instanceof CPacketCloseWindow || (Boolean)this.d.getObjectValue() != false && object instanceof CPacketPlayer.Rotation || (Boolean)this.e.getObjectValue() != false && object instanceof CPacketPlayer.Position || (Boolean)this.f.getObjectValue() != false && object instanceof CPacketPlayer.PositionRotation || (Boolean)this.g.getObjectValue() != false && object instanceof CPacketClientStatus || (Boolean)this.h.getObjectValue() != false && object instanceof CPacketInput || (Boolean)this.i.getObjectValue() != false && object instanceof CPacketPlayerAbilities || (Boolean)this.j.getObjectValue() != false && object instanceof CPacketPlayerDigging || (Boolean)this.k.getObjectValue() != false && object instanceof CPacketUseEntity || (Boolean)this.l.getObjectValue() != false && object instanceof CPacketVehicleMove || (Boolean)this.m.getObjectValue() != false && object instanceof CPacketEntityAction) && ((Boolean)this.n.getObjectValue() == false || !(object instanceof CPacketClickWindow));
    }
}

