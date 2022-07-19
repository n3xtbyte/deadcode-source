/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.managers;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.commands.CommandBind;
import i.gishreloaded.deadcode.commands.CommandDumpPlayers;
import i.gishreloaded.deadcode.commands.CommandEffectManager;
import i.gishreloaded.deadcode.commands.CommandFriendManager;
import i.gishreloaded.deadcode.commands.CommandGPS;
import i.gishreloaded.deadcode.commands.CommandHelp;
import i.gishreloaded.deadcode.commands.CommandHorizontalClip;
import i.gishreloaded.deadcode.commands.CommandLogin;
import i.gishreloaded.deadcode.commands.CommandNoCom;
import i.gishreloaded.deadcode.commands.CommandPickupFilter;
import i.gishreloaded.deadcode.commands.CommandSay;
import i.gishreloaded.deadcode.commands.CommandTeleport;
import i.gishreloaded.deadcode.commands.CommandToggleModule;
import i.gishreloaded.deadcode.commands.CommandVerticalClip;
import i.gishreloaded.deadcode.commands.CommandXRay;
import i.gishreloaded.deadcode.hacks.other.Sleep;
import i.gishreloaded.deadcode.managers.ConfigManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;

public class CommandManager {
    public static final String a = ".";
    private static ArrayList b;

    public CommandManager() {
        b = new ArrayList();
        b.add(new CommandHelp());
        b.add(new CommandBind());
        b.add(new CommandVerticalClip());
        b.add(new CommandHorizontalClip());
        b.add(new CommandLogin());
        b.add(new CommandSay());
        b.add(new CommandEffectManager());
        b.add(new CommandNoCom());
        b.add(new CommandGPS());
        b.add(new CommandDumpPlayers());
        b.add(new CommandTeleport());
        b.add(new CommandFriendManager());
        b.add(new CommandToggleModule());
        b.add(new ConfigManager());
        b.add(new CommandPickupFilter());
        b.add(new CommandXRay());
        ChatUtils.debug("Loaded [" + b.size() + "] commands.");
        ChatUtils.debug("CommandManager: initialized.");
    }

    public static ArrayList a() {
        return b;
    }

    public static Command getCommand(String string) {
        Command command = null;
        for (Command command2 : CommandManager.a()) {
            if (!command2.getCommand().equalsIgnoreCase(string)) continue;
            command = command2;
            break;
        }
        return command;
    }

    public static void executeCommand(String string) {
        if (Sleep.a) {
            return;
        }
        \u2007\u2008\u00a0.p.a(">_", string, aX.h, aX.h, 0.01);
        string = a + string;
        String string2 = string.trim().substring(a.length()).trim();
        boolean bl = false;
        boolean bl2 = string2.trim().contains(" ");
        String string3 = bl2 ? string2.split(" ")[0] : string2.trim();
        String[] stringArray = bl2 ? string2.substring(string3.length()).trim().split(" ") : new String[]{};
        for (Command command : b) {
            if (!command.getCommand().trim().equalsIgnoreCase(string3.trim())) continue;
            command.runCommand(string2, stringArray);
            bl = true;
            break;
        }
        if (!bl) {
            ChatUtils.error("Cannot resolve internal command: \u00a7c" + string3);
        }
    }

    public static void a(int n2) {
        if (Wrapper.INSTANCE.getMinecraft().currentScreen != null) {
            return;
        }
        for (Command command : b) {
            if (command.d().isEmpty()) continue;
            for (fx fx2 : command.d()) {
                if (fx2.b() != n2) continue;
                CommandManager.executeCommand(fx2.a());
            }
        }
    }
}

