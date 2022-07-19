/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.commands;

import i.gishreloaded.deadcode.command.Command;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.math.BigInteger;

public class CommandVerticalClip
extends Command {
    public CommandVerticalClip() {
        super("vclip");
    }

    @Override
    public void runCommand(String string, String[] stringArray) {
        try {
            Wrapper.INSTANCE.getLocalPlayer().setPosition(cs.a.d(), cs.a.e() + (double)new BigInteger(stringArray[0]).longValue(), cs.a.f());
            ChatUtils.info("Height teleported to " + new BigInteger(stringArray[0]).longValue());
        }
        catch (Exception exception) {
            ChatUtils.error("Usage: " + this.getSyntax());
        }
    }

    @Override
    public String getDescription() {
        return "Teleports you up/down.";
    }

    @Override
    public String getSyntax() {
        return "vclip <height>";
    }
}

