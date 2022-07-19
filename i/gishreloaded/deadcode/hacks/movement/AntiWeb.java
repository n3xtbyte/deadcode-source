/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Blocks
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  org.apache.commons.lang3.RandomUtils
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.managers.MappingManager;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.commons.lang3.RandomUtils;

public class AntiWeb
extends Hack {
    public ModeValue a;

    public AntiWeb(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("Matrix"));
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Does not change walking speed in web.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        try {
            Field field = Entity.class.getDeclaredField(MappingManager.fieldIsInWeb);
            field.setAccessible(true);
            field.setBoolean(Wrapper.INSTANCE.getLocalPlayer(), false);
        }
        catch (Exception exception) {
            this.c(false);
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        float f2;
        if (!this.a.getModeByIndex(1).isToggled()) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (!eS.a((EntityLivingBase)entityPlayerSP, Blocks.WEB) || !dV.a()) {
            return;
        }
        this.a(false);
        entityPlayerSP.setSprinting(false);
        float f3 = entityPlayerSP.moveForward > 0.0f ? 1.0f : (f2 = entityPlayerSP.moveForward < 0.0f ? -1.0f : 0.0f);
        float f4 = entityPlayerSP.moveStrafing > 0.0f ? 1.0f : (entityPlayerSP.moveStrafing < 0.0f ? -1.0f : 0.0f);
        float f5 = entityPlayerSP.rotationYaw;
        float f6 = 90.0f * f4;
        float f7 = f5 - (f6 *= f2 != 0.0f ? f2 * 0.5f : 1.0f);
        f7 -= (float)(f2 < 0.0f ? 180 : 0);
        f7 = (float)Math.toRadians(f7);
        float f8 = Wrapper.INSTANCE.getGameSettings().mouseSensitivity;
        float f9 = f8 * 0.6f + 0.2f;
        float f10 = f9 * f9 * f9 * 1.2f;
        f7 -= f7 % f10;
        double d2 = 1.0E-5 - (double)RandomUtils.nextFloat((float)1.0E-5f, (float)5.0E-5f);
        double d3 = -Math.sin(f7) * d2;
        double d4 = Math.cos(f7) * d2;
        entityPlayerSP.motionX = d3;
        entityPlayerSP.motionZ = d4;
        super.onPlayerTickEvent(playerTickEvent);
    }

    public void a(boolean bl) {
        KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)bl);
        KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindSneak.getKeyCode(), (boolean)bl);
    }
}

