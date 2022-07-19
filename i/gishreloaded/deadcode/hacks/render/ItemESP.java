/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.render.Profiler;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ModeValue;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ItemESP
extends Hack {
    public ModeValue a;

    public ItemESP(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("WatchDogs"), new Mode("2D", true), new Mode("3D"));
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows you to see all of the items around you.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent, Object object) {
        if (object instanceof EntityItem || object instanceof EntityArrow) {
            Entity entity = (Entity)object;
            Profiler.a(entity, renderWorldLastEvent.getPartialTicks(), this.a.getModeByIndex(0).isToggled(), this.a.getModeByIndex(1).isToggled(), this.a.getModeByIndex(2).isToggled(), false, false, false, false, false, false);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

