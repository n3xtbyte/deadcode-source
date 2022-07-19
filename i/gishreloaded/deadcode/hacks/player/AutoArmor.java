/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.InventoryEffectRenderer
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.util.DamageSource
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.player;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoArmor
extends Hack {
    public BooleanValue a;
    public BooleanValue b;
    public IntegerValue c;
    private int d;

    public AutoArmor(String string) {
        super(string, HackCategory.Player);
        this.b("General");
        this.a = new BooleanValue("Enchantments", true);
        this.b = new BooleanValue("Swap while moving", false);
        this.c = new IntegerValue("Delay", 2, 0, 20);
        this.a(this.a, this.b, this.c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Manages your armor automatically.";
    }

    @Override
    public void onEnable() {
        this.d = 0;
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        int n2;
        ItemArmor itemArmor;
        Object object;
        int n3;
        if (this.d > 0) {
            --this.d;
            return;
        }
        if (Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiContainer && !(Wrapper.INSTANCE.getMinecraft().currentScreen instanceof InventoryEffectRenderer)) {
            return;
        }
        InventoryPlayer inventoryPlayer = cs.a.a();
        if (!(((Boolean)this.b.getObjectValue()).booleanValue() || Wrapper.INSTANCE.getLocalPlayer().movementInput.moveForward == 0.0f && Wrapper.INSTANCE.getLocalPlayer().movementInput.moveStrafe == 0.0f)) {
            return;
        }
        int[] nArray = new int[4];
        int[] nArray2 = new int[4];
        for (n3 = 0; n3 < 4; ++n3) {
            nArray[n3] = -1;
            object = inventoryPlayer.armorItemInSlot(n3);
            if (et.a((ItemStack)object) || !(object.getItem() instanceof ItemArmor)) continue;
            itemArmor = (ItemArmor)object.getItem();
            nArray2[n3] = this.a(itemArmor, (ItemStack)object);
        }
        for (n3 = 0; n3 < 36; ++n3) {
            object = inventoryPlayer.getStackInSlot(n3);
            if (et.a((ItemStack)object) || !(object.getItem() instanceof ItemArmor)) continue;
            itemArmor = (ItemArmor)object.getItem();
            n2 = itemArmor.armorType.getIndex();
            int n4 = this.a(itemArmor, (ItemStack)object);
            if (n4 <= nArray2[n2]) continue;
            nArray[n2] = n3;
            nArray2[n2] = n4;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3));
        Collections.shuffle(arrayList);
        object = arrayList.iterator();
        while (object.hasNext()) {
            ItemStack itemStack;
            int n5 = (Integer)object.next();
            n2 = nArray[n5];
            if (n2 == -1 || !et.a(itemStack = inventoryPlayer.armorItemInSlot(n5)) && inventoryPlayer.getFirstEmptyStack() == -1) continue;
            if (n2 < 9) {
                n2 += 36;
            }
            if (!et.a(itemStack)) {
                et.a(0, 8 - n5, 0, ClickType.QUICK_MOVE);
            }
            et.a(0, n2, 0, ClickType.QUICK_MOVE);
            break;
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (bw2 == bw.b && object instanceof CPacketClickWindow) {
            this.d = this.c.getValue();
        }
        return true;
    }

    public int a(ItemArmor itemArmor, ItemStack itemStack) {
        int n2 = itemArmor.damageReduceAmount;
        int n3 = 0;
        int n4 = (int)itemArmor.toughness;
        int n5 = itemArmor.getArmorMaterial().getDamageReductionAmount(EntityEquipmentSlot.LEGS);
        if (((Boolean)this.a.getObjectValue()).booleanValue()) {
            Enchantment enchantment = Enchantments.PROTECTION;
            int n6 = EnchantmentHelper.getEnchantmentLevel((Enchantment)enchantment, (ItemStack)itemStack);
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            DamageSource damageSource = DamageSource.causePlayerDamage((EntityPlayer)entityPlayerSP);
            n3 = enchantment.calcModifierDamage(n6, damageSource);
        }
        return n2 * 5 + n3 * 3 + n4 + n5;
    }
}

