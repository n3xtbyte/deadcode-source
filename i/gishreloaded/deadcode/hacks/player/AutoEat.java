/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockContainer
 *  net.minecraft.block.BlockWorkbench
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.player;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoEat
extends Hack {
    public int a;
    public int b;

    public AutoEat(String string) {
        super(string, HackCategory.Player);
    }

    @Override
    public String getDescription() {
        return "Eat food automatically.";
    }

    @Override
    public void onEnable() {
        this.a = -1;
        this.b = -1;
        super.onEnable();
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (this.a == -1) {
            if (!this.b()) {
                return;
            }
            float f2 = 0.0f;
            for (int i2 = 0; i2 < 9; ++i2) {
                ItemFood itemFood;
                float f3;
                ItemStack itemStack = cs.a.a().getStackInSlot(i2);
                if (!this.a(itemStack) || !((f3 = (itemFood = (ItemFood)itemStack.getItem()).getSaturationModifier(itemStack)) > f2)) continue;
                f2 = f3;
                this.b = i2;
            }
            if (this.b != -1) {
                this.a = cs.a.a().currentItem;
            }
        } else {
            if (!this.b()) {
                this.c();
                return;
            }
            if (!this.a(cs.a.a().getStackInSlot(this.b))) {
                this.c();
                return;
            }
            cs.a.a().currentItem = this.b;
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindUseItem.getKeyCode(), (boolean)true);
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    public boolean b() {
        if (!Wrapper.INSTANCE.getLocalPlayer().canEat(false)) {
            return false;
        }
        if (Wrapper.INSTANCE.getMinecraft().objectMouseOver != null) {
            Block block;
            Entity entity = Wrapper.INSTANCE.getMinecraft().objectMouseOver.entityHit;
            if (entity instanceof EntityVillager || entity instanceof EntityTameable) {
                return false;
            }
            BlockPos blockPos = Wrapper.INSTANCE.getMinecraft().objectMouseOver.getBlockPos();
            if (blockPos != null && ((block = eS.b(blockPos)) instanceof BlockContainer || block instanceof BlockWorkbench)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(ItemStack itemStack) {
        return !et.a(itemStack) && itemStack.getItem() instanceof ItemFood;
    }

    public void c() {
        KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindUseItem.getKeyCode(), (boolean)false);
        cs.a.a().currentItem = this.a;
        this.a = -1;
    }
}

