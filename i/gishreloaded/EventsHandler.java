/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.client.gui.GuiNewChat
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.block.model.ModelManager
 *  net.minecraft.client.renderer.color.ItemColors
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.client.GuiIngameForge
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.client.event.ScreenshotEvent
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingJumpEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.event.entity.player.EntityItemPickupEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$MouseInputEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  net.minecraftforge.fml.common.network.FMLNetworkEvent$ClientConnectedToServerEvent
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.Display
 */
package i.gishreloaded;

import excluded.g;
import excluded.j;
import i.gishreloaded.deadcode.excluded.EntityRendererHook;
import i.gishreloaded.deadcode.excluded.FontRendererHook;
import i.gishreloaded.deadcode.excluded.GuiDefault;
import i.gishreloaded.deadcode.excluded.UIScreen;
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hacks.exploit.VClip;
import i.gishreloaded.deadcode.hacks.other.Debug;
import i.gishreloaded.deadcode.hacks.other.Sleep;
import i.gishreloaded.deadcode.hacks.render.Ambience;
import i.gishreloaded.deadcode.hacks.render.AntiBadEffects;
import i.gishreloaded.deadcode.hacks.render.CameraClip;
import i.gishreloaded.deadcode.hacks.render.CustomChat;
import i.gishreloaded.deadcode.hacks.render.CustomFog;
import i.gishreloaded.deadcode.hacks.render.CustomRain;
import i.gishreloaded.deadcode.hacks.render.CustomSnow;
import i.gishreloaded.deadcode.hacks.render.EnchantColor;
import i.gishreloaded.deadcode.hacks.render.Item360;
import i.gishreloaded.deadcode.hacks.render.NightVision;
import i.gishreloaded.deadcode.hacks.render.NoHurtCam;
import i.gishreloaded.deadcode.hacks.render.SwingAnimate;
import i.gishreloaded.deadcode.hacks.render.Tracers;
import i.gishreloaded.deadcode.hacks.render.ViewModel;
import i.gishreloaded.deadcode.hacks.render.WaterVision;
import i.gishreloaded.deadcode.hacks.render.WeatherClear;
import i.gishreloaded.deadcode.hacks.render.Zoom;
import i.gishreloaded.deadcode.hacks.world.NoInteract;
import i.gishreloaded.deadcode.managers.CommandManager;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.managers.MappingManager;
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.ScreenshotEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class EventsHandler {
    public static EntityRenderer a;
    public static boolean b;

    public EventsHandler() {
        \u2007\u2008\u00a0.d = Display.getTitle();
        ChatUtils.debug("EventsHandler: initialized.");
    }

    public boolean a(Object object, bw bw2) {
        boolean bl = true;
        if (Sleep.a) {
            return bl;
        }
        ef.a(object, bw2);
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            bl &= hack.a(object, bw2);
        }
        return bl &= bn.a(object);
    }

    public void a(FMLNetworkEvent.ClientConnectedToServerEvent clientConnectedToServerEvent) {
        try {
            \u2007\u2008\u00a0.h.if(new \u200a\u00a0\u00a0(\u2007\u2008\u00a0.u.if()));
        }
        catch (Exception exception) {
            \u2001\u2001.true();
        }
        RenderUtils.e.clear();
        try {
            HackManager.a(clientConnectedToServerEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onClientConnectedToServer", runtimeException);
        }
    }

    public void a(PlayerSPPushOutOfBlocksEvent playerSPPushOutOfBlocksEvent) {
        if (et.a() || Sleep.a) {
            return;
        }
        try {
            HackManager.a(playerSPPushOutOfBlocksEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onPlayerSPPushOutOfBlocksEvent", runtimeException);
        }
    }

    public void a(LivingEntityUseItemEvent livingEntityUseItemEvent) {
        if (et.a() || Sleep.a) {
            return;
        }
        try {
            HackManager.a(livingEntityUseItemEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onLivingJump", runtimeException);
        }
    }

    public void a(LivingEvent.LivingJumpEvent livingJumpEvent) {
        if (et.a() || Sleep.a) {
            return;
        }
        try {
            HackManager.a(livingJumpEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onLivingJump", runtimeException);
        }
    }

    public void a(GuiOpenEvent guiOpenEvent) {
        if (et.a() || Sleep.a) {
            return;
        }
        try {
            HackManager.a(guiOpenEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onGuiOpen", runtimeException);
        }
    }

    public void a(InputEvent.MouseInputEvent mouseInputEvent) {
        if (et.a()) {
            return;
        }
        try {
            if (Mouse.getEventButtonState()) {
                int n2 = Mouse.getEventButton();
                HackManager.a(n2);
            }
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onMouseInput", runtimeException);
        }
    }

    public void a(InputEvent.KeyInputEvent keyInputEvent) {
        if (et.a()) {
            return;
        }
        try {
            if (Keyboard.getEventKeyState()) {
                int n2 = Keyboard.getEventKey();
                CommandManager.a(n2);
                HackManager.b(n2);
            }
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onKeyInput", runtimeException);
        }
    }

    public void a(InputUpdateEvent inputUpdateEvent) {
        if (et.a() || Sleep.a) {
            return;
        }
        try {
            HackManager.a(inputUpdateEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onInputUpdate", runtimeException);
        }
    }

    public void a(EntityItemPickupEvent entityItemPickupEvent) {
        if (et.a() || Sleep.a) {
            return;
        }
        try {
            HackManager.a(entityItemPickupEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onItemPickup", runtimeException);
        }
    }

    public void a(TickEvent.PlayerTickEvent playerTickEvent) {
        if (et.a() || Sleep.a) {
            return;
        }
        try {
            HackManager.a(playerTickEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onPlayerTick", runtimeException);
        }
    }

    public static void a() {
        Debug.toggled = false;
        CustomChat.a = false;
        NightVision.a = false;
        SwingAnimate.f = false;
        WeatherClear.a = false;
        Tracers.e = false;
        Item360.a = false;
        EnchantColor.a = false;
        AntiBadEffects.a = false;
        WaterVision.a = false;
        NoInteract.a = false;
        Zoom.a = false;
        ViewModel.a = false;
        NoHurtCam.a = false;
        CameraClip.a = false;
        CustomFog.a = false;
        CustomRain.a = false;
        CustomSnow.a = false;
        Ambience.a = false;
        GuiIngameForge.renderCrosshairs = true;
    }

    public void a(ScreenshotEvent screenshotEvent) {
        if (et.a() || Sleep.a) {
            return;
        }
        try {
            HackManager.a(screenshotEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onScreenshotEvent", runtimeException);
        }
    }

    public void a(TickEvent.ClientTickEvent clientTickEvent) {
        try {
            fE.a();
            \u2007\u2008\u00a0.n.a(true);
            \u2007\u2008\u00a0.o.a();
            \u2007\u2008\u00a0.q.a();
            if (!Sleep.a) {
                Display.setTitle((String)"DeadCode 3.8");
            }
            if (et.a()) {
                b = false;
                return;
            }
            if (!b) {
                new cw(this);
                ShaderManager.a();
                \u2007\u2008\u00a0.n.b();
                \u2007\u2008\u00a0.o.b();
                GuiIngameForge.renderVignette = false;
                b = true;
            }
            if (\u2007\u2008\u00a0.l != null && !(Wrapper.INSTANCE.getMinecraft().fontRenderer instanceof FontRendererHook)) {
                Wrapper.INSTANCE.getMinecraft().fontRenderer = new FontRendererHook(Wrapper.INSTANCE.getGameSettings(), new ResourceLocation("textures/font/ascii.png"), Wrapper.INSTANCE.getMinecraft().renderEngine, false);
            }
            if (RenderUtils.f == null && Wrapper.INSTANCE.getMinecraft().getRenderItem() != null) {
                RenderUtils.f = Wrapper.INSTANCE.getMinecraft().getRenderItem();
            }
            if (!Sleep.a && Wrapper.INSTANCE.getMinecraft().getResourceManager() != null && !(Wrapper.INSTANCE.getMinecraft().entityRenderer instanceof EntityRendererHook)) {
                a = Wrapper.INSTANCE.getMinecraft().entityRenderer;
                try {
                    Field field = Minecraft.class.getDeclaredField(MappingManager.fieldItemColors);
                    field.setAccessible(true);
                    Field field2 = Minecraft.class.getDeclaredField(MappingManager.fieldModelChanger);
                    field2.setAccessible(true);
                    Field field3 = Minecraft.class.getDeclaredField(MappingManager.fieldRenderItem);
                    field3.setAccessible(true);
                    ModelManager modelManager = (ModelManager)field2.get(Wrapper.INSTANCE.getMinecraft());
                    ItemColors itemColors = (ItemColors)field.get(Wrapper.INSTANCE.getMinecraft());
                    j j2 = new j(Wrapper.INSTANCE.getMinecraft().getTextureManager(), modelManager, itemColors);
                    field3.set(Wrapper.INSTANCE.getMinecraft(), (Object)j2);
                    Field field4 = GuiIngame.class.getDeclaredField(MappingManager.fieldItemRenderer);
                    field4.setAccessible(true);
                    Field field5 = Field.class.getDeclaredField("modifiers");
                    field5.setAccessible(true);
                    field5.setInt(field4, field4.getModifiers() & 0xFFFFFFEF);
                    field4.set(Wrapper.INSTANCE.getMinecraft().ingameGUI, (Object)j2);
                    Field field6 = null;
                    for (Field field7 : GuiIngame.class.getDeclaredFields()) {
                        field7.setAccessible(true);
                        if (!(field7.get(Wrapper.INSTANCE.getMinecraft().ingameGUI) instanceof GuiNewChat)) continue;
                        field6 = field7;
                        break;
                    }
                    if (field6 != null) {
                        g g2 = new g(Wrapper.INSTANCE.getMinecraft());
                        field5 = Field.class.getDeclaredField("modifiers");
                        field5.setAccessible(true);
                        field5.setInt(field6, field6.getModifiers() & 0xFFFFFFEF);
                        field6.set(Wrapper.INSTANCE.getMinecraft().ingameGUI, (Object)g2);
                    } else {
                        ChatUtils.error("Field GuiNewChat not found!");
                    }
                }
                catch (Exception exception) {
                    ChatUtils.exception("HookInit: ", exception);
                }
                Wrapper.INSTANCE.getMinecraft().entityRenderer = new EntityRendererHook(Wrapper.INSTANCE.getMinecraft(), Wrapper.INSTANCE.getMinecraft().getResourceManager());
            }
            VClip.b();
            if (!(Wrapper.INSTANCE.getMinecraft().currentScreen instanceof UIScreen)) {
                HackManager.getHack("UserInterface").c(false);
            }
            if (!Sleep.a) {
                HackManager.a(clientTickEvent);
            }
            if (GuiDefault.a && Wrapper.INSTANCE.getMinecraft().currentScreen == null) {
                Wrapper.INSTANCE.getMinecraft().displayGuiScreen((GuiScreen)new GuiDefault());
            }
            if (RenderUtils.e.size() > 2000) {
                ChatUtils.debug("String cache has been cleared!");
                RenderUtils.e.clear();
            }
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onClientTick", runtimeException);
        }
    }

    public void a(LivingEvent.LivingUpdateEvent livingUpdateEvent) {
        if (et.a() || Sleep.a) {
            return;
        }
        try {
            HackManager.a(livingUpdateEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onLivingUpdate", runtimeException);
        }
    }

    public void a(RenderWorldLastEvent renderWorldLastEvent) {
        if (et.a() || Sleep.a || Wrapper.INSTANCE.getGameSettings().hideGUI) {
            return;
        }
        try {
            HackManager.a(renderWorldLastEvent);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onRenderWorldLast", runtimeException);
        }
    }

    public void a(float f2) {
        if (et.a() || Sleep.a) {
            return;
        }
        try {
            HackManager.a(f2);
        }
        catch (RuntimeException runtimeException) {
            ChatUtils.fatalexception("RuntimeException: onRenderGameOverlay", runtimeException);
        }
    }
}

