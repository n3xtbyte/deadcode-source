/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.SoundPlayer;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import net.minecraft.network.play.client.CPacketUseEntity;

public class HitSound
extends Hack {
    public IntegerValue a;

    public HitSound(String string) {
        super(string, HackCategory.Other);
        this.b("General");
        this.a = new IntegerValue("Volume", 30, 5, 40);
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Plays custom sounds on hit.";
    }

    @Override
    public boolean a(Object object, bw bw2) {
        CPacketUseEntity cPacketUseEntity;
        if (object instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity)object).getAction() == CPacketUseEntity.Action.ATTACK) {
            float f2 = -40.0f + (float)this.a.getValue().intValue();
            SoundPlayer.a(\u2007\u2008\u00a0.q.a, f2);
        }
        return super.a(object, bw2);
    }
}

