/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockAir
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.event.InputUpdateEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.ReflectionUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.block.BlockAir;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.InputUpdateEvent;

public class Strafe
extends Hack {
    public ModeValue a;
    public BooleanValue b;
    public BooleanValue c;
    public DoubleValue d;

    public Strafe(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("Matrix"), new Mode("NCP"));
        this.b = new BooleanValue("AutoJump", true);
        this.c = new BooleanValue("UseTimer", true);
        this.d = new DoubleValue("Matrix speed", 0.25, 0.2, 0.3);
        this.a(this.a, this.b, this.c, this.d);
        this.b("Strafe");
    }

    @Override
    public String getDescription() {
        return "Allows you to freely move in mid air.";
    }

    @Override
    public void onEnable() {
        if (((Boolean)this.c.getObjectValue()).booleanValue()) {
            ReflectionUtils.setTimerSpeedF(1.0866f);
        }
        if (this.a.getModeByIndex(2).isToggled()) {
            this.c();
        }
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.b();
        super.onDisable();
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (this.a.getModeByIndex(0).isToggled() && object instanceof CPacketPlayer.Rotation && dV.a()) {
            return false;
        }
        return super.a(object, bw2);
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.a.getModeByIndex(0).isToggled()) {
            if (dV.a()) {
                if (entityPlayerSP.onGround) {
                    if (((Boolean)this.b.getObjectValue()).booleanValue()) {
                        entityPlayerSP.jump();
                    }
                    entityPlayerSP.motionX *= 1.01;
                    entityPlayerSP.motionZ *= 1.01;
                    ReflectionUtils.setSpeedInAir(0.0223f);
                }
                entityPlayerSP.motionY -= 9.9999E-4;
                dV.c();
            } else {
                entityPlayerSP.motionX = 0.0;
                entityPlayerSP.motionZ = 0.0;
            }
        } else if (this.a.getModeByIndex(1).isToggled()) {
            if (entityPlayerSP.collidedHorizontally || entityPlayerSP.isSneaking()) {
                return;
            }
            if (entityPlayerSP.onGround) {
                this.d();
            }
            if (dV.b() < 0.22f) {
                dV.a(dV.b() * 1.01f);
            }
            if (entityPlayerSP.onGround) {
                dV.a(dV.b() * 1.01f);
            }
        } else if (this.a.getModeByIndex(2).isToggled()) {
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
                this.c();
                return;
            }
            ReflectionUtils.setTimerSpeedF(1.1f);
            if (entityPlayerSP.onGround) {
                dV.c();
            }
            if (entityPlayerSP.motionY == -0.4448259643949201) {
                float f2 = 1.3f;
                float f3 = 1.3f;
                entityPlayerSP.motionX *= (double)f2;
                entityPlayerSP.motionZ *= (double)f3;
            }
        }
        super.onInputEvent(inputUpdateEvent);
    }

    public void b() {
        if (((Boolean)this.c.getObjectValue()).booleanValue()) {
            this.c();
        }
        ReflectionUtils.setSpeedInAir(0.02f);
    }

    public void c() {
        ReflectionUtils.setTimerSpeedD(1.0);
    }

    public void d() {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        entityPlayerSP.motionY = 0.42f;
        if (entityPlayerSP.isPotionActive(MobEffects.JUMP_BOOST)) {
            entityPlayerSP.motionY += (double)((float)(entityPlayerSP.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1f);
        }
        if (entityPlayerSP.isSprinting()) {
            float f2 = this.d.getValue().floatValue();
            float f3 = (float)MathUtils.a(true);
            entityPlayerSP.motionX -= (double)MathHelper.sin((float)f3) * (double)f2;
            entityPlayerSP.motionZ += (double)MathHelper.cos((float)f3) * (double)f2;
        }
        entityPlayerSP.isAirBorne = true;
    }
}

