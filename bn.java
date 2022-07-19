/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketChatMessage
 */
import i.gishreloaded.deadcode.managers.CommandManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import net.minecraft.network.play.client.CPacketChatMessage;

public class bn {
    public static boolean a(Object object) {
        if (object instanceof CPacketChatMessage) {
            return bn.a((CPacketChatMessage)object);
        }
        return true;
    }

    public static boolean a(CPacketChatMessage cPacketChatMessage) {
        String string = cPacketChatMessage.getMessage().trim();
        if (string.startsWith(".")) {
            CommandManager.executeCommand(string.replace(".", ""));
            try {
                \u2001\u2000\u00a0.g.true();
            }
            catch (Exception exception) {
                ChatUtils.exception("Console: runCommands", exception);
            }
            return false;
        }
        return true;
    }
}

