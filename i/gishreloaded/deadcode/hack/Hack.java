/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent
 *  net.minecraftforge.client.event.RenderPlayerEvent
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.client.event.ScreenshotEvent
 *  net.minecraftforge.event.entity.EntityJoinWorldEvent
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingJumpEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.event.entity.player.EntityItemPickupEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  net.minecraftforge.fml.common.network.FMLNetworkEvent$ClientConnectedToServerEvent
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package i.gishreloaded.deadcode.hack;

import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.other.Sleep;
import i.gishreloaded.deadcode.hacks.render.HUD;
import i.gishreloaded.deadcode.hacks.render.UserInterface;
import i.gishreloaded.deadcode.utils.SoundPlayer;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.Value;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import java.util.Collection;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.ScreenshotEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Hack
extends n {
    private ArrayList values = new ArrayList();
    private String name;
    private HackCategory category;
    private boolean show;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int key;
    private int k;
    private int l;
    public long x;
    public double y;
    public long z;
    public double A;

    public Hack(String string, HackCategory hackCategory) {
        this.name = string;
        this.category = hackCategory;
        this.show = true;
        this.e = false;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = false;
        this.key = -1;
        this.k = -1;
        this.m();
        ChatUtils.debug(String.format("Load hack: [%s] %s", this.category.toString(), this.name));
    }

    public String getKeyString() {
        String string = "NONE";
        if (this.getKey() != -1) {
            string = Keyboard.getKeyName((int)this.getKey()).replace("NUMPAD", "NUM");
        } else if (this.r() != -1) {
            string = Mouse.getButtonName((int)this.r()).replace("BUTTON", "BUT");
        }
        return string;
    }

    public boolean hasBind() {
        return this.getKey() != -1 || this.r() != -1;
    }

    public void b(String string) {
        this.getSettings().add(new cs_0(string));
    }

    public void a(Value ... valueArray) {
        for (Value value : valueArray) {
            this.getSettings().add(value);
        }
    }

    public void addValues(Collection collection) {
        this.getSettings().addAll(collection);
    }

    public ArrayList getSettings() {
        return this.values;
    }

    public String l() {
        String string = "";
        for (Value value : this.getSettings()) {
            ModeValue modeValue;
            if (!(value instanceof ModeValue) || !(modeValue = (ModeValue)value).isToggled()) continue;
            for (Mode mode : modeValue.getModes()) {
                if (!mode.isToggled()) continue;
                string = string + " \u00a7f" + mode.getName();
            }
        }
        Object object = this.getName() + string;
        if (((Boolean)HUD.l.getObjectValue()).booleanValue() && this.hasBind()) {
            object = (String)object + " \u00a7f> " + this.getKeyString();
        }
        this.l = Wrapper.INSTANCE.p().a((String)object);
        return object;
    }

    public boolean isToggledMode(String string) {
        for (Value value : this.values) {
            if (!(value instanceof ModeValue)) continue;
            ModeValue modeValue = (ModeValue)value;
            return modeValue.getMode(string).isToggled();
        }
        return false;
    }

    public boolean b(int n2) {
        for (Value value : this.values) {
            if (!(value instanceof ModeValue)) continue;
            ModeValue modeValue = (ModeValue)value;
            return modeValue.getModeByIndex(n2).isToggled();
        }
        return false;
    }

    public boolean isToggledBooleanValue(String string) {
        for (Value value : this.values) {
            BooleanValue booleanValue;
            if (!(value instanceof BooleanValue) || !(booleanValue = (BooleanValue)value).getName().equalsIgnoreCase(string) || !((Boolean)booleanValue.getObjectValue()).booleanValue()) continue;
            return true;
        }
        return false;
    }

    public void setValues(ArrayList arrayList) {
        for (Value value : arrayList) {
            for (Value value2 : this.values) {
                if (!value.getName().equalsIgnoreCase(value2.getName())) continue;
                value2.setValue(value.getObjectValue());
            }
        }
    }

    public void m() {
        long l2 = System.currentTimeMillis();
        this.y = 130.0;
        this.A = -10.0;
        this.x = l2;
        this.z = l2;
    }

    public void toggle() {
        if (Sleep.a && !this.getName().equals("Sleep") || !this.u()) {
            return;
        }
        this.l();
        boolean bl = this.e = !this.e;
        if (this.e) {
            this.m();
            \u2007\u2008\u00a0.p.a("ON", this.getName(), aX.i, aX.i, 0.01);
            this.onEnable();
        } else {
            \u2007\u2008\u00a0.p.a("OFF", this.getName(), aX.l, aX.l, 0.01);
            this.onDisable();
        }
        if (this instanceof UserInterface) {
            SoundPlayer.b();
        } else {
            SoundPlayer.c();
        }
    }

    public void onPushOutOfBlocksEvent(PlayerSPPushOutOfBlocksEvent playerSPPushOutOfBlocksEvent) {
    }

    public void onEntityUseItemEvent(LivingEntityUseItemEvent livingEntityUseItemEvent) {
    }

    public void onScreenshotEvent(ScreenshotEvent screenshotEvent) {
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void onJumpEvent(LivingEvent.LivingJumpEvent livingJumpEvent) {
    }

    public void onGuiOpenEvent(GuiOpenEvent guiOpenEvent) {
    }

    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
    }

    public boolean a(Object object, bw bw2) {
        return true;
    }

    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
    }

    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
    }

    public void onItemPickupEvent(EntityItemPickupEvent entityItemPickupEvent) {
    }

    public void onEntityJoinWorldEvent(EntityJoinWorldEvent entityJoinWorldEvent) {
    }

    public void onUpdateEvent(LivingEvent.LivingUpdateEvent livingUpdateEvent) {
    }

    public void onRenderPlayerEvent(RenderPlayerEvent renderPlayerEvent) {
    }

    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
    }

    public void a(float f2) {
    }

    public void onConnectedToServerEvent(FMLNetworkEvent.ClientConnectedToServerEvent clientConnectedToServerEvent) {
    }

    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent, Object object) {
    }

    public String getDescription() {
        return null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public HackCategory getCategory() {
        return this.category;
    }

    public void a(HackCategory hackCategory) {
        this.category = hackCategory;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int n2) {
        this.key = n2;
    }

    public int r() {
        return this.k;
    }

    public void d(int n2) {
        this.k = n2;
    }

    public boolean isToggled() {
        return this.e;
    }

    public void c(boolean bl) {
        this.e = bl;
    }

    public boolean isShown() {
        return this.f;
    }

    public void d(boolean bl) {
        this.f = bl;
    }

    public boolean u() {
        return this.show;
    }

    public void e(boolean bl) {
        this.show = bl;
    }

    public int v() {
        return this.l;
    }

    public boolean w() {
        return this.g;
    }

    public void f(boolean bl) {
        this.g = bl;
    }

    public boolean x() {
        return this.h;
    }

    public void g(boolean bl) {
        this.h = bl;
    }

    public boolean y() {
        return this.i;
    }

    public void h(boolean bl) {
        this.i = bl;
    }
}

