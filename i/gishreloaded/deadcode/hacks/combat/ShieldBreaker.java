/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.world.World
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.combat.KillAura;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.world.World;

public class ShieldBreaker
extends Hack {
    public int a = -2;

    public ShieldBreaker(String string) {
        super(string, HackCategory.Combat);
    }

    @Override
    public void onEnable() {
        this.a = -2;
        super.onEnable();
    }

    @Override
    public String getDescription() {
        return "Automatically get axe on attack, for destroy shield.";
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (ShieldBreaker.b()) {
            return true;
        }
        if (bw2 == bw.b && object instanceof CPacketUseEntity) {
            CPacketUseEntity cPacketUseEntity = (CPacketUseEntity)object;
            if (cPacketUseEntity.getAction() != CPacketUseEntity.Action.ATTACK) {
                return true;
            }
            Entity entity = cPacketUseEntity.getEntityFromWorld((World)Wrapper.INSTANCE.getWorld());
            if (entity != null) {
                this.a(entity);
            }
        }
        return true;
    }

    public static boolean b() {
        return (Boolean)KillAura.n.getObjectValue() != false && KillAura.J != null;
    }

    public void a(Entity entity) {
        int n2;
        EntityPlayer entityPlayer;
        if (entity instanceof EntityPlayer && et.b(entityPlayer = (EntityPlayer)entity) && (n2 = bz.c()) != -2) {
            this.a = Wrapper.INSTANCE.getLocalPlayer().inventory.currentItem;
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(n2));
            new i.gishreloaded.deadcode.hacks.thread.ShieldBreaker(this).start();
        }
    }
}

