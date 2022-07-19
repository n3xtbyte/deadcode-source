/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.network.Packet
 */
package i.gishreloaded.deadcode.wrappers;

import i.gishreloaded.deadcode.managers.FontManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.network.Packet;

public class Wrapper {
    public static volatile Wrapper INSTANCE = new Wrapper();

    private /* synthetic */ void r() {
        if (\u2007\u2008\u00a0.g == null) {
            \u2007\u2008\u00a0.g = new FontManager();
        }
    }

    public Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }

    public EntityPlayerSP getLocalPlayer() {
        return Wrapper.INSTANCE.getMinecraft().player;
    }

    public WorldClient getWorld() {
        return Wrapper.INSTANCE.getMinecraft().world;
    }

    public GameSettings getGameSettings() {
        return Wrapper.INSTANCE.getMinecraft().gameSettings;
    }

    public FontRenderer getFontRenderer() {
        return Wrapper.INSTANCE.getMinecraft().fontRenderer;
    }

    public bu f() {
        this.r();
        return \u2007\u2008\u00a0.g.a();
    }

    public bu g() {
        this.r();
        return \u2007\u2008\u00a0.g.b();
    }

    public bu h() {
        this.r();
        return \u2007\u2008\u00a0.g.c();
    }

    public bu i() {
        this.r();
        return \u2007\u2008\u00a0.g.d();
    }

    public bu j() {
        this.r();
        return \u2007\u2008\u00a0.g.e();
    }

    public bu k() {
        this.r();
        return \u2007\u2008\u00a0.g.f();
    }

    public bu l() {
        this.r();
        return \u2007\u2008\u00a0.g.g();
    }

    public bu m() {
        this.r();
        return \u2007\u2008\u00a0.g.h();
    }

    public bu n() {
        this.r();
        return \u2007\u2008\u00a0.g.i();
    }

    public bu o() {
        this.r();
        return \u2007\u2008\u00a0.g.j();
    }

    public bu p() {
        this.r();
        return \u2007\u2008\u00a0.g.k();
    }

    public bu q() {
        this.r();
        return \u2007\u2008\u00a0.g.l();
    }

    public void sendPacket(Packet packet) {
        Wrapper.INSTANCE.getLocalPlayer().connection.sendPacket(packet);
    }
}

