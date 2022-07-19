/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public final class eS {
    public static IBlockState a(BlockPos blockPos) {
        return Wrapper.INSTANCE.getWorld().getBlockState(blockPos);
    }

    public static Block b(BlockPos blockPos) {
        return eS.a(blockPos).getBlock();
    }

    public static Material c(BlockPos blockPos) {
        return eS.a(blockPos).getMaterial();
    }

    public static boolean d(BlockPos blockPos) {
        return eS.b(blockPos).canCollideCheck(eS.a(blockPos), false);
    }

    public static float e(BlockPos blockPos) {
        return eS.a(blockPos).getPlayerRelativeBlockHardness((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), (World)Wrapper.INSTANCE.getWorld(), blockPos);
    }

    public static boolean a(BlockPos blockPos, Block block) {
        return eS.b(blockPos) == Blocks.AIR;
    }

    public static boolean a(BlockPos blockPos, Material material) {
        return eS.a(blockPos).getMaterial() == material;
    }

    public static Block a() {
        Block block = null;
        if (Wrapper.INSTANCE.getMinecraft().currentScreen == null && Wrapper.INSTANCE.getLocalPlayer().ticksExisted > 100) {
            for (int i2 = 0; i2 < Integer.MAX_VALUE; ++i2) {
                BlockPos blockPos = Wrapper.INSTANCE.getLocalPlayer().getPosition().down(i2);
                Block block2 = eS.b(blockPos);
                if (block2 == null || block2 == Blocks.AIR) continue;
                block = block2;
                break;
            }
        }
        return block;
    }

    public static BlockPos b() {
        BlockPos blockPos = null;
        if (Wrapper.INSTANCE.getMinecraft().currentScreen == null && Wrapper.INSTANCE.getLocalPlayer().ticksExisted > 100) {
            for (int i2 = 0; i2 < Integer.MAX_VALUE; ++i2) {
                BlockPos blockPos2 = Wrapper.INSTANCE.getLocalPlayer().getPosition().down(i2);
                Block block = eS.b(blockPos2);
                if (block == null || block == Blocks.AIR) continue;
                blockPos = blockPos2;
                break;
            }
        }
        return blockPos;
    }

    public static boolean f(BlockPos blockPos) {
        List<Material> list = Arrays.asList(Material.WATER, Material.LAVA);
        return list.contains(eS.c(blockPos));
    }

    public static boolean a(AxisAlignedBB axisAlignedBB, bt bt2) {
        for (int i2 = MathHelper.floor((double)Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox().minX); i2 < MathHelper.floor((double)Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox().maxX) + 1; ++i2) {
            for (int i3 = MathHelper.floor((double)Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox().minZ); i3 < MathHelper.floor((double)Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox().maxZ) + 1; ++i3) {
                Block block = eS.b(new BlockPos((double)i2, axisAlignedBB.minY, (double)i3));
                if (block == null || bt2.if(block)) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean b(AxisAlignedBB axisAlignedBB, bt bt2) {
        for (int i2 = MathHelper.floor((double)Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox().minX); i2 < MathHelper.floor((double)Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox().maxX) + 1; ++i2) {
            for (int i3 = MathHelper.floor((double)Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox().minZ); i3 < MathHelper.floor((double)Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox().maxZ) + 1; ++i3) {
                AxisAlignedBB axisAlignedBB2;
                BlockPos blockPos = new BlockPos((double)i2, axisAlignedBB.minY, (double)i3);
                Block block = eS.b(blockPos);
                if (block == null || !bt2.if(block) || (axisAlignedBB2 = block.getCollisionBoundingBox(eS.a(blockPos), (IBlockAccess)Wrapper.INSTANCE.getWorld(), blockPos)) == null || !Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox().intersects(axisAlignedBB2)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean a(EntityLivingBase entityLivingBase, Block block) {
        for (int i2 = MathHelper.floor((double)entityLivingBase.getEntityBoundingBox().minX); i2 < MathHelper.floor((double)entityLivingBase.getEntityBoundingBox().maxX) + 1; ++i2) {
            for (int i3 = MathHelper.floor((double)entityLivingBase.getEntityBoundingBox().minY); i3 < MathHelper.floor((double)entityLivingBase.getEntityBoundingBox().maxY) + 1; ++i3) {
                for (int i4 = MathHelper.floor((double)entityLivingBase.getEntityBoundingBox().minZ); i4 < MathHelper.floor((double)entityLivingBase.getEntityBoundingBox().maxZ) + 1; ++i4) {
                    BlockPos blockPos = new BlockPos(i2, i3, i4);
                    IBlockState iBlockState = eS.a(blockPos);
                    Block block2 = eS.b(blockPos);
                    if (!(block == null ? block2 != null && !(block2 instanceof BlockAir) && block2.getCollisionBoundingBox(eS.a(new BlockPos(i2, i3, i4)), (IBlockAccess)Wrapper.INSTANCE.getWorld(), new BlockPos(i2, i3, i4)) != null && entityLivingBase.isInsideOfMaterial(iBlockState.getMaterial()) : block2 != null && block2 == block)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(EntityLivingBase entityLivingBase) {
        return Wrapper.INSTANCE.getWorld().getCollisionBoxes((Entity)entityLivingBase, entityLivingBase.getEntityBoundingBox().offset(0.0, -0.5, 0.0).expand(0.001, 0.0, 0.001)).isEmpty() && entityLivingBase.onGround;
    }

    public static float g(BlockPos blockPos) {
        return eS.a((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ());
    }

    public static float a(double d2, double d3, double d4) {
        float f2 = (float)(cs.a.d() - d2);
        float f3 = (float)(cs.a.e() - d3);
        float f4 = (float)(cs.a.f() - d4);
        return eS.a(f2, f3, f4);
    }

    public static float a(float f2, float f3, float f4) {
        return MathHelper.sqrt((float)((f2 - 0.5f) * (f2 - 0.5f) + (f3 - 0.5f) * (f3 - 0.5f) + (f4 - 0.5f) * (f4 - 0.5f)));
    }

    public static float h(BlockPos blockPos) {
        float f2 = (float)(cs.a.d() - (double)blockPos.getX());
        float f3 = (float)(cs.a.f() - (double)blockPos.getZ());
        return MathHelper.sqrt((float)((f2 - 0.5f) * (f2 - 0.5f) + (f3 - 0.5f) * (f3 - 0.5f)));
    }

    public static boolean i(BlockPos blockPos) {
        int n2;
        EnumFacing enumFacing = null;
        EnumFacing[] enumFacingArray = EnumFacing.values();
        Vec3d vec3d = MathUtils.a();
        Vec3d vec3d2 = eS.a(blockPos).getBoundingBox((IBlockAccess)Wrapper.INSTANCE.getWorld(), blockPos).getCenter();
        Vec3d vec3d3 = new Vec3d((Vec3i)blockPos).add(vec3d2);
        Vec3d[] vec3dArray = new Vec3d[enumFacingArray.length];
        for (n2 = 0; n2 < enumFacingArray.length; ++n2) {
            Vec3i vec3i = enumFacingArray[n2].getDirectionVec();
            Vec3d vec3d4 = new Vec3d(vec3d2.x * (double)vec3i.getX(), vec3d2.y * (double)vec3i.getY(), vec3d2.z * (double)vec3i.getZ());
            vec3dArray[n2] = vec3d3.add(vec3d4);
        }
        for (n2 = 0; n2 < enumFacingArray.length; ++n2) {
            if (Wrapper.INSTANCE.getWorld().rayTraceBlocks(vec3d, vec3dArray[n2], false, true, false) != null) continue;
            enumFacing = enumFacingArray[n2];
            break;
        }
        if (enumFacing == null) {
            double d2 = vec3d.squareDistanceTo(vec3d3);
            for (int i2 = 0; i2 < enumFacingArray.length; ++i2) {
                if (vec3d.squareDistanceTo(vec3dArray[i2]) >= d2) continue;
                enumFacing = enumFacingArray[i2];
                break;
            }
        }
        if (enumFacing == null) {
            enumFacing = enumFacingArray[0];
        }
        float[] fArray = MathUtils.a(vec3dArray[enumFacing.ordinal()], false);
        ef.a(fArray[0], fArray[1]);
        if (!cs.a.b().onPlayerDamageBlock(blockPos, enumFacing)) {
            return false;
        }
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
        return true;
    }

    public static void a(Iterable iterable) {
        Vec3d vec3d = MathUtils.a();
        NetHandlerPlayClient netHandlerPlayClient = Wrapper.INSTANCE.getLocalPlayer().connection;
        block0: for (BlockPos blockPos : iterable) {
            Vec3d vec3d2 = new Vec3d((Vec3i)blockPos).add(0.5, 0.5, 0.5);
            double d2 = vec3d.squareDistanceTo(vec3d2);
            for (EnumFacing enumFacing : EnumFacing.values()) {
                Vec3d vec3d3 = vec3d2.add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
                if (vec3d.squareDistanceTo(vec3d3) >= d2) continue;
                netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, enumFacing));
                netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, enumFacing));
                continue block0;
            }
        }
    }

    public static Stream a(int n2, int n3, int n4) {
        if (et.a()) {
            return null;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        BlockPos blockPos = new BlockPos(entityPlayerSP.posX - (double)n2, entityPlayerSP.posY - (double)n3, entityPlayerSP.posZ - (double)n4);
        BlockPos blockPos2 = new BlockPos(entityPlayerSP.posX + (double)n2, entityPlayerSP.posY + (double)n3, entityPlayerSP.posZ + (double)n4);
        return StreamSupport.stream(BlockPos.getAllInBox((BlockPos)blockPos, (BlockPos)blockPos2).spliterator(), true);
    }
}

