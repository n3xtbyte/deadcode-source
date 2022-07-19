/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.network.play.server.SPacketPlayerListItem
 *  net.minecraft.network.play.server.SPacketPlayerListItem$AddPlayerData
 *  net.minecraft.scoreboard.ScorePlayerTeam
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.util.text.ITextComponent
 */
package i.gishreloaded.deadcode.hacks.other;

import com.mojang.authlib.GameProfile;
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.text.ITextComponent;

public class StaffDetector
extends Hack {
    public ModeValue a;
    public ModeValue b = new ModeValue("Detect mode", new Mode("Join/Left", true), new Mode("Report"));
    public IntegerValue c;
    public DoubleValue d;
    public HashMap e;
    public String f;
    public String[] g;
    public String h;
    public int i;
    public int j;

    public StaffDetector(String string) {
        super(string, HackCategory.Other);
        this.a = new ModeValue("Mode", false, new Mode("Notification", true), new Mode("Screen"));
        this.c = new IntegerValue("Show time", 500, 100, 3000);
        this.d = new DoubleValue("Alert size", 3.0, 1.0, 5.0);
        this.b("General");
        this.a(this.b, this.a, this.c, this.d);
        this.b("Other");
        this.g = \u200b\u2000.case();
        this.e = new HashMap();
    }

    @Override
    public String getDescription() {
        return "Notifies you about staff.";
    }

    @Override
    public void onEnable() {
        this.h = null;
        this.f = null;
        this.i = 0;
        this.e.clear();
        super.onEnable();
    }

    public void a(String string, int n2) {
        if (this.a.getModeByIndex(0).isToggled()) {
            Object[] objectArray = this.a(n2);
            String string2 = (String)objectArray[0];
            \u2007\u2008\u00a0.p.a("!", string + " - " + string2, (Integer)objectArray[1], (Integer)objectArray[1], 0.002);
            return;
        }
        this.h = string;
        this.j = n2;
        this.i = 0;
    }

    public Object[] a(int n2) {
        switch (n2) {
            case 0: {
                return new Object[]{"Watching for somebody", er.l};
            }
            case 1: {
                return new Object[]{"Left the server", er.k};
            }
            case 2: {
                return new Object[]{"Join the server", aX.i};
            }
        }
        return new Object[0];
    }

    @Override
    public void a(float f2) {
        if (!et.a(this.h)) {
            if (this.i >= this.c.getValue()) {
                this.h = null;
                this.i = 0;
                return;
            }
            Object[] objectArray = this.a(this.j);
            String string = (String)objectArray[0];
            int n2 = (Integer)objectArray[1];
            float f3 = this.d.getValue().floatValue();
            RenderUtils.a(this.h, string, 0, 0, f3, 1, -109);
            RenderUtils.a(this.h, string, er.e, n2, f3, 0, -110);
            ++this.i;
        }
        super.a(f2);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        try {
            if (object instanceof SPacketPlayerListItem) {
                SPacketPlayerListItem sPacketPlayerListItem = (SPacketPlayerListItem)object;
                NetHandlerPlayClient netHandlerPlayClient = Wrapper.INSTANCE.getMinecraft().getConnection();
                if (netHandlerPlayClient == null) {
                    return true;
                }
                List list = sPacketPlayerListItem.getEntries();
                if (list.isEmpty()) {
                    return true;
                }
                GameProfile gameProfile = ((SPacketPlayerListItem.AddPlayerData)list.get(0)).getProfile();
                if (gameProfile == null) {
                    return true;
                }
                UUID uUID = gameProfile.getId();
                if (uUID == null) {
                    return true;
                }
                switch (sPacketPlayerListItem.getAction()) {
                    case ADD_PLAYER: {
                        this.e.put(uUID, gameProfile.getName());
                        String string = this.a(uUID);
                        if (string == null) {
                            return true;
                        }
                        String string2 = this.a(string);
                        if (string2 == null) break;
                        String string3 = string2 + " " + gameProfile.getName();
                        this.a(string3, 2);
                        break;
                    }
                    case REMOVE_PLAYER: {
                        if (!this.e.containsKey(uUID)) break;
                        String string = this.a(uUID);
                        if (string == null) {
                            return true;
                        }
                        String string4 = this.a(string);
                        if (string4 != null) {
                            if (this.b.getModeByIndex(1).isToggled()) {
                                this.f = (String)this.e.get(uUID);
                                String string5 = "/msg ";
                                if (bB.b()) {
                                    string5 = "/report ";
                                }
                                Wrapper.INSTANCE.sendPacket((Packet)new CPacketChatMessage(string5 + this.f + " test"));
                                this.f = string4 + " " + this.f;
                            } else if (this.b.getModeByIndex(0).isToggled()) {
                                String string6 = string4 + " " + (String)this.e.get(uUID);
                                this.a(string6, 1);
                            }
                        }
                        this.e.remove(uUID);
                    }
                }
            } else if (object instanceof SPacketChat) {
                SPacketChat sPacketChat = (SPacketChat)object;
                ITextComponent iTextComponent = sPacketChat.getChatComponent();
                if (iTextComponent == null || et.a(this.f)) {
                    return true;
                }
                String string = iTextComponent.getFormattedText();
                if (bB.b()) {
                    if (string.contains("\u0443\u0441\u043f\u0435\u0448\u043d\u043e \u043f\u043e\u0434\u0430\u043d\u0430")) {
                        this.a(this.f, 0);
                        this.f = null;
                        return false;
                    }
                    if (string.contains("\u00a7c\u0418\u0433\u0440\u043e\u043a \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d")) {
                        this.a(this.f, 1);
                        this.f = null;
                        return false;
                    }
                } else {
                    if (string.contains("\u00a77\u041e\u0448\u0438\u0431\u043a\u0430")) {
                        this.a(this.f, 0);
                        this.f = null;
                        return false;
                    }
                    if (string.contains("\u00a7c\u041e\u0448\u0438\u0431\u043a\u0430")) {
                        this.a(this.f, 1);
                        this.f = null;
                        return false;
                    }
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return super.a(object, bw2);
    }

    public String a(UUID uUID) {
        NetHandlerPlayClient netHandlerPlayClient = Wrapper.INSTANCE.getMinecraft().getConnection();
        if (netHandlerPlayClient == null) {
            return null;
        }
        NetworkPlayerInfo networkPlayerInfo = netHandlerPlayClient.getPlayerInfo(uUID);
        if (networkPlayerInfo == null) {
            return null;
        }
        if (networkPlayerInfo.getDisplayName() == null) {
            if (networkPlayerInfo.getGameProfile() == null) {
                return null;
            }
            return ScorePlayerTeam.formatPlayerName((Team)networkPlayerInfo.getPlayerTeam(), (String)networkPlayerInfo.getGameProfile().getName());
        }
        return networkPlayerInfo.getDisplayName().getFormattedText();
    }

    public String a(String string) {
        if (et.a(string)) {
            return null;
        }
        String string2 = et.c(string);
        String[] stringArray = string2.split(" ");
        if (stringArray.length < 2) {
            return null;
        }
        String string3 = stringArray[0];
        for (String string4 : this.g) {
            if (!string3.equalsIgnoreCase(string4)) continue;
            return string3;
        }
        return null;
    }
}

