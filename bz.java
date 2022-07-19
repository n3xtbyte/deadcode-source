/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemAxe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.potion.PotionUtils
 */
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;

public class bz {
    public static int a(Item item, int n2, int n3) {
        int n4 = -2;
        for (int i2 = n2; i2 <= n3; ++i2) {
            if (cs.a.a().getStackInSlot(i2).getItem() != item) continue;
            n4 = i2;
        }
        return n4;
    }

    public static int a(Item item) {
        return bz.a(item, 0, 44);
    }

    public static int b(Item item) {
        return bz.a(item, 0, 8);
    }

    public static int c(Item item) {
        return bz.a(item, 9, 44);
    }

    public static int a() {
        for (int i2 = 9; i2 <= 44; ++i2) {
            if (!cs.a.a().getStackInSlot(i2).isEmpty()) continue;
            return i2;
        }
        return -2;
    }

    public static int b() {
        for (int i2 = 0; i2 < 8; ++i2) {
            if (!((ItemStack)cs.a.a().mainInventory.get(i2)).isEmpty()) continue;
            return i2;
        }
        return -2;
    }

    public static int c() {
        int n2 = -2;
        for (int i2 = 0; i2 <= 8; ++i2) {
            if (!(cs.a.a().getStackInSlot(i2).getItem() instanceof ItemAxe)) continue;
            n2 = i2;
        }
        return n2;
    }

    public static int a(Potion potion, boolean bl) {
        for (int i2 = 9; i2 <= 44; ++i2) {
            ItemStack itemStack = cs.a.a().getStackInSlot(i2);
            if (bl && itemStack.getItem() != Items.SPLASH_POTION || !bl && itemStack.getItem() == Items.SPLASH_POTION || !bz.a(itemStack, potion)) continue;
            return i2;
        }
        return -2;
    }

    public static int b(Potion potion, boolean bl) {
        for (int i2 = 0; i2 < 9; ++i2) {
            ItemStack itemStack = cs.a.a().getStackInSlot(i2);
            if (bl && itemStack.getItem() != Items.SPLASH_POTION || !bl && itemStack.getItem() == Items.SPLASH_POTION || !bz.a(itemStack, potion)) continue;
            return i2;
        }
        return -2;
    }

    public static boolean a(ItemStack itemStack, Potion potion) {
        for (PotionEffect potionEffect : PotionUtils.getEffectsFromStack((ItemStack)itemStack)) {
            if (potionEffect.getPotion() != potion) continue;
            return true;
        }
        return false;
    }

    public static void a(int n2, int n3) {
        et.a(0, n2, n3, ClickType.PICKUP);
    }

    public static void b(int n2, int n3) {
        et.a(n2, n3, 1, ClickType.QUICK_MOVE);
    }

    public static void c(int n2, int n3) {
        et.a(0, n2, n3, ClickType.SWAP);
    }
}

