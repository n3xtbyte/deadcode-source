/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class HitBox
extends Hack {
    public DoubleValue a;
    public DoubleValue b;

    public HitBox(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.a = new DoubleValue("Width", 0.6, 0.1, 5.0);
        this.b = new DoubleValue("Height", 1.8, 0.1, 5.0);
        this.a(this.a, this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Change size hit box of players.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        for (EntityPlayer entityPlayer : et.c()) {
            if (!this.a((EntityLivingBase)entityPlayer)) continue;
            float f2 = this.a.getValue().floatValue();
            float f3 = this.b.getValue().floatValue();
            et.a((Entity)entityPlayer, f2, f3);
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onDisable() {
        for (EntityPlayer entityPlayer : et.c()) {
            et.a((Entity)entityPlayer);
        }
        super.onDisable();
    }

    public boolean a(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntityPlayerSP) {
            return false;
        }
        if (entityLivingBase == Wrapper.INSTANCE.getLocalPlayer()) {
            return false;
        }
        if (entityLivingBase.isDead) {
            return false;
        }
        if (!eQ.a(entityLivingBase)) {
            return false;
        }
        return eQ.b(entityLivingBase);
    }
}

