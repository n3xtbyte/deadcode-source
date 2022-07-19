/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package i.gishreloaded.deadcode.commands;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hacks.render.UserInterface;
import i.gishreloaded.deadcode.managers.CommandManager;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.value.Value;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import org.lwjgl.input.Keyboard;

public class CommandBind
extends Command {
    public CommandBind() {
        super("bind");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            String string2 = stringArray[0];
            int n2 = -1;
            if (string2.equalsIgnoreCase("reset")) {
                for (Object object : HackManager.getHacks()) {
                    if (object instanceof UserInterface) continue;
                    ((Hack)object).setKey(-1);
                    ((Hack)object).d(-1);
                    for (Value value : ((Hack)object).getSettings()) {
                        if (!(value instanceof BooleanValue)) continue;
                        BooleanValue booleanValue = (BooleanValue)value;
                        booleanValue.a(-1);
                    }
                }
                for (Object object : CommandManager.a()) {
                    ((Command)object).d().clear();
                }
                \u2001\u2000\u00a0.g.if();
                \u2001\u2000\u00a0.g.true();
                ChatUtils.info("Bind list has been cleared.");
                return;
            }
            if (string2.equalsIgnoreCase("list")) {
                for (Object object : HackManager.getHacks()) {
                    if (((Hack)object).getKey() == -1) continue;
                    ChatUtils.info(String.format("\u00a79%s \u00a77binded on \u00a79%s", ((Hack)object).getName(), ((Hack)object).getKeyString()));
                }
                for (Object object : CommandManager.a()) {
                    for (fx fx2 : ((Command)object).d()) {
                        ChatUtils.info(String.format("\u00a7a%s \u00a77binded on \u00a7a%s", fx2.a(), Keyboard.getKeyName((int)fx2.b())));
                    }
                }
                return;
            }
            try {
                n2 = Keyboard.getKeyIndex((String)string2.toUpperCase());
            }
            catch (Exception exception) {
                // empty catch block
            }
            for (Object object : CommandManager.a()) {
                if (!stringArray[1].startsWith(((Command)object).getCommand())) continue;
                if (string2.equalsIgnoreCase("remove")) {
                    ((Command)object).d().clear();
                    this.a(((Command)object).getCommand());
                    \u2001\u2000\u00a0.g.if();
                    return;
                }
                String string3 = ((Command)object).getCommand();
                for (int i2 = 2; i2 < stringArray.length; ++i2) {
                    string3 = string3 + " " + stringArray[i2];
                }
                if (n2 == 0) {
                    ChatUtils.error("Key not found.");
                    return;
                }
                ((Command)object).b(string3, n2);
                this.a(((Command)object).getCommand(), n2);
                \u2001\u2000\u00a0.g.if();
                return;
            }
            block12: for (Object object : HackManager.getHacks()) {
                BooleanValue booleanValue;
                String string4;
                if (!((Hack)object).getName().equalsIgnoreCase(stringArray[1])) continue;
                if (string2.equalsIgnoreCase("remove")) {
                    if (stringArray.length > 2) {
                        string4 = stringArray[2];
                        if (stringArray.length > 3) {
                            for (int i3 = 3; i3 < stringArray.length; ++i3) {
                                string4 = string4 + " " + stringArray[i3];
                            }
                        }
                        for (Value value : ((Hack)object).getSettings()) {
                            if (!value.getName().equalsIgnoreCase(string4) || !(value instanceof BooleanValue)) continue;
                            booleanValue = (BooleanValue)value;
                            booleanValue.a(-1);
                            this.a(((Hack)object).getName(), booleanValue.getName());
                            \u2001\u2000\u00a0.g.true();
                            continue block12;
                        }
                        continue;
                    }
                    ((Hack)object).setKey(-1);
                    this.a(((Hack)object).getName());
                    \u2001\u2000\u00a0.g.true();
                    break;
                }
                if (stringArray.length > 2) {
                    string4 = stringArray[2];
                    if (stringArray.length > 3) {
                        for (int i4 = 3; i4 < stringArray.length; ++i4) {
                            string4 = string4 + " " + stringArray[i4];
                        }
                    }
                    for (Value value : ((Hack)object).getSettings()) {
                        if (!value.getName().equalsIgnoreCase(string4) || !(value instanceof BooleanValue)) continue;
                        booleanValue = (BooleanValue)value;
                        booleanValue.a(n2);
                        this.a(((Hack)object).getName(), booleanValue.getName(), booleanValue.a());
                        \u2001\u2000\u00a0.g.true();
                        continue block12;
                    }
                    continue;
                }
                ((Hack)object).setKey(n2);
                this.a(((Hack)object).getName(), ((Hack)object).getKey());
                \u2001\u2000\u00a0.g.true();
                break;
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    public void a(String string) {
        ChatUtils.info(String.format("Bind for %s \u00a79removed.", string));
    }

    public void a(String string, String string2) {
        ChatUtils.info(String.format("Bind for %s \u00a78<\u00a77%s\u00a78> \u00a79removed.", string, string2));
    }

    public void a(String string, int n2) {
        ChatUtils.info(String.format("%s binded to \u00a79%s", string, Keyboard.getKeyName((int)n2)));
    }

    public void a(String string, String string2, int n2) {
        ChatUtils.info(String.format("%s \u00a78<\u00a77%s\u00a78>\u00a77 binded to \u00a79%s", string, string2, Keyboard.getKeyName((int)n2)));
    }

    @Override
    public String getDescription() {
        return "Change key for hacks/commands.";
    }

    @Override
    public String getSyntax() {
        return "bind <key> <command/hack>";
    }
}

