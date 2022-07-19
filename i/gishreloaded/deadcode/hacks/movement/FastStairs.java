/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.client.event.InputUpdateEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.InputUpdateEvent;

public class FastStairs
extends Hack {
    public FastStairs(String string) {
        super(string, HackCategory.Movement);
    }

    @Override
    public String getDescription() {
        return "Make you faster on stairs.";
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        double d2 = entityPlayerSP.posX;
        double d3 = entityPlayerSP.posY;
        double d4 = entityPlayerSP.posZ;
        double d5 = MathUtils.a((Entity)entityPlayerSP);
        float f2 = entityPlayerSP.onGround ? 0.5f : 1000.0f;
        Block block = eS.b(new BlockPos(d2, d3 - (double)f2, d4));
        Block block2 = eS.b(new BlockPos(d2 - Math.sin(d5) * (double)f2, d3, d4 + Math.cos(d5) * (double)f2));
        if (!(block != Blocks.STONE_STAIRS && block != Blocks.OAK_STAIRS && block != Blocks.NETHER_BRICK_STAIRS && block != Blocks.SANDSTONE_STAIRS && block != Blocks.QUARTZ_STAIRS && block != Blocks.ACACIA_STAIRS && block != Blocks.DARK_OAK_STAIRS && block != Blocks.PURPUR_STAIRS && block != Blocks.RED_SANDSTONE_STAIRS && block != Blocks.JUNGLE_STAIRS && block != Blocks.BIRCH_STAIRS && block != Blocks.STONE_BRICK_STAIRS && block != Blocks.BRICK_STAIRS && block != Blocks.SPRUCE_STAIRS || block2 != Blocks.STONE_STAIRS && block2 != Blocks.OAK_STAIRS && block2 != Blocks.NETHER_BRICK_STAIRS && block2 != Blocks.SANDSTONE_STAIRS && block2 != Blocks.QUARTZ_STAIRS && block2 != Blocks.ACACIA_STAIRS && block2 != Blocks.DARK_OAK_STAIRS && block2 != Blocks.PURPUR_STAIRS && block2 != Blocks.RED_SANDSTONE_STAIRS && block2 != Blocks.JUNGLE_STAIRS && block2 != Blocks.BIRCH_STAIRS && block2 != Blocks.STONE_BRICK_STAIRS && block2 != Blocks.BRICK_STAIRS && block2 != Blocks.SPRUCE_STAIRS)) {
            if (entityPlayerSP.onGround) {
                entityPlayerSP.jump();
            }
            entityPlayerSP.jumpMovementFactor = 0.0f;
            entityPlayerSP.motionY = -0.42;
        }
        super.onInputEvent(inputUpdateEvent);
    }
}

