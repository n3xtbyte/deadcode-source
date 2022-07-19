/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.RaytraceUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Reach
extends Hack {
    public DoubleValue a;
    public DoubleValue b;
    public ModeValue c;

    public Reach(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.c = new ModeValue("Mode", new Mode("Default", true), new Mode("Packet"));
        this.a = new DoubleValue("Distance", 4.5, 0.1, 6.0);
        this.b = new DoubleValue("Packet distance", 8.0, 3.0, 100.0);
        this.a(this.c, this.a, this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Hit a player from a long distance.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        KeyBinding keyBinding = Wrapper.INSTANCE.getGameSettings().keyBindAttack;
        if (!keyBinding.isKeyDown()) {
            return;
        }
        Entity entity = RaytraceUtils.b(RaytraceUtils.b());
        if (entity == null || entity != null && this.a(entity)) {
            return;
        }
        if (this.c.getModeByIndex(1).isToggled()) {
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            double d2 = entity.posX - 3.5 * Math.cos(Math.toRadians(MathUtils.c(entity) + 90.0f));
            double d3 = entity.posZ - 3.5 * Math.sin(Math.toRadians(MathUtils.c(entity) + 90.0f));
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.PositionRotation(d2, entity.posY, d3, MathUtils.c(entity), MathUtils.b(entity), entityPlayerSP.onGround));
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketUseEntity(entity));
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position(entityPlayerSP.posX, entityPlayerSP.posY, entityPlayerSP.posZ, entityPlayerSP.onGround));
        } else {
            cs.a.a(entity);
        }
        cs.a.c();
        KeyBinding.setKeyBindState((int)keyBinding.getKeyCode(), (boolean)false);
        super.onClientTickEvent(clientTickEvent);
    }

    public boolean a(Entity entity) {
        return (double)entity.getDistance((Entity)Wrapper.INSTANCE.getLocalPlayer()) <= RaytraceUtils.a();
    }
}

