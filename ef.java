/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.client.CPacketPlayer
 */
import i.gishreloaded.deadcode.managers.MappingManager;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import net.minecraft.network.play.client.CPacketPlayer;

public class ef {
    private static double e;
    private static double f;
    private static double g;
    public static boolean a;
    private static double[] h;
    private static float i;
    private static float j;
    public static boolean b;
    private static float[] k;
    private static boolean l;
    public static boolean c;
    public static boolean d;

    public static boolean a(Object object, bw bw2) {
        if (object instanceof CPacketPlayer) {
            CPacketPlayer cPacketPlayer = (CPacketPlayer)object;
            try {
                Class<?> clazz = cPacketPlayer.getClass().getSuperclass();
                Field field = clazz.getDeclaredField(MappingManager.fieldPosX);
                field.setAccessible(true);
                Field field2 = clazz.getDeclaredField(MappingManager.fieldPosY);
                field2.setAccessible(true);
                Field field3 = clazz.getDeclaredField(MappingManager.fieldPosZ);
                field3.setAccessible(true);
                Field field4 = clazz.getDeclaredField(MappingManager.fieldMoving);
                field4.setAccessible(true);
                Field field5 = clazz.getDeclaredField(MappingManager.fieldOnGround);
                field5.setAccessible(true);
                Field field6 = clazz.getDeclaredField(MappingManager.fieldRotationYaw);
                field6.setAccessible(true);
                Field field7 = clazz.getDeclaredField(MappingManager.fieldRotationPitch);
                field7.setAccessible(true);
                Field field8 = clazz.getDeclaredField(MappingManager.fieldIsRotating);
                field8.setAccessible(true);
                if (a) {
                    field.setDouble(cPacketPlayer, e);
                    field2.setDouble(cPacketPlayer, f);
                    field3.setDouble(cPacketPlayer, g);
                    field4.setBoolean(cPacketPlayer, true);
                }
                if (b) {
                    field6.setFloat(cPacketPlayer, i);
                    field7.setFloat(cPacketPlayer, j);
                    field8.setBoolean(cPacketPlayer, true);
                }
                if (c) {
                    field5.setBoolean(cPacketPlayer, l);
                }
                d = field5.getBoolean(cPacketPlayer);
                if (field4.getBoolean(cPacketPlayer)) {
                    h = new double[]{field.getDouble(cPacketPlayer), field2.getDouble(cPacketPlayer), field3.getDouble(cPacketPlayer)};
                }
                if (field8.getBoolean(cPacketPlayer)) {
                    k = new float[]{field6.getFloat(cPacketPlayer), field7.getFloat(cPacketPlayer)};
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return true;
    }

    public static double a() {
        return h[0];
    }

    public static double b() {
        return h[1];
    }

    public static double c() {
        return h[2];
    }

    public static float d() {
        return k[0];
    }

    public static float e() {
        return k[1];
    }

    public static float[] f() {
        return k;
    }

    public static double[] g() {
        return h;
    }

    public static boolean h() {
        return d;
    }

    public static void a(boolean bl) {
        l = bl;
        c = true;
    }

    public static void a(double d2, double d3, double d4, float f2, float f3) {
        ef.a(d2, d3, d4);
        ef.a(f2, f3);
    }

    public static void a(float[] fArray) {
        ef.a(fArray[0], fArray[1]);
        Wrapper.INSTANCE.getLocalPlayer().renderYawOffset = ef.d();
        Wrapper.INSTANCE.getLocalPlayer().rotationYawHead = ef.d();
    }

    public static void a(float f2, float f3) {
        if (Double.isNaN(f2) || Double.isNaN(f3)) {
            return;
        }
        i = f2;
        j = f3;
        b = true;
    }

    public static void a(double d2, double d3, double d4) {
        if (Double.isNaN(d2) || Double.isNaN(d3) || Double.isNaN(d4)) {
            return;
        }
        e = d2;
        f = d3;
        g = d4;
        a = true;
    }

    public static void i() {
        ef.j();
        ef.k();
        ef.l();
    }

    public static void j() {
        b = false;
        i = 0.0f;
        j = 0.0f;
    }

    public static void k() {
        a = false;
        e = 0.0;
        f = 0.0;
        g = 0.0;
    }

    public static void l() {
        c = false;
        l = Wrapper.INSTANCE.getLocalPlayer().onGround;
    }

    static {
        h = new double[]{0.0, 0.0, 0.0};
        k = new float[]{0.0f, 0.0f};
    }
}

