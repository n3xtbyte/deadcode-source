/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

public class NoClip
extends Hack {
    public ModeValue a;
    public BooleanValue b;
    public DoubleValue c;

    public NoClip(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("SunRise"));
        this.b = new BooleanValue("No walls", false);
        this.c = new DoubleValue("Speed", 0.2, 0.01, 1.0);
        this.a(this.a, this.b, this.c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows you to pass through walls.";
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        if (!this.a.getModeByIndex(1).isToggled()) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (!entityPlayerSP.onGround || !entityPlayerSP.collidedHorizontally || eS.a((EntityLivingBase)entityPlayerSP, null) && !entityPlayerSP.isSneaking()) {
            return;
        }
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position(entityPlayerSP.posX, entityPlayerSP.posY, entityPlayerSP.posZ, true));
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position(0.5, 0.0, 0.5, true));
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position(entityPlayerSP.posX, entityPlayerSP.posY, entityPlayerSP.posZ, true));
        double d2 = Math.toRadians(entityPlayerSP.rotationYaw);
        double d3 = -Math.sin(d2) * 0.04;
        double d4 = Math.cos(d2) * 0.04;
        entityPlayerSP.setPosition(entityPlayerSP.posX + d3, entityPlayerSP.posY, entityPlayerSP.posZ + d4);
        super.onInputEvent(inputUpdateEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        boolean bl = true;
        if (((Boolean)this.b.getObjectValue()).booleanValue() && this.a.getModeByIndex(0).isToggled() && bw2 == bw.b && object instanceof CPacketPlayer) {
            bl = false;
        }
        return bl;
    }

    @Override
    public void onDisable() {
        Wrapper.INSTANCE.getLocalPlayer().noClip = false;
        if (((Boolean)this.b.getObjectValue()).booleanValue() && this.a.getModeByIndex(0).isToggled()) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.PositionRotation(cs.a.d(), Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox().minY, cs.a.f(), Wrapper.INSTANCE.getLocalPlayer().cameraYaw, Wrapper.INSTANCE.getLocalPlayer().cameraPitch, Wrapper.INSTANCE.getLocalPlayer().onGround));
        }
        super.onDisable();
    }

    @Override
    public void onUpdateEvent(LivingEvent.LivingUpdateEvent livingUpdateEvent) {
        if (!this.a.getModeByIndex(0).isToggled()) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        entityPlayerSP.noClip = true;
        entityPlayerSP.fallDistance = 0.0f;
        entityPlayerSP.onGround = true;
        entityPlayerSP.capabilities.isFlying = false;
        entityPlayerSP.motionX = 0.0;
        entityPlayerSP.motionY = 0.0;
        entityPlayerSP.motionZ = 0.0;
        float f2 = this.c.getValue().floatValue();
        float f3 = MathUtils.a((Entity)entityPlayerSP);
        if (Wrapper.INSTANCE.getGameSettings().keyBindForward.isKeyDown()) {
            entityPlayerSP.motionX -= (double)(MathHelper.sin((float)f3) * f2);
            entityPlayerSP.motionZ += (double)(MathHelper.cos((float)f3) * f2);
        }
        if (Wrapper.INSTANCE.getGameSettings().keyBindBack.isKeyDown()) {
            entityPlayerSP.motionX += (double)(MathHelper.sin((float)f3) * f2);
            entityPlayerSP.motionZ -= (double)(MathHelper.cos((float)f3) * f2);
        }
        if (Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown()) {
            entityPlayerSP.motionY += (double)f2;
        }
        if (Wrapper.INSTANCE.getGameSettings().keyBindSneak.isKeyDown()) {
            entityPlayerSP.motionY -= (double)f2;
        }
        super.onUpdateEvent(livingUpdateEvent);
    }
}

