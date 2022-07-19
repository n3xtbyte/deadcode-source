/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.commands;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.hacks.exploit.NoCom;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;

public class CommandNoCom
extends Command {
    public CommandNoCom() {
        super("nocom");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray[0].equalsIgnoreCase("reset")) {
                NoCom.e = -1;
                ChatUtils.info("NoCom radius has been reset.");
                return;
            }
            NoCom.e = Integer.parseInt(stringArray[0]);
            ChatUtils.info("NoCom radius = " + NoCom.e);
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Set radius for NoCom exploit";
    }

    @Override
    public String getSyntax() {
        return "nocom <radius/reset>";
    }
}

