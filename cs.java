/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.util.EnumHand
 */
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumHand;

public class cs {
    public static volatile cs a = new cs();

    public InventoryPlayer a() {
        return Wrapper.INSTANCE.getLocalPlayer().inventory;
    }

    public PlayerControllerMP b() {
        return Wrapper.INSTANCE.getMinecraft().playerController;
    }

    public void c() {
        Wrapper.INSTANCE.getLocalPlayer().swingArm(EnumHand.MAIN_HAND);
    }

    public void a(Entity entity) {
        a.b().attackEntity((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), entity);
    }

    public double d() {
        return Wrapper.INSTANCE.getLocalPlayer().posX;
    }

    public double e() {
        return Wrapper.INSTANCE.getLocalPlayer().posY;
    }

    public double f() {
        return Wrapper.INSTANCE.getLocalPlayer().posZ;
    }
}

