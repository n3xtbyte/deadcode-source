/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemAppleGold
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent$Finish
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent$Start
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class GoldenAppleDelay
extends Hack {
    public dr_0 a;
    public IntegerValue b;
    public ItemStack c;
    public TimerUtils d;

    public GoldenAppleDelay(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.b = new IntegerValue("Delay", 3000, 100, 10000);
        this.a = new dr_0("Position", new eM(500, 200));
        this.a(this.b, this.a);
        this.b("Other");
        this.d = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Prevents you from eating gapples until the timer expires.";
    }

    @Override
    public void onEnable() {
        this.c = null;
        super.onEnable();
    }

    @Override
    public void a(float f2) {
        if (this.c == null) {
            return;
        }
        float f3 = (float)((double)((long)this.b.getValue().intValue() - this.d.elapsedSinceLastReset()) / this.b.getValue().doubleValue());
        if (f3 > 0.0f) {
            int n2 = ((eM)this.a.getObjectValue()).a();
            int n3 = ((eM)this.a.getObjectValue()).b();
            float f4 = 12.0f;
            float f5 = 9.0f;
            float f6 = 8.0f;
            if (this.c.getCount() > 10) {
                f6 = 7.0f;
            }
            RenderUtils.a(this.c, n2, n3);
            RenderUtils.a((float)n2 + f5, (float)n3 - f6, f4, f3, false, aX.f, aX.j);
        }
        super.a(f2);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (this.c != null && object instanceof CPacketPlayerTryUseItem) {
            return false;
        }
        return super.a(object, bw2);
    }

    @Override
    public void onEntityUseItemEvent(LivingEntityUseItemEvent livingEntityUseItemEvent) {
        if (!et.a(livingEntityUseItemEvent.getItem()) && !(livingEntityUseItemEvent.getItem().getItem() instanceof ItemAppleGold)) {
            return;
        }
        if (livingEntityUseItemEvent instanceof LivingEntityUseItemEvent.Finish) {
            this.d.resetTime();
            this.c = livingEntityUseItemEvent.getItem();
        }
        if (livingEntityUseItemEvent instanceof LivingEntityUseItemEvent.Start && this.c != null) {
            livingEntityUseItemEvent.setCanceled(true);
        }
        super.onEntityUseItemEvent(livingEntityUseItemEvent);
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (this.c == null) {
            return;
        }
        if (this.d.isReached(this.b.getValue().intValue())) {
            this.c = null;
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

