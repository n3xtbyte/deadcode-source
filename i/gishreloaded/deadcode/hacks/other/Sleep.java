/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.block.model.ModelManager
 *  net.minecraft.client.renderer.color.ItemColors
 *  org.lwjgl.opengl.Display
 */
package i.gishreloaded.deadcode.hacks.other;

import i.gishreloaded.EventsHandler;
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.managers.MappingManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.color.ItemColors;
import org.lwjgl.opengl.Display;

public class Sleep
extends Hack {
    public static boolean a = false;
    public BooleanValue b;

    public Sleep(String string) {
        super(string, HackCategory.Other);
        this.b("General");
        this.b = new BooleanValue("Clear traces", false);
        this.a(this.b);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Disable all hacks.";
    }

    @Override
    public void onEnable() {
        if (this.getKey() == -1) {
            ChatUtils.info("You need to bind this hack.");
            this.c(false);
            return;
        }
        a = true;
        Wrapper.INSTANCE.getMinecraft().entityRenderer = EventsHandler.a != null ? EventsHandler.a : new EntityRenderer(Wrapper.INSTANCE.getMinecraft(), Wrapper.INSTANCE.getMinecraft().getResourceManager());
        try {
            Field field = Minecraft.class.getDeclaredField(MappingManager.fieldItemColors);
            field.setAccessible(true);
            Field field2 = Minecraft.class.getDeclaredField(MappingManager.fieldModelChanger);
            field2.setAccessible(true);
            Field field3 = Minecraft.class.getDeclaredField(MappingManager.fieldRenderItem);
            field3.setAccessible(true);
            ModelManager modelManager = (ModelManager)field2.get(Wrapper.INSTANCE.getMinecraft());
            ItemColors itemColors = (ItemColors)field.get(Wrapper.INSTANCE.getMinecraft());
            RenderItem renderItem = new RenderItem(Wrapper.INSTANCE.getMinecraft().getTextureManager(), modelManager, itemColors);
            field3.set(Wrapper.INSTANCE.getMinecraft(), renderItem);
            Field field4 = GuiIngame.class.getDeclaredField(MappingManager.fieldItemRenderer);
            field4.setAccessible(true);
            Field field5 = Field.class.getDeclaredField("modifiers");
            field5.setAccessible(true);
            field5.setInt(field4, field4.getModifiers() & 0xFFFFFFEF);
            field4.set(Wrapper.INSTANCE.getMinecraft().ingameGUI, renderItem);
        }
        catch (Exception exception) {
            ChatUtils.exception("HookSleep: ", exception);
        }
        Wrapper.INSTANCE.getMinecraft().ingameGUI.getChatGUI().clearChatMessages(true);
        RenderUtils.c();
        RenderUtils.e.clear();
        RenderUtils.d.clear();
        EventsHandler.a();
        Display.setTitle((String)\u2007\u2008\u00a0.d);
        if (((Boolean)this.b.getObjectValue()).booleanValue()) {
            \u2001\u2001.super();
        }
        System.gc();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        a = false;
        super.onDisable();
    }
}

