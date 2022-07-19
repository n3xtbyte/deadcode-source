/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.RaytraceUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Spider
extends Hack {
    public ModeValue a;
    public BooleanValue b;

    public Spider(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("Matrix"), new Mode("SunRise"));
        this.b = new BooleanValue("SunRise horizont", false);
        this.a(this.a, this.b);
        this.b("Spider");
    }

    @Override
    public String getDescription() {
        return "Allows you to climb walls.";
    }

    @Override
    public void onDisable() {
        ef.j();
        super.onDisable();
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (!Wrapper.INSTANCE.getLocalPlayer().collidedHorizontally) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.a.getModeByIndex(0).isToggled()) {
            entityPlayerSP.motionY = 0.2;
            entityPlayerSP.isAirBorne = false;
        } else if (this.a.getModeByIndex(1).isToggled()) {
            if (entityPlayerSP.ticksExisted % 8 == 0) {
                entityPlayerSP.onGround = true;
                entityPlayerSP.isAirBorne = false;
            } else {
                entityPlayerSP.onGround = false;
            }
            entityPlayerSP.prevPosY -= 2.0E-232;
            if (entityPlayerSP.onGround) {
                et.i();
            }
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (!this.a.getModeByIndex(2).isToggled() || Wrapper.INSTANCE.getMinecraft().isSingleplayer() || ((Boolean)this.b.getObjectValue()).booleanValue() && !entityPlayerSP.collidedHorizontally) {
            return;
        }
        int n2 = -2;
        for (int i2 = 0; i2 <= 8; ++i2) {
            if (!(cs.a.a().getStackInSlot(i2).getItem() instanceof ItemBlock)) continue;
            n2 = i2;
        }
        if (n2 == -2) {
            return;
        }
        ef.a(entityPlayerSP.rotationYaw, -70.0f);
        if (entityPlayerSP.ticksExisted % 2 == 0) {
            RayTraceResult rayTraceResult = RaytraceUtils.a(RaytraceUtils.b(), ef.d(), ef.e());
            Vec3d vec3d = rayTraceResult.hitVec;
            BlockPos blockPos = rayTraceResult.getBlockPos();
            float f2 = (float)(vec3d.x - (double)blockPos.getX());
            float f3 = (float)(vec3d.y - (double)blockPos.getY());
            float f4 = (float)(vec3d.z - (double)blockPos.getZ());
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(n2));
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketEntityAction((Entity)entityPlayerSP, CPacketEntityAction.Action.START_SNEAKING));
            if (eS.b(new BlockPos((Entity)entityPlayerSP).add(0, 2, 0)) == Blocks.AIR) {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(blockPos, rayTraceResult.sideHit, EnumHand.MAIN_HAND, f2, f3, f4));
            } else {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, rayTraceResult.sideHit));
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, rayTraceResult.sideHit));
            }
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketEntityAction((Entity)entityPlayerSP, CPacketEntityAction.Action.STOP_SNEAKING));
            entityPlayerSP.onGround = true;
            if (!((Boolean)this.b.getObjectValue()).booleanValue()) {
                entityPlayerSP.collidedHorizontally = true;
            }
            entityPlayerSP.collidedVertically = true;
            entityPlayerSP.isAirBorne = true;
            entityPlayerSP.jump();
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(entityPlayerSP.inventory.currentItem));
        }
        super.onInputEvent(inputUpdateEvent);
    }
}

