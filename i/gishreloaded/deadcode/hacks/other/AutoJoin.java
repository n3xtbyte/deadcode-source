/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.inventory.ClickType
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.ClickType;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoJoin
extends Hack {
    public IntegerValue a;
    public IntegerValue b;
    public BooleanValue c;
    public TimerUtils d;
    public TimerUtils e;
    public boolean f;

    public AutoJoin(String string) {
        super(string, HackCategory.Other);
        this.b("General");
        this.a = new IntegerValue("Slot", 0, 0, 54);
        this.b = new IntegerValue("Delay", 50, 0, 500);
        this.c = new BooleanValue("Start delay", false);
        this.a(this.a, this.b, this.c);
        this.b("Other");
        this.d = new TimerUtils();
        this.e = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Automatically clicks on a slot.";
    }

    @Override
    public void onEnable() {
        this.f = false;
        if (((Boolean)this.c.getObjectValue()).booleanValue()) {
            this.e.resetTime();
        }
        super.onEnable();
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (!(Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiContainer) || ((Boolean)this.c.getObjectValue()).booleanValue() && !this.f && !this.e.isReached(3000L) || !this.d.isReached(this.b.getValue().longValue())) {
            return;
        }
        et.a(Wrapper.INSTANCE.getLocalPlayer().openContainer.windowId, this.a.getValue(), 0, ClickType.PICKUP);
        this.f = true;
        this.d.resetTime();
        super.onPlayerTickEvent(playerTickEvent);
    }
}

