/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.commands;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;

public class CommandPickupFilter
extends Command {
    public CommandPickupFilter() {
        super("pfilter");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray[0].equalsIgnoreCase("add")) {
                fB.a(Integer.parseInt(stringArray[1]));
            } else if (stringArray[0].equalsIgnoreCase("remove")) {
                fB.b(Integer.parseInt(stringArray[1]));
            } else if (stringArray[0].equalsIgnoreCase("clear")) {
                fB.a();
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "PickupFilter manager.";
    }

    @Override
    public String getSyntax() {
        return "pfilter add <id> | remove <id> | clear";
    }
}

