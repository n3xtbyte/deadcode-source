/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.NetworkPlayerInfo
 */
package i.gishreloaded.deadcode.commands;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.io.File;
import java.util.ArrayList;
import net.minecraft.client.network.NetworkPlayerInfo;

public class CommandDumpPlayers
extends Command {
    public CommandDumpPlayers() {
        super("dumpplayers");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            ArrayList<String> arrayList = new ArrayList<String>();
            if (stringArray[0].equalsIgnoreCase("all")) {
                for (NetworkPlayerInfo networkPlayerInfo : Wrapper.INSTANCE.getMinecraft().getConnection().getPlayerInfoMap()) {
                    arrayList.add("\n" + networkPlayerInfo.getGameProfile().getName());
                }
            } else if (stringArray[0].equalsIgnoreCase("creatives")) {
                for (NetworkPlayerInfo networkPlayerInfo : Wrapper.INSTANCE.getMinecraft().getConnection().getPlayerInfoMap()) {
                    if (!networkPlayerInfo.getGameType().isCreative()) continue;
                    arrayList.add("\n" + networkPlayerInfo.getGameProfile().getName());
                }
            }
            if (arrayList.isEmpty()) {
                ChatUtils.error("List is empty.");
            } else {
                File file = new File(\u2001\u2000\u00a0.g.a, "dump_players.txt");
                fn.a(file, arrayList, false, true);
                ChatUtils.info("Saved to '" + file.getAbsolutePath() + "'.");
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Get list of players.";
    }

    @Override
    public String getSyntax() {
        return "dumpplayers <all/creatives>";
    }
}

