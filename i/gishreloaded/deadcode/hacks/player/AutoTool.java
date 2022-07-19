/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.player;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.combat.KillAura;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.block.BlockAir;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoTool
extends Hack {
    public int a = -2;

    public AutoTool(String string) {
        super(string, HackCategory.Player);
    }

    @Override
    public String getDescription() {
        return "Automatically selects the best tool.";
    }

    @Override
    public void onEnable() {
        this.a = -2;
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (!Wrapper.INSTANCE.getGameSettings().keyBindAttack.isKeyDown() || KillAura.J != null) {
            if (this.a != -2) {
                entityPlayerSP.inventory.currentItem = this.a;
                this.a = -2;
            }
            return;
        }
        RayTraceResult rayTraceResult = Wrapper.INSTANCE.getMinecraft().objectMouseOver;
        if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) {
            return;
        }
        IBlockState iBlockState = eS.a(rayTraceResult.getBlockPos());
        if (iBlockState.getBlock() instanceof BlockAir) {
            return;
        }
        float f2 = 1.0f;
        int n2 = -2;
        if (this.a == -2) {
            this.a = entityPlayerSP.inventory.currentItem;
        }
        for (int i2 = 0; i2 < 9; ++i2) {
            float f3;
            ItemStack itemStack = entityPlayerSP.inventory.getStackInSlot(i2);
            if (et.a(itemStack) || !((f3 = itemStack.getDestroySpeed(iBlockState)) > f2)) continue;
            f2 = f3;
            n2 = i2;
        }
        if (n2 != -2) {
            entityPlayerSP.inventory.currentItem = n2;
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

