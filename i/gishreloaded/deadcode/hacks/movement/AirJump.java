/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$Phase
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AirJump
extends Hack {
    public ModeValue a = new ModeValue("Mode", new Mode("Default", true), new Mode("Matrix"));

    public AirJump(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a(this.a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Allows you to jump in the air.";
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        if (this.a.getModeByIndex(0).isToggled() && Wrapper.INSTANCE.getGameSettings().keyBindJump.isKeyDown()) {
            Wrapper.INSTANCE.getLocalPlayer().onGround = true;
        }
        super.onInputEvent(inputUpdateEvent);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (this.a.getModeByIndex(1).isToggled()) {
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            if (playerTickEvent.phase == TickEvent.Phase.END) {
                entityPlayerSP.setSprinting(false);
                float f2 = 1.0f;
                if ((eS.b(new BlockPos(entityPlayerSP.posX, entityPlayerSP.posY - (double)f2, entityPlayerSP.posZ)) != Blocks.AIR || eS.b(new BlockPos(entityPlayerSP.posX - (double)f2, entityPlayerSP.posY - (double)f2, entityPlayerSP.posZ - (double)f2)) != Blocks.AIR || eS.b(new BlockPos(entityPlayerSP.posX + (double)f2, entityPlayerSP.posY - (double)f2, entityPlayerSP.posZ + (double)f2)) != Blocks.AIR || eS.b(new BlockPos(entityPlayerSP.posX - (double)f2, entityPlayerSP.posY - (double)f2, entityPlayerSP.posZ + (double)f2)) != Blocks.AIR || eS.b(new BlockPos(entityPlayerSP.posX + (double)f2, entityPlayerSP.posY - (double)f2, entityPlayerSP.posZ - (double)f2)) != Blocks.AIR || eS.b(new BlockPos(entityPlayerSP.posX + (double)f2, entityPlayerSP.posY - (double)f2, entityPlayerSP.posZ)) != Blocks.AIR || eS.b(new BlockPos(entityPlayerSP.posX - (double)f2, entityPlayerSP.posY - (double)f2, entityPlayerSP.posZ)) != Blocks.AIR || eS.b(new BlockPos(entityPlayerSP.posX, entityPlayerSP.posY - (double)f2, entityPlayerSP.posZ + (double)f2)) != Blocks.AIR || eS.b(new BlockPos(entityPlayerSP.posX, entityPlayerSP.posY - (double)f2, entityPlayerSP.posZ - (double)f2)) != Blocks.AIR) && !entityPlayerSP.collidedHorizontally && dV.a()) {
                    entityPlayerSP.onGround = true;
                    entityPlayerSP.jump();
                }
            }
        }
        super.onPlayerTickEvent(playerTickEvent);
    }
}

