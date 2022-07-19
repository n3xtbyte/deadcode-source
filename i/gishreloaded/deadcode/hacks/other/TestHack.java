/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TestHack
extends Hack {
    public TimerUtils a = new TimerUtils();

    public TestHack(String string) {
        super(string, HackCategory.Other);
    }

    @Override
    public String getDescription() {
        return "I do not recommend enabling this!";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        super.onInputEvent(inputUpdateEvent);
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void a(float f2) {
        super.a(f2);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (object instanceof CPacketClickWindow) {
            CPacketClickWindow cPacketClickWindow = (CPacketClickWindow)object;
            String string = String.format("Item: %s WindId: %s Slot: %s Button: %s Type: %s", cPacketClickWindow.getClickedItem().getItem().getTranslationKey(), cPacketClickWindow.getWindowId(), cPacketClickWindow.getSlotId(), cPacketClickWindow.getUsedButton(), cPacketClickWindow.getClickType().name());
            ChatUtils.debug(string);
        }
        return super.a(object, bw2);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        super.onPlayerTickEvent(playerTickEvent);
    }
}

