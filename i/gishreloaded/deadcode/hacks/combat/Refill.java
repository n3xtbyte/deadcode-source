/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.potion.Potion
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Refill
extends Hack {
    public HashMap a = new HashMap();

    public Refill(String string) {
        super(string, HackCategory.Combat);
        this.a.put(MobEffects.INSTANT_HEALTH, false);
        this.a.put(MobEffects.REGENERATION, false);
    }

    @Override
    public String getDescription() {
        return "Automatically fills the hotbar with healing potions.";
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        int n2;
        int n3 = bz.c(Items.GOLDEN_APPLE);
        int n4 = bz.b();
        if (n4 == -2 && (n2 = bz.b(Items.GLASS_BOTTLE)) != -2) {
            n4 = n2;
        }
        if (n3 == -2) {
            for (Map.Entry entry : this.a.entrySet()) {
                boolean bl;
                Potion potion = (Potion)entry.getKey();
                int n5 = bz.a(potion, bl = ((Boolean)entry.getValue()).booleanValue());
                if (n5 == -2) continue;
                n3 = n5;
                break;
            }
        }
        if (n3 != -2 && n4 != -2) {
            bz.c(n3, n4);
        }
        super.onPlayerTickEvent(playerTickEvent);
    }
}

