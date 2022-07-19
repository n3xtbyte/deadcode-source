/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockAir
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingJumpEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.exploit.Blackout;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.ReflectionUtils;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.block.BlockAir;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Speed
extends Hack {
    public ModeValue a;
    public BooleanValue b;
    public DoubleValue c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;
    public long h;
    public TimerUtils i;

    public Speed(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Matrix", true), new Mode("MatrixDisabler"), new Mode("MatrixTimer"), new Mode("SunRise"), new Mode("YPort"), new Mode("SunRiseDamage"), new Mode("Matrix2"), new Mode("Matrix3"), new Mode("SunRiseOneDamage"), new Mode("Matrix4"), new Mode("NewSunRiseDamage"), new Mode("MatrixElytraDisabler"), new Mode("Matrix5"), new Mode("Matrix6"));
        this.b = new BooleanValue("Auto jump", true);
        this.c = new DoubleValue("Speed", 0.7f, 0.1f, 1.0);
        this.a(this.a, this.b, this.c);
        this.b("Other");
        this.i = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Make you faster.";
    }

    @Override
    public void onDisable() {
        this.b();
        if (this.a.getModeByIndex(11).isToggled() || this.a.getModeByIndex(1).isToggled()) {
            Blackout.b();
        }
        this.e = false;
        this.f = 0;
        this.g = 0;
        if (this.a.getModeByIndex(12).isToggled()) {
            this.b();
        }
        super.onDisable();
    }

    @Override
    public void onEnable() {
        if (this.a.getModeByIndex(11).isToggled() || this.a.getModeByIndex(1).isToggled()) {
            Blackout.b();
        }
        this.e = false;
        this.f = 0;
        this.g = 0;
        super.onEnable();
    }

    public void b() {
        ReflectionUtils.setTimerSpeedD(1.0);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.a.getModeByIndex(5).isToggled()) {
            if (entityPlayerSP.hurtTime > 0) {
                this.e = true;
            }
            if (this.e && entityPlayerSP.onGround) {
                entityPlayerSP.setSprinting(true);
                if (entityPlayerSP.isSprinting()) {
                    KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
                    float f2 = MathUtils.a((Entity)entityPlayerSP);
                    entityPlayerSP.motionX = (double)(-MathHelper.sin((float)f2)) * 0.7;
                    entityPlayerSP.motionZ = (double)MathHelper.cos((float)f2) * 0.7;
                }
            }
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (!this.c()) {
            return;
        }
        if (this.a.getModeByIndex(4).isToggled()) {
            if (((Boolean)this.b.getObjectValue()).booleanValue() && entityPlayerSP.onGround) {
                entityPlayerSP.jump();
            } else {
                entityPlayerSP.motionY = -1.0;
            }
        } else if (this.a.getModeByIndex(6).isToggled()) {
            if (((Boolean)this.b.getObjectValue()).booleanValue()) {
                KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
            }
            entityPlayerSP.setSprinting(true);
            if (entityPlayerSP.onGround) {
                this.f = 0;
                if (((Boolean)this.b.getObjectValue()).booleanValue()) {
                    entityPlayerSP.jump();
                }
            } else {
                ++this.f;
            }
            if (this.f == 1) {
                entityPlayerSP.motionX *= 1.6;
                entityPlayerSP.motionZ *= 1.6;
            }
        } else if (this.a.getModeByIndex(7).isToggled()) {
            if (((Boolean)this.b.getObjectValue()).booleanValue()) {
                KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
            }
            ReflectionUtils.resetJumpTicks();
            if (entityPlayerSP.onGround) {
                dV.a(dV.b(entityPlayerSP.rotationYaw), dV.b());
                this.f = 0;
                if (((Boolean)this.b.getObjectValue()).booleanValue()) {
                    entityPlayerSP.jump();
                }
            } else {
                ++this.f;
            }
            if (!entityPlayerSP.onGround && (double)entityPlayerSP.fallDistance <= 0.1) {
                ReflectionUtils.setTimerSpeedD(1.1);
            }
            if (this.f == 1) {
                entityPlayerSP.motionX *= 1.5;
                entityPlayerSP.motionZ *= 1.5;
            }
            if ((double)entityPlayerSP.fallDistance > 0.1) {
                ReflectionUtils.setTimerSpeedD(0.95);
            }
        } else if (this.a.getModeByIndex(8).isToggled()) {
            if (entityPlayerSP.fallDistance > 0.0f) {
                this.g = 5 + (int)(entityPlayerSP.fallDistance * 10.0f);
            }
            if (this.g > 0) {
                --this.g;
            } else {
                entityPlayerSP.setSprinting(true);
                KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
                dV.a(entityPlayerSP.ticksExisted % 3 == 0 ? this.c.getValue().floatValue() : 0.5f);
            }
        } else if (this.a.getModeByIndex(9).isToggled()) {
            if (((Boolean)this.b.getObjectValue()).booleanValue()) {
                KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
                if (entityPlayerSP.onGround) {
                    entityPlayerSP.jump();
                }
            }
            if ((double)entityPlayerSP.fallDistance > 1.131) {
                entityPlayerSP.fallDistance = -250.0f;
            }
            if ((double)entityPlayerSP.fallDistance > 1.13) {
                entityPlayerSP.jumpMovementFactor = 0.31f;
            }
        } else if (this.a.getModeByIndex(10).isToggled()) {
            if (entityPlayerSP.onGround) {
                entityPlayerSP.addVelocity(-Math.sin(MathUtils.a((Entity)entityPlayerSP)) * 9.8 / 24.5, 0.0, Math.cos(MathUtils.a((Entity)entityPlayerSP)) * 9.8 / 24.5);
                dV.c();
            } else if (entityPlayerSP.isInWater()) {
                entityPlayerSP.addVelocity(-Math.sin(MathUtils.a((Entity)entityPlayerSP)) * 8.5 / 24.5, 0.0, Math.cos(MathUtils.a((Entity)entityPlayerSP)) * 9.5 / 24.5);
                dV.c();
            } else if (!entityPlayerSP.onGround) {
                entityPlayerSP.addVelocity(-Math.sin(MathUtils.a((Entity)entityPlayerSP)) * 0.11 / 24.5, 0.0, Math.cos(MathUtils.a((Entity)entityPlayerSP)) * 0.11 / 24.5);
                entityPlayerSP.setSprinting(true);
                dV.c();
            } else {
                entityPlayerSP.addVelocity(-Math.sin(MathUtils.a((Entity)entityPlayerSP)) * 0.005 * (double)dV.b(), 0.0, Math.cos(MathUtils.a((Entity)entityPlayerSP)) * 0.005 * (double)dV.b());
                dV.c();
            }
        } else if (this.a.getModeByIndex(11).isToggled()) {
            ItemStack itemStack = entityPlayerSP.inventory.armorItemInSlot(2);
            if (!et.a(itemStack) && itemStack.getItem() == Items.ELYTRA) {
                if (System.currentTimeMillis() - this.h > 1000L) {
                    Blackout.a(false);
                    this.h = System.currentTimeMillis();
                }
                float f2 = 0.2f;
                if (System.currentTimeMillis() - this.h < 800L && !entityPlayerSP.isSneaking()) {
                    f2 = 0.23f;
                }
                dV.a(dV.b() * 1.0f + f2);
            }
        } else if (this.a.getModeByIndex(12).isToggled()) {
            BlockPos blockPos = new BlockPos(entityPlayerSP.posX, entityPlayerSP.posY, entityPlayerSP.posZ);
            BlockPos blockPos2 = new BlockPos(blockPos.getX(), blockPos.getY() - 1, blockPos.getZ());
            if (eS.b(blockPos2) instanceof BlockAir) {
                return;
            }
            if (((Boolean)this.b.getObjectValue()).booleanValue()) {
                KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
                if (entityPlayerSP.onGround) {
                    entityPlayerSP.jump();
                }
            } else if (!Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown()) {
                this.b();
                return;
            }
            double d2 = entityPlayerSP.posX;
            double d3 = entityPlayerSP.posY;
            double d4 = entityPlayerSP.posZ;
            double d5 = (double)entityPlayerSP.rotationYaw * 0.017453292;
            ReflectionUtils.setTimerSpeedF(1.2f);
            float f3 = 2.0f;
            float f4 = 2.0f;
            if (entityPlayerSP.motionY == -0.4448259643949201) {
                entityPlayerSP.motionX *= (double)f3;
                entityPlayerSP.motionZ *= (double)f4;
                entityPlayerSP.setPosition(d2 - Math.sin(d5) * 0.007, d3, d4 + Math.cos(d5) * 0.007);
            }
        } else if (this.a.getModeByIndex(13).isToggled()) {
            if (((Boolean)this.b.getObjectValue()).booleanValue()) {
                KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
                if (entityPlayerSP.onGround) {
                    entityPlayerSP.jump();
                }
            } else if (!Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown()) {
                return;
            }
            double d6 = entityPlayerSP.posX;
            double d7 = entityPlayerSP.posY;
            double d8 = entityPlayerSP.posZ;
            double d9 = (double)entityPlayerSP.rotationYaw * 0.017453292;
            float f5 = 1.8f;
            float f6 = 1.8f;
            if (entityPlayerSP.motionY == -0.4448259643949201 && this.i.isReached(1000L)) {
                entityPlayerSP.motionX *= (double)f5;
                entityPlayerSP.motionZ *= (double)f6;
                entityPlayerSP.setPosition(d6 - Math.sin(d9) * 0.0038, d7, d8 + Math.cos(d9) * 0.0038);
                this.i.resetTime();
            }
        }
        super.onInputEvent(inputUpdateEvent);
    }

    @Override
    public void onJumpEvent(LivingEvent.LivingJumpEvent livingJumpEvent) {
        if (this.a.getModeByIndex(3).isToggled() && livingJumpEvent.getEntity() == Wrapper.INSTANCE.getLocalPlayer() && this.d) {
            Wrapper.INSTANCE.getLocalPlayer().motionY *= 4.2E-12;
        }
        super.onJumpEvent(livingJumpEvent);
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.a.getModeByIndex(0).isToggled() || this.a.getModeByIndex(2).isToggled()) {
            if (!this.c()) {
                return;
            }
            if (((Boolean)this.b.getObjectValue()).booleanValue()) {
                et.i();
                KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
            }
            if (entityPlayerSP.fallDistance > 0.8f) {
                entityPlayerSP.jumpMovementFactor *= 3.4f;
                if (this.a.getModeByIndex(2).isToggled()) {
                    ReflectionUtils.setTimerSpeedD(8.0);
                } else {
                    entityPlayerSP.motionY -= (double)0.4f;
                }
            } else {
                this.b();
            }
        } else if (this.a.getModeByIndex(1).isToggled()) {
            entityPlayerSP.setSprinting(false);
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
            if (dV.a()) {
                dV.a(1.4f);
            }
        } else if (this.a.getModeByIndex(3).isToggled() && this.c()) {
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)true);
            this.d = true;
        } else if (this.d) {
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
            this.d = false;
        }
        super.onClientTickEvent(clientTickEvent);
    }

    public boolean c() {
        return !Wrapper.INSTANCE.getLocalPlayer().isOnLadder() && !Wrapper.INSTANCE.getLocalPlayer().isInWater() && !Wrapper.INSTANCE.getLocalPlayer().isInLava() && dV.a();
    }
}

