/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.arikia.dev.drpc.DiscordRPC
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.types.BooleanValue;

public class DiscordRPC
extends Hack {
    public static int a = 0;
    public static int b = 0;
    public static BooleanValue c;

    public DiscordRPC(String string) {
        super(string, HackCategory.Other);
        this.d(false);
        this.c(net.arikia.dev.drpc.DiscordRPC.isExistsDll());
        c = new BooleanValue("Kill counter", false);
        this.b("General");
        this.a(c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Show discord rich presence.";
    }

    @Override
    public void onDisable() {
        fE.b();
        super.onDisable();
    }
}

