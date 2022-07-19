/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.util.text.ChatType
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ChatCalc
extends Hack {
    public IntegerValue a = new IntegerValue("Delay", 100, 0, 5000);
    public ArrayList b;
    public TimerUtils c;
    public final String d;

    public ChatCalc(String string) {
        super(string, HackCategory.Other);
        this.b("General");
        this.a(this.a);
        this.b("Other");
        this.d = "\u043f\u0440\u0438\u043c\u0435\u0440:";
        this.b = new ArrayList();
        this.c = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Automatically resolves examples from chat.";
    }

    @Override
    public void onEnable() {
        this.b.clear();
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (this.b.isEmpty()) {
            return;
        }
        if (!this.c.isReached(this.a.getValue().intValue())) {
            return;
        }
        for (String string : this.b) {
            int n2 = string.indexOf(this.d);
            if (n2 == -1) continue;
            try {
                String string2 = string.replace(string.substring(0, n2), "").replace(this.d, "").replace(" ", "");
                String string3 = ChatCalc.a(string2);
                if (et.a(string3)) continue;
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketChatMessage(string3));
            }
            catch (Exception exception) {}
        }
        this.b.clear();
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (object instanceof SPacketChat) {
            this.a((SPacketChat)object);
        }
        return super.a(object, bw2);
    }

    public static String a(String string) {
        String string2 = "";
        try {
            String[] stringArray = string.replaceAll("[+*/()-]+", " ").split(" ");
            String[] stringArray2 = string.replaceAll("[0-9()]+", "").split("");
            int n2 = Integer.parseInt(stringArray[0]);
            for (int i2 = 0; i2 < stringArray2.length; ++i2) {
                int n3 = Integer.parseInt(stringArray[i2 + 1]);
                switch (stringArray2[i2]) {
                    case "+": {
                        n2 += n3;
                        break;
                    }
                    case "-": {
                        n2 -= n3;
                        break;
                    }
                    case "*": {
                        n2 *= n3;
                        break;
                    }
                    case "/": {
                        n2 /= n3;
                    }
                }
                if (i2 + 2 >= stringArray2.length) continue;
                stringArray[i2 + 1] = String.valueOf(n2);
            }
            string2 = String.valueOf(n2);
        }
        catch (Exception exception) {
            // empty catch block
        }
        return string2;
    }

    public void a(SPacketChat sPacketChat) {
        if (sPacketChat.getChatComponent() == null || sPacketChat.getType() != ChatType.SYSTEM) {
            return;
        }
        String string = et.c(sPacketChat.getChatComponent().getFormattedText());
        if (string.contains(this.d)) {
            this.b.add(string);
            this.c.resetTime();
        }
    }
}

