/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  org.lwjgl.opengl.GL11
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.combat.AimBot;
import i.gishreloaded.deadcode.hacks.combat.BowAimBot;
import i.gishreloaded.deadcode.hacks.combat.KillAura;
import i.gishreloaded.deadcode.hacks.combat.TargetStrafe;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.utils.RaytraceUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.ColorValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class HUD
extends Hack {
    public static BooleanValue a;
    public static BooleanValue b;
    public ColorValue c;
    public BooleanValue d;
    public DoubleValue e;
    public IntegerValue f;
    public IntegerValue g;
    public static BooleanValue h;
    public BooleanValue i;
    public static BooleanValue j;
    public BooleanValue k;
    public static BooleanValue l;
    public BooleanValue m;
    public BooleanValue n;
    public BooleanValue o;
    public BooleanValue p;
    public BooleanValue q;
    public dr_0 r;
    public ColorValue s;
    public long t;
    public double u;
    public d v;
    public static boolean w;

    public HUD(String string) {
        super(string, HackCategory.Render);
        this.c(true);
        this.d(false);
        a = new BooleanValue("Glow", true);
        b = new BooleanValue("Shadow", true);
        this.c = new ColorValue("Main color", aX.i);
        this.d = new BooleanValue("Astolfo color", false);
        this.e = new DoubleValue("Astolfo intensity", 0.5, 0.1, 1.0);
        this.i = new BooleanValue("Target HUD", true);
        this.r = new dr_0("Target HUD Position", new eM(200, 200));
        this.s = new ColorValue("Target HUD Color", aX.i);
        j = new BooleanValue("Armor HUD", true);
        this.k = new BooleanValue("Array list", true);
        this.m = new BooleanValue("Watermark", true);
        h = new BooleanValue("Notifications", true);
        this.n = new BooleanValue("FPS info", false);
        this.o = new BooleanValue("BPS info", false);
        this.p = new BooleanValue("Coord info", false);
        this.q = new BooleanValue("Server info", false);
        l = new BooleanValue("Show binds", false);
        this.f = new IntegerValue("W-Offset", 5, 0, 20);
        this.g = new IntegerValue("A-Offset", 5, 0, 20);
        this.b("General");
        this.a(a, b);
        this.b("ArrayList");
        this.a(this.k, l, this.d, this.c, this.g, this.e);
        this.b("Target HUD");
        this.a(this.r, this.s, this.i);
        this.b("Watermark");
        this.a(this.m, this.n, this.o, this.p, this.q, this.f);
        this.b("Other");
        this.a(j, h);
        this.v = new d();
    }

    @Override
    public String getDescription() {
        return "Heads-Up Display.";
    }

    @Override
    public void a(float f2) {
        if (((Boolean)h.getObjectValue()).booleanValue()) {
            \u2007\u2008\u00a0.p.a();
        }
        if (((Boolean)this.i.getObjectValue()).booleanValue()) {
            this.a(((eM)this.r.getObjectValue()).a(), ((eM)this.r.getObjectValue()).b(), f2);
        }
        if (((Boolean)j.getObjectValue()).booleanValue()) {
            this.a((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer());
        } else {
            w = false;
        }
        if (((Boolean)this.k.getObjectValue()).booleanValue()) {
            this.b();
        }
        if (((Boolean)this.m.getObjectValue()).booleanValue()) {
            this.c();
        }
        super.a(f2);
    }

    public void b() {
        List list = HackManager.getSortedHacks();
        int n2 = 10;
        int n3 = 0;
        int n4 = 0;
        int n5 = this.g.getValue();
        int n6 = this.c.getValue();
        if (((Boolean)this.d.getObjectValue()).booleanValue()) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                n4 += 14;
            }
        }
        long l2 = System.currentTimeMillis();
        for (Hack hack : list) {
            if (hack.y != hack.y || hack.A != hack.A) {
                hack.m();
            }
            String string = hack.l();
            if (((Boolean)this.d.getObjectValue()).booleanValue()) {
                n6 = er.a(n3, n4, this.e.getValue().floatValue());
            }
            double d2 = hack.A + ((double)n3 - hack.A) * Math.pow((double)(l2 - hack.z) / 1000.0, 0.5);
            double d3 = hack.y + (0.0 - hack.y) * Math.pow((double)(l2 - hack.x) / 1000.0, 0.5);
            RenderUtils.a(string, (float)(d3 + (double)n5), (float)(d2 + (double)n5), n6, hack.v() + 3, n3 == 0 ? 0 : 3);
            hack.y = d3;
            hack.x = l2;
            hack.A = d2;
            hack.z = l2;
            n3 += n2;
        }
    }

    public void c() {
        int n2;
        int n3;
        int n4;
        String string;
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        int n5 = this.f.getValue();
        int n6 = 110;
        int n7 = 20;
        int n8 = 12;
        int n9 = scaledResolution.getScaledWidth() - n6 - n5;
        int n10 = n5;
        if (Wrapper.INSTANCE.getLocalPlayer().getActivePotionEffects().size() > 0) {
            n10 += 26;
        }
        int n11 = er.b(aX.f, 0.5f);
        String string2 = String.format("%s %s", "DeadCode".toUpperCase(), "3.8");
        if (((Boolean)b.getObjectValue()).booleanValue() && RenderUtils.a()) {
            ShaderManager.b().a(n9, n10, n9 + n6, n10 + n7, 8.0f, 2, n11);
        }
        RenderUtils.a((double)n9, (double)n10, (double)(n9 + n6), (double)(n10 + n7), n11);
        Wrapper.INSTANCE.g().a(string2, n9 + 4, n10 + 5, aX.h);
        n10 += 8;
        if (((Boolean)this.p.getObjectValue()).booleanValue()) {
            n10 += n8;
            string = String.format("x: %s y: %s z: %s", RenderUtils.a(Float.valueOf((float)entityPlayerSP.posX), 1), RenderUtils.a(Float.valueOf((float)entityPlayerSP.posY), 1), RenderUtils.a(Float.valueOf((float)entityPlayerSP.posZ), 1));
            n4 = Wrapper.INSTANCE.p().a(string);
            n3 = scaledResolution.getScaledWidth() - n4 - 4 - n5;
            n2 = scaledResolution.getScaledWidth() - n5;
            if (((Boolean)b.getObjectValue()).booleanValue() && RenderUtils.a()) {
                ShaderManager.b().a(n3, n10, n2, n10 + n8, 8.0f, 2, n11);
            }
            RenderUtils.a((double)n3, (double)n10, (double)n2, (double)(n10 + n8), n11);
            Wrapper.INSTANCE.p().a(string, n3 + 2, n10 + 3, aX.h);
        }
        if (((Boolean)this.q.getObjectValue()).booleanValue()) {
            n10 += n8;
            string = "server: " + (Wrapper.INSTANCE.getMinecraft().isSingleplayer() ? "singleplayer" : Wrapper.INSTANCE.getMinecraft().getCurrentServerData().serverIP.split(":")[0]);
            n4 = Wrapper.INSTANCE.p().a(string);
            n3 = scaledResolution.getScaledWidth() - n4 - 4 - n5;
            n2 = scaledResolution.getScaledWidth() - n5;
            if (((Boolean)b.getObjectValue()).booleanValue() && RenderUtils.a()) {
                ShaderManager.b().a(n3, n10, n2, n10 + n8, 8.0f, 2, n11);
            }
            RenderUtils.a((double)n3, (double)n10, (double)n2, (double)(n10 + n8), n11);
            Wrapper.INSTANCE.p().a(string, n3 + 2, n10 + 3, aX.h);
        }
        if (((Boolean)this.n.getObjectValue()).booleanValue()) {
            n10 += n8;
            string = "fps: " + Minecraft.getDebugFPS();
            n4 = Wrapper.INSTANCE.p().a(string);
            n3 = scaledResolution.getScaledWidth() - n4 - 4 - n5;
            n2 = scaledResolution.getScaledWidth() - n5;
            if (((Boolean)b.getObjectValue()).booleanValue() && RenderUtils.a()) {
                ShaderManager.b().a(n3, n10, n2, n10 + n8, 8.0f, 2, n11);
            }
            RenderUtils.a((double)n3, (double)n10, (double)n2, (double)(n10 + n8), n11);
            Wrapper.INSTANCE.p().a(string, n3 + 2, n10 + 3, aX.h);
        }
        if (((Boolean)this.o.getObjectValue()).booleanValue()) {
            double d2 = entityPlayerSP.posX - entityPlayerSP.prevPosX;
            double d3 = entityPlayerSP.posZ - entityPlayerSP.prevPosZ;
            float f2 = (float)Math.sqrt(d2 * d2 + d3 * d3);
            int n12 = Math.round(f2 * 15.5f);
            n10 += n8;
            String string3 = "bps: " + n12;
            int n13 = Wrapper.INSTANCE.p().a(string3);
            int n14 = scaledResolution.getScaledWidth() - n13 - 4 - n5;
            int n15 = scaledResolution.getScaledWidth() - n5;
            if (((Boolean)b.getObjectValue()).booleanValue() && RenderUtils.a()) {
                ShaderManager.b().a(n14, n10, n15, n10 + n8, 8.0f, 2, n11);
            }
            RenderUtils.a((double)n14, (double)n10, (double)n15, (double)(n10 + n8), n11);
            Wrapper.INSTANCE.p().a(string3, n14 + 2, n10 + 3, aX.h);
        }
    }

    public void a(int n2, int n3, float f2) {
        Entity entity = RaytraceUtils.b(50.0, f2);
        EntityLivingBase entityLivingBase = null;
        if (AimBot.e != null && !(AimBot.e instanceof EntityArmorStand)) {
            entityLivingBase = AimBot.e;
        }
        if (TargetStrafe.l != null && !(TargetStrafe.l instanceof EntityArmorStand)) {
            entityLivingBase = TargetStrafe.l;
        }
        if (BowAimBot.b != null && !(BowAimBot.b instanceof EntityArmorStand)) {
            entityLivingBase = BowAimBot.b;
        }
        if (KillAura.J != null && !(KillAura.J instanceof EntityArmorStand)) {
            entityLivingBase = KillAura.J;
        }
        if (entity != null && entity instanceof EntityLivingBase && !(entity instanceof EntityArmorStand)) {
            entityLivingBase = (EntityLivingBase)entity;
        }
        if (Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiChat || Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiContainer) {
            entityLivingBase = Wrapper.INSTANCE.getLocalPlayer();
        }
        if (entityLivingBase == null || entityLivingBase.isDead || entityLivingBase.deathTime > 0) {
            if (this.v.b() == 0.0) {
                this.t = System.currentTimeMillis();
                this.u = -25.0;
                this.v.a();
                return;
            }
            this.v.a(false);
        }
        this.a(entityLivingBase, n2, n3);
    }

    public void a(EntityLivingBase entityLivingBase, int n2, int n3) {
        int n4;
        float f2;
        int n5;
        int n6;
        int n7 = 9;
        int n8 = n2;
        int n9 = n3;
        String string = entityLivingBase == null ? "" : entityLivingBase.getName();
        int n10 = 30;
        int n11 = 30;
        int n12 = er.g;
        int n13 = this.s.getValue();
        int n14 = 75;
        int n15 = 0;
        int n16 = -11;
        int n17 = n14;
        int n18 = n7;
        int n19 = Wrapper.INSTANCE.f().a(string) + 6;
        int n20 = 0;
        boolean bl = entityLivingBase instanceof EntityPlayer;
        if (bl) {
            EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
            n6 = et.d(entityPlayer);
            n20 = 0;
            if (n6 > 0) {
                for (n5 = 0; n5 < n6; ++n5) {
                    n20 += 18;
                }
            }
            if (!et.a(entityPlayer.getHeldItemOffhand())) {
                n20 += 18;
            }
        }
        if (n19 > n17) {
            n17 = n19;
        }
        if (n20 > n17) {
            n17 = n20;
        }
        int n21 = n15 + n10 + n17;
        n6 = n11;
        n5 = 4;
        if (!bl) {
            n6 = n7;
        }
        int n22 = er.a(0, 0, 0, 75);
        n22 = er.b(n22, (float)(this.v.b() / 3.0));
        if (((Boolean)b.getObjectValue()).booleanValue() && RenderUtils.a()) {
            ShaderManager.b().a(n8 + -n5, n9 + n16 - n5, n8 + n10 + n17 + n5, n9 + n6 + n5, 10.0f, 3, n22);
        }
        RenderUtils.a((double)(n8 + -n5), (double)(n9 + n16 - n5), (double)(n8 + n10 + n17 + n5), (double)(n9 + n6 + n5), n22);
        int n23 = entityLivingBase == null ? 0 : entityLivingBase.hurtTime;
        float f3 = entityLivingBase == null ? 0.0f : entityLivingBase.getHealth();
        float f4 = f2 = entityLivingBase == null ? 0.0f : entityLivingBase.getMaxHealth();
        if (!bl) {
            RenderUtils.a(string, n8 + 2, n9 + 2, er.e);
        } else {
            RenderUtils.a(string, n8 + n10 + 4, n9 + 4, er.e);
        }
        String string2 = String.format("%s - %s", RenderUtils.a(Float.valueOf(f3), 1), RenderUtils.a(Float.valueOf(f2), 0));
        int n24 = er.h;
        if (n23 > 0) {
            n24 = er.a;
        }
        n24 = er.b(n24, (float)this.v.b());
        if (((Boolean)a.getObjectValue()).booleanValue() && RenderUtils.a()) {
            ShaderManager.b().a(n8 + n15, n9 + n16, n8 + n10 + n17, n9 + n16 + n18, 10.0f, 3, n24);
        }
        if (n23 > 0) {
            RenderUtils.a((double)(n8 + n15), (double)(n9 + n16), (double)(n8 + n10 + n17), (double)(n9 + n16 + n18), er.a(200, 55, 55, 200));
        } else if (f3 < f2) {
            RenderUtils.a((double)(n8 + n15), (double)(n9 + n16), (double)(n8 + n10 + n17), (double)(n9 + n16 + n18), n24);
        }
        if ((double)f3 > 0.0) {
            double d2 = (double)f3 / (double)f2;
            n4 = (int)((double)n21 * d2);
            if (n4 > n21) {
                n4 = n21;
            }
            long l2 = System.currentTimeMillis();
            double d3 = this.u + ((double)n4 - this.u) * Math.pow((double)(l2 - this.t) / 455.0, 0.5);
            if (((Boolean)a.getObjectValue()).booleanValue() && RenderUtils.a()) {
                int n25 = er.b(n13, 0.8f);
                ShaderManager.b().a(n8 + n15, n9 + n16, (float)((double)(n8 + n15) + d3), n9 + n16 + n18, 12.0f, 3, n25);
            }
            RenderUtils.a((double)(n8 + n15), (double)(n9 + n16), (double)(n8 + n15) + d3, (double)(n9 + n16 + n18), n13);
            this.u = d3;
            this.t = l2;
        }
        if (bl && ((Boolean)a.getObjectValue()).booleanValue() && RenderUtils.a()) {
            ShaderManager.b().a(n8, n9 + 2, n8 + n10, n9 + 2 + n11, 10.0f, 3, er.a(0, 0, 0, 155));
        }
        RenderUtils.a(string2, n8 + 2, n9 + n16 + 1, n12);
        if (bl) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)n8, (float)n9, (float)0.0f);
            EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
            int n26 = 33;
            n4 = 15;
            float f5 = 0.7f;
            GL11.glScalef((float)f5, (float)f5, (float)f5);
            RenderUtils.a(entityPlayer, n26, n4, 1);
            NetworkPlayerInfo networkPlayerInfo = Wrapper.INSTANCE.getMinecraft().getConnection().getPlayerInfo(entityPlayer.getName());
            if (networkPlayerInfo != null) {
                Wrapper.INSTANCE.getMinecraft().getTextureManager().bindTexture(networkPlayerInfo.getLocationSkin());
                int n27 = n10 + 13;
                int n28 = n11 + 13;
                Gui.drawScaledCustomSizeModalRect((int)0, (int)2, (float)8.0f, (float)8.0f, (int)8, (int)8, (int)n27, (int)n28, (float)64.0f, (float)64.0f);
            }
            GlStateManager.popMatrix();
        }
        if (entityLivingBase == null) {
            return;
        }
        this.v.a(true);
    }

    public void a(EntityPlayer entityPlayer) {
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        int n2 = 22;
        int n3 = scaledResolution.getScaledWidth() - 102;
        int n4 = scaledResolution.getScaledHeight() - 2;
        int n5 = 0;
        int n6 = er.b(aX.f, 0.5f);
        if (HUD.d()) {
            n4 -= 14;
        }
        n3 -= n2 + 2;
        for (ItemStack itemStack : entityPlayer.inventory.armorInventory) {
            if (itemStack == null || itemStack.isEmpty() || itemStack.getItem() == Items.AIR) continue;
            int n7 = n3 - 90 + (9 - ++n5) * 24;
            float f2 = ((float)itemStack.getMaxDamage() - (float)itemStack.getItemDamage()) / (float)itemStack.getMaxDamage();
            float f3 = 1.0f - f2;
            int n8 = 100 - (int)(f3 * 100.0f);
            String string = "" + n8;
            if (n8 < 100) {
                string = string + "%";
            }
            int n9 = (int)((float)n2 * f2);
            RenderUtils.a((double)n7, (double)n4, (double)(n7 + n2), (double)(n4 - n2 - 9), 1.0f, er.a(0, 0, 0, 55), n6);
            if (itemStack.getMaxDamage() > 0) {
                RenderUtils.a((double)n7, (double)n4, (double)(n7 + n9), (double)(n4 - n2 - 9), n6);
                RenderUtils.a(string, n7 + 2, n4 - 28, er.e);
            }
            RenderUtils.a(itemStack, n7 + 2, n4 - 2);
        }
        w = n5 > 0;
    }

    public static boolean d() {
        return Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiChat;
    }
}

