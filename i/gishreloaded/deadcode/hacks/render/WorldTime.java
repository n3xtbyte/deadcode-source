/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class WorldTime
extends Hack {
    public IntegerValue a;

    public WorldTime(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        this.a = new IntegerValue("Time", 0, 0, 24000);
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Set custom world time.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        Wrapper.INSTANCE.getWorld().setWorldTime((long)this.a.getValue().intValue());
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

