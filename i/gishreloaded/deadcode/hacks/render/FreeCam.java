/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiDownloadTerrain
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.world.World
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FreeCam
extends Hack {
    public BooleanValue a;
    public BooleanValue b;
    public BooleanValue c;
    public BooleanValue d;
    public static dv_0 e = null;

    public FreeCam(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        this.a = new BooleanValue("No clip", true);
        this.b = new BooleanValue("Disable on damage", false);
        this.c = new BooleanValue("Spawn ghost", true);
        this.d = new BooleanValue("Position fix", false);
        this.a(this.a, this.b, this.c, this.d);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows you to move the camera without moving your character.";
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiDownloadTerrain) {
            return true;
        }
        if (object instanceof SPacketPlayerPosLook) {
            if (((Boolean)this.d.getObjectValue()).booleanValue()) {
                SPacketPlayerPosLook sPacketPlayerPosLook = (SPacketPlayerPosLook)object;
                try {
                    Field field = SPacketPlayerPosLook.class.getDeclaredFields()[0];
                    field.setAccessible(true);
                    field.setDouble(sPacketPlayerPosLook, Wrapper.INSTANCE.getLocalPlayer().posX);
                    field = SPacketPlayerPosLook.class.getDeclaredFields()[1];
                    field.setAccessible(true);
                    field.setDouble(sPacketPlayerPosLook, Wrapper.INSTANCE.getLocalPlayer().posY);
                    field = SPacketPlayerPosLook.class.getDeclaredFields()[2];
                    field.setAccessible(true);
                    field.setDouble(sPacketPlayerPosLook, Wrapper.INSTANCE.getLocalPlayer().posZ);
                }
                catch (Exception exception) {}
            } else {
                return false;
            }
        }
        return !(object instanceof CPacketPlayer) && !(object instanceof CPacketPlayer.Position) && !(object instanceof CPacketPlayer.Rotation) && !(object instanceof CPacketPlayer.PositionRotation);
    }

    @Override
    public void a(float f2) {
        if (e == null) {
            return;
        }
        int n2 = 0;
        int n3 = 0;
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(scaledResolution.getScaledWidth() / 2 + n2), (float)(scaledResolution.getScaledHeight() / 2 + n3), (float)0.0f);
        int n4 = (int)(-(FreeCam.e.posY - Wrapper.INSTANCE.getLocalPlayer().posY));
        String string = "VClip: " + n4;
        RenderUtils.a(string, 0 - Wrapper.INSTANCE.getFontRenderer().getStringWidth(string) - 4, 2, er.d, er.e);
        GlStateManager.popMatrix();
        super.a(f2);
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (et.h()) {
            this.c(false);
            this.onDisable();
        }
        if (!((Boolean)this.b.getObjectValue()).booleanValue()) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (entityPlayerSP.hurtTime == entityPlayerSP.maxHurtTime - 1) {
            this.c(false);
            this.onDisable();
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onUpdateEvent(LivingEvent.LivingUpdateEvent livingUpdateEvent) {
        if (!((Boolean)this.a.getObjectValue()).booleanValue()) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        entityPlayerSP.noClip = true;
        entityPlayerSP.onGround = false;
        entityPlayerSP.capabilities.setFlySpeed(0.105f);
        entityPlayerSP.capabilities.isFlying = true;
        super.onUpdateEvent(livingUpdateEvent);
    }

    @Override
    public void onEnable() {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (((Boolean)this.c.getObjectValue()).booleanValue() && entityPlayerSP != null && Wrapper.INSTANCE.getWorld() != null) {
            e = new dv_0((World)Wrapper.INSTANCE.getWorld(), entityPlayerSP.getGameProfile());
            e.setPosition(cs.a.d(), cs.a.e(), cs.a.f());
            FreeCam.e.inventory = cs.a.a();
            FreeCam.e.rotationPitch = entityPlayerSP.rotationPitch;
            FreeCam.e.rotationYaw = entityPlayerSP.rotationYaw;
            FreeCam.e.rotationYawHead = entityPlayerSP.rotationYawHead;
            for (PotionEffect potionEffect : entityPlayerSP.getActivePotionEffects()) {
                e.addPotionEffect(potionEffect);
            }
            Wrapper.INSTANCE.getWorld().spawnEntity((Entity)e);
        }
        super.onEnable();
    }

    @Override
    public void onDisable() {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (e != null && Wrapper.INSTANCE.getWorld() != null) {
            entityPlayerSP.setPosition(FreeCam.e.posX, FreeCam.e.posY, FreeCam.e.posZ);
            entityPlayerSP.rotationPitch = FreeCam.e.rotationPitch;
            entityPlayerSP.rotationYaw = FreeCam.e.rotationYaw;
            entityPlayerSP.rotationYawHead = FreeCam.e.rotationYawHead;
            Wrapper.INSTANCE.getWorld().removeEntity((Entity)e);
            e = null;
        }
        Wrapper.INSTANCE.getMinecraft().renderGlobal.loadRenderers();
        entityPlayerSP.capabilities.isFlying = false;
        super.onDisable();
    }
}

