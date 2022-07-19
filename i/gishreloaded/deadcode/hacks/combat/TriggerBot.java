/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.EnumCreatureAttribute
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.combat.Criticals;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.utils.RandomUtils;
import i.gishreloaded.deadcode.utils.RaytraceUtils;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TriggerBot
extends Hack {
    public BooleanValue a = new BooleanValue("Cooldown", true);
    public DoubleValue b = new DoubleValue("Cooldown value", 0.95, 0.1, 1.0);
    public BooleanValue c = new BooleanValue("Only weapon", false);
    public IntegerValue d = new IntegerValue("Min CPS", 6, 1, 20);
    public IntegerValue e = new IntegerValue("Max CPS", 12, 1, 20);
    public static EntityLivingBase f;
    public TimerUtils g;

    public TriggerBot(String string) {
        super(string, HackCategory.Combat);
        this.b("Attack");
        this.a(this.c);
        this.b("Delay");
        this.a(this.a, this.b, this.d, this.e);
        this.b("Other");
        this.g = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Automatically attacks the entity you're looking at.";
    }

    @Override
    public void onEnable() {
        f = null;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        f = null;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        this.b();
        this.a(f);
        super.onClientTickEvent(clientTickEvent);
    }

    public void a(EntityLivingBase entityLivingBase) {
        if (((Boolean)this.c.getObjectValue()).booleanValue() && !et.e()) {
            return;
        }
        if (this.c(entityLivingBase)) {
            if (((Boolean)this.a.getObjectValue()).booleanValue()) {
                if ((double)Wrapper.INSTANCE.getLocalPlayer().getCooledAttackStrength(0.0f) >= this.b.getValue()) {
                    this.b(entityLivingBase);
                }
            } else {
                int n2 = RandomUtils.randomInt(this.d.getValue(), this.e.getValue());
                if (this.g.isReached(1000 / n2)) {
                    this.b(entityLivingBase);
                    this.g.resetTime();
                }
            }
        }
    }

    public void b(EntityLivingBase entityLivingBase) {
        if (HackManager.getHack("Criticals").isToggled() && !Criticals.h()) {
            return;
        }
        float f2 = EnchantmentHelper.getModifierForCreature((ItemStack)Wrapper.INSTANCE.getLocalPlayer().getHeldItemMainhand(), (EnumCreatureAttribute)entityLivingBase.getCreatureAttribute());
        cs.a.a((Entity)entityLivingBase);
        cs.a.c();
        if (f2 > 0.0f) {
            Wrapper.INSTANCE.getLocalPlayer().onEnchantmentCritical((Entity)entityLivingBase);
        }
    }

    public void b() {
        EntityLivingBase entityLivingBase = null;
        Entity entity = null;
        if (HackManager.getHack("Reach").isToggled()) {
            entity = RaytraceUtils.b(RaytraceUtils.b());
        } else {
            Wrapper.INSTANCE.getMinecraft().entityRenderer.getMouseOver(1.0f);
            if (Wrapper.INSTANCE.getMinecraft().objectMouseOver != null && Wrapper.INSTANCE.getMinecraft().objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY) {
                entity = Wrapper.INSTANCE.getMinecraft().objectMouseOver.entityHit;
            }
        }
        if (f != entityLivingBase) {
            f = null;
        }
        if (entity != null && entity instanceof EntityLivingBase) {
            entityLivingBase = (EntityLivingBase)entity;
        }
        if (entityLivingBase != null) {
            f = entityLivingBase;
        }
    }

    public boolean c(EntityLivingBase entityLivingBase) {
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
}

