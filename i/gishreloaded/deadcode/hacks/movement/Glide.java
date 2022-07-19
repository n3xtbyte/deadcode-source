/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Glide
extends Hack {
    public ModeValue a;
    private int b;
    private boolean c;
    private int d;
    private TimerUtils e;

    public Glide(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Falling", true), new Mode("Flat"), new Mode("Matrix"));
        this.a(this.a);
        this.b("Other");
        this.e = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Makes you glide down slowly when falling.";
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.a.getMode("Flat").isToggled()) {
            if (!entityPlayerSP.capabilities.isFlying && entityPlayerSP.fallDistance > 0.0f && !entityPlayerSP.isSneaking()) {
                entityPlayerSP.motionY = 0.0;
            }
            if (Wrapper.INSTANCE.getGameSettings().keyBindSneak.isKeyDown()) {
                entityPlayerSP.motionY = -0.11;
            }
            if (Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown()) {
                entityPlayerSP.motionY = 0.11;
            }
            if (this.e.isReached(50L)) {
                entityPlayerSP.onGround = false;
                this.e.resetTime();
            }
        } else if (this.a.getMode("Falling").isToggled()) {
            if (entityPlayerSP.onGround) {
                this.d = 0;
            }
            if (entityPlayerSP.fallDistance > 0.0f && this.d <= 1) {
                if (this.b > 0 && this.c) {
                    entityPlayerSP.motionY = 0.0;
                    this.b = 0;
                } else {
                    ++this.b;
                }
                if ((double)entityPlayerSP.fallDistance >= 0.1) {
                    this.c = false;
                }
                if ((double)entityPlayerSP.fallDistance >= 0.4) {
                    this.c = true;
                    entityPlayerSP.fallDistance = 0.0f;
                }
            }
        } else if (this.a.getMode("Matrix").isToggled()) {
            if (entityPlayerSP.fallDistance > 6.0f) {
                return;
            }
            if (entityPlayerSP.motionY <= -0.36) {
                entityPlayerSP.motionY = -0.1;
            }
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

