/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class WaterLeave
extends Hack {
    public IntegerValue a;
    public TimerUtils b;
    public boolean c;

    public WaterLeave(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a = new IntegerValue("Motion Y", 5, 1, 100);
        this.a(this.a);
        this.b("Other");
        this.b = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Gives you the ability to leave above water.";
    }

    @Override
    public void onEnable() {
        this.c = false;
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (!dV.a() && eS.a(Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox(), block -> block instanceof BlockLiquid)) {
            Wrapper.INSTANCE.getLocalPlayer().motionY = 0.07;
            entityPlayerSP.fallDistance = 0.0f;
        }
        if (!this.c && eS.a(Wrapper.INSTANCE.getLocalPlayer().getEntityBoundingBox(), block -> block instanceof BlockLiquid) && !entityPlayerSP.isInWater()) {
            if (this.a.getValue() > 20) {
                dV.a(this.a.getValue());
            }
            this.c = true;
        } else if (this.b.isReached(10L)) {
            if (this.c && (double)entityPlayerSP.fallDistance != 0.0) {
                entityPlayerSP.motionY = this.a.getValue().intValue();
                this.c = false;
            }
            if (entityPlayerSP.onGround) {
                this.c = false;
            }
            this.b.resetTime();
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

