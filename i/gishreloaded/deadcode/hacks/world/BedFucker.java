/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.world;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class BedFucker
extends Hack {
    public IntegerValue a;
    public TimerUtils b;
    public TimerUtils c;
    public TimerUtils d;

    public BedFucker(String string) {
        super(string, HackCategory.World);
        this.b("General");
        this.a = new IntegerValue("Distance", 5, 2, 10);
        this.a(this.a);
        this.b("Other");
        this.b = new TimerUtils();
        this.c = new TimerUtils();
        this.d = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Breaking beds near you.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        int n2 = this.a.getValue();
        Stream stream = eS.a(n2, n2, n2);
        if (stream == null) {
            return;
        }
        stream.forEach(blockPos -> {
            int n2 = Block.getIdFromBlock((Block)eS.b(blockPos));
            if (n2 == Block.getIdFromBlock((Block)Blocks.BED)) {
                float[] fArray = MathUtils.a(blockPos);
                ef.a(fArray);
                if (this.d.isReached(1L)) {
                    Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
                }
                if (this.d.isReached(2L)) {
                    Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw - 2.0E-4);
                    this.d.resetTime();
                }
                if (this.c.isReached(33L)) {
                    if (this.b.isReached(1000L)) {
                        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, blockPos, Wrapper.INSTANCE.getMinecraft().objectMouseOver.sideHit));
                    }
                    if (this.b.isReached(2000L)) {
                        Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, Wrapper.INSTANCE.getMinecraft().objectMouseOver.sideHit));
                        this.b.resetTime();
                    }
                    cs.a.c();
                    this.c.resetTime();
                }
            }
        });
        super.onClientTickEvent(clientTickEvent);
    }
}

