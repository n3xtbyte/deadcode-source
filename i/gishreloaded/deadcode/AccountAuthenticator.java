/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.Agent
 *  com.mojang.authlib.exceptions.AuthenticationException
 *  com.mojang.authlib.exceptions.AuthenticationUnavailableException
 *  com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService
 *  com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.Session
 */
package i.gishreloaded.deadcode;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import i.gishreloaded.deadcode.managers.MappingManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import java.net.Proxy;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

public class AccountAuthenticator {
    public static String a(String string, String string2) {
        YggdrasilAuthenticationService yggdrasilAuthenticationService = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
        YggdrasilUserAuthentication yggdrasilUserAuthentication = (YggdrasilUserAuthentication)yggdrasilAuthenticationService.createUserAuthentication(Agent.MINECRAFT);
        yggdrasilUserAuthentication.setUsername(string);
        yggdrasilUserAuthentication.setPassword(string2);
        String string3 = null;
        try {
            yggdrasilUserAuthentication.logIn();
            try {
                Field field = Minecraft.class.getDeclaredField(MappingManager.fieldSession);
                field.setAccessible(true);
                Field field2 = Field.class.getDeclaredField("modifiers");
                field2.setAccessible(true);
                field2.setInt(field, field.getModifiers() & 0xFFFFFFEF);
                field.set(Wrapper.INSTANCE.getMinecraft(), new Session(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang"));
                string3 = "Logged [License]: " + Wrapper.INSTANCE.getMinecraft().getSession().getUsername();
            }
            catch (Exception exception) {
                string3 = "Unknown error.";
                ChatUtils.exception("AuthUtils: login", exception);
            }
        }
        catch (AuthenticationUnavailableException authenticationUnavailableException) {
            string3 = "Cannot contact authentication server!";
        }
        catch (AuthenticationException authenticationException) {
            string3 = authenticationException.getMessage().contains("Invalid username or password.") || authenticationException.getMessage().toLowerCase().contains("account migrated") ? "Wrong password!" : "Cannot contact authentication server!";
        }
        catch (NullPointerException nullPointerException) {
            string3 = "Wrong password!";
        }
        return string3;
    }

    public static String b(String string, String string2) {
        YggdrasilAuthenticationService yggdrasilAuthenticationService = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
        YggdrasilUserAuthentication yggdrasilUserAuthentication = (YggdrasilUserAuthentication)yggdrasilAuthenticationService.createUserAuthentication(Agent.MINECRAFT);
        yggdrasilUserAuthentication.setUsername(string);
        yggdrasilUserAuthentication.setPassword(string2);
        try {
            yggdrasilUserAuthentication.logIn();
            return yggdrasilUserAuthentication.getSelectedProfile().getName();
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static void a(String string) {
        try {
            Field field = Minecraft.class.getDeclaredField(MappingManager.fieldSession);
            field.setAccessible(true);
            Field field2 = Field.class.getDeclaredField("modifiers");
            field2.setAccessible(true);
            field2.setInt(field, field.getModifiers() & 0xFFFFFFEF);
            field.set(Wrapper.INSTANCE.getMinecraft(), new Session(string, "", "", "mojang"));
        }
        catch (Exception exception) {
            ChatUtils.exception("AuthUtils: changeCrackedName", exception);
        }
    }
}

