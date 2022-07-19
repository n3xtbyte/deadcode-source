/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityMinecartTNT
 *  net.minecraft.entity.item.EntityTNTPrimed
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoTotem
extends Hack {
    public DoubleValue a;
    public IntegerValue b;
    public BooleanValue c;
    public BooleanValue d;
    public IntegerValue e;
    public BooleanValue f;
    public DoubleValue g;
    public TimerUtils h;
    public int i;
    public boolean j;

    public AutoTotem(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.a = new DoubleValue("Health", 4.0, 1.0, 20.0);
        this.b = new IntegerValue("Delay", 100, 0, 1000);
        this.c = new BooleanValue("Reset", true);
        this.d = new BooleanValue("Explosion detect", true);
        this.e = new IntegerValue("Distance", 8, 5, 20);
        this.f = new BooleanValue("Falling detect", false);
        this.g = new DoubleValue("Falling distance", 10.0, 4.0, 50.0);
        this.a(this.a, this.b, this.c, new cs_0("Explosions"), this.e, this.d);
        this.b("Falling");
        this.a(this.g, this.f);
        this.b("Other");
        this.h = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Automatically takes a totem in offhand.";
    }

    @Override
    public void onEnable() {
        this.i = -2;
        this.j = false;
        super.onEnable();
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        if (((Boolean)this.d.getObjectValue()).booleanValue()) {
            for (Entity entity : et.b()) {
                if (!(Wrapper.INSTANCE.getLocalPlayer().getDistance(entity) < (float)this.e.getValue().intValue()) || !(entity instanceof EntityEnderCrystal) && !(entity instanceof EntityTNTPrimed) && !(entity instanceof EntityMinecartTNT)) continue;
                this.j = true;
            }
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        this.b();
        super.onPlayerTickEvent(playerTickEvent);
    }

    public void b() {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (((Boolean)this.f.getObjectValue()).booleanValue() && entityPlayerSP.fallDistance > this.g.getValue().floatValue()) {
            this.j = true;
        }
        if ((double)(entityPlayerSP.getHealth() + entityPlayerSP.getAbsorptionAmount() + 1.0f) <= this.a.getValue() || this.j) {
            int n2 = this.d();
            int n3 = n2 < 9 ? n2 + 36 : n2;
            ItemStack itemStack = entityPlayerSP.getHeldItemOffhand();
            if (n2 == -2 && et.a(itemStack)) {
                this.c();
            }
            if (this.h.isReached(this.b.getValue().longValue()) && n2 != -2) {
                if (itemStack.getItem() != Items.TOTEM_OF_UNDYING) {
                    boolean bl = (Boolean)this.c.getObjectValue() != false && !et.a(itemStack);
                    bz.a(n3, 0);
                    bz.a(45, 0);
                    if (bl) {
                        this.i = n3;
                        bz.a(this.i, 0);
                    }
                }
                this.h.resetTime();
            }
        } else {
            this.c();
        }
        this.j = false;
    }

    public void c() {
        if (this.i != -2) {
            ItemStack itemStack = Wrapper.INSTANCE.getLocalPlayer().getHeldItemOffhand();
            boolean bl = !et.a(itemStack);
            bz.a(this.i, 0);
            bz.a(45, 0);
            if (bl) {
                bz.a(this.i, 0);
            }
            this.i = -2;
        }
    }

    public int d() {
        int n2 = -2;
        int n3 = -2;
        for (int i2 = 0; i2 <= 44; ++i2) {
            ItemStack itemStack = cs.a.a().getStackInSlot(i2);
            if (itemStack.getItem() != Items.TOTEM_OF_UNDYING) continue;
            if (itemStack.isItemEnchanted()) {
                n3 = i2;
                continue;
            }
            n2 = i2;
        }
        if (n2 == -2) {
            n2 = n3;
        }
        return n2;
    }
}

