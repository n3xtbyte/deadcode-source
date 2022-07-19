/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.world;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoInteract
extends Hack {
    public static boolean a;
    public static Block[] b;

    public NoInteract(String string) {
        super(string, HackCategory.World);
        b = new Block[]{Blocks.CHEST, Blocks.ANVIL, Blocks.ENDER_CHEST, Blocks.CRAFTING_TABLE, Blocks.FURNACE, Blocks.ENCHANTING_TABLE, Blocks.DROPPER, Blocks.DISPENSER, Blocks.NOTEBLOCK, Blocks.OAK_DOOR, Blocks.OAK_FENCE_GATE};
    }

    @Override
    public String getDescription() {
        return "Disable interact with blocks, entitys.";
    }

    @Override
    public void onDisable() {
        a = false;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        a = true;
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        CPacketUseEntity cPacketUseEntity;
        if (bw2 != bw.b) {
            return true;
        }
        if (object instanceof CPacketUseEntity && ((cPacketUseEntity = (CPacketUseEntity)object).getAction() == CPacketUseEntity.Action.INTERACT || cPacketUseEntity.getAction() == CPacketUseEntity.Action.INTERACT_AT)) {
            return false;
        }
        return super.a(object, bw2);
    }
}

