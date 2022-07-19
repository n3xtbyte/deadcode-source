/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.Slot
 */
package excluded;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

class q
extends Slot {
    public q(IInventory iInventory, int n2, int n3, int n4) {
        super(iInventory, n2, n3, n4);
    }

    public boolean a(EntityPlayer entityPlayer) {
        if (super.canTakeStack(entityPlayer) && this.getHasStack()) {
            return this.getStack().getSubCompound("CustomCreativeLock") == null;
        }
        return !this.getHasStack();
    }
}

