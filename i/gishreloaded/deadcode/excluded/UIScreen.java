/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package i.gishreloaded.deadcode.excluded;

import i.gishreloaded.deadcode.hacks.render.UserInterface;
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.utils.SoundPlayer;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class UIScreen
extends GuiScreen {
    public static final int a = 1;
    public static \u2005\u200a b;
    public static int[] c;
    public static float d;
    public static boolean e;

    public UIScreen() {
        c = new int[2];
    }

    public static void reset() {
        d = 0.0f;
        e = false;
        ShaderManager.e().a();
    }

    public static boolean isFullAlpha() {
        return !(d < 1.0f);
    }

    public static void tickAlpha(float f2) {
        if (!UIScreen.isFullAlpha()) {
            d += 0.18f * f2;
            UIScreen.renderGlitch();
        }
    }

    public static void tickAlphaReverse(float f2) {
        if ((double)d > 0.0) {
            d -= 0.18f * f2;
            UIScreen.renderGlitch();
        } else {
            UIScreen.closeScreen();
        }
    }

    static void renderGlitch() {
        if (!((Boolean)UserInterface.c.getObjectValue()).booleanValue()) {
            return;
        }
        cL cL2 = b.k();
        ShaderManager.e().a(cL2.getX(), cL2.getY(), cL2.getX() + cL2.getWidth(), cL2.getY() + cL2.getHeight());
    }

    public static void closeScreen() {
        try {
            SoundPlayer.b();
            Wrapper.INSTANCE.getMinecraft().displayGuiScreen(null);
            \u2001\u2000\u00a0.g.true();
        }
        catch (Exception exception) {
            ChatUtils.exception("UIScreen: saveHacks", exception);
        }
    }

    protected void mouseClicked(int n2, int n3, int n4) {
        super.mouseClicked(n2, n3, n4);
    }

    public void drawScreen(int n2, int n3, float f2) {
        if (((Boolean)UserInterface.d.getObjectValue()).booleanValue()) {
            ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
            ShaderManager.d().a(0.0, 0.0, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight());
        }
        b.c(f2);
        if (e) {
            UIScreen.tickAlphaReverse(f2);
        } else {
            UIScreen.tickAlpha(f2);
        }
        super.drawScreen(n2, n3, f2);
    }

    public void initGui() {
        Keyboard.enableRepeatEvents((boolean)true);
        if (!Wrapper.INSTANCE.getMinecraft().entityRenderer.isShaderActive()) {
            Wrapper.INSTANCE.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        }
        UIScreen.b.k().b = false;
        UIScreen.b.k().o = 0 - b.k().getWidth();
        UIScreen.b.k().p = 0 - b.k().getHeight();
        UIScreen.b.k().n = System.currentTimeMillis();
        UIScreen.reset();
        super.initGui();
    }

    public void updateScreen() {
        b.i();
        super.updateScreen();
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents((boolean)false);
        if (Wrapper.INSTANCE.getMinecraft().entityRenderer.isShaderActive()) {
            Wrapper.INSTANCE.getMinecraft().entityRenderer.stopUseShader();
        }
        super.onGuiClosed();
    }

    public void handleInput() {
        try {
            this.handleKeyboard();
            this.handleMouse();
            super.handleInput();
        }
        catch (Exception exception) {
            ChatUtils.exception("Exception: handleInput", exception);
        }
    }

    private /* synthetic */ void handleKeyboard() {
        try {
            if (Keyboard.isCreated()) {
                Keyboard.enableRepeatEvents((boolean)true);
                while (Keyboard.next()) {
                    if (Keyboard.getEventKeyState()) {
                        if (Keyboard.getEventKey() == 1) {
                            if (!((Boolean)UserInterface.a.getObjectValue()).booleanValue() && !((Boolean)UserInterface.c.getObjectValue()).booleanValue()) {
                                UIScreen.closeScreen();
                                continue;
                            }
                            e = true;
                            continue;
                        }
                        if (Keyboard.getEventKey() == 208) {
                            b.a(-4);
                            continue;
                        }
                        if (Keyboard.getEventKey() == 200) {
                            b.a(4);
                            continue;
                        }
                        b.b(Keyboard.getEventKey(), Keyboard.getEventCharacter());
                        continue;
                    }
                    b.a(Keyboard.getEventKey(), Keyboard.getEventCharacter());
                }
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("UIScreen: handleKeyboard", exception);
        }
    }

    private /* synthetic */ void handleMouse() {
        if (Mouse.isCreated()) {
            while (Mouse.next()) {
                cy cy2 = new cy(this.mc);
                int n2 = Mouse.getEventX() * cy2.a() / this.mc.displayWidth;
                int n3 = cy2.b() - Mouse.getEventY() * cy2.b() / this.mc.displayHeight - 1;
                if (Mouse.getEventButton() == -1) {
                    b.a(Mouse.getEventDWheel() / 100 * 5);
                    b.a(n2, n3);
                    UIScreen.c[0] = n2;
                    UIScreen.c[1] = n3;
                    continue;
                }
                if (Mouse.getEventButtonState()) {
                    b.b(n2, n3, Mouse.getEventButton());
                    continue;
                }
                b.b(n2, n3);
            }
        }
    }
}

