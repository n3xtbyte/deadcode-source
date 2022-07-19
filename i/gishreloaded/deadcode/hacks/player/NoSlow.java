/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemBucketMilk
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.item.ItemShield
 *  net.minecraft.item.ItemSoup
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingJumpEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.player;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoSlow
extends Hack {
    public ModeValue a;
    public DoubleValue b;
    public BooleanValue c;
    public static BooleanValue d;
    public static BooleanValue e;
    public static BooleanValue f;
    public static BooleanValue g;
    public static BooleanValue h;
    public static BooleanValue i;
    public static boolean j;
    public boolean k;

    public NoSlow(String string) {
        super(string, HackCategory.Player);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("Bypass"), new Mode("SunRise"), new Mode("Matrix"));
        this.b = new DoubleValue("Speed", 5.0, 0.5, 5.0);
        this.c = new BooleanValue("Matrix auto jump", true);
        d = new BooleanValue("RightHand", true);
        e = new BooleanValue("LeftHand", true);
        f = new BooleanValue("Bow", true);
        g = new BooleanValue("Shield", true);
        h = new BooleanValue("Food", true);
        i = new BooleanValue("Potion", true);
        this.a(this.a, this.b, this.c);
        this.b("Hands");
        this.a(d, e);
        this.b("Items");
        this.a(f, g, h, i);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Do not slow down when using / eating.";
    }

    @Override
    public void onDisable() {
        j = false;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        j = true;
        if (this.a.getModeByIndex(2).isToggled() && NoSlow.b()) {
            Wrapper.INSTANCE.getLocalPlayer().setSprinting(false);
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)true);
            this.k = true;
        } else if (this.k) {
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
            this.k = false;
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onJumpEvent(LivingEvent.LivingJumpEvent livingJumpEvent) {
        if (this.a.getModeByIndex(2).isToggled() && livingJumpEvent.getEntity() == Wrapper.INSTANCE.getLocalPlayer() && this.k) {
            Wrapper.INSTANCE.getLocalPlayer().motionY *= 4.2E-12;
        }
        super.onJumpEvent(livingJumpEvent);
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        if (!NoSlow.b() || !dV.a()) {
            return;
        }
        float f2 = this.b.getValue().floatValue();
        if (this.a.getModeByIndex(3).isToggled()) {
            if ((double)Wrapper.INSTANCE.getLocalPlayer().fallDistance > 0.5) {
                Wrapper.INSTANCE.getLocalPlayer().jumpMovementFactor = 0.01f;
            }
            if (((Boolean)this.c.getObjectValue()).booleanValue() && Wrapper.INSTANCE.getLocalPlayer().onGround) {
                et.i();
            }
            inputUpdateEvent.getMovementInput().moveForward *= f2;
            inputUpdateEvent.getMovementInput().moveStrafe *= f2;
        } else if (this.a.getModeByIndex(1).isToggled()) {
            if (Wrapper.INSTANCE.getLocalPlayer().ticksExisted % 2 == 0) {
                inputUpdateEvent.getMovementInput().moveForward *= f2;
                inputUpdateEvent.getMovementInput().moveStrafe *= f2;
            }
        } else {
            inputUpdateEvent.getMovementInput().moveForward *= f2;
            inputUpdateEvent.getMovementInput().moveStrafe *= f2;
        }
        super.onInputEvent(inputUpdateEvent);
    }

    public static boolean b() {
        return j && Wrapper.INSTANCE.getGameSettings().keyBindUseItem.isKeyDown() && NoSlow.c();
    }

    public static boolean c() {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        boolean bl = (Boolean)d.getObjectValue() != false && NoSlow.a(entityPlayerSP.getHeldItemMainhand());
        boolean bl2 = (Boolean)e.getObjectValue() != false && NoSlow.a(entityPlayerSP.getHeldItemOffhand());
        return bl || bl2;
    }

    private static /* synthetic */ boolean a(ItemStack itemStack) {
        return !et.a(itemStack) && ((Boolean)h.getObjectValue() != false && itemStack.getItem() instanceof ItemFood || (Boolean)f.getObjectValue() != false && itemStack.getItem() instanceof ItemBow || (Boolean)g.getObjectValue() != false && itemStack.getItem() instanceof ItemShield || (Boolean)i.getObjectValue() != false && itemStack.getItem() instanceof ItemPotion || (Boolean)h.getObjectValue() != false && itemStack.getItem() instanceof ItemSoup || (Boolean)h.getObjectValue() != false && itemStack.getItem() instanceof ItemBucketMilk);
    }
}

