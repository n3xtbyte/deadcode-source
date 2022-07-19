/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.GameType
 *  net.minecraftforge.fml.relauncher.ReflectionHelper
 */
import excluded.i;
import i.gishreloaded.deadcode.managers.MappingManager;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.world.GameType;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class f {
    public static void a(Entity entity, double d2) {
        Minecraft minecraft = Wrapper.INSTANCE.getMinecraft();
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (entityPlayerSP == entity) {
            if (!(minecraft.playerController instanceof i)) {
                GameType gameType = (GameType)ReflectionHelper.getPrivateValue(PlayerControllerMP.class, (Object)minecraft.playerController, (String[])new String[]{MappingManager.fieldCurrentGameType});
                NetHandlerPlayClient netHandlerPlayClient = (NetHandlerPlayClient)ReflectionHelper.getPrivateValue(PlayerControllerMP.class, (Object)minecraft.playerController, (String[])new String[]{MappingManager.fieldConnection});
                i i2 = new i(minecraft, netHandlerPlayClient);
                boolean bl = entityPlayerSP.capabilities.isFlying;
                boolean bl2 = entityPlayerSP.capabilities.allowFlying;
                i2.setGameType(gameType);
                entityPlayerSP.capabilities.isFlying = bl;
                entityPlayerSP.capabilities.allowFlying = bl2;
                minecraft.playerController = i2;
            }
            ((i)minecraft.playerController).a((float)d2);
        }
    }

    public static void a(boolean bl) {
        try {
            Field field = PlayerControllerMP.class.getDeclaredField(MappingManager.fieldIsHittingBlock);
            field.setAccessible(true);
            field.setBoolean(cs.a.b(), bl);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static void a(int n2) {
        try {
            Field field = PlayerControllerMP.class.getDeclaredField(MappingManager.fieldBlockHitDelay);
            field.setAccessible(true);
            field.setInt(cs.a.b(), n2);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static float a() {
        float f2 = 0.0f;
        try {
            Field field = PlayerControllerMP.class.getDeclaredField(MappingManager.fieldCurrentBlockDamageMP);
            field.setAccessible(true);
            f2 = field.getFloat(cs.a.b());
        }
        catch (Exception exception) {
            // empty catch block
        }
        return f2;
    }
}

