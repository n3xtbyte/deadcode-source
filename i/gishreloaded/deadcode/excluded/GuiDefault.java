/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.input.Keyboard
 */
package i.gishreloaded.deadcode.excluded;

import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

public class GuiDefault
extends GuiScreen {
    public static boolean a = true;
    private aB b = new aB(200L, false);

    public GuiDefault() {
        a = false;
    }

    public void initGui() {
        Keyboard.enableRepeatEvents((boolean)true);
        if (!Wrapper.INSTANCE.getMinecraft().entityRenderer.isShaderActive()) {
            Wrapper.INSTANCE.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        }
        super.initGui();
    }

    public void updateScreen() {
        super.updateScreen();
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents((boolean)false);
        if (Wrapper.INSTANCE.getMinecraft().entityRenderer.isShaderActive()) {
            Wrapper.INSTANCE.getMinecraft().entityRenderer.stopUseShader();
        }
        super.onGuiClosed();
    }

    public void drawScreen(int n2, int n3, float f2) {
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        ShaderManager.d().a(0.0, 0.0, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight());
        RenderUtils.a(0.0, 0.0, (double)scaledResolution.getScaledWidth(), (double)scaledResolution.getScaledHeight(), er.a(0, 0, 0, 185));
        String string = "DeadCode";
        if (this.b.b().equals(string)) {
            string = this.b.c();
        }
        RenderUtils.a(string, null, er.e, er.e, 4.0f, 0, 0);
        RenderUtils.d("Coded by Gish_Reloaded", er.i, 0, 0);
        if (this.b.b().equals("null") || this.b.a() && RenderUtils.b()) {
            this.b.a(string);
        }
        this.b.d();
    }

    public void handleInput() {
        try {
            this.handleKeyboard();
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
                    if (!Keyboard.getEventKeyState() || Keyboard.getEventKey() != 1) continue;
                    this.mc.displayGuiScreen(null);
                }
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("GuiDefault: handleKeyboard", exception);
        }
    }
}

