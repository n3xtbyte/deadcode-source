/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class DeathCoords
extends Hack {
    public boolean a = false;

    public DeathCoords(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Shows your coords at death.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (!this.a && et.h()) {
            ChatUtils.info(String.format("You died: X: %s Y: %s Z: %s", RenderUtils.a(entityPlayerSP.posX, 1), RenderUtils.a(entityPlayerSP.posY, 1), RenderUtils.a(entityPlayerSP.posZ, 1)));
            this.a = true;
        }
        if (!et.h()) {
            this.a = false;
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

