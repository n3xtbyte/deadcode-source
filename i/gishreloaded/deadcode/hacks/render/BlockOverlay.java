/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class BlockOverlay
extends Hack {
    public BlockOverlay(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Show of selected block.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        if (Wrapper.INSTANCE.getMinecraft().objectMouseOver == null) {
            return;
        }
        if (Wrapper.INSTANCE.getMinecraft().objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
            Block block = eS.b(Wrapper.INSTANCE.getMinecraft().objectMouseOver.getBlockPos());
            BlockPos blockPos = Wrapper.INSTANCE.getMinecraft().objectMouseOver.getBlockPos();
            if (Block.getIdFromBlock((Block)block) == 0) {
                return;
            }
            RenderUtils.a(blockPos, 1.0f, 1.0f, 1.0f);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

