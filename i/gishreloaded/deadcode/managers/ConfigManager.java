/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.managers;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import java.awt.Desktop;

public class ConfigManager
extends Command {
    public ConfigManager() {
        super("config");
        this.a(false);
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray[0].equalsIgnoreCase("open")) {
                Desktop.getDesktop().open(\u2001\u2000\u00a0.g.a);
            } else {
                \u2001\u2000\u00a0.true(stringArray[0]);
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Config manager.";
    }

    @Override
    public String getSyntax() {
        return "config <name>, config open";
    }
}

