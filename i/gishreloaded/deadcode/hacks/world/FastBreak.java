/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.lwjgl.input.Mouse
 */
package i.gishreloaded.deadcode.hacks.world;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

public class FastBreak
extends Hack {
    public FastBreak(String string) {
        super(string, HackCategory.World);
    }

    @Override
    public String getDescription() {
        return "Allows you to break blocks faster.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        f.a(0);
        RayTraceResult rayTraceResult = Wrapper.INSTANCE.getMinecraft().objectMouseOver;
        if (rayTraceResult == null) {
            return;
        }
        if (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && Mouse.isButtonDown((int)0) && Wrapper.INSTANCE.getMinecraft().currentScreen == null) {
            float f2 = f.a() + eS.e(rayTraceResult.getBlockPos());
            if (f2 >= 1.0f) {
                return;
            }
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, rayTraceResult.getBlockPos(), Wrapper.INSTANCE.getMinecraft().objectMouseOver.sideHit));
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

