/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 */
package i.gishreloaded.deadcode.commands;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.managers.XRayManager;
import i.gishreloaded.deadcode.utils.RandomUtils;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import i.gishreloaded.deadcode.xray.XRayData;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

public class CommandXRay
extends Command {
    public CommandXRay() {
        super("xray");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray[0].equalsIgnoreCase("add")) {
                if (stringArray[1].equalsIgnoreCase("mouse") && Wrapper.INSTANCE.getMinecraft().objectMouseOver != null) {
                    RayTraceResult rayTraceResult = Wrapper.INSTANCE.getMinecraft().objectMouseOver;
                    if (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
                        BlockPos blockPos = rayTraceResult.getBlockPos();
                        IBlockState iBlockState = Wrapper.INSTANCE.getWorld().getBlockState(blockPos);
                        int n2 = Block.getIdFromBlock((Block)iBlockState.getBlock());
                        int n3 = iBlockState.getBlock().getMetaFromState(iBlockState);
                        XRayData xRayData = new XRayData(n2, n3, RandomUtils.randomInt(0, 254), RandomUtils.randomInt(0, 254), RandomUtils.randomInt(0, 254));
                        XRayManager.b(xRayData);
                    }
                } else {
                    int n4;
                    int n5 = stringArray.length > 2 ? Integer.parseInt(stringArray[2]) : RandomUtils.randomInt(0, 254);
                    int n6 = stringArray.length > 3 ? Integer.parseInt(stringArray[3]) : RandomUtils.randomInt(0, 254);
                    int n7 = n4 = stringArray.length > 4 ? Integer.parseInt(stringArray[4]) : RandomUtils.randomInt(0, 254);
                    if (stringArray[1].contains(":")) {
                        String[] stringArray2 = stringArray[1].split(":");
                        XRayManager.a(new XRayData(Integer.parseInt(stringArray2[0]), Integer.parseInt(stringArray2[1]), n5, n6, n4));
                    } else {
                        XRayManager.a(new XRayData(Integer.parseInt(stringArray[1]), 0, n5, n6, n4));
                    }
                }
            } else if (stringArray[0].equalsIgnoreCase("remove")) {
                XRayManager.c(Integer.parseInt(stringArray[1]));
            } else if (stringArray[0].equalsIgnoreCase("clear")) {
                XRayManager.a();
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "XRay manager.";
    }

    @Override
    public String getSyntax() {
        return "xray add <id:meta> <red> <green> <blue> | add mouse | remove <id> | clear";
    }
}

