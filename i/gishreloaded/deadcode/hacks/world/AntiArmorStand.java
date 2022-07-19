/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package i.gishreloaded.deadcode.hacks.world;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class AntiArmorStand
extends Hack {
    public AntiArmorStand(String string) {
        super(string, HackCategory.World);
    }

    @Override
    public String getDescription() {
        return "Removes all armor stands from the world.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        for (Entity entity : et.b()) {
            if (!(entity instanceof EntityArmorStand)) continue;
            Wrapper.INSTANCE.getWorld().removeEntity(entity);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

