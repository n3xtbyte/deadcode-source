/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.util.MovementInput
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  org.lwjgl.input.Keyboard
 */
package i.gishreloaded.deadcode.hacks.player;

import i.gishreloaded.deadcode.excluded.UIScreen;
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.MovementInput;
import net.minecraftforge.client.event.InputUpdateEvent;
import org.lwjgl.input.Keyboard;

public class GuiWalk
extends Hack {
    public GuiWalk(String string) {
        super(string, HackCategory.Player);
    }

    @Override
    public String getDescription() {
        return "Allows you to walk while the gui is open.";
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        Object object;
        if (!(Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiContainer) && !(Wrapper.INSTANCE.getMinecraft().currentScreen instanceof UIScreen)) {
            return;
        }
        if (\u2007\u2008\u00a0.s.if() != null && \u2007\u2008\u00a0.s.if().k() != null) {
            object = \u2007\u2008\u00a0.s.if().k().a();
            if (Wrapper.INSTANCE.getMinecraft().currentScreen instanceof UIScreen && object.a != null && object.a.e == aT.c) {
                return;
            }
        }
        object = Wrapper.INSTANCE.getGameSettings();
        MovementInput movementInput = inputUpdateEvent.getMovementInput();
        movementInput.moveStrafe = 0.0f;
        movementInput.moveForward = 0.0f;
        if (Keyboard.isKeyDown((int)object.keyBindForward.getKeyCode())) {
            movementInput.moveForward += 1.0f;
            movementInput.forwardKeyDown = true;
        } else {
            movementInput.forwardKeyDown = false;
        }
        if (Keyboard.isKeyDown((int)object.keyBindBack.getKeyCode())) {
            movementInput.moveForward -= 1.0f;
            movementInput.backKeyDown = true;
        } else {
            movementInput.backKeyDown = false;
        }
        if (Keyboard.isKeyDown((int)object.keyBindLeft.getKeyCode())) {
            movementInput.moveStrafe += 1.0f;
            movementInput.leftKeyDown = true;
        } else {
            movementInput.leftKeyDown = false;
        }
        if (Keyboard.isKeyDown((int)object.keyBindRight.getKeyCode())) {
            movementInput.moveStrafe -= 1.0f;
            movementInput.rightKeyDown = true;
        } else {
            movementInput.rightKeyDown = false;
        }
        movementInput.jump = Keyboard.isKeyDown((int)object.keyBindJump.getKeyCode());
        super.onInputEvent(inputUpdateEvent);
    }
}

