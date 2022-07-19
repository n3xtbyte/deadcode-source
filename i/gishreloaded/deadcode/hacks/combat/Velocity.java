/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Velocity
extends Hack {
    public ModeValue a;

    public Velocity(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("AAC"), new Mode("Matrix"));
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Prevents you from getting pushed by players, mobs and flowing water.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.a.getModeByIndex(1).isToggled()) {
            if (entityPlayerSP.hurtTime > 0 && entityPlayerSP.hurtTime <= 7) {
                entityPlayerSP.motionX *= 0.5;
                entityPlayerSP.motionZ *= 0.5;
            }
            if (entityPlayerSP.hurtTime > 0 && entityPlayerSP.hurtTime < 6) {
                entityPlayerSP.motionX = 0.0;
                entityPlayerSP.motionZ = 0.0;
            }
            if (entityPlayerSP.hurtTime > 0 && entityPlayerSP.hurtTime < 1) {
                entityPlayerSP.motionY = -0.4;
            }
        } else if (this.a.getModeByIndex(2).isToggled() && entityPlayerSP.hurtTime >= 9) {
            entityPlayerSP.motionX = 0.0;
            entityPlayerSP.motionY /= 2.0;
            entityPlayerSP.motionZ = 0.0;
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        SPacketEntityVelocity sPacketEntityVelocity;
        return !(object instanceof SPacketEntityVelocity) || !this.a.getModeByIndex(0).isToggled() || (sPacketEntityVelocity = (SPacketEntityVelocity)object).getEntityID() != Wrapper.INSTANCE.getLocalPlayer().getEntityId();
    }
}

