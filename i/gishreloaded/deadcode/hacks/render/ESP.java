/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.render.Profiler;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ColorValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ESP
extends Hack {
    public static ColorValue a;
    public ModeValue b;

    public ESP(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        this.b = new ModeValue("Mode", new Mode("WatchDogs"), new Mode("2D", true), new Mode("3D"));
        a = new ColorValue("Color", aX.i);
        this.a(a, this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows you to see all of the entities around you.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent, Object object) {
        if (object instanceof EntityLivingBase) {
            EntityLivingBase entityLivingBase = (EntityLivingBase)object;
            Profiler.a((Entity)entityLivingBase, renderWorldLastEvent.getPartialTicks(), this.b.getModeByIndex(0).isToggled(), this.b.getModeByIndex(1).isToggled(), this.b.getModeByIndex(2).isToggled(), false, false, false, false, false, false);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

