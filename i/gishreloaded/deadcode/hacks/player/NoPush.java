/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.player;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoPush
extends Hack {
    public BooleanValue a = new BooleanValue("Liquids", true);

    public NoPush(String string) {
        super(string, HackCategory.Player);
        this.b("General");
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "You are not pushed by liquid blocks and entitys.";
    }

    @Override
    public void onDisable() {
        Wrapper.INSTANCE.getLocalPlayer().entityCollisionReduction = 0.0f;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        Wrapper.INSTANCE.getLocalPlayer().entityCollisionReduction = 1.0f;
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onPushOutOfBlocksEvent(PlayerSPPushOutOfBlocksEvent playerSPPushOutOfBlocksEvent) {
        playerSPPushOutOfBlocksEvent.setCanceled(true);
        super.onPushOutOfBlocksEvent(playerSPPushOutOfBlocksEvent);
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        if (!((Boolean)this.a.getObjectValue()).booleanValue()) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if ((entityPlayerSP.isInWater() || entityPlayerSP.isInLava()) && !HackManager.getHack("Jesus").isToggled() && !HackManager.getHack("WaterSpeed").isToggled()) {
            if (dV.a()) {
                if (entityPlayerSP.onGround) {
                    entityPlayerSP.motionY = 0.02381440030250553;
                }
                double d2 = 0.0783702;
                dV.a(dV.b(entityPlayerSP.rotationYaw), d2);
            } else {
                entityPlayerSP.motionX = 0.0;
                entityPlayerSP.motionZ = 0.0;
            }
        }
        super.onInputEvent(inputUpdateEvent);
    }
}

