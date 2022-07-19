/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.MobEffects
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.init.MobEffects;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoSprint
extends Hack {
    public AutoSprint(String string) {
        super(string, HackCategory.Movement);
    }

    @Override
    public String getDescription() {
        return "Sprints automatically when you should be walking.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (this.b()) {
            Wrapper.INSTANCE.getLocalPlayer().setSprinting(dV.a());
        }
        super.onClientTickEvent(clientTickEvent);
    }

    public boolean b() {
        if (!Wrapper.INSTANCE.getLocalPlayer().onGround) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isSprinting()) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isOnLadder()) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isInWater()) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isInLava()) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isHandActive()) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().collidedHorizontally) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().moveForward < 0.8f) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isSneaking()) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().getFoodStats().getFoodLevel() < 6) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isRiding()) {
            return false;
        }
        return !Wrapper.INSTANCE.getLocalPlayer().isPotionActive(MobEffects.BLINDNESS);
    }
}

