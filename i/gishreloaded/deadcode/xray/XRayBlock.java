/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 */
package i.gishreloaded.deadcode.xray;

import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class XRayBlock {
    public BlockPos blockPos;
    public EnumFacing facing;

    public XRayBlock(BlockPos blockPos, EnumFacing enumFacing) {
        this.blockPos = blockPos;
        this.facing = enumFacing;
    }

    public static XRayBlock getXrayData(BlockPos blockPos) {
        if (Wrapper.INSTANCE.getWorld().getBlockState(blockPos.add(0, -1, 0)).getBlock() != Blocks.AIR) {
            return new XRayBlock(blockPos.add(0, -1, 0), EnumFacing.UP);
        }
        if (Wrapper.INSTANCE.getWorld().getBlockState(blockPos.add(-1, 0, 0)).getBlock() != Blocks.AIR) {
            return new XRayBlock(blockPos.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (Wrapper.INSTANCE.getWorld().getBlockState(blockPos.add(1, 0, 0)).getBlock() != Blocks.AIR) {
            return new XRayBlock(blockPos.add(1, 0, 0), EnumFacing.WEST);
        }
        if (Wrapper.INSTANCE.getWorld().getBlockState(blockPos.add(0, 0, -1)).getBlock() != Blocks.AIR) {
            return new XRayBlock(blockPos.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (Wrapper.INSTANCE.getWorld().getBlockState(blockPos.add(0, 0, 1)).getBlock() != Blocks.AIR) {
            return new XRayBlock(blockPos.add(0, 0, 1), EnumFacing.NORTH);
        }
        return null;
    }
}

