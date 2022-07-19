/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.entity.item.EntityPainting
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntitySign
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Optimization
extends Hack {
    public static boolean a = false;
    public BooleanValue b;

    public Optimization(String string) {
        super(string, HackCategory.Other);
        this.d(false);
        this.c(true);
        this.b("General");
        this.b = new BooleanValue("Some entities", false);
        this.a(this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Optimizes minecraft client.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        a = true;
        if (!((Boolean)this.b.getObjectValue()).booleanValue()) {
            return;
        }
        try {
            this.b();
            this.c();
        }
        catch (Exception exception) {
            // empty catch block
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onDisable() {
        a = false;
        super.onDisable();
    }

    public void b() {
        for (Entity entity : et.b()) {
            if (!(entity instanceof EntityBoat) && !(entity instanceof EntityPainting)) continue;
            Wrapper.INSTANCE.getWorld().removeEntity(entity);
        }
    }

    public void c() {
        for (TileEntity tileEntity : Wrapper.INSTANCE.getWorld().loadedTileEntityList) {
            if (!(tileEntity instanceof TileEntitySign)) continue;
            Wrapper.INSTANCE.getWorld().removeTileEntity(tileEntity.getPos());
        }
    }

    public static boolean a(Entity entity) {
        float f2 = 170.0f;
        if (Wrapper.INSTANCE.getLocalPlayer().rotationPitch > 50.0f) {
            f2 *= Wrapper.INSTANCE.getLocalPlayer().rotationPitch / 40.0f;
        }
        return MathUtils.a(entity, (double)f2);
    }
}

