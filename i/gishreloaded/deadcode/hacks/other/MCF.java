/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.lwjgl.input.Mouse
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.managers.FriendManager;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

public class MCF
extends Hack {
    public TimerUtils a = new TimerUtils();

    public MCF(String string) {
        super(string, HackCategory.Other);
    }

    @Override
    public String getDescription() {
        return "Wheel click > Add/Remove from Friends list.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        Entity entity;
        RayTraceResult rayTraceResult = Wrapper.INSTANCE.getMinecraft().objectMouseOver;
        if (rayTraceResult == null) {
            return;
        }
        if (rayTraceResult.typeOfHit == RayTraceResult.Type.ENTITY && (entity = rayTraceResult.entityHit) instanceof EntityPlayer && !(entity instanceof EntityArmorStand) && !Wrapper.INSTANCE.getLocalPlayer().isDead && Wrapper.INSTANCE.getLocalPlayer().canEntityBeSeen(entity)) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            String string = et.a(entityPlayer);
            if (Mouse.isButtonDown((int)2) && this.a.isReached(200L) && Wrapper.INSTANCE.getMinecraft().currentScreen == null) {
                FriendManager.a(string);
                this.a.resetTime();
            }
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

