/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.inventory.GuiChest
 *  net.minecraft.client.gui.inventory.GuiShulkerBox
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.Slot
 *  net.minecraft.network.play.server.SPacketWindowItems
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  org.apache.commons.lang3.RandomUtils
 */
package i.gishreloaded.deadcode.hacks.world;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiShulkerBox;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.network.play.server.SPacketWindowItems;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.commons.lang3.RandomUtils;

public class ChestStealer
extends Hack {
    public IntegerValue a;
    public IntegerValue b;
    public BooleanValue c;
    public SPacketWindowItems d;
    public double e;
    public TimerUtils f;

    public ChestStealer(String string) {
        super(string, HackCategory.World);
        this.b("General");
        this.a = new IntegerValue("Min delay", 50, 10, 350);
        this.b = new IntegerValue("Max delay", 100, 10, 350);
        this.c = new BooleanValue("Close", true);
        this.a(this.a, this.b, this.c);
        this.b("Other");
        this.f = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Steals all stuff from chest.";
    }

    @Override
    public void onEnable() {
        this.e = RandomUtils.nextDouble((double)this.a.getValue().intValue(), (double)this.b.getValue().intValue());
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.d = null;
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (bw2 == bw.a && object instanceof SPacketWindowItems) {
            this.d = (SPacketWindowItems)object;
        }
        return true;
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.d != null && entityPlayerSP.openContainer.windowId == this.d.getWindowId() && this.b()) {
            if (!this.a(entityPlayerSP.openContainer)) {
                int n2 = entityPlayerSP.openContainer.inventorySlots.size() - 36;
                for (int i2 = 0; i2 < n2; ++i2) {
                    Slot slot = entityPlayerSP.openContainer.getSlot(i2);
                    if (!slot.getHasStack() || slot.getStack() == null || !this.f.isReached((long)this.e)) continue;
                    this.a(entityPlayerSP.openContainer.windowId, i2);
                }
            } else {
                if (((Boolean)this.c.getObjectValue()).booleanValue()) {
                    Wrapper.INSTANCE.getMinecraft().displayGuiScreen((GuiScreen)null);
                }
                if (this.d != null) {
                    this.d = null;
                }
            }
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    public boolean b() {
        return Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiShulkerBox || Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiChest;
    }

    public void a(int n2, int n3) {
        bz.b(n2, n3);
        this.f.resetTime();
        this.e = RandomUtils.nextDouble((double)this.a.getValue().intValue(), (double)this.b.getValue().intValue());
    }

    public boolean a(Container container) {
        int n2;
        boolean bl = true;
        int n3 = n2 = container.inventorySlots.size() == 90 ? 54 : 35;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!container.getSlot(i2).getHasStack()) continue;
            bl = false;
        }
        return bl;
    }
}

