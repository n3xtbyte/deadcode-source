/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 */
import i.gishreloaded.deadcode.ui.base.Component;
import net.minecraft.entity.player.EntityPlayer;

public class cD
extends be_0 {
    public final /* synthetic */ String f;
    public final /* synthetic */ bg g;

    public cD(bg bg2, int n2, int n3, int n4, int n5, Component component, eC eC2, String string, String string2) {
        this.g = bg2;
        this.f = string2;
        super(n2, n3, n4, n5, component, eC2, string);
    }

    @Override
    public boolean d() {
        boolean bl = false;
        for (EntityPlayer entityPlayer : et.c()) {
            if (!entityPlayer.getName().equals(this.f)) continue;
            bl = true;
            break;
        }
        return bl;
    }

    @Override
    public String a() {
        return this.d() ? "Online" : "Offline";
    }
}

