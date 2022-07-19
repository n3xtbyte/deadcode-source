/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.util.EnumHandSide
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.combat.KillAura;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class SwingAnimate
extends Hack {
    public DoubleValue a;
    public static BooleanValue b;
    public static BooleanValue c;
    public static BooleanValue d;
    public static ModeValue e;
    public static boolean f;
    public static d g;

    public SwingAnimate(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        e = new ModeValue("Mode", new Mode("Block", true), new Mode("Swing"), new Mode("Break"), new Mode("Tap"), new Mode("Slap"));
        this.a = new DoubleValue("Speed", 0.05, 0.02, 0.1);
        b = new BooleanValue("Left hand", false);
        c = new BooleanValue("Right hand", true);
        d = new BooleanValue("Only with KillAura", false);
        this.a(e, b, c, d, this.a);
        this.b("Other");
        g = new d(this.a.getValue());
    }

    @Override
    public String getDescription() {
        return "Show custom swing animations.";
    }

    @Override
    public void a(dc dc2) {
        g = new d(this.a.getValue());
        super.a(dc2);
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        f = true;
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onDisable() {
        f = false;
        super.onDisable();
    }

    public static boolean a(EnumHandSide enumHandSide) {
        return f && (enumHandSide == EnumHandSide.RIGHT && (Boolean)c.getObjectValue() != false || enumHandSide == EnumHandSide.LEFT && (Boolean)b.getObjectValue() != false) && ((Boolean)d.getObjectValue() == false || (Boolean)d.getObjectValue() != false && KillAura.J != null);
    }

    public static void a(EnumHandSide enumHandSide, float f2) {
        int n2 = enumHandSide == EnumHandSide.RIGHT ? 1 : -1;
        float f3 = MathHelper.sin((float)(f2 * f2 * (float)Math.PI));
        GlStateManager.rotate((float)((float)n2 * (45.0f + f3 * -20.0f)), (float)0.0f, (float)1.0f, (float)0.0f);
        float f4 = MathHelper.sin((float)(MathHelper.sqrt((float)f2) * (float)Math.PI));
        GlStateManager.rotate((float)-120.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)(-60.0f * f2), (float)1.0f, (float)0.0f, (float)0.0f);
    }

    public static void b(float f2) {
        float f3 = MathHelper.sin((float)(f2 * f2 * (float)Math.PI));
        float f4 = MathHelper.sin((float)(MathHelper.sqrt((float)f2) * (float)Math.PI));
        GlStateManager.translate((float)0.46f, (float)-0.3f, (float)-0.71999997f);
        GlStateManager.rotate((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(f3 * -20.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(f4 * -20.0f), (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.rotate((float)(f4 * -40.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.scale((float)0.5f, (float)0.5f, (float)0.5f);
        GlStateManager.translate((float)-0.5f, (float)0.2f, (float)0.0f);
        GlStateManager.rotate((float)30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)-80.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)60.0f, (float)0.0f, (float)1.0f, (float)0.0f);
    }

    public static void c(float f2) {
        float f3 = MathHelper.sin((float)(MathHelper.sqrt((float)f2) * (float)Math.PI));
        GlStateManager.translate((float)0.46f, (float)-0.3f, (float)-0.71999997f);
        GlStateManager.rotate((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(f3 * -40.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.scale((float)0.5f, (float)0.5f, (float)0.5f);
        GlStateManager.translate((float)-0.5f, (float)0.2f, (float)0.0f);
        GlStateManager.rotate((float)30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)-80.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)60.0f, (float)0.0f, (float)1.0f, (float)0.0f);
    }

    public static void d(float f2) {
        float f3 = f2 * 0.8f - f2 * f2 * 0.8f;
        GlStateManager.translate((float)0.56f, (float)-0.52f, (float)-0.71999997f);
        GlStateManager.translate((float)0.0f, (float)(f2 * -0.15f), (float)0.0f);
        GlStateManager.rotate((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(f3 * -90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.scale((float)0.37f, (float)0.37f, (float)0.37f);
        GlStateManager.translate((float)-0.5f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)-80.0f, (float)1.0f, (float)0.0f, (float)0.0f);
    }

    public static void e(float f2) {
        GlStateManager.translate((float)0.96f, (float)-0.02f, (float)-0.71999997f);
        GlStateManager.translate((float)0.0f, (float)-0.0f, (float)0.0f);
        GlStateManager.rotate((float)45.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        float f3 = MathHelper.sin((float)0.0f);
        float f4 = MathHelper.sin((float)(MathHelper.sqrt((float)0.0f) * (float)Math.PI));
        GlStateManager.rotate((float)(f3 * -20.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(f4 * -20.0f), (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.rotate((float)(f4 * -80.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.translate((float)-0.5f, (float)0.2f, (float)0.0f);
        GlStateManager.rotate((float)30.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)-80.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)60.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        int n2 = (int)Math.min(255L, System.currentTimeMillis() % 255L > 127L ? Math.abs(Math.abs(System.currentTimeMillis()) % 255L - 255L) : System.currentTimeMillis() % 255L);
        float f5 = (double)f2 > 0.5 ? 1.0f - f2 : f2;
        GlStateManager.translate((float)0.3f, (float)-0.0f, (float)0.4f);
        GlStateManager.rotate((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.translate((float)0.0f, (float)0.5f, (float)0.0f);
        GlStateManager.rotate((float)90.0f, (float)1.0f, (float)0.0f, (float)-1.0f);
        GlStateManager.translate((float)0.6f, (float)0.5f, (float)0.0f);
        GlStateManager.rotate((float)-90.0f, (float)1.0f, (float)0.0f, (float)-1.0f);
        GlStateManager.rotate((float)-10.0f, (float)1.0f, (float)0.0f, (float)-1.0f);
        GlStateManager.rotate((float)(-f5 * 10.0f), (float)10.0f, (float)10.0f, (float)-9.0f);
        GlStateManager.rotate((float)10.0f, (float)-1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.translate((double)0.0, (double)0.0, (double)-0.5);
        GlStateManager.rotate((float)(Wrapper.INSTANCE.getLocalPlayer().isSwingInProgress ? (float)(-n2) / 2.0f : 0.0f), (float)1.0f, (float)-0.0f, (float)1.0f);
        GlStateManager.translate((double)0.0, (double)0.0, (double)0.5);
    }
}

