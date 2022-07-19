/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.other.Targets;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class Glowing
extends Hack {
    public Glowing(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Glows all entities around you.";
    }

    @Override
    public void onDisable() {
        for (Object e : et.b()) {
            Entity entity = (Entity)e;
            if (!entity.isGlowing()) continue;
            entity.setGlowing(false);
        }
        super.onDisable();
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent, Object object) {
        Entity entity = (Entity)object;
        if (this.a(entity) != null && entity != Wrapper.INSTANCE.getLocalPlayer() && !entity.isGlowing()) {
            entity.setGlowing(true);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    public Entity a(Entity entity) {
        Entity entity2 = null;
        if (Targets.d && entity instanceof EntityPlayer) {
            entity2 = entity;
        } else if (Targets.e && entity instanceof EntityLiving) {
            entity2 = entity;
        } else if (entity instanceof EntityItem) {
            entity2 = entity;
        } else if (entity instanceof EntityArrow) {
            entity2 = entity;
        }
        return entity2;
    }
}

