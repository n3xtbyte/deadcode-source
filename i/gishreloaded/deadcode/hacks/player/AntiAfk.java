/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.player;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.RandomUtils;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AntiAfk
extends Hack {
    public ModeValue mode;
    public DoubleValue delay;
    public TimerUtils timer = new TimerUtils();

    public AntiAfk(String string) {
        super(string, HackCategory.Player);
        this.b("General");
        this.mode = new ModeValue("Mode", new Mode("Jump"), new Mode("Command", true));
        this.delay = new DoubleValue("Delay in second", 10.0, 1.0, 100.0);
        this.a(this.mode, this.delay);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Prevents from being kicked for AFK.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (Wrapper.INSTANCE.getMinecraft().isSingleplayer()) {
            return;
        }
        if (this.timer.isReached(1000L * this.delay.getValue().longValue())) {
            if (this.mode.getModeByIndex(0).isToggled()) {
                Wrapper.INSTANCE.getLocalPlayer().jump();
            } else if (this.mode.getModeByIndex(1).isToggled()) {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketChatMessage("/" + RandomUtils.randomString(6)));
            }
            this.timer.resetTime();
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

