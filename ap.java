/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketPlayerListItem$Action
 */
import net.minecraft.network.play.server.SPacketPlayerListItem;

public class ap {
    public static final /* synthetic */ int[] a;

    static {
        a = new int[SPacketPlayerListItem.Action.values().length];
        try {
            ap.a[SPacketPlayerListItem.Action.ADD_PLAYER.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ap.a[SPacketPlayerListItem.Action.REMOVE_PLAYER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

