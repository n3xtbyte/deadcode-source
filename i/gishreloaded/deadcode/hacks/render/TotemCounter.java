/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TotemCounter
extends Hack {
    public TotemCounter(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Shows the number of totems in the inventory.";
    }

    @Override
    public void a(float f2) {
        int n2 = 0;
        ItemStack itemStack = null;
        for (int i2 = 0; i2 <= 44; ++i2) {
            ItemStack itemStack2 = cs.a.a().getStackInSlot(i2);
            if (itemStack2.getItem() != Items.TOTEM_OF_UNDYING) continue;
            ++n2;
            itemStack = itemStack2;
        }
        if (itemStack == null || n2 == 0) {
            return;
        }
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        int n3 = scaledResolution.getScaledWidth() / 2 - 23;
        int n4 = scaledResolution.getScaledHeight() / 2 + 31;
        RenderUtils.a(itemStack, n3, n4);
        RenderUtils.c(String.valueOf(n2), n3 + 15, n4 - 8, er.e);
        super.a(f2);
    }
}

