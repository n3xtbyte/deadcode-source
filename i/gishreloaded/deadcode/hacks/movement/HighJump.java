/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class HighJump
extends Hack {
    public ModeValue a;
    public DoubleValue b;
    public BooleanValue c;

    public HighJump(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("Matrix"));
        this.b = new DoubleValue("Motion Y", 1.5, 1.0, 5.0);
        this.c = new BooleanValue("Only damage", false);
        this.a(this.a, this.b, this.c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "High jump.";
    }

    @Override
    public void onEnable() {
        if (this.a.getModeByIndex(1).isToggled()) {
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            if (entityPlayerSP.onGround) {
                entityPlayerSP.jump();
            }
            new i.gishreloaded.deadcode.hacks.thread.HighJump(this, entityPlayerSP).start();
            this.c(false);
        }
        super.onEnable();
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (this.a.getModeByIndex(0).isToggled()) {
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            KeyBinding keyBinding = Wrapper.INSTANCE.getGameSettings().keyBindJump;
            if (!entityPlayerSP.onGround) {
                return;
            }
            if (((Boolean)this.c.getObjectValue()).booleanValue() && entityPlayerSP.hurtTime <= 0) {
                return;
            }
            if (!((Boolean)this.c.getObjectValue()).booleanValue() && !keyBinding.isKeyDown()) {
                return;
            }
            entityPlayerSP.motionY = this.b.getValue();
            KeyBinding.setKeyBindState((int)keyBinding.getKeyCode(), (boolean)false);
        }
        super.onPlayerTickEvent(playerTickEvent);
    }
}

