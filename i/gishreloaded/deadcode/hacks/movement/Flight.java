/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.exploit.Blackout;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Flight
extends Hack {
    public static ModeValue a;
    public BooleanValue b;
    public DoubleValue c;
    public long d;
    public long e;
    public double f;
    public double g;

    public Flight(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        a = new ModeValue("Mode", new Mode("Default", true), new Mode("Dynamic"), new Mode("Matrix"), new Mode("MatrixDisabler"), new Mode("Elytra"), new Mode("Boat"), new Mode("SunRiseBlocks"), new Mode("ReallyWorld"), new Mode("NewMatrix"), new Mode("NexusBoat"), new Mode("MatrixElytra"));
        this.b = new BooleanValue("Auto jump", false);
        this.c = new DoubleValue("Fly speed", 1.0, 0.1, 8.0);
        this.a(a, this.b, this.c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows you to you fly.";
    }

    @Override
    public void onEnable() {
        if (a.getModeByIndex(4).isToggled()) {
            Blackout.b();
        }
        super.onEnable();
    }

    @Override
    public void onDisable() {
        if (a.getModeByIndex(0).isToggled()) {
            Wrapper.INSTANCE.getLocalPlayer().capabilities.isFlying = false;
        } else if (a.getModeByIndex(4).isToggled()) {
            Blackout.b();
        } else if (a.getModeByIndex(9).isToggled()) {
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindUseItem.getKeyCode(), (boolean)false);
        } else if (a.getModeByIndex(10).isToggled()) {
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindForward.getKeyCode(), (boolean)false);
        }
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (a.getModeByIndex(3).isToggled()) {
            if (Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown()) {
                if (!Blackout.a) {
                    ChatUtils.info("Only works with Blackout hack.");
                    this.c(false);
                    return;
                }
                entityPlayerSP.motionY = 0.3;
                entityPlayerSP.jumpMovementFactor *= this.c.getValue().floatValue();
                entityPlayerSP.setSprinting(false);
            }
        } else if (a.getModeByIndex(4).isToggled() && Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown()) {
            entityPlayerSP.motionY = 1.3;
            entityPlayerSP.jumpMovementFactor = (float)((double)entityPlayerSP.jumpMovementFactor * 3.4);
            entityPlayerSP.setSprinting(false);
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (a.getModeByIndex(0).isToggled()) {
            if (!this.b()) {
                return;
            }
            entityPlayerSP.capabilities.isFlying = true;
        } else if (a.getModeByIndex(6).isToggled()) {
            ItemStack itemStack;
            if (bB.a() && Wrapper.INSTANCE.getMinecraft().currentScreen == null && !et.a(itemStack = entityPlayerSP.getHeldItemMainhand()) && itemStack.getItem() instanceof ItemBlock) {
                boolean bl = Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown();
                boolean bl2 = Wrapper.INSTANCE.getGameSettings().keyBindForward.isKeyDown();
                if ((bl || bl2) && entityPlayerSP.ticksExisted % 2 == 0) {
                    Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.DROP_ITEM, BlockPos.ORIGIN, EnumFacing.NORTH));
                }
                if (bl) {
                    entityPlayerSP.jump();
                }
                if (bl2) {
                    float f2 = MathUtils.a((Entity)entityPlayerSP);
                    entityPlayerSP.motionX = -MathHelper.sin((float)f2) * 0.4f;
                    entityPlayerSP.motionZ = MathHelper.cos((float)f2) * 0.4f;
                }
            }
        } else if (a.getModeByIndex(1).isToggled()) {
            if (!this.b()) {
                return;
            }
            float f3 = this.c.getValue().floatValue();
            entityPlayerSP.jumpMovementFactor = 0.4f;
            entityPlayerSP.motionX = 0.0;
            entityPlayerSP.motionY = 0.0;
            entityPlayerSP.motionZ = 0.0;
            entityPlayerSP.jumpMovementFactor *= f3 * 3.0f;
            if (Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown()) {
                entityPlayerSP.motionY += (double)f3;
            }
            if (Wrapper.INSTANCE.getGameSettings().keyBindSneak.isKeyDown()) {
                entityPlayerSP.motionY -= (double)f3;
            }
        } else if (a.getModeByIndex(2).isToggled()) {
            if (!this.b() || !Wrapper.INSTANCE.getGameSettings().keyBindForward.isKeyDown()) {
                return;
            }
            float f4 = MathUtils.a((Entity)entityPlayerSP);
            entityPlayerSP.motionX = (double)(-MathHelper.sin((float)f4)) * this.c.getValue();
            entityPlayerSP.motionZ = (double)MathHelper.cos((float)f4) * this.c.getValue();
            entityPlayerSP.motionY = -0.02;
            entityPlayerSP.onGround = false;
        } else if (a.getModeByIndex(5).isToggled() && entityPlayerSP.isRiding() && entityPlayerSP.getRidingEntity() instanceof EntityBoat && Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown()) {
            entityPlayerSP.getRidingEntity().motionY = 0.5;
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (a.getModeByIndex(7).isToggled()) {
            if (!Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown()) {
                return;
            }
            if (entityPlayerSP.ticksExisted % 3 == 0) {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketEntityAction((Entity)entityPlayerSP, CPacketEntityAction.Action.START_FALL_FLYING));
            }
            entityPlayerSP.onGround = true;
        } else if (a.getModeByIndex(8).isToggled()) {
            if (System.currentTimeMillis() - this.e < 1200L) {
                double d2 = Math.hypot(entityPlayerSP.motionX, entityPlayerSP.motionZ) + this.f - 0.2;
                dV.a((float)d2);
                entityPlayerSP.motionY = this.g;
            }
        } else if (a.getModeByIndex(9).isToggled()) {
            boolean bl;
            Entity entity = entityPlayerSP.getRidingEntity();
            boolean bl2 = bl = entityPlayerSP.isRiding() && entity instanceof EntityBoat;
            if (bl) {
                float f2 = 0.8f;
                float f3 = MathUtils.a(entity);
                entity.motionY = f2;
                entity.motionX = -MathHelper.sin((float)f3) * f2;
                entity.motionZ = MathHelper.cos((float)f3) * f2;
            } else {
                EntityBoat entityBoat = null;
                for (Entity entity2 : et.b()) {
                    if (!(entity2 instanceof EntityBoat) || !(entityPlayerSP.getDistance(entity2) < 4.0f)) continue;
                    entityBoat = (EntityBoat)entity2;
                }
                if (entityBoat != null) {
                    Object object = MathUtils.a(entityBoat, cy_0.b);
                    entityPlayerSP.rotationYaw = (float)object[0];
                    entityPlayerSP.rotationPitch = (float)object[1];
                    KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindUseItem.getKeyCode(), (boolean)true);
                }
            }
        } else if (a.getModeByIndex(10).isToggled()) {
            if (System.currentTimeMillis() - this.d > 1000L) {
                Blackout.a(true);
                this.d = System.currentTimeMillis();
            }
            double d3 = -0.2;
            if (System.currentTimeMillis() - this.d < 800L && !entityPlayerSP.isSneaking()) {
                d3 = 0.15;
            }
            entityPlayerSP.jump();
            entityPlayerSP.motionY = d3;
            entityPlayerSP.setSprinting(true);
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindForward.getKeyCode(), (boolean)true);
        }
        super.onInputEvent(inputUpdateEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        SPacketEntityVelocity sPacketEntityVelocity;
        if (a.getModeByIndex(8).isToggled() && object instanceof SPacketEntityVelocity && (sPacketEntityVelocity = (SPacketEntityVelocity)object).getEntityID() == Wrapper.INSTANCE.getLocalPlayer().getEntityId()) {
            double d2 = Math.abs((double)sPacketEntityVelocity.getMotionX() / 8000.0);
            double d3 = Math.abs((double)sPacketEntityVelocity.getMotionY() / 8000.0);
            double d4 = Math.abs((double)sPacketEntityVelocity.getMotionZ() / 8000.0);
            this.f = d2 + d4;
            if (this.f > 0.3) {
                this.e = System.currentTimeMillis();
                this.g = d3;
            } else {
                this.f = 0.0;
            }
        }
        return super.a(object, bw2);
    }

    public boolean b() {
        boolean bl = true;
        if (((Boolean)this.b.getObjectValue()).booleanValue()) {
            bl = false;
            et.i();
            if (!Wrapper.INSTANCE.getLocalPlayer().onGround && Wrapper.INSTANCE.getLocalPlayer().fallDistance != 0.0f) {
                bl = true;
            }
        }
        return bl;
    }
}

