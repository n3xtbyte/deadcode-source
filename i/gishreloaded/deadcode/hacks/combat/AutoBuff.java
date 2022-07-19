/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.EnumHand
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.combat.KillAura;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.Value;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoBuff
extends Hack {
    public IntegerValue a;
    public BooleanValue b;
    public ModeValue c;
    public IntegerValue d;
    public DoubleValue e;
    public HashMap f;
    public TimerUtils g;
    public TimerUtils h;

    public AutoBuff(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.c = new ModeValue("Rotation", false, new Mode("Default"), new Mode("Packet", true));
        this.d = new IntegerValue("Delay", 500, 0, 1000);
        this.b = new BooleanValue("Only ground", false);
        this.e = new DoubleValue("Health", 20.0, 1.0, 20.0);
        this.a = new IntegerValue("Ticks existed", 110, 0, 1000);
        this.f = new HashMap();
        this.f.put(MobEffects.REGENERATION, new BooleanValue("Regeneration", true));
        this.f.put(MobEffects.STRENGTH, new BooleanValue("Strength Potion", true));
        this.f.put(MobEffects.FIRE_RESISTANCE, new BooleanValue("Fire Resistance", true));
        this.f.put(MobEffects.JUMP_BOOST, new BooleanValue("Jump Boost", true));
        this.f.put(MobEffects.SPEED, new BooleanValue("Speed Potion", true));
        this.a(this.c, this.b, this.e, this.d, this.a);
        this.b("Potions");
        this.addValues(this.f.values());
        this.b("Other");
        this.g = new TimerUtils();
        this.h = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Automatically throws buff potions.";
    }

    @Override
    public void onDisable() {
        ef.j();
        super.onDisable();
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        int n2;
        Object object;
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (entityPlayerSP.ticksExisted < this.a.getValue()) {
            return;
        }
        if (entityPlayerSP.capabilities.isFlying || ((Boolean)this.b.getObjectValue()).booleanValue() && !entityPlayerSP.onGround) {
            return;
        }
        if (this.e.getValue().intValue() != (int)entityPlayerSP.getMaxHealth() && (double)entityPlayerSP.getHealth() >= this.e.getValue()) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Map.Entry entry : this.f.entrySet()) {
            Potion potion = (Potion)entry.getKey();
            object = (BooleanValue)entry.getValue();
            if (!((Boolean)((Value)object).getObjectValue()).booleanValue() || ((Boolean)((Value)object).getObjectValue()).booleanValue() && entityPlayerSP.getActivePotionEffect(potion) != null || (n2 = bz.b(potion, true)) == -2) continue;
            arrayList.add(n2);
        }
        boolean bl = this.c.getModeByIndex(0).isToggled();
        boolean bl2 = this.c.getModeByIndex(1).isToggled();
        if (!arrayList.isEmpty()) {
            float f2;
            float f3 = f2 = KillAura.J != null && !KillAura.F() ? KillAura.K[0] : entityPlayerSP.rotationYaw;
            if (bl) {
                entityPlayerSP.rotationPitch = 90.0f;
            } else if (bl2) {
                ef.a(f2, 90.0f);
                Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
                if (this.h.isReached(1L)) {
                    Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
                }
                if (this.h.isReached(2L)) {
                    Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw - 2.0E-4);
                    this.h.resetTime();
                }
            }
            if (bl || bl2 && ef.e() == 90.0f) {
                if (!this.g.isReached(this.d.getValue().longValue())) {
                    return;
                }
                object = arrayList.iterator();
                while (object.hasNext()) {
                    n2 = (Integer)object.next();
                    this.a(n2);
                }
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(entityPlayerSP.inventory.currentItem));
                this.g.resetTime();
                this.a(bl2);
            }
            return;
        }
        this.a(bl2);
        super.onPlayerTickEvent(playerTickEvent);
    }

    public void a(boolean bl) {
        if (bl && (KillAura.J == null || KillAura.J != null && KillAura.F())) {
            ef.j();
        }
    }

    public void a(int n2) {
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(n2));
        Wrapper.INSTANCE.getMinecraft().playerController.updateController();
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
        Wrapper.INSTANCE.getMinecraft().playerController.updateController();
    }
}

