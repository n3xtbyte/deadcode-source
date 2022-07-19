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
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoStep
extends Hack {
    public ModeValue a;
    public DoubleValue b;
    public int c = 0;

    public AutoStep(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("AAC"));
        this.b = new DoubleValue("Height", 0.5, 0.0, 10.0);
        this.a(this.a, this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows you to walk on value blocks height.";
    }

    @Override
    public void onEnable() {
        this.c = 0;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        Wrapper.INSTANCE.getLocalPlayer().stepHeight = 0.5f;
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (this.a.getModeByIndex(1).isToggled()) {
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            if (entityPlayerSP.collidedHorizontally) {
                switch (this.c) {
                    case 0: {
                        if (!entityPlayerSP.onGround) break;
                        entityPlayerSP.jump();
                        break;
                    }
                    case 7: {
                        entityPlayerSP.motionY = 0.0;
                        break;
                    }
                    case 8: {
                        if (entityPlayerSP.onGround) break;
                        entityPlayerSP.setPosition(entityPlayerSP.posX, entityPlayerSP.posY + 1.0, entityPlayerSP.posZ);
                    }
                }
                ++this.c;
            } else {
                this.c = 0;
            }
        } else if (this.a.getModeByIndex(0).isToggled()) {
            Wrapper.INSTANCE.getLocalPlayer().stepHeight = this.b.getValue().floatValue();
        }
        super.onClientTickEvent(clientTickEvent);
    }
}

