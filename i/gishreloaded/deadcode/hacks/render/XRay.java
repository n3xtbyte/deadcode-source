/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import java.util.ArrayList;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class XRay
extends Hack {
    public IntegerValue a;
    public IntegerValue b;
    public TimerUtils c;
    public ArrayList d;

    public XRay(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        this.a = new IntegerValue("Distance", 30, 4, 100);
        this.b = new IntegerValue("Update delay", 2000, 500, 2000);
        this.a(this.a, this.b);
        this.b("Other");
        this.c = new TimerUtils();
        this.d = new ArrayList();
    }

    @Override
    public String getDescription() {
        return "Allows you to see blocks through walls.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        int n2 = this.a.getValue();
        if (!this.c.isReached(this.b.getValue().intValue())) {
            return;
        }
        new cK(this, n2).start();
        this.c.resetTime();
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        RenderUtils.a(this.d, renderWorldLastEvent.getPartialTicks());
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }
}

