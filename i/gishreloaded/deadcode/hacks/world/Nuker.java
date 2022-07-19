/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.lwjgl.input.Mouse
 */
package i.gishreloaded.deadcode.hacks.world;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

public class Nuker
extends Hack {
    public ModeValue a;
    public DoubleValue b;
    public final ArrayDeque c = new ArrayDeque();
    public BlockPos d;
    public float e;
    public float f;
    public int g;

    public Nuker(String string) {
        super(string, HackCategory.World);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("ID", true), new Mode("All"));
        this.b = new DoubleValue("Distance", 6.0, 0.1, 6.0);
        this.a(this.a, this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Automatically breaks blocks around you.";
    }

    @Override
    public void onDisable() {
        if (this.d != null) {
            f.a(true);
            cs.a.b().resetBlockRemoving();
            this.d = null;
        }
        ef.j();
        this.c.clear();
        this.g = 0;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        this.b();
        this.d = null;
        Vec3d vec3d = MathUtils.a().subtract(0.5, 0.5, 0.5);
        BlockPos blockPos2 = new BlockPos(MathUtils.a());
        double d2 = Math.pow(this.b.getValue(), 2.0);
        int n2 = (int)Math.ceil(this.b.getValue());
        Stream<Object> stream = StreamSupport.stream(BlockPos.getAllInBox((BlockPos)blockPos2.add(n2, n2, n2), (BlockPos)blockPos2.add(-n2, -n2, -n2)).spliterator(), true);
        stream = stream.filter(blockPos -> vec3d.squareDistanceTo(new Vec3d((Vec3i)blockPos)) <= d2).filter(blockPos -> eS.d(blockPos)).sorted(Comparator.comparingDouble(blockPos -> vec3d.squareDistanceTo(new Vec3d((Vec3i)blockPos))));
        if (this.a.getModeByIndex(0).isToggled()) {
            stream = stream.filter(blockPos -> Block.getIdFromBlock((Block)eS.b(blockPos)) == this.g);
        } else if (this.a.getModeByIndex(1).isToggled()) {
            // empty if block
        }
        List list = stream.collect(Collectors.toList());
        if (Wrapper.INSTANCE.getLocalPlayer().capabilities.isCreativeMode) {
            Stream<Object> stream2 = list.parallelStream();
            for (Set set : this.c) {
                stream2 = stream2.filter(blockPos -> !set.contains(blockPos));
            }
            List list2 = stream2.collect(Collectors.toList());
            this.c.addLast(new HashSet(list2));
            while (this.c.size() > 5) {
                this.c.removeFirst();
            }
            if (!list2.isEmpty()) {
                this.d = (BlockPos)list2.get(0);
            }
            cs.a.b().resetBlockRemoving();
            this.e = 1.0f;
            this.f = 1.0f;
            eS.a(list2);
            return;
        }
        for (BlockPos blockPos3 : list) {
            if (!eS.i(blockPos3)) continue;
            this.d = blockPos3;
            break;
        }
        if (this.d == null) {
            cs.a.b().resetBlockRemoving();
        }
        if (this.d != null && eS.e(this.d) < 1.0f) {
            Object object = MathUtils.a(this.d);
            ef.a((float[])object);
            Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
            this.f = this.e;
        }
        this.e = f.a();
        if (this.e < this.f) {
            this.f = this.e;
        } else {
            this.e = 1.0f;
            this.f = 1.0f;
        }
        super.onClientTickEvent(clientTickEvent);
    }

    public void b() {
        IBlockState iBlockState;
        RayTraceResult rayTraceResult = Wrapper.INSTANCE.getMinecraft().objectMouseOver;
        if (rayTraceResult == null) {
            return;
        }
        if (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && Mouse.isButtonDown((int)0) && Wrapper.INSTANCE.getMinecraft().currentScreen == null && !((iBlockState = eS.a(rayTraceResult.getBlockPos())).getBlock() instanceof BlockAir)) {
            this.g = Block.getIdFromBlock((Block)iBlockState.getBlock());
        }
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        if (this.d == null) {
            return;
        }
        if (this.a.getMode("All").isToggled()) {
            RenderUtils.a(this.d, 1.0f, 0.0f, 0.0f);
        } else if (this.a.getMode("ID").isToggled()) {
            RenderUtils.a(this.d, 0.0f, 0.0f, 1.0f);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

