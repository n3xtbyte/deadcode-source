/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentTranslation
 */
package i.gishreloaded.deadcode.utils.visual;

import i.gishreloaded.EventsHandler;
import i.gishreloaded.deadcode.excluded.UIScreen;
import i.gishreloaded.deadcode.hacks.other.Debug;
import i.gishreloaded.deadcode.hacks.other.Sleep;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class ChatUtils {
    private static /* synthetic */ void component(ITextComponent iTextComponent) {
        if (et.a() || Wrapper.INSTANCE.getMinecraft().ingameGUI.getChatGUI() == null || Sleep.a || !EventsHandler.b) {
            ChatUtils.a(iTextComponent.getFormattedText());
            return;
        }
        ChatUtils.a(iTextComponent.getFormattedText());
        Wrapper.INSTANCE.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("", new Object[0]).appendSibling(iTextComponent));
    }

    private static /* synthetic */ void message(String string) {
        if (!(Wrapper.INSTANCE.getMinecraft().currentScreen instanceof UIScreen)) {
            ChatUtils.component((ITextComponent)new TextComponentTranslation("\u00a7f " + string, new Object[0]));
            return;
        }
        if (\u2007\u2008\u00a0.s == null) {
            return;
        }
        if (\u2007\u2008\u00a0.s.if() == null) {
            return;
        }
        if (\u2007\u2008\u00a0.s.if().k() == null) {
            return;
        }
        if (\u2007\u2008\u00a0.s.if().k().f() == null) {
            return;
        }
        \u2007\u2008\u00a0.s.if().k().f().b(string);
    }

    public static void a(Object object) {
        if (\u2007\u2008\u00a0.e != null) {
            \u2007\u2008\u00a0.e.a(object);
        }
    }

    public static void a(Object object, Exception exception) {
        if (\u2007\u2008\u00a0.e != null) {
            \u2007\u2008\u00a0.e.a(object, exception);
        }
    }

    public static void info(Object object) {
        ChatUtils.message("\u00a79\u00a7lInfo \u00a77-> \u00a77" + object);
    }

    public static void warning(Object object) {
        ChatUtils.component((ITextComponent)new TextComponentTranslation("\u00a7f " + ("\u00a7e\u00a7lWarning \u00a77-> \u00a77" + object), new Object[0]));
    }

    public static void debug(Object object) {
        if (!Debug.toggled) {
            ChatUtils.a("\u00a76\u00a7lDebug \u00a77-> \u00a77" + object);
            return;
        }
        ChatUtils.component((ITextComponent)new TextComponentTranslation("\u00a7f " + ("\u00a76\u00a7lDebug \u00a77-> \u00a77" + object), new Object[0]));
    }

    public static void error(Object object) {
        ChatUtils.a("\u00a7l\u00a7cError \u00a77-> \u00a7c" + object);
        ChatUtils.message("\u00a7c\u00a7lError \u00a77-> \u00a7c" + object);
    }

    public static void fatalerror(Object object) {
        if (!Debug.toggled) {
            ChatUtils.a("\u00a74\u00a7lFatal-Error \u00a77-> \u00a74" + object);
            return;
        }
        ChatUtils.component((ITextComponent)new TextComponentTranslation("\u00a7f " + ("\u00a74\u00a7lFatal-Error \u00a77-> \u00a74" + object), new Object[0]));
    }

    public static void exception(Object object, Exception exception) {
        ChatUtils.error(object);
        ChatUtils.a("", exception);
    }

    public static void fatalexception(Object object, Exception exception) {
        ChatUtils.fatalerror(object);
        ChatUtils.a("", exception);
    }
}

