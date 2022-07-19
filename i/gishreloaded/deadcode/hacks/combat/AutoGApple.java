/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent$Finish
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoGApple
extends Hack {
    public BooleanValue a;
    public DoubleValue b;
    public boolean c;
    public int d = -2;

    public AutoGApple(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.a = new BooleanValue("Hotbar", false);
        this.b = new DoubleValue("Health", 15.0, 0.0, 20.0);
        this.a(this.b, this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Automatically eat golden apples.";
    }

    @Override
    public void onEntityUseItemEvent(LivingEntityUseItemEvent livingEntityUseItemEvent) {
        if (this.c && livingEntityUseItemEvent instanceof LivingEntityUseItemEvent.Finish && livingEntityUseItemEvent.getItem().getItem() == Items.GOLDEN_APPLE) {
            this.a(false);
        }
        super.onEntityUseItemEvent(livingEntityUseItemEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        CPacketUseEntity cPacketUseEntity;
        if (this.c && object instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity)object).getAction() != CPacketUseEntity.Action.ATTACK) {
            return false;
        }
        return super.a(object, bw2);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        int n2;
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.d != -2) {
            entityPlayerSP.inventory.currentItem = this.d;
            this.d = -2;
        }
        if (this.b.getValue() <= (double)entityPlayerSP.getMaxHealth() && (double)entityPlayerSP.getHealth() >= this.b.getValue()) {
            return;
        }
        ItemStack itemStack = entityPlayerSP.getHeldItemOffhand();
        if (((Boolean)this.a.getObjectValue()).booleanValue() && (et.a(itemStack) || itemStack.getItem() != Items.GOLDEN_APPLE) && (n2 = bz.b(Items.GOLDEN_APPLE)) != -2) {
            this.d = entityPlayerSP.inventory.currentItem;
            entityPlayerSP.inventory.currentItem = n2;
        }
        if (!et.a(itemStack) && itemStack.getItem() == Items.GOLDEN_APPLE || this.d != -2) {
            this.a(true);
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    public void a(boolean bl) {
        KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindUseItem.getKeyCode(), (boolean)bl);
        this.c = bl;
    }
}

