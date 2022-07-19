/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Parkour
extends Hack {
    public Parkour(String string) {
        super(string, HackCategory.Movement);
    }

    @Override
    public String getDescription() {
        return "Jump when reaching a block's edge.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (eS.a((EntityLivingBase)Wrapper.INSTANCE.getLocalPlayer()) && !Wrapper.INSTANCE.getLocalPlayer().isSneaking()) {
            Wrapper.INSTANCE.getLocalPlayer().jump();
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

