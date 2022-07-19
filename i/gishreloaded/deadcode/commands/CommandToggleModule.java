/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.commands;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;

public class CommandToggleModule
extends Command {
    public CommandToggleModule() {
        super("toggle");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            HackManager.getHack(stringArray[0]).toggle();
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Toggling selected hack.";
    }

    @Override
    public String getSyntax() {
        return "toggle <hackname>";
    }
}

