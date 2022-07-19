/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 */
package excluded;

import excluded.q;
import i.gishreloaded.deadcode.excluded.GuiContainerCreative;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class m
extends Container {
    public NonNullList a = NonNullList.create();

    public m(EntityPlayer entityPlayer) {
        int n2;
        InventoryPlayer inventoryPlayer = entityPlayer.inventory;
        for (n2 = 0; n2 < 5; ++n2) {
            for (int i2 = 0; i2 < 9; ++i2) {
                this.addSlotToContainer(new q((IInventory)GuiContainerCreative.g(), n2 * 9 + i2, 9 + i2 * 18, 18 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot((IInventory)inventoryPlayer, n2, 9 + n2 * 18, 112));
        }
        this.a(0.0f);
    }

    public boolean a(EntityPlayer entityPlayer) {
        return true;
    }

    public void a(float f2) {
        int n2 = (this.a.size() + 9 - 1) / 9 - 5;
        int n3 = (int)((double)(f2 * (float)n2) + 0.5);
        if (n3 < 0) {
            n3 = 0;
        }
        for (int i2 = 0; i2 < 5; ++i2) {
            for (int i3 = 0; i3 < 9; ++i3) {
                int n4 = i3 + (i2 + n3) * 9;
                if (n4 >= 0 && n4 < this.a.size()) {
                    GuiContainerCreative.g().setInventorySlotContents(i3 + i2 * 9, (ItemStack)this.a.get(n4));
                    continue;
                }
                GuiContainerCreative.g().setInventorySlotContents(i3 + i2 * 9, ItemStack.EMPTY);
            }
        }
    }

    public boolean a() {
        return this.a.size() > 45;
    }

    public ItemStack a(EntityPlayer entityPlayer, int n2) {
        Slot slot;
        if (n2 >= this.inventorySlots.size() - 9 && n2 < this.inventorySlots.size() && (slot = (Slot)this.inventorySlots.get(n2)) != null && slot.getHasStack()) {
            slot.putStack(ItemStack.EMPTY);
        }
        return ItemStack.EMPTY;
    }

    public boolean a(ItemStack itemStack, Slot slot) {
        return slot.yPos > 90;
    }

    public boolean a(Slot slot) {
        return slot.inventory instanceof InventoryPlayer || slot.yPos > 90 && slot.xPos <= 162;
    }
}

