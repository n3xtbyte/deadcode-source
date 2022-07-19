/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoDebuff
extends Hack {
    public ModeValue a;
    public IntegerValue b;
    public HashMap c;
    public static EntityLivingBase d;
    public int e;
    public int f;

    public AutoDebuff(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.a = new ModeValue("Target priority", false, new Mode("Closest", true), new Mode("Health"));
        this.b = new IntegerValue("Delay", 100, 0, 500);
        this.c = new HashMap();
        this.c.put(MobEffects.INSTANT_DAMAGE, new BooleanValue("InstantDamage", true));
        this.c.put(MobEffects.SLOWNESS, new BooleanValue("Slowness", true));
        this.c.put(MobEffects.POISON, new BooleanValue("Poison", true));
        this.c.put(MobEffects.WEAKNESS, new BooleanValue("Weakness", true));
        this.a(this.a, this.b);
        this.b("Potions");
        this.addValues(this.c.values());
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Automatically throws debuff potions to enemy.";
    }

    @Override
    public void onEnable() {
        d = null;
        this.e = 0;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        d = null;
        this.e = 0;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        this.c();
        this.b();
        super.onClientTickEvent(clientTickEvent);
    }

    public void b() {
        if (d == null) {
            return;
        }
        int n2 = 1;
        int n3 = -2;
        for (Map.Entry entry : this.c.entrySet()) {
            Potion potion = (Potion)entry.getKey();
            BooleanValue booleanValue = (BooleanValue)entry.getValue();
            n3 = bz.b(potion, true);
            if (((Boolean)booleanValue.getObjectValue()).booleanValue() && d.getActivePotionEffect(potion) == null) {
                this.f = n2;
            }
            if (this.e > 0) {
                --this.e;
                d = null;
                return;
            }
            if (((Boolean)booleanValue.getObjectValue()).booleanValue() && n3 != -2 && d.getActivePotionEffect(potion) == null && this.f == n2) {
                this.a(n3, d);
                ++this.f;
            }
            ++n2;
        }
        if (n3 == -2) {
            d = null;
        }
    }

    public void a(int n2, EntityLivingBase entityLivingBase) {
        float[] fArray = MathUtils.a((Entity)entityLivingBase, cy_0.a);
        int n3 = Wrapper.INSTANCE.getLocalPlayer().inventory.currentItem;
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Rotation(fArray[0], fArray[1], Wrapper.INSTANCE.getLocalPlayer().onGround));
        Wrapper.INSTANCE.getLocalPlayer().inventory.currentItem = n2;
        cs.a.b().processRightClick((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), (World)Wrapper.INSTANCE.getWorld(), EnumHand.MAIN_HAND);
        this.e = this.b.getValue();
        Wrapper.INSTANCE.getLocalPlayer().inventory.currentItem = n3;
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Rotation(Wrapper.INSTANCE.getLocalPlayer().rotationYaw, Wrapper.INSTANCE.getLocalPlayer().rotationPitch, Wrapper.INSTANCE.getLocalPlayer().onGround));
    }

    public void c() {
        for (Object e : et.b()) {
            EntityLivingBase entityLivingBase;
            if (!(e instanceof EntityLivingBase) || !this.c(entityLivingBase = (EntityLivingBase)e)) continue;
            d = entityLivingBase;
        }
    }

    public boolean a(EntityLivingBase entityLivingBase) {
        return this.a.getModeByIndex(0).isToggled() && eQ.c(entityLivingBase, d) || this.a.getModeByIndex(1).isToggled() && eQ.a(entityLivingBase, d);
    }

    public boolean b(EntityLivingBase entityLivingBase) {
        return entityLivingBase.getDistance((Entity)Wrapper.INSTANCE.getLocalPlayer()) <= this.d() && entityLivingBase.getDistance((Entity)Wrapper.INSTANCE.getLocalPlayer()) >= this.e();
    }

    public float d() {
        return 10.0f;
    }

    public float e() {
        return 4.0f;
    }

    public boolean c(EntityLivingBase entityLivingBase) {
        return !(entityLivingBase instanceof EntityPlayerSP) && !eQ.a((Entity)entityLivingBase) && eQ.a() && entityLivingBase != Wrapper.INSTANCE.getLocalPlayer() && !entityLivingBase.isDead && entityLivingBase.deathTime <= 0 && eQ.a(entityLivingBase) && eQ.c(entityLivingBase) && this.b(entityLivingBase) && eQ.b(entityLivingBase) && Wrapper.INSTANCE.getLocalPlayer().canEntityBeSeen((Entity)entityLivingBase) && this.a(entityLivingBase);
    }
}

