/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class BowAimBot
extends Hack {
    public BooleanValue a;
    public static EntityLivingBase b;

    public BowAimBot(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.a = new BooleanValue("Predict", false);
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Automatically aims your bow at the closest entity.";
    }

    @Override
    public void onDisable() {
        b = null;
        super.onDisable();
    }

    @Override
    public void onEnable() {
        b = null;
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        ItemStack itemStack = cs.a.a().getCurrentItem();
        if (itemStack == null || !(itemStack.getItem() instanceof ItemBow)) {
            b = null;
            return;
        }
        if (!Wrapper.INSTANCE.getGameSettings().keyBindUseItem.isKeyDown()) {
            ef.i();
            b = null;
            return;
        }
        b = this.b();
        if (b == null) {
            return;
        }
        MathUtils.a((Entity)b, true, (Boolean)this.a.getObjectValue(), 2.0f);
        super.onClientTickEvent(clientTickEvent);
    }

    public boolean a(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntityArmorStand) {
            return false;
        }
        if (eQ.a((Entity)entityLivingBase)) {
            return false;
        }
        if (!eQ.a()) {
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
        if (!eQ.c(entityLivingBase)) {
            return false;
        }
        if (!eQ.b(entityLivingBase)) {
            return false;
        }
        return Wrapper.INSTANCE.getLocalPlayer().canEntityBeSeen((Entity)entityLivingBase);
    }

    public EntityLivingBase b() {
        EntityLivingBase entityLivingBase = null;
        for (Object e : et.b()) {
            EntityLivingBase entityLivingBase2;
            if (!(e instanceof EntityLivingBase) || e instanceof EntityArmorStand || !this.a(entityLivingBase2 = (EntityLivingBase)e) || entityLivingBase != null && !(Wrapper.INSTANCE.getLocalPlayer().getDistance((Entity)entityLivingBase2) < Wrapper.INSTANCE.getLocalPlayer().getDistance((Entity)entityLivingBase))) continue;
            entityLivingBase = entityLivingBase2;
        }
        return entityLivingBase;
    }
}

