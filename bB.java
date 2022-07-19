/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.wrappers.Wrapper;

public class bB {
    public static boolean a() {
        return Wrapper.INSTANCE.getMinecraft().getCurrentServerData() != null && Wrapper.INSTANCE.getMinecraft().getCurrentServerData().serverIP.contains("sunmc.ru");
    }

    public static boolean b() {
        return Wrapper.INSTANCE.getMinecraft().getCurrentServerData() != null && Wrapper.INSTANCE.getMinecraft().getCurrentServerData().serverIP.contains("reallyworld.ru");
    }
}

