/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Ordering
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.RenderLivingBase
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.texture.TextureUtil
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.client.resources.I18n
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.apache.commons.lang3.RandomUtils
 *  org.lwjgl.opengl.GL11
 */
package i.gishreloaded.deadcode.utils.visual;

import com.google.common.collect.Ordering;
import i.gishreloaded.deadcode.hacks.render.HUD;
import i.gishreloaded.deadcode.managers.ShaderManager;
import i.gishreloaded.deadcode.utils.MathUtils1;
import i.gishreloaded.deadcode.utils.shader.ShaderProgram;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.utils.visual.ColorUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import i.gishreloaded.deadcode.xray.XRayData;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;
import org.lwjgl.opengl.GL11;

public class RenderUtils {
    public static final String a = "&q";
    public static final String b = "\u00a7";
    private static final AxisAlignedBB g = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    public static final HashMap c = new HashMap();
    public static final HashMap d = new HashMap();
    public static final ArrayList e = new ArrayList();
    private static final bx_0[] h = new bx_0[]{new bx_0(Enchantments.PROTECTION, "P"), new bx_0(Enchantments.THORNS, "T"), new bx_0(Enchantments.SHARPNESS, "S"), new bx_0(Enchantments.FIRE_ASPECT, "F"), new bx_0(Enchantments.KNOCKBACK, "K"), new bx_0(Enchantments.UNBREAKING, "U"), new bx_0(Enchantments.POWER, "Pw"), new bx_0(Enchantments.INFINITY, "I"), new bx_0(Enchantments.PUNCH, "Ph")};
    public static RenderItem f;

    public static void a(String string, int n2, int n3, int n4) {
        Wrapper.INSTANCE.f().a(string, n2, n3, n4);
    }

    public static void b(String string, int n2, int n3, int n4) {
        Wrapper.INSTANCE.getFontRenderer().drawString(string, n2, n3, n4);
    }

    public static void c(String string, int n2, int n3, int n4) {
        Wrapper.INSTANCE.getFontRenderer().drawStringWithShadow(string, (float)n2, (float)n3, n4);
    }

    public static void a(String string, int n2, int n3, int n4, int n5) {
        RenderUtils.a((double)(n2 - 2), (double)(n3 - 2), (double)(n2 + Wrapper.INSTANCE.getFontRenderer().getStringWidth(string) + 2), (double)(n3 + Wrapper.INSTANCE.getFontRenderer().FONT_HEIGHT), n5);
        Wrapper.INSTANCE.getFontRenderer().drawString(string, n2, n3, n4);
    }

    public static void a(String string, int n2, int n3, int n4, int n5, int n6) {
        RenderUtils.a((double)n2, (double)n3, (double)(n2 + n6 + 1), (double)(n3 + Wrapper.INSTANCE.getFontRenderer().FONT_HEIGHT), n5);
        Wrapper.INSTANCE.getFontRenderer().drawString(string, n2 + 1, n3 + 1, n4);
    }

    public static void a(String string, float f2, float f3, int n2, int n3, int n4) {
        int n5 = er.b(aX.f, 0.5f);
        if (((Boolean)HUD.b.getObjectValue()).booleanValue() && RenderUtils.a()) {
            ShaderManager.b().a(f2, f3 + (float)n4, f2 + (float)n3, f3 + 10.0f, 7.0f, 3, n5);
        }
        RenderUtils.a(f2, (double)f3, (double)(f2 + (float)n3), (double)(f3 + 10.0f), n5);
        Wrapper.INSTANCE.p().a(string, f2 + 1.0f, f3 + 2.0f, n2);
    }

    public static boolean a(ShaderProgram shaderProgram) {
        return RenderUtils.a() && shaderProgram.h();
    }

    public static boolean a() {
        return Wrapper.INSTANCE.getGameSettings().guiScale == 2;
    }

    public static void a(String string, String string2, int n2, int n3, float f2, int n4, int n5) {
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(scaledResolution.getScaledWidth() / 2 + n4), (float)(scaledResolution.getScaledHeight() / 2 + n5), (float)0.0f);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.pushMatrix();
        GlStateManager.scale((float)f2, (float)f2, (float)f2);
        RenderUtils.b(string, -Wrapper.INSTANCE.getFontRenderer().getStringWidth(string) / 2, -10, n2);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.scale((float)(f2 / 2.0f), (float)(f2 / 2.0f), (float)(f2 / 2.0f));
        if (string2 != null) {
            RenderUtils.b(string2, -Wrapper.INSTANCE.getFontRenderer().getStringWidth(string2) / 2, 5, n3);
        }
        GlStateManager.popMatrix();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static void d(String string, int n2, int n3, int n4) {
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(scaledResolution.getScaledWidth() / 2 + n3), (float)(scaledResolution.getScaledHeight() / 2 + n4), (float)0.0f);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        RenderUtils.a(string, -Wrapper.INSTANCE.f().a(string) / 2, -4, n2);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static String a(Number number, int n2) {
        DecimalFormat decimalFormat = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        decimalFormat.setMaximumFractionDigits(n2);
        return decimalFormat.format(number);
    }

    public static boolean b() {
        return RandomUtils.nextInt((int)0, (int)40) == 10;
    }

    public static void a(ItemStack itemStack, int n2, int n3) {
        RenderItem renderItem = Wrapper.INSTANCE.getMinecraft().getRenderItem();
        GlStateManager.enableDepth();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.pushMatrix();
        float f2 = 1.0625f;
        GlStateManager.translate((float)n2, (float)n3, (float)0.0f);
        GlStateManager.scale((float)(1.1f / f2), (float)((f2 + 1.0f) / 2.0f), (float)1.0f);
        GlStateManager.translate((float)(-n2), (float)(-(n3 + 16)), (float)0.0f);
        renderItem.zLevel = 200.0f;
        renderItem.renderItemAndEffectIntoGUI((EntityLivingBase)Wrapper.INSTANCE.getLocalPlayer(), itemStack, n2, n3);
        GlStateManager.popMatrix();
        renderItem.renderItemOverlays(Wrapper.INSTANCE.getFontRenderer(), itemStack, n2, n3 - 17);
        renderItem.zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
        GlStateManager.disableDepth();
    }

    public static void a(Entity entity, int n2, float f2) {
        RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
        Wrapper.INSTANCE.getMinecraft().entityRenderer.disableLightmap();
        if (entity.ticksExisted == 0) {
            entity.lastTickPosX = entity.posX;
            entity.lastTickPosY = entity.posY;
            entity.lastTickPosZ = entity.posZ;
        }
        double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2;
        double d3 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2;
        double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2;
        float f3 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f2;
        ColorUtils.setColor(n2);
        renderManager.renderEntity(entity, d2 - renderManager.viewerPosX, d3 - renderManager.viewerPosY, d4 - renderManager.viewerPosZ, f3, f2, false);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        Wrapper.INSTANCE.getMinecraft().entityRenderer.enableLightmap();
    }

    public static int a(EntityLivingBase entityLivingBase) {
        int n2 = (int)entityLivingBase.getHealth();
        if ((double)n2 <= (double)entityLivingBase.getMaxHealth() * 0.25) {
            return er.d(13, 4L, 0.5f);
        }
        if ((double)n2 <= (double)entityLivingBase.getMaxHealth() * 0.5) {
            return er.d(13, 4L, 0.5f);
        }
        if ((double)n2 <= (double)entityLivingBase.getMaxHealth() * 0.75) {
            return er.c(13, 4L, 0.3f);
        }
        return er.c(13, 4L, 0.3f);
    }

    public static void c() {
        RenderLivingBase.NAME_TAG_RANGE = 64.0f;
        RenderLivingBase.NAME_TAG_RANGE_SNEAK = 32.0f;
    }

    public static void d() {
        RenderLivingBase.NAME_TAG_RANGE = 0.0f;
        RenderLivingBase.NAME_TAG_RANGE_SNEAK = 0.0f;
    }

    public static void a(Entity entity, String string, double d2, double d3, double d4, cU cU2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        try {
            Object object;
            EntityLivingBase entityLivingBase;
            float f2;
            float f3;
            EntityItem entityItem;
            ItemStack itemStack;
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            FontRenderer fontRenderer = Wrapper.INSTANCE.getFontRenderer();
            RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
            if (renderManager == null || renderManager.options == null) {
                return;
            }
            int n2 = er.a(155, 155, 155, 125);
            int n3 = er.e;
            switch (cU2) {
                case f: {
                    n2 = er.i;
                    n3 = er.d;
                    break;
                }
                case d: {
                    n2 = er.a(0, 0, 0, 155);
                    n3 = er.e;
                    break;
                }
                case c: {
                    n2 = er.a(0, 0, 255, 155);
                    n3 = er.c;
                    break;
                }
                case b: {
                    n2 = er.a(0, 255, 0, 155);
                    n3 = er.d;
                    break;
                }
                case a: {
                    n2 = er.a(255, 0, 0, 155);
                    n3 = er.e;
                    break;
                }
                case k: {
                    n2 = er.a(255, 0, 255, 155);
                    n3 = er.e;
                    break;
                }
                case i: {
                    n2 = er.a(255, 255, 0, 155);
                    n3 = er.d;
                    break;
                }
                case j: {
                    n2 = er.a(255, 55, 0, 155);
                    n3 = er.k;
                    break;
                }
            }
            if (entity instanceof EntityItem && !et.a(itemStack = (entityItem = (EntityItem)entity).getItem()) && itemStack.isItemEnchanted()) {
                n3 = er.c(13, 0L, 0.3f);
            }
            if ((f3 = (f2 = entityPlayerSP.getDistance(entity)) / 4.0f) < 1.6f) {
                f3 = 1.6f;
            }
            float f4 = f3 / 1.2f + 4.2f;
            f4 = f4 / 30.0f * 0.2f;
            float f5 = (float)(d3 + (double)entity.height + (double)0.3f + (double)(f3 / 6.0f));
            boolean bl6 = renderManager.options.thirdPersonView == 2;
            GlStateManager.pushMatrix();
            GlStateManager.translate((double)d2, (double)f5, (double)d4);
            GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)(-renderManager.playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)((float)(bl6 ? -1 : 1) * renderManager.playerViewX), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.scale((float)(-f4), (float)(-f4), (float)f4);
            GlStateManager.disableLighting();
            GlStateManager.depthMask((boolean)false);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            GlStateManager.disableTexture2D();
            if (bl5 && bl2 && entity instanceof EntityLivingBase && (double)(entityLivingBase = (EntityLivingBase)entity).getHealth() > 0.0) {
                String string2 = "4";
                if (entityLivingBase.getHealth() > entityLivingBase.getMaxHealth() / 4.0f) {
                    string2 = "6";
                    if (entityLivingBase.getHealth() > entityLivingBase.getMaxHealth() / 2.0f) {
                        string2 = "e";
                        if (entityLivingBase.getHealth() == entityLivingBase.getMaxHealth()) {
                            string2 = "a";
                        }
                    }
                }
                String string3 = String.format("%s [%s]", b + string2, RenderUtils.a(Float.valueOf(entityLivingBase.getHealth()), 1));
                string = string + string3;
            }
            int n4 = -11;
            int n5 = -11;
            int n6 = fontRenderer.getStringWidth(string);
            int n7 = fontRenderer.FONT_HEIGHT + 8;
            int n8 = 12;
            int n9 = n4 + n8 - n6 / 2;
            if (bl2) {
                RenderUtils.d();
                int n10 = n5 + 10;
                RenderUtils.a(string, n9, n10, n3, er.a(0.0f, 0.0f, 0.0f, 0.25f), n6);
                if (entity instanceof EntityLivingBase && bl3) {
                    object = (EntityLivingBase)entity;
                    if (object.getHealth() < object.getMaxHealth()) {
                        RenderUtils.a((double)(n9 - 2), (double)(n5 + 9), (double)(n9 + n6 + 2), (double)(n5 + (n7 - 12) + 1), n2);
                    }
                    if ((double)object.getHealth() > 0.0) {
                        double d5 = (double)object.getHealth() / (double)object.getMaxHealth();
                        int n11 = (int)((double)n6 * d5);
                        if (n11 > n6) {
                            n11 = n6;
                        }
                        RenderUtils.a((double)(n9 - 2), (double)(n5 + 9), (double)(n9 + n11 + 2), (double)(n5 + (n7 - 12) + 1), RenderUtils.a((EntityLivingBase)object));
                    }
                }
            }
            if (entity instanceof EntityPlayer) {
                EntityPlayer entityPlayer = (EntityPlayer)entity;
                if (bl || bl4) {
                    if (!bl3) {
                        n5 += 5;
                    }
                    if (bl) {
                        object = RenderUtils.a(entityPlayer, n4 - 14, n5 - 14, 3);
                        if (object[0] < 1) {
                            n5 = 0;
                        }
                        if (bl4) {
                            RenderUtils.a(entityPlayer, n9, n5 - 14, n6, n7, object[1]);
                        }
                    } else if (bl4) {
                        RenderUtils.a(entityPlayer, n9, 0, n6, n7, 0);
                    }
                }
            }
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.popMatrix();
        }
        catch (Exception exception) {
            ChatUtils.exception("drawProfiler", exception);
        }
    }

    public static void a(EntityPlayer entityPlayer, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        Collection collection = entityPlayer.getActivePotionEffects();
        if (collection.isEmpty()) {
            return;
        }
        FontRenderer fontRenderer = Wrapper.INSTANCE.getFontRenderer();
        int n8 = fontRenderer.FONT_HEIGHT + 3;
        for (n7 = 0; n7 < n6; ++n7) {
            n3 -= n8;
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        n7 = n2;
        int n9 = n3 - n5;
        for (PotionEffect potionEffect : Ordering.natural().reverse().sortedCopy((Iterable)collection)) {
            int n10;
            if (potionEffect.getDuration() <= 0) continue;
            Potion potion = potionEffect.getPotion();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            Wrapper.INSTANCE.getMinecraft().getTextureManager().bindTexture(GuiContainer.INVENTORY_BACKGROUND);
            if (potion.hasStatusIcon()) {
                n10 = potion.getStatusIconIndex();
                RenderUtils.drawRect(n7, n9 - 5, 0 + n10 % 8 * 18, 198 + n10 / 8 * 18, 18, 18);
            }
            n10 = potionEffect.getAmplifier();
            String string = "\u00a7f";
            if (n10 > 1) {
                string = "\u00a7c";
            }
            String string2 = "";
            if (n10 > 0) {
                string2 = String.format("%s%s %s", string, string2, I18n.format((String)("enchantment.level." + (n10 + 1)), (Object[])new Object[0]));
            }
            String string3 = String.format("%s \u00a77[\u00a7f%s\u00a77]", string2, Potion.getPotionDurationString((PotionEffect)potionEffect, (float)1.0f));
            RenderUtils.a(a + string3, n7 + 20, n9, er.e, er.q, fontRenderer.getStringWidth(string3));
            n9 -= n8 + 5;
        }
        GlStateManager.enableDepth();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }

    public static void drawRect(int n2, int n3, int n4, int n5, int n6, int n7) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos((double)(n2 + 0), (double)(n3 + n7), 1.0).tex((double)((float)(n4 + 0) * 0.00390625f), (double)((float)(n5 + n7) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double)(n2 + n6), (double)(n3 + n7), 1.0).tex((double)((float)(n4 + n6) * 0.00390625f), (double)((float)(n5 + n7) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double)(n2 + n6), (double)(n3 + 0), 1.0).tex((double)((float)(n4 + n6) * 0.00390625f), (double)((float)(n5 + 0) * 0.00390625f)).endVertex();
        bufferBuilder.pos((double)(n2 + 0), (double)(n3 + 0), 1.0).tex((double)((float)(n4 + 0) * 0.00390625f), (double)((float)(n5 + 0) * 0.00390625f)).endVertex();
        tessellator.draw();
    }

    public static int[] a(EntityPlayer entityPlayer, int n2, int n3, int n4) {
        InventoryPlayer inventoryPlayer = entityPlayer.inventory;
        ItemStack itemStack = entityPlayer.getHeldItemMainhand();
        ItemStack itemStack2 = entityPlayer.getHeldItemOffhand();
        ItemStack itemStack3 = inventoryPlayer.armorItemInSlot(0);
        ItemStack itemStack4 = inventoryPlayer.armorItemInSlot(1);
        ItemStack itemStack5 = inventoryPlayer.armorItemInSlot(2);
        ItemStack itemStack6 = inventoryPlayer.armorItemInSlot(3);
        ItemStack[] itemStackArray = new ItemStack[]{itemStack2, itemStack, itemStack6, itemStack5, itemStack4, itemStack3};
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (ItemStack itemStack7 : itemStackArray) {
            if (et.a(itemStack7)) continue;
            arrayList.add(itemStack7);
        }
        if (n4 != 1) {
            n2 = n2 * arrayList.size() / 3;
        }
        int n5 = 0;
        for (ItemStack itemStack8 : arrayList) {
            int n6 = RenderUtils.a(itemStack8, n2, n3, n4);
            if (n6 > n5) {
                n5 = n6;
            }
            if (n4 == 0) {
                n3 += 18;
            }
            if (n4 != 1 && n4 != 3) continue;
            n2 += 18;
        }
        return new int[]{arrayList.size(), n5};
    }

    private static /* synthetic */ int a(ItemStack itemStack, int n2, int n3, int n4) {
        FontRenderer fontRenderer = Wrapper.INSTANCE.getFontRenderer();
        int n5 = fontRenderer.FONT_HEIGHT + 3;
        GlStateManager.pushMatrix();
        GlStateManager.pushMatrix();
        float f2 = 1.0f;
        if (n4 == 1) {
            f2 = 1.4f;
        }
        GlStateManager.scale((float)f2, (float)f2, (float)f2);
        RenderHelper.enableGUIStandardItemLighting();
        RenderUtils.f.zLevel = -100.0f;
        GlStateManager.disableDepth();
        f.renderItemIntoGUI(itemStack, n2, n3);
        f.renderItemOverlayIntoGUI(fontRenderer, itemStack, n2, n3, null);
        GlStateManager.popMatrix();
        int n6 = 0;
        if (n4 == 3) {
            n3 -= n5;
            GlStateManager.disableDepth();
            GlStateManager.disableLighting();
            for (bx_0 bx_02 : h) {
                int n7 = EnchantmentHelper.getEnchantmentLevel((Enchantment)bx_02.a(), (ItemStack)itemStack);
                String string = "" + n7;
                int n8 = er.e;
                if (n7 > 9) {
                    string = "9+";
                    n8 = er.a;
                }
                if (n7 <= 0) continue;
                String string2 = String.format("%s%s", bx_02.b(), string);
                RenderUtils.b(a + string2, n2, n3, n8);
                n3 -= n5;
                ++n6;
            }
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
        }
        RenderUtils.f.zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.enableDepth();
        GlStateManager.popMatrix();
        return n6;
    }

    public static void a(Entity entity, float f2, int n2, float f3) {
        ScaledResolution scaledResolution = new ScaledResolution(Wrapper.INSTANCE.getMinecraft());
        float f4 = scaledResolution.getScaledWidth() / 2;
        float f5 = scaledResolution.getScaledHeight() / 2;
        RenderUtils.a(f4, f5, entity, f2, n2, f3);
    }

    public static void a(float f2, float f3, Entity entity, float f4, int n2, float f5) {
        float f6 = (float)(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f5);
        float f7 = (float)(entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f5);
        RenderUtils.a(f2, f3, f6, f7, f4, n2, f5);
    }

    public static void a(float f2, float f3, float f4, float f5, float f6, int n2, float f7) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        float f8 = (float)(0.08 * (135.0 / (double)f6));
        float f9 = 14.0f;
        float[] fArray = er.a(n2);
        float f10 = (RenderUtils.a(f4, f5, f7) + 360.0f) % 360.0f;
        float f11 = (f10 - entityPlayerSP.rotationYaw + 360.0f) % 360.0f - 90.0f;
        double d2 = Math.toRadians(f11);
        float f12 = f8 / 100.0f;
        float f13 = f9 - 4.0f;
        RenderUtils.e();
        GL11.glPushMatrix();
        GL11.glEnable((int)2881);
        GL11.glLineWidth((float)1.0f);
        GL11.glColor4f((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)fArray[3]);
        GL11.glBegin((int)5);
        GL11.glVertex2d((double)((double)f2 + (double)(MathHelper.cos((float)((float)d2)) * f6)), (double)((double)f3 + (double)(MathHelper.sin((float)((float)d2)) * f6)));
        GL11.glVertex2d((double)((double)f2 + (double)MathHelper.cos((float)((float)(d2 + (double)f8))) * ((double)f6 - (double)f9)), (double)((double)f3 + (double)MathHelper.sin((float)((float)(d2 + (double)f8))) * ((double)f6 - (double)f9)));
        GL11.glVertex2d((double)((double)f2 + (double)MathHelper.cos((float)((float)(d2 - (double)f12))) * ((double)f6 - (double)f13)), (double)((double)f3 + (double)MathHelper.sin((float)((float)(d2 - (double)f12))) * ((double)f6 - (double)f13)));
        GL11.glVertex2d((double)((double)f2 + (double)(MathHelper.cos((float)((float)d2)) * f6)), (double)((double)f3 + (double)(MathHelper.sin((float)((float)d2)) * f6)));
        GL11.glVertex2d((double)((double)f2 + (double)MathHelper.cos((float)((float)(d2 - (double)f8))) * ((double)f6 - (double)f9)), (double)((double)f3 + (double)MathHelper.sin((float)((float)(d2 - (double)f8))) * ((double)f6 - (double)f9)));
        GL11.glVertex2d((double)((double)f2 + (double)(MathHelper.cos((float)((float)d2)) * f6)), (double)((double)f3 + (double)(MathHelper.sin((float)((float)d2)) * f6)));
        GL11.glEnd();
        GL11.glColor4f((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glBegin((int)2);
        GL11.glVertex2d((double)((double)f2 + (double)(MathHelper.cos((float)((float)d2)) * f6)), (double)((double)f3 + (double)(MathHelper.sin((float)((float)d2)) * f6)));
        GL11.glVertex2d((double)((double)f2 + (double)MathHelper.cos((float)((float)(d2 + (double)f8))) * ((double)f6 - (double)f9)), (double)((double)f3 + (double)MathHelper.sin((float)((float)(d2 + (double)f8))) * ((double)f6 - (double)f9)));
        GL11.glVertex2d((double)((double)f2 + (double)MathHelper.cos((float)((float)(d2 - (double)f12))) * ((double)f6 - (double)f13)), (double)((double)f3 + (double)MathHelper.sin((float)((float)(d2 - (double)f12))) * ((double)f6 - (double)f13)));
        GL11.glVertex2d((double)((double)f2 + (double)MathHelper.cos((float)((float)(d2 - (double)f8))) * ((double)f6 - (double)f9)), (double)((double)f3 + (double)MathHelper.sin((float)((float)(d2 - (double)f8))) * ((double)f6 - (double)f9)));
        GL11.glVertex2d((double)((double)f2 + (double)(MathHelper.cos((float)((float)d2)) * f6)), (double)((double)f3 + (double)(MathHelper.sin((float)((float)d2)) * f6)));
        GL11.glEnd();
        GL11.glColor4f((float)(fArray[0] / 1.5f), (float)(fArray[1] / 1.5f), (float)(fArray[2] / 1.5f), (float)fArray[3]);
        GL11.glBegin((int)5);
        GL11.glVertex2d((double)((double)f2 + (double)(MathHelper.cos((float)((float)d2)) * f6)), (double)((double)f3 + (double)(MathHelper.sin((float)((float)d2)) * f6)));
        GL11.glVertex2d((double)((double)f2 + (double)MathHelper.cos((float)((float)(d2 + (double)f8))) * ((double)f6 - (double)f9)), (double)((double)f3 + (double)MathHelper.sin((float)((float)(d2 + (double)f8))) * ((double)f6 - (double)f9)));
        GL11.glVertex2d((double)((double)f2 + (double)MathHelper.cos((float)((float)(d2 - (double)f12))) * ((double)f6 - (double)f13)), (double)((double)f3 + (double)MathHelper.sin((float)((float)(d2 - (double)f12))) * ((double)f6 - (double)f13)));
        GL11.glVertex2d((double)((double)f2 + (double)(MathHelper.cos((float)((float)d2)) * f6)), (double)((double)f3 + (double)(MathHelper.sin((float)((float)d2)) * f6)));
        GL11.glVertex2d((double)((double)f2 + (double)MathHelper.cos((float)((float)(d2 - (double)f12))) * ((double)f6 - (double)f9)), (double)((double)f3 + (double)MathHelper.sin((float)((float)(d2 - (double)f12))) * ((double)f6 - (double)f9)));
        GL11.glVertex2d((double)((double)f2 + (double)(MathHelper.cos((float)((float)d2)) * f6)), (double)((double)f3 + (double)(MathHelper.sin((float)((float)d2)) * f6)));
        GL11.glEnd();
        GL11.glDisable((int)2881);
        GL11.glPopMatrix();
        RenderUtils.f();
    }

    public static float a(double d2, double d3, float f2) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        double d4 = d2 - (entityPlayerSP.lastTickPosX + (entityPlayerSP.posX - entityPlayerSP.lastTickPosX) * (double)f2);
        double d5 = d3 - (entityPlayerSP.lastTickPosZ + (entityPlayerSP.posZ - entityPlayerSP.lastTickPosZ) * (double)f2);
        return (float)(Math.atan2(d5, d4) * 180.0 / Math.PI) - 90.0f;
    }

    public static void b(Entity entity, int n2, float f2) {
        double d2 = Wrapper.INSTANCE.getMinecraft().getRenderManager().viewerPosX;
        double d3 = Wrapper.INSTANCE.getMinecraft().getRenderManager().viewerPosY;
        double d4 = Wrapper.INSTANCE.getMinecraft().getRenderManager().viewerPosZ;
        double d5 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2 - d2;
        double d6 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2 + (double)(entity.height / 2.0f) - d3;
        double d7 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2 - d4;
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glEnable((int)2848);
        GL11.glDisable((int)2896);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        ColorUtils.setColor(n2);
        Vec3d vec3d = null;
        vec3d = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-((float)Math.toRadians(Wrapper.INSTANCE.getLocalPlayer().rotationPitch))).rotateYaw(-((float)Math.toRadians(Wrapper.INSTANCE.getLocalPlayer().rotationYaw)));
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)vec3d.x, (double)((double)Wrapper.INSTANCE.getLocalPlayer().getEyeHeight() + vec3d.y), (double)vec3d.z);
        float f3 = entity.height / 2.0f;
        GL11.glVertex3d((double)d5, (double)(d6 - (double)f3 - 0.2), (double)d7);
        GL11.glEnd();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)2896);
        GL11.glDisable((int)2848);
        GL11.glDisable((int)3042);
        GL11.glDepthMask((boolean)true);
    }

    public static void c(Entity entity, int n2, float f2) {
        try {
            RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
            double d2 = renderManager.viewerPosX;
            double d3 = renderManager.viewerPosY;
            double d4 = renderManager.viewerPosZ;
            if (entity instanceof EntityItem) {
                d3 -= (double)entity.height;
            }
            GL11.glPushMatrix();
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)2848);
            GL11.glLineWidth((float)1.0f);
            GL11.glDisable((int)3553);
            GL11.glEnable((int)2884);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2896);
            GL11.glTranslated((double)(-d2), (double)(-d3), (double)(-d4));
            ColorUtils.setColor(n2);
            RenderUtils.d(entity.getEntityBoundingBox());
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glEnable((int)2896);
            GL11.glEnable((int)2929);
            GL11.glEnable((int)3553);
            GL11.glDisable((int)3042);
            GL11.glDisable((int)2848);
            GL11.glPopMatrix();
        }
        catch (Exception exception) {
            ChatUtils.exception("RenderUtils: drawESP3D", exception);
        }
    }

    public static void d(Entity entity, int n2, float f2) {
        try {
            RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
            if (renderManager == null || renderManager.options == null) {
                return;
            }
            double d2 = renderManager.viewerPosX;
            double d3 = renderManager.viewerPosY;
            double d4 = renderManager.viewerPosZ;
            if (entity instanceof EntityItem) {
                d3 -= (double)entity.height;
            }
            double d5 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2 - d2;
            double d6 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2 + (double)(entity.height / 2.0f) - d3;
            double d7 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2 - d4;
            float f3 = renderManager.playerViewY;
            float f4 = renderManager.playerViewX;
            boolean bl = renderManager.options.thirdPersonView == 2;
            GL11.glPushMatrix();
            GL11.glTranslated((double)d5, (double)d6, (double)d7);
            GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(-f3), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)((float)(bl ? -1 : 1) * f4), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glEnable((int)3042);
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
            GL11.glLineWidth((float)1.0f);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)2848);
            ColorUtils.setColor(n2);
            float f5 = entity.width;
            float f6 = (float)((double)entity.height / 1.6);
            RenderUtils.a(f5, f6);
            if (entity instanceof EntityLivingBase && (double)entity.width > 0.0 && (double)entity.height > 0.0) {
                EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
                RenderUtils.a(entityLivingBase, n2);
            }
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)2929);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2896);
            GL11.glDisable((int)2848);
            GL11.glDisable((int)3042);
            GL11.glPopMatrix();
        }
        catch (Exception exception) {
            ChatUtils.exception("RenderUtils: drawESP2D", exception);
        }
    }

    public static void a(EntityLivingBase entityLivingBase, int n2) {
        if (!((double)entityLivingBase.getHealth() > 0.0)) {
            return;
        }
        float f2 = 0.05f;
        float f3 = entityLivingBase.width + f2;
        float f4 = (float)((double)entityLivingBase.height / 1.6);
        ColorUtils.setColor(n2);
        GL11.glBegin((int)1);
        float f5 = 0.001f;
        float f6 = f2 + 0.01f;
        GL11.glVertex3d((double)(0.0 + (double)(f3 += 0.055f) + (double)f5), (double)(0.0 + (double)(f4 += 0.005f)), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3 - (double)f6), (double)(0.0 + (double)f4), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3 + (double)f5), (double)(0.0 + (double)f4), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3 + (double)f5), (double)(0.0 - (double)f4), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3 - (double)f6), (double)(0.0 + (double)f4), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3 - (double)f6), (double)(0.0 - (double)f4), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3 + (double)f5), (double)(0.0 - (double)f4), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3 - (double)f6), (double)(0.0 - (double)f4), (double)0.0);
        GL11.glEnd();
        double d2 = (double)entityLivingBase.getHealth() / (double)entityLivingBase.getMaxHealth();
        float f7 = (float)((double)(f4 -= 0.005f) * d2);
        f3 -= 0.055f;
        if (entityLivingBase.getHealth() < entityLivingBase.getMaxHealth()) {
            ColorUtils.setColor(er.a(155, 155, 155, 155));
            GL11.glBegin((int)7);
            GL11.glVertex3d((double)(0.0 + (double)f3), (double)(0.0 + (double)f4), (double)0.0);
            GL11.glVertex3d((double)(0.0 + (double)f3 + (double)f2), (double)(0.0 + (double)f4), (double)0.0);
            GL11.glVertex3d((double)(0.0 + (double)f3 + (double)f2), (double)(0.0 - (double)f4), (double)0.0);
            GL11.glVertex3d((double)(0.0 + (double)f3), (double)(0.0 - (double)f4), (double)0.0);
            GL11.glVertex3d((double)(0.0 + (double)f3), (double)(0.0 + (double)f4), (double)0.0);
            GL11.glEnd();
        }
        if (!(f7 > f4)) {
            f4 = f7;
        }
        ColorUtils.setColor(n2);
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)(0.0 + (double)f3), (double)(0.0 + (double)f4), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3 + (double)f2), (double)(0.0 + (double)f4), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3 + (double)f2), (double)(0.0 - (double)f4), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3), (double)(0.0 - (double)f4), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f3), (double)(0.0 + (double)f4), (double)0.0);
        GL11.glEnd();
    }

    public static void e(Entity entity, int n2, float f2) {
        try {
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
            if (renderManager == null || renderManager.options == null) {
                return;
            }
            double d2 = renderManager.viewerPosX;
            double d3 = renderManager.viewerPosY;
            double d4 = renderManager.viewerPosZ;
            double d5 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2 - d2;
            double d6 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2 + (double)(entity.height / 2.0f) - d3;
            double d7 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2 - d4;
            float f3 = renderManager.playerViewY;
            float f4 = renderManager.playerViewX;
            boolean bl = renderManager.options.thirdPersonView == 2;
            int n3 = 1;
            float f5 = entityPlayerSP.getDistance(entity);
            float f6 = f5 / 4.0f;
            if (f6 < 1.6f) {
                f6 = 1.6f;
            }
            float f7 = f6 / 2.2f + 2.2f;
            f7 *= 0.3f;
            GL11.glPushMatrix();
            GlStateManager.translate((double)d5, (double)d6, (double)d7);
            GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)(-f3), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)((float)(bl ? -1 : 1) * f4), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glScalef((float)f7, (float)f7, (float)f7);
            GL11.glEnable((int)3042);
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
            GL11.glLineWidth((float)1.0f);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)2848);
            ColorUtils.setColor(n2);
            GL11.glBegin((int)n3);
            GL11.glVertex3d((double)0.0, (double)1.0, (double)0.0);
            GL11.glVertex3d((double)-0.5, (double)0.5, (double)0.0);
            GL11.glVertex3d((double)0.0, (double)1.0, (double)0.0);
            GL11.glVertex3d((double)0.5, (double)0.5, (double)0.0);
            GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
            GL11.glVertex3d((double)-0.5, (double)0.5, (double)0.0);
            GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
            GL11.glVertex3d((double)0.5, (double)0.5, (double)0.0);
            GL11.glEnd();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)2929);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2896);
            GL11.glDisable((int)2848);
            GL11.glDisable((int)3042);
            GL11.glPopMatrix();
        }
        catch (Exception exception) {
            ChatUtils.exception("RenderUtils: drawESPWatchdogs", exception);
        }
    }

    public static void a(eC eC2) {
        RenderUtils.a(eC2.d(), eC2.hashCode());
    }

    public static void a(String string, int n2) {
        try {
            byte[] byArray = \u200b\u2000.true(string);
            BufferedImage bufferedImage = \u200b\u2000.if(byArray);
            if (bufferedImage != null) {
                int n3 = TextureUtil.uploadTextureImageAllocate((int)TextureUtil.glGenTextures(), (BufferedImage)bufferedImage, (boolean)true, (boolean)false);
                c.put(n2, n3);
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("loadImage", exception);
        }
    }

    public static void a(String string, int n2, float f2, float f3) {
        try {
            BufferedImage bufferedImage = fn.a(string);
            if (bufferedImage != null) {
                int n3;
                if (bufferedImage.getWidth() > 200 && bufferedImage.getHeight() > 200) {
                    n3 = bufferedImage.getWidth();
                    int n4 = bufferedImage.getHeight();
                    if (bufferedImage.getWidth() > 400 && bufferedImage.getHeight() > 400) {
                        if (bufferedImage.getWidth() > 600 && bufferedImage.getHeight() > 600) {
                            n3 = bufferedImage.getWidth() / 2 - bufferedImage.getWidth() / 3 + 26;
                            n4 = bufferedImage.getHeight() / 2 - bufferedImage.getWidth() / 3 + 26;
                            bufferedImage = RenderUtils.a(bufferedImage, n3 + bufferedImage.getWidth(), n4 + bufferedImage.getWidth());
                            bufferedImage = RenderUtils.a(bufferedImage, new Rectangle(n3, n4, n3 + bufferedImage.getWidth() / 2, n4 + bufferedImage.getWidth() / 2));
                        } else {
                            bufferedImage = RenderUtils.a(bufferedImage, n3 /= 5, n4 /= 5);
                        }
                    } else {
                        bufferedImage = RenderUtils.a(bufferedImage, n3 /= 3, n4 /= 3);
                    }
                }
                n3 = TextureUtil.uploadTextureImageAllocate((int)TextureUtil.glGenTextures(), (BufferedImage)bufferedImage, (boolean)true, (boolean)false);
                c.put(n2, n3);
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("loadImage", exception);
        }
    }

    public static BufferedImage a(BufferedImage bufferedImage, Rectangle rectangle) {
        BufferedImage bufferedImage2 = new BufferedImage((int)rectangle.getWidth(), (int)rectangle.getHeight(), 1);
        Graphics graphics = bufferedImage2.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, (int)rectangle.getWidth(), (int)rectangle.getHeight(), (int)rectangle.getX(), (int)rectangle.getY(), (int)(rectangle.getX() + rectangle.getWidth()), (int)(rectangle.getY() + rectangle.getHeight()), null);
        graphics.dispose();
        return bufferedImage2;
    }

    public static BufferedImage a(BufferedImage bufferedImage, int n2, int n3) {
        float f2 = (float)bufferedImage.getHeight() / (float)bufferedImage.getWidth();
        if (f2 <= 1.0f) {
            n3 = (int)Math.ceil((float)n2 * f2);
        } else {
            n2 = Math.round((float)n3 / f2);
        }
        BufferedImage bufferedImage2 = new BufferedImage(n2, n3, bufferedImage.getTransparency() == 1 ? 1 : 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(bufferedImage, 0, 0, n2, n3, null);
        graphics2D.dispose();
        return bufferedImage2;
    }

    public static void a(String string, float f2, float f3, float f4, float f5, boolean bl) {
        RenderUtils.a(string, f2, f3, f4, f5, f5, bl);
    }

    public static void a(String string, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        int n2 = string.getBytes().length;
        RenderUtils.a(string, f2, f3, f4, f5, f6, bl, n2);
    }

    public static void a(String string, float f2, float f3, float f4, float f5, boolean bl, int n2) {
        RenderUtils.a(string, f2, f3, f4, f5, 1.0f, bl, n2);
    }

    public static void a(String string, float f2, float f3, float f4, float f5, float f6, boolean bl, int n2) {
        if (f4 < 1.0f || f5 < 1.0f || !\u2007\u2008\u00a0.n.d()) {
            return;
        }
        int n3 = -1;
        if (c.containsKey(n2)) {
            n3 = (Integer)c.get(n2);
        } else {
            RenderUtils.a(string, n2);
        }
        if (n3 == -1) {
            return;
        }
        RenderUtils.a(n3, f2, f3, f4, f5, f6, bl);
    }

    public static void b(String string, float f2, float f3, float f4, float f5, boolean bl) {
        RenderUtils.b(string, f2, f3, f4, f5, 1.0f, bl, string.hashCode());
    }

    public static void b(String string, float f2, float f3, float f4, float f5, float f6, boolean bl, int n2) {
        if (f4 < 1.0f || f5 < 1.0f || !\u2007\u2008\u00a0.n.d()) {
            return;
        }
        int n3 = -1;
        if (c.containsKey(n2)) {
            n3 = (Integer)c.get(n2);
        } else {
            RenderUtils.a(string, n2, f4, f5);
        }
        if (n3 == -1) {
            return;
        }
        RenderUtils.a(n3, f2, f3, f4, f5, f6, bl);
    }

    private static /* synthetic */ void a(int n2, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        GL11.glPushMatrix();
        GL11.glDisable((int)2884);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.bindTexture((int)n2);
        if (bl) {
            GL11.glTexParameterf((int)3553, (int)10240, (float)9728.0f);
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)f6);
        GL11.glBegin((int)7);
        GL11.glTexCoord2f((float)0.0f, (float)0.0f);
        GL11.glVertex2f((float)f2, (float)f3);
        GL11.glTexCoord2f((float)0.0f, (float)1.0f);
        GL11.glVertex2f((float)f2, (float)(f3 + f5));
        GL11.glTexCoord2f((float)1.0f, (float)1.0f);
        GL11.glVertex2f((float)(f2 + f4), (float)(f3 + f5));
        GL11.glTexCoord2f((float)1.0f, (float)0.0f);
        GL11.glVertex2f((float)(f2 + f4), (float)f3);
        GL11.glEnd();
        if (bl) {
            GL11.glTexParameterf((int)3553, (int)10240, (float)9729.0f);
        }
        GlStateManager.disableBlend();
        GlStateManager.disableTexture2D();
        GL11.glEnable((int)2884);
        GL11.glPopMatrix();
    }

    public static void a(float f2, float f3, float f4, float f5, boolean bl, int n2, int n3) {
        int n4;
        float f6 = MathUtils1.a(f5 * 2.0f, 0.0f, 2.0f);
        int n5 = 40;
        float f7 = (float)Math.PI * 2;
        GL11.glPushMatrix();
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)5.0f);
        ColorUtils.setColor(n2);
        GL11.glBegin((int)3);
        for (n4 = 0; n4 <= n5; ++n4) {
            GL11.glVertex2f((float)((float)((double)f2 + (double)f4 * Math.cos((float)n4 * f7 / (float)n5))), (float)((float)((double)f3 + (double)f4 * Math.sin((float)n4 * f7 / (float)n5))));
        }
        ColorUtils.setColor(n3);
        f7 = (float)((double)f6 * Math.PI);
        for (n4 = 0; n4 <= n5; ++n4) {
            GL11.glVertex2f((float)((float)((double)f2 + (double)f4 * Math.cos((float)n4 * f7 / (float)n5))), (float)((float)((double)f3 + (double)f4 * Math.sin((float)n4 * f7 / (float)n5))));
        }
        GL11.glEnd();
        if (bl) {
            GL11.glLineWidth((float)3.0f);
            GL11.glBegin((int)3);
            for (n4 = 0; n4 <= n5; ++n4) {
                GL11.glVertex2f((float)((float)((double)f2 + (double)(f4 / 1.18f) * Math.cos((float)n4 * f7 / (float)n5))), (float)((float)((double)f3 + (double)(f4 / 1.18f) * Math.sin((float)n4 * f7 / (float)n5))));
            }
            GL11.glEnd();
        }
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GL11.glPopMatrix();
    }

    public static void a(ArrayList arrayList, float f2) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2896);
        WorldClient worldClient = Wrapper.INSTANCE.getWorld();
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        double d2 = entityPlayerSP.lastTickPosX + (entityPlayerSP.posX - entityPlayerSP.lastTickPosX) * (double)f2;
        double d3 = entityPlayerSP.lastTickPosY + (entityPlayerSP.posY - entityPlayerSP.lastTickPosY) * (double)f2;
        double d4 = entityPlayerSP.lastTickPosZ + (entityPlayerSP.posZ - entityPlayerSP.lastTickPosZ) * (double)f2;
        for (by by2 : arrayList2) {
            if (by2 == null) continue;
            BlockPos blockPos = by2.a();
            XRayData xRayData = by2.b();
            if (blockPos == null || xRayData == null) continue;
            IBlockState iBlockState = worldClient.getBlockState(blockPos);
            int n2 = new Color(xRayData.getRed(), xRayData.getGreen(), xRayData.getBlue(), 255).getRGB();
            ColorUtils.setColor(n2);
            AxisAlignedBB axisAlignedBB = iBlockState.getSelectedBoundingBox((World)worldClient, blockPos).grow((double)0.002f).offset(-d2, -d3, -d4);
            RenderUtils.a(axisAlignedBB);
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public static void a(BlockPos blockPos, float f2, float f3, float f4) {
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        double d2 = Wrapper.INSTANCE.getMinecraft().getRenderManager().viewerPosX;
        double d3 = Wrapper.INSTANCE.getMinecraft().getRenderManager().viewerPosY;
        double d4 = Wrapper.INSTANCE.getMinecraft().getRenderManager().viewerPosZ;
        GL11.glTranslated((double)(-d2), (double)(-d3), (double)(-d4));
        GL11.glTranslated((double)Math.floor(blockPos.getX()), (double)Math.floor(blockPos.getY()), (double)Math.floor(blockPos.getZ()));
        ColorUtils.setColor(f2, f3, f4, 0.3f);
        RenderUtils.g();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public static void a(int n2, int n3, int n4, int n5, int n6) {
        GL11.glTranslated((double)n2, (double)n3, (double)0.0);
        GL11.glRotatef((float)(180 + n5), (float)0.0f, (float)0.0f, (float)1.0f);
        ColorUtils.setColor(n6);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glLineWidth((float)1.0f);
        GL11.glBegin((int)6);
        GL11.glVertex2d((double)0.0, (double)(1.0f * (float)n4));
        GL11.glVertex2d((double)(1 * n4), (double)(-(1.0f * (float)n4)));
        GL11.glVertex2d((double)(-(1 * n4)), (double)(-(1.0f * (float)n4)));
        GL11.glEnd();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glRotatef((float)(-180 - n5), (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glTranslated((double)(-n2), (double)(-n3), (double)0.0);
    }

    private static /* synthetic */ double a(double d2) {
        if (d2 < 0.5) {
            return 2.0 * d2 * d2;
        }
        return 1.0 - Math.pow(-2.0 * d2 + 2.0, 2.0) / 2.0;
    }

    public static void a(EntityLivingBase entityLivingBase, int n2, float f2) {
        RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
        long l2 = 2500L;
        long l3 = System.currentTimeMillis() % l2;
        boolean bl = l3 > l2 / 2L;
        double d2 = (double)l3 / ((double)l2 / 2.0);
        d2 = !bl ? 1.0 - d2 : (d2 -= 1.0);
        d2 = RenderUtils.a(d2);
        GL11.glPushMatrix();
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)2896);
        GL11.glShadeModel((int)7425);
        AxisAlignedBB axisAlignedBB = entityLivingBase.getEntityBoundingBox();
        double d3 = (axisAlignedBB.maxX - axisAlignedBB.minX + (axisAlignedBB.maxZ - axisAlignedBB.minZ)) * 0.5;
        double d4 = axisAlignedBB.maxY - axisAlignedBB.minY;
        double d5 = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * (double)f2 - renderManager.viewerPosX;
        double d6 = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * (double)f2 - renderManager.viewerPosY + d4 * d2;
        double d7 = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * (double)f2 - renderManager.viewerPosZ;
        double d8 = d2 > 0.5 ? 1.0 - d2 : d2;
        double d9 = bl ? -1.0 : 1.0;
        double d10 = d4 / 2.0 * d8 * d9;
        for (int i2 = 0; i2 < 360; i2 += 5) {
            double d11 = d5 - Math.sin((double)i2 * Math.PI / 180.0) * d3;
            double d12 = d7 + Math.cos((double)i2 * Math.PI / 180.0) * d3;
            double d13 = d5 - Math.sin((double)(i2 - 5) * Math.PI / 180.0) * d3;
            double d14 = d7 + Math.cos((double)(i2 - 5) * Math.PI / 180.0) * d3;
            GL11.glBegin((int)7);
            ColorUtils.setColor(er.b(n2, 0.0f));
            GL11.glVertex3d((double)d11, (double)(d6 + d10), (double)d12);
            GL11.glVertex3d((double)d13, (double)(d6 + d10), (double)d14);
            ColorUtils.setColor(er.b(n2, 0.9f));
            GL11.glVertex3d((double)d13, (double)d6, (double)d14);
            GL11.glVertex3d((double)d11, (double)d6, (double)d12);
            GL11.glEnd();
        }
        GL11.glEnable((int)2884);
        GL11.glShadeModel((int)7424);
        ColorUtils.setColor(er.e);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3553);
        GL11.glPopMatrix();
    }

    public static void a(Entity entity, double d2, int n2, float f2, int n3, float f3) {
        RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
        double d3 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f3 - renderManager.viewerPosX;
        double d4 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f3 - renderManager.viewerPosY;
        double d5 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f3 - renderManager.viewerPosZ;
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glLineWidth((float)f2);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        ColorUtils.setColor(n3);
        GL11.glBegin((int)3);
        for (int i2 = 0; i2 <= n2; ++i2) {
            GL11.glVertex3d((double)(d3 + d2 * Math.cos((double)i2 * (Math.PI * 2) / (double)n2)), (double)d4, (double)(d5 + d2 * Math.sin((double)i2 * (Math.PI * 2) / (double)n2)));
        }
        GL11.glEnd();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)2929);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void e() {
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
    }

    public static void f() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    public static void a(AxisAlignedBB axisAlignedBB) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        tessellator.draw();
    }

    public static void a(AxisAlignedBB axisAlignedBB, float f2, float f3, float f4, float f5) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f2, f3, f4, f5).endVertex();
        tessellator.draw();
    }

    public static void a(float f2, float f3) {
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)0.0, (double)(0.0 + (double)f3), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f2), (double)(0.0 + (double)f3), (double)0.0);
        GL11.glVertex3d((double)0.0, (double)(0.0 + (double)f3), (double)0.0);
        GL11.glVertex3d((double)(0.0 - (double)f2), (double)(0.0 + (double)f3), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f2), (double)(0.0 + (double)f3), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f2), (double)(0.0 - (double)f3), (double)0.0);
        GL11.glVertex3d((double)(0.0 - (double)f2), (double)(0.0 + (double)f3), (double)0.0);
        GL11.glVertex3d((double)(0.0 - (double)f2), (double)(0.0 - (double)f3), (double)0.0);
        GL11.glVertex3d((double)0.0, (double)(0.0 - (double)f3), (double)0.0);
        GL11.glVertex3d((double)(0.0 + (double)f2), (double)(0.0 - (double)f3), (double)0.0);
        GL11.glVertex3d((double)0.0, (double)(0.0 - (double)f3), (double)0.0);
        GL11.glVertex3d((double)(0.0 - (double)f2), (double)(0.0 - (double)f3), (double)0.0);
        GL11.glEnd();
    }

    public static void g() {
        RenderUtils.b(g);
    }

    public static void b(AxisAlignedBB axisAlignedBB) {
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
    }

    public static void h() {
        RenderUtils.d(g);
    }

    public static void c(AxisAlignedBB axisAlignedBB) {
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
    }

    public static void d(AxisAlignedBB axisAlignedBB) {
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
    }

    public static void e(AxisAlignedBB axisAlignedBB) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
        tessellator.draw();
    }

    public static void f(AxisAlignedBB axisAlignedBB) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        tessellator.draw();
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).endVertex();
        tessellator.draw();
    }

    public static void a(double d2, double d3, double d4, double d5, float f2, int n2, int n3) {
        RenderUtils.a(d2, d3, d4, d5, n2);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float)f2);
        ColorUtils.setColor(n3);
        bufferBuilder.begin(1, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(d2, d3, 0.0).endVertex();
        bufferBuilder.pos(d2, d5, 0.0).endVertex();
        bufferBuilder.pos(d4, d5, 0.0).endVertex();
        bufferBuilder.pos(d4, d3, 0.0).endVertex();
        bufferBuilder.pos(d2, d3, 0.0).endVertex();
        bufferBuilder.pos(d4, d3, 0.0).endVertex();
        bufferBuilder.pos(d2, d5, 0.0).endVertex();
        bufferBuilder.pos(d4, d5, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void a(double d2, double d3, double d4, double d5, double d6, int n2) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        int n3 = 5;
        ColorUtils.setColor(n2);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(d2, d5, 0.0).endVertex();
        bufferBuilder.pos(d4 - (double)n3, d5, 0.0).endVertex();
        bufferBuilder.pos(d4 - (double)n3, d3, 0.0).endVertex();
        bufferBuilder.pos(d2, d3, 0.0).endVertex();
        tessellator.draw();
        bufferBuilder.begin(4, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(d4 - (double)n3, d5, 0.0).endVertex();
        bufferBuilder.pos(d4 + d6 / 6.5, d5 - d6 / 2.0, 0.0).endVertex();
        bufferBuilder.pos(d4 - (double)n3, d3, 0.0).endVertex();
        bufferBuilder.pos(d4 - (double)n3, d3, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void a(double d2, double d3, double d4, double d5, int n2) {
        double d6;
        if (d2 < d4) {
            d6 = d2;
            d2 = d4;
            d4 = d6;
        }
        if (d3 < d5) {
            d6 = d3;
            d3 = d5;
            d5 = d6;
        }
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        ColorUtils.setColor(n2);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(d2, d5, 0.0).endVertex();
        bufferBuilder.pos(d4, d5, 0.0).endVertex();
        bufferBuilder.pos(d4, d3, 0.0).endVertex();
        bufferBuilder.pos(d2, d3, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void a(int n2, int n3, int n4, int n5, int n6, int n7, int n8, aY aY2) {
        float f2 = (float)(n6 >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n6 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n6 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n6 & 0xFF) / 255.0f;
        float f6 = (float)(n7 >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n7 >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n7 >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n7 & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel((int)7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        switch (aY2) {
            case a: {
                bufferBuilder.pos((double)n2, (double)n5, (double)n8).color(f3, f4, f5, f2).endVertex();
                bufferBuilder.pos((double)n4, (double)n5, (double)n8).color(f3, f4, f5, f2).endVertex();
                bufferBuilder.pos((double)n4, (double)n3, (double)n8).color(f7, f8, f9, f6).endVertex();
                bufferBuilder.pos((double)n2, (double)n3, (double)n8).color(f7, f8, f9, f6).endVertex();
                break;
            }
            case b: {
                bufferBuilder.pos((double)n4, (double)n3, (double)n8).color(f3, f4, f5, f2).endVertex();
                bufferBuilder.pos((double)n2, (double)n3, (double)n8).color(f3, f4, f5, f2).endVertex();
                bufferBuilder.pos((double)n2, (double)n5, (double)n8).color(f7, f8, f9, f6).endVertex();
                bufferBuilder.pos((double)n4, (double)n5, (double)n8).color(f7, f8, f9, f6).endVertex();
                break;
            }
            case c: {
                bufferBuilder.pos((double)n2, (double)n3, (double)n8).color(f3, f4, f5, f2).endVertex();
                bufferBuilder.pos((double)n2, (double)n5, (double)n8).color(f3, f4, f5, f2).endVertex();
                bufferBuilder.pos((double)n4, (double)n5, (double)n8).color(f7, f8, f9, f6).endVertex();
                bufferBuilder.pos((double)n4, (double)n3, (double)n8).color(f7, f8, f9, f6).endVertex();
                break;
            }
            case d: {
                bufferBuilder.pos((double)n4, (double)n5, (double)n8).color(f3, f4, f5, f2).endVertex();
                bufferBuilder.pos((double)n4, (double)n3, (double)n8).color(f3, f4, f5, f2).endVertex();
                bufferBuilder.pos((double)n2, (double)n3, (double)n8).color(f7, f8, f9, f6).endVertex();
                bufferBuilder.pos((double)n2, (double)n5, (double)n8).color(f7, f8, f9, f6).endVertex();
                break;
            }
        }
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
}

