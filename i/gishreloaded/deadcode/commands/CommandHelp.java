/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.commands;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.managers.CommandManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;

public class CommandHelp
extends Command {
    public CommandHelp() {
        super("help");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        for (Command command : CommandManager.a()) {
            if (command == this) continue;
            ChatUtils.info(command.getSyntax().replace("<", "<\u00a79").replace(">", "\u00a77>") + " - " + command.getDescription());
        }
    }

    @Override
    public String getDescription() {
        return "Lists all commands.";
    }

    @Override
    public String getSyntax() {
        return "help";
    }
}

