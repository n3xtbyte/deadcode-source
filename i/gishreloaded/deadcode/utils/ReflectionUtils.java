/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  org.apache.commons.lang3.reflect.FieldUtils
 */
package i.gishreloaded.deadcode.utils;

import i.gishreloaded.deadcode.managers.MappingManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.apache.commons.lang3.reflect.FieldUtils;

public class ReflectionUtils {
    public static void resetJumpTicks() {
        try {
            Field field = EntityLivingBase.class.getDeclaredField(MappingManager.fieldJumpTicks);
            field.setAccessible(true);
            field.setInt(Wrapper.INSTANCE.getLocalPlayer(), 0);
        }
        catch (Exception exception) {
            ChatUtils.exception("ReflectUtils: resetJumpTicks: ", exception);
        }
    }

    public static void setSpeedInAir(float f2) {
        try {
            Field field = EntityPlayer.class.getDeclaredField(MappingManager.fieldSpeedInAir);
            field.setAccessible(true);
            field.setFloat(Wrapper.INSTANCE.getLocalPlayer(), f2);
        }
        catch (Exception exception) {
            ChatUtils.exception("ReflectUtils: setSpeedInAir", exception);
        }
    }

    private static /* synthetic */ Object[] getTimer() {
        Class<Minecraft> clazz = Minecraft.class;
        try {
            Field field = clazz.getDeclaredField(MappingManager.fieldTimer);
            field.setAccessible(true);
            FieldUtils.removeFinalModifier((Field)field);
            Object object = field.get(Wrapper.INSTANCE.getMinecraft());
            Class<?> clazz2 = object.getClass();
            Field field2 = clazz2.getDeclaredField(MappingManager.fieldTickLength);
            return new Object[]{field2, object};
        }
        catch (Exception exception) {
            ChatUtils.exception("ReflectUtils: getObjects", exception);
            return null;
        }
    }

    public static float getTimerSpeed() {
        try {
            Object[] objectArray = ReflectionUtils.getTimer();
            Field field = (Field)objectArray[0];
            field.setAccessible(true);
            return field.getFloat(objectArray[1]);
        }
        catch (Exception exception) {
            ChatUtils.exception("ReflectUtils: getTimerSpeed", exception);
            return 0.0f;
        }
    }

    public static void setTimerSpeedF(float f2) {
        try {
            Object[] objectArray = ReflectionUtils.getTimer();
            Field field = (Field)objectArray[0];
            field.setAccessible(true);
            field.setFloat(objectArray[1], 50.0f / f2);
        }
        catch (Exception exception) {
            ChatUtils.exception("ReflectUtils: setTimerSpeed", exception);
        }
    }

    public static void setTimerSpeedD(double d2) {
        try {
            Object[] objectArray = ReflectionUtils.getTimer();
            Field field = (Field)objectArray[0];
            field.setAccessible(true);
            field.setFloat(objectArray[1], (float)(50.0 / d2));
        }
        catch (Exception exception) {
            ChatUtils.exception("ReflectUtils: setTimerSpeed", exception);
        }
    }
}

