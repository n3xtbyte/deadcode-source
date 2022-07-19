/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.util.math.BlockPos
 */
import i.gishreloaded.deadcode.hacks.render.XRay;
import i.gishreloaded.deadcode.managers.XRayManager;
import i.gishreloaded.deadcode.xray.XRayData;
import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;

public class cK
extends Thread {
    public final /* synthetic */ int a;
    public final /* synthetic */ XRay b;

    public cK(XRay xRay, int n2) {
        this.b = xRay;
        this.a = n2;
    }

    @Override
    public void run() {
        Stream stream = eS.a(this.a, this.a, this.a);
        if (stream == null) {
            return;
        }
        this.b.d.clear();
        stream.forEach(blockPos -> {
            IBlockState iBlockState = eS.a(blockPos);
            int n2 = Block.getIdFromBlock((Block)iBlockState.getBlock());
            int n3 = iBlockState.getBlock().getMetaFromState(iBlockState);
            for (XRayData xRayData : XRayManager.a) {
                if (n2 != xRayData.getId() || n3 != xRayData.getMeta()) continue;
                by by2 = new by((BlockPos)blockPos, xRayData);
                this.b.d.add(by2);
            }
        });
    }
}

