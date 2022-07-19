/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 */
package i.gishreloaded.deadcode.commands;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.managers.FriendManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import net.minecraft.entity.player.EntityPlayer;

public class CommandFriendManager
extends Command {
    public CommandFriendManager() {
        super("friend");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            if (stringArray[0].equalsIgnoreCase("add")) {
                if (stringArray[1].equalsIgnoreCase("all")) {
                    for (Object e : et.b()) {
                        EntityPlayer entityPlayer;
                        if (!(e instanceof EntityPlayer) || (entityPlayer = (EntityPlayer)e).isInvisible()) continue;
                        FriendManager.b(et.a(entityPlayer));
                    }
                } else {
                    FriendManager.b(stringArray[1]);
                }
            } else if (stringArray[0].equalsIgnoreCase("remove")) {
                FriendManager.c(stringArray[1]);
            } else if (stringArray[0].equalsIgnoreCase("clear")) {
                FriendManager.a();
            }
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Friend manager.";
    }

    @Override
    public String getSyntax() {
        return "friend <add/remove/clear> <nick>";
    }
}

