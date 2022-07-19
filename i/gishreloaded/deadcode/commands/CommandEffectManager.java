/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.potion.Potion
 */
package i.gishreloaded.deadcode.commands;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import net.minecraft.potion.Potion;

public class CommandEffectManager
extends Command {
    public CommandEffectManager() {
        super("effect");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray[0].equalsIgnoreCase("add")) {
                int n2 = Integer.parseInt(stringArray[1]);
                int n3 = Integer.parseInt(stringArray[2]);
                int n4 = Integer.parseInt(stringArray[3]);
                if (Potion.getPotionById((int)n2) == null) {
                    ChatUtils.error("Potion is null");
                    return;
                }
                et.a(n2, n3, n4);
            } else if (stringArray[0].equalsIgnoreCase("remove")) {
                int n5 = Integer.parseInt(stringArray[1]);
                if (Potion.getPotionById((int)n5) == null) {
                    ChatUtils.error("Potion is null");
                    return;
                }
                et.a(n5);
            } else if (stringArray[0].equalsIgnoreCase("clear")) {
                et.d();
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Effect manager.";
    }

    @Override
    public String getSyntax() {
        return "effect <add/remove/clear> <id> <duration> <amplifier>";
    }
}

