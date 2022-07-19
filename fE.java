/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.arikia.dev.drpc.DiscordEventHandlers
 *  net.arikia.dev.drpc.DiscordEventHandlers$Builder
 *  net.arikia.dev.drpc.DiscordRPC
 *  net.arikia.dev.drpc.DiscordRichPresence
 *  net.arikia.dev.drpc.DiscordRichPresence$Builder
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiMultiplayer
 */
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hacks.other.DiscordRPC;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;

public class fE {
    private static boolean a;
    private static int b;

    private static /* synthetic */ boolean c() {
        if (a) {
            return a;
        }
        Hack hack = HackManager.getHack("DiscordRPC");
        try {
            if (!hack.isToggled()) {
                return false;
            }
            if (!net.arikia.dev.drpc.DiscordRPC.isExistsDll()) {
                ChatUtils.error("\"" + net.arikia.dev.drpc.DiscordRPC.getDllDir() + ".dll\" not found");
                hack.c(false);
                return false;
            }
            b = 0;
            DiscordEventHandlers discordEventHandlers = new DiscordEventHandlers.Builder().setReadyEventHandler(discordUser -> ChatUtils.debug("Discord-RPC initialized.")).build();
            net.arikia.dev.drpc.DiscordRPC.discordInitialize((String)\u200b\u2000.byte()[0], (DiscordEventHandlers)discordEventHandlers, (boolean)true);
            a = true;
        }
        catch (Exception exception) {
            hack.c(false);
            ChatUtils.exception("DiscordRPC init(): ", exception);
        }
        return a;
    }

    public static void a() {
        if (!fE.c()) {
            return;
        }
        try {
            if (b % 40 == 0) {
                long l2 = 0L;
                l2 = System.currentTimeMillis() - (long)(b * 26);
                \u00a0\u00a0 \u00a0\u00a02 = \u2007\u2008\u00a0.f.if();
                String string = \u200b\u2000.byte()[1];
                String string2 = "Null";
                if (Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiMainMenu) {
                    string2 = "MainMenu";
                } else if (Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiMultiplayer) {
                    string2 = "Multiplayer";
                } else if (Wrapper.INSTANCE.getMinecraft().isSingleplayer()) {
                    string2 = "Singleplayer";
                } else if (Wrapper.INSTANCE.getMinecraft().getCurrentServerData() != null) {
                    string2 = "Server: " + Wrapper.INSTANCE.getMinecraft().getCurrentServerData().serverIP;
                }
                if (\u00a0\u00a02.if() == \u200b\u2006.c || \u00a0\u00a02.if() == \u200b\u2006.d) {
                    string = \u200b\u2000.byte()[2];
                }
                String string3 = (Boolean)DiscordRPC.c.getObjectValue() != false ? String.format("Kills: [%s]", DiscordRPC.b) : String.format("Hacks: [%s/%s]", HackManager.c().size(), HackManager.getHacks().size());
                String string4 = String.format("UID: %s | Role: %s | User: %s", \u00a0\u00a02.if(), et.b(\u00a0\u00a02.if().toString()), \u00a0\u00a02.if());
                DiscordRichPresence discordRichPresence = new DiscordRichPresence.Builder(string3).setBigImage(string, "DeadCode " + et.k()).setSmallImage(string, string4).setDetails(string2).setStartTimestamps(l2).build();
                net.arikia.dev.drpc.DiscordRPC.discordUpdatePresence((DiscordRichPresence)discordRichPresence);
            }
            if (b % 200 == 0) {
                net.arikia.dev.drpc.DiscordRPC.discordRunCallbacks();
            }
            ++b;
        }
        catch (Exception exception) {
            ChatUtils.exception("DiscordRPC tick(): ", exception);
        }
    }

    public static void b() {
        if (!a) {
            return;
        }
        try {
            net.arikia.dev.drpc.DiscordRPC.discordShutdown();
        }
        catch (Exception exception) {
            ChatUtils.exception("DiscordRPC destroy(): ", exception);
        }
        a = false;
    }
}

