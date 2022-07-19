/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.MoreObjects
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.ItemRenderer
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.entity.RenderPlayer
 *  net.minecraft.client.renderer.texture.TextureAtlasSprite
 *  net.minecraft.client.renderer.texture.TextureMap
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBow
 *  net.minecraft.item.ItemMap
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.BlockRenderLayer
 *  net.minecraft.util.EnumBlockRenderType
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.EnumHandSide
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 *  net.minecraft.world.storage.MapData
 *  net.minecraftforge.client.ForgeHooksClient
 *  net.minecraftforge.client.event.RenderBlockOverlayEvent$OverlayType
 *  net.minecraftforge.event.ForgeEventFactory
 */
package i.gishreloaded.deadcode.excluded;

import com.google.common.base.MoreObjects;
import i.gishreloaded.deadcode.hacks.render.Item360;
import i.gishreloaded.deadcode.hacks.render.SwingAnimate;
import i.gishreloaded.deadcode.hacks.render.ViewModel;
import java.util.Objects;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.event.ForgeEventFactory;

public class ItemRendererHook
extends ItemRenderer {
    private final ResourceLocation a = new ResourceLocation("textures/map/map_background.png");
    private final ResourceLocation b = new ResourceLocation("textures/misc/underwater.png");
    private final Minecraft c;
    private ItemStack d = ItemStack.EMPTY;
    private ItemStack e = ItemStack.EMPTY;
    private float f;
    private float g;
    private float h;
    private float i;
    private final RenderManager j;
    private final RenderItem k;

    public ItemRendererHook(Minecraft minecraft) {
        super(minecraft);
        this.c = minecraft;
        this.j = minecraft.getRenderManager();
        this.k = minecraft.getRenderItem();
    }

    public void renderItem(EntityLivingBase entityLivingBase, ItemStack itemStack, ItemCameraTransforms.TransformType transformType) {
        this.renderItem(entityLivingBase, itemStack, transformType, false);
    }

    public void renderItem(EntityLivingBase entityLivingBase, ItemStack itemStack, ItemCameraTransforms.TransformType transformType, boolean bl) {
        if (!itemStack.isEmpty()) {
            boolean bl2;
            Item item = itemStack.getItem();
            Block block = Block.getBlockFromItem((Item)item);
            GlStateManager.pushMatrix();
            boolean bl3 = bl2 = this.k.shouldRenderItemIn3D(itemStack) && block.getRenderLayer() == BlockRenderLayer.TRANSLUCENT;
            if (bl2) {
                GlStateManager.depthMask((boolean)false);
            }
            this.k.renderItem(itemStack, entityLivingBase, transformType, bl);
            if (bl2) {
                GlStateManager.depthMask((boolean)true);
            }
            GlStateManager.popMatrix();
        }
    }

    private /* synthetic */ void rotateArroundXAndY(float f2, float f3) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate((float)f2, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)f3, (float)0.0f, (float)1.0f, (float)0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }

    private /* synthetic */ void setLightmap() {
        EntityPlayerSP entityPlayerSP = this.c.player;
        int n2 = this.c.world.getCombinedLight(new BlockPos(entityPlayerSP.posX, entityPlayerSP.posY + (double)entityPlayerSP.getEyeHeight(), entityPlayerSP.posZ), 0);
        float f2 = n2 & 0xFFFF;
        float f3 = n2 >> 16;
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)f2, (float)f3);
    }

    private /* synthetic */ void c(float f2) {
        EntityPlayerSP entityPlayerSP = this.c.player;
        float f3 = entityPlayerSP.prevRenderArmPitch + (entityPlayerSP.renderArmPitch - entityPlayerSP.prevRenderArmPitch) * f2;
        float f4 = entityPlayerSP.prevRenderArmYaw + (entityPlayerSP.renderArmYaw - entityPlayerSP.prevRenderArmYaw) * f2;
        GlStateManager.rotate((float)((entityPlayerSP.rotationPitch - f3) * 0.1f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)((entityPlayerSP.rotationYaw - f4) * 0.1f), (float)0.0f, (float)1.0f, (float)0.0f);
    }

    private /* synthetic */ float d(float f2) {
        float f3 = 1.0f - f2 / 45.0f + 0.1f;
        f3 = MathHelper.clamp((float)f3, (float)0.0f, (float)1.0f);
        f3 = -MathHelper.cos((float)(f3 * (float)Math.PI)) * 0.5f + 0.5f;
        return f3;
    }

    private /* synthetic */ void c() {
        if (!this.c.player.isInvisible()) {
            GlStateManager.disableCull();
            GlStateManager.pushMatrix();
            GlStateManager.rotate((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            this.a(EnumHandSide.RIGHT);
            this.a(EnumHandSide.LEFT);
            GlStateManager.popMatrix();
            GlStateManager.enableCull();
        }
    }

    private /* synthetic */ void a(EnumHandSide enumHandSide) {
        this.c.getTextureManager().bindTexture(this.c.player.getLocationSkin());
        Render render = this.j.getEntityRenderObject((Entity)this.c.player);
        RenderPlayer renderPlayer = (RenderPlayer)render;
        GlStateManager.pushMatrix();
        float f2 = enumHandSide == EnumHandSide.RIGHT ? 1.0f : -1.0f;
        GlStateManager.rotate((float)92.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)45.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)(f2 * -41.0f), (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.translate((float)(f2 * 0.3f), (float)-1.1f, (float)0.45f);
        if (enumHandSide == EnumHandSide.RIGHT) {
            renderPlayer.renderRightArm((AbstractClientPlayer)this.c.player);
        } else {
            renderPlayer.renderLeftArm((AbstractClientPlayer)this.c.player);
        }
        GlStateManager.popMatrix();
    }

    private /* synthetic */ void a(float f2, EnumHandSide enumHandSide, float f3, ItemStack itemStack) {
        float f4 = enumHandSide == EnumHandSide.RIGHT ? 1.0f : -1.0f;
        GlStateManager.translate((float)(f4 * 0.125f), (float)-0.125f, (float)0.0f);
        if (!this.c.player.isInvisible()) {
            GlStateManager.pushMatrix();
            GlStateManager.rotate((float)(f4 * 10.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            this.a(f2, f3, enumHandSide);
            GlStateManager.popMatrix();
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(f4 * 0.51f), (float)(-0.08f + f2 * -1.2f), (float)-0.75f);
        float f5 = MathHelper.sqrt((float)f3);
        float f6 = MathHelper.sin((float)(f5 * (float)Math.PI));
        float f7 = -0.5f * f6;
        float f8 = 0.4f * MathHelper.sin((float)(f5 * ((float)Math.PI * 2)));
        float f9 = -0.3f * MathHelper.sin((float)(f3 * (float)Math.PI));
        GlStateManager.translate((float)(f4 * f7), (float)(f8 - 0.3f * f6), (float)f9);
        GlStateManager.rotate((float)(f6 * -45.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)(f4 * f6 * -30.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        this.a(itemStack);
        GlStateManager.popMatrix();
    }

    private /* synthetic */ void a(float f2, float f3, float f4) {
        float f5 = MathHelper.sqrt((float)f4);
        float f6 = -0.2f * MathHelper.sin((float)(f4 * (float)Math.PI));
        float f7 = -0.4f * MathHelper.sin((float)(f5 * (float)Math.PI));
        GlStateManager.translate((float)0.0f, (float)(-f6 / 2.0f), (float)f7);
        float f8 = this.d(f2);
        GlStateManager.translate((float)0.0f, (float)(0.04f + f3 * -1.2f + f8 * -0.5f), (float)-0.72f);
        GlStateManager.rotate((float)(f8 * -85.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        this.c();
        float f9 = MathHelper.sin((float)(f5 * (float)Math.PI));
        GlStateManager.rotate((float)(f9 * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.scale((float)2.0f, (float)2.0f, (float)2.0f);
        this.a(this.d);
    }

    private /* synthetic */ void a(ItemStack itemStack) {
        GlStateManager.rotate((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.scale((float)0.38f, (float)0.38f, (float)0.38f);
        GlStateManager.disableLighting();
        this.c.getTextureManager().bindTexture(this.a);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.translate((float)-0.5f, (float)-0.5f, (float)0.0f);
        GlStateManager.scale((float)0.0078125f, (float)0.0078125f, (float)0.0078125f);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(-7.0, 135.0, 0.0).tex(0.0, 1.0).endVertex();
        bufferBuilder.pos(135.0, 135.0, 0.0).tex(1.0, 1.0).endVertex();
        bufferBuilder.pos(135.0, -7.0, 0.0).tex(1.0, 0.0).endVertex();
        bufferBuilder.pos(-7.0, -7.0, 0.0).tex(0.0, 0.0).endVertex();
        tessellator.draw();
        MapData mapData = ((ItemMap)itemStack.getItem()).getMapData(itemStack, (World)this.c.world);
        if (mapData != null) {
            this.c.entityRenderer.getMapItemRenderer().renderMap(mapData, false);
        }
        GlStateManager.enableLighting();
    }

    private /* synthetic */ void a(float f2, float f3, EnumHandSide enumHandSide) {
        boolean bl = enumHandSide != EnumHandSide.LEFT;
        float f4 = bl ? 1.0f : -1.0f;
        float f5 = MathHelper.sqrt((float)f3);
        float f6 = -0.3f * MathHelper.sin((float)(f5 * (float)Math.PI));
        float f7 = 0.4f * MathHelper.sin((float)(f5 * ((float)Math.PI * 2)));
        float f8 = -0.4f * MathHelper.sin((float)(f3 * (float)Math.PI));
        GlStateManager.translate((float)(f4 * (f6 + 0.64000005f)), (float)(f7 + -0.6f + f2 * -0.6f), (float)(f8 + -0.71999997f));
        GlStateManager.rotate((float)(f4 * 45.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        float f9 = MathHelper.sin((float)(f3 * f3 * (float)Math.PI));
        float f10 = MathHelper.sin((float)(f5 * (float)Math.PI));
        GlStateManager.rotate((float)(f4 * f10 * 70.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(f4 * f9 * -20.0f), (float)0.0f, (float)0.0f, (float)1.0f);
        EntityPlayerSP entityPlayerSP = this.c.player;
        this.c.getTextureManager().bindTexture(entityPlayerSP.getLocationSkin());
        GlStateManager.translate((float)(f4 * -1.0f), (float)3.6f, (float)3.5f);
        GlStateManager.rotate((float)(f4 * 120.0f), (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.rotate((float)200.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)(f4 * -135.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.translate((float)(f4 * 5.6f), (float)0.0f, (float)0.0f);
        RenderPlayer renderPlayer = (RenderPlayer)this.j.getEntityRenderObject((Entity)entityPlayerSP);
        GlStateManager.disableCull();
        if (bl) {
            renderPlayer.renderRightArm((AbstractClientPlayer)entityPlayerSP);
        } else {
            renderPlayer.renderLeftArm((AbstractClientPlayer)entityPlayerSP);
        }
        GlStateManager.enableCull();
    }

    public void a(float f2) {
        ItemStack itemStack;
        EntityPlayerSP entityPlayerSP = this.c.player;
        float f3 = entityPlayerSP.getSwingProgress(f2);
        EnumHand enumHand = (EnumHand)MoreObjects.firstNonNull((Object)entityPlayerSP.swingingHand, (Object)EnumHand.MAIN_HAND);
        float f4 = entityPlayerSP.prevRotationPitch + (entityPlayerSP.rotationPitch - entityPlayerSP.prevRotationPitch) * f2;
        float f5 = entityPlayerSP.prevRotationYaw + (entityPlayerSP.rotationYaw - entityPlayerSP.prevRotationYaw) * f2;
        boolean bl = true;
        boolean bl2 = true;
        if (entityPlayerSP.isHandActive() && (itemStack = entityPlayerSP.getActiveItemStack()).getItem() instanceof ItemBow) {
            EnumHand enumHand2 = entityPlayerSP.getActiveHand();
            bl = enumHand2 == EnumHand.MAIN_HAND;
            bl2 = !bl;
        }
        this.rotateArroundXAndY(f4, f5);
        this.setLightmap();
        this.c(f2);
        GlStateManager.enableRescaleNormal();
        if (bl) {
            float f6;
            float f7;
            GlStateManager.pushMatrix();
            if (ViewModel.a) {
                GlStateManager.translate((double)(ViewModel.e.getValue() - 1.0), (double)(ViewModel.f.getValue() - 1.0), (double)(ViewModel.g.getValue() - 1.0));
            }
            if (!ForgeHooksClient.renderSpecificFirstPersonHand((EnumHand)EnumHand.MAIN_HAND, (float)f2, (float)f4, (float)(f7 = enumHand == EnumHand.MAIN_HAND ? f3 : 0.0f), (float)(f6 = 1.0f - (this.g + (this.f - this.g) * f2)), (ItemStack)this.d)) {
                this.a((AbstractClientPlayer)entityPlayerSP, f2, f4, EnumHand.MAIN_HAND, f7, this.d, f6);
            }
            GlStateManager.popMatrix();
        }
        if (bl2) {
            float f8;
            float f9;
            GlStateManager.pushMatrix();
            if (ViewModel.a) {
                GlStateManager.translate((double)(ViewModel.b.getValue() - 1.0), (double)(ViewModel.c.getValue() - 1.0), (double)(ViewModel.d.getValue() - 1.0));
            }
            if (!ForgeHooksClient.renderSpecificFirstPersonHand((EnumHand)EnumHand.OFF_HAND, (float)f2, (float)f4, (float)(f9 = enumHand == EnumHand.OFF_HAND ? f3 : 0.0f), (float)(f8 = 1.0f - (this.i + (this.h - this.i) * f2)), (ItemStack)this.e)) {
                this.a((AbstractClientPlayer)entityPlayerSP, f2, f4, EnumHand.OFF_HAND, f9, this.e, f8);
            }
            GlStateManager.popMatrix();
        }
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
    }

    public void a(AbstractClientPlayer abstractClientPlayer, float f2, float f3, EnumHand enumHand, float f4, ItemStack itemStack, float f5) {
        boolean bl = enumHand == EnumHand.MAIN_HAND;
        EnumHandSide enumHandSide = bl ? abstractClientPlayer.getPrimaryHand() : abstractClientPlayer.getPrimaryHand().opposite();
        GlStateManager.pushMatrix();
        if (itemStack.isEmpty()) {
            if (bl && !abstractClientPlayer.isInvisible()) {
                this.a(f5, f4, enumHandSide);
            }
        } else if (itemStack.getItem() instanceof ItemMap) {
            if (bl && this.e.isEmpty()) {
                this.a(f3, f5, f4);
            } else {
                this.a(f5, enumHandSide, f4, itemStack);
            }
        } else {
            boolean bl2;
            boolean bl3 = bl2 = enumHandSide == EnumHandSide.RIGHT;
            if (abstractClientPlayer.isHandActive() && abstractClientPlayer.getItemInUseCount() > 0 && abstractClientPlayer.getActiveHand() == enumHand) {
                int n2 = bl2 ? 1 : -1;
                switch (itemStack.getItemUseAction()) {
                    case NONE: {
                        this.a(enumHandSide, f5, f4);
                        break;
                    }
                    case EAT: 
                    case DRINK: {
                        this.a(f2, enumHandSide, itemStack);
                        this.a(enumHandSide, f5, f4);
                        break;
                    }
                    case BLOCK: {
                        this.a(enumHandSide, f5, f4);
                        break;
                    }
                    case BOW: {
                        this.a(enumHandSide, f5, f4);
                        GlStateManager.translate((float)((float)n2 * -0.2785682f), (float)0.18344387f, (float)0.15731531f);
                        GlStateManager.rotate((float)-13.935f, (float)1.0f, (float)0.0f, (float)0.0f);
                        GlStateManager.rotate((float)((float)n2 * 35.3f), (float)0.0f, (float)1.0f, (float)0.0f);
                        GlStateManager.rotate((float)((float)n2 * -9.785f), (float)0.0f, (float)0.0f, (float)1.0f);
                        float f6 = (float)itemStack.getMaxItemUseDuration() - ((float)this.c.player.getItemInUseCount() - f2 + 1.0f);
                        float f7 = f6 / 20.0f;
                        f7 = (f7 * f7 + f7 * 2.0f) / 3.0f;
                        if (f7 > 1.0f) {
                            f7 = 1.0f;
                        }
                        if (f7 > 0.1f) {
                            float f8 = MathHelper.sin((float)((f6 - 0.1f) * 1.3f));
                            float f9 = f7 - 0.1f;
                            float f10 = f8 * f9;
                            GlStateManager.translate((float)(f10 * 0.0f), (float)(f10 * 0.004f), (float)(f10 * 0.0f));
                        }
                        GlStateManager.translate((float)(f7 * 0.0f), (float)(f7 * 0.0f), (float)(f7 * 0.04f));
                        GlStateManager.scale((float)1.0f, (float)1.0f, (float)(1.0f + f7 * 0.2f));
                        GlStateManager.rotate((float)((float)n2 * 45.0f), (float)0.0f, (float)-1.0f, (float)0.0f);
                    }
                }
            } else {
                int n3;
                float f11 = -0.4f * MathHelper.sin((float)(MathHelper.sqrt((float)f4) * (float)Math.PI));
                float f12 = 0.2f * MathHelper.sin((float)(MathHelper.sqrt((float)f4) * ((float)Math.PI * 2)));
                float f13 = -0.2f * MathHelper.sin((float)(f4 * (float)Math.PI));
                int n4 = n3 = bl2 ? 1 : -1;
                if (SwingAnimate.a(enumHandSide)) {
                    if (SwingAnimate.e.getModeByIndex(0).isToggled()) {
                        SwingAnimate.g.a(f4 > 0.0f);
                        this.a(enumHandSide, f5, f4);
                        SwingAnimate.a(enumHandSide, (float)SwingAnimate.g.b());
                    } else if (SwingAnimate.e.getModeByIndex(1).isToggled()) {
                        SwingAnimate.b(f4);
                    } else if (SwingAnimate.e.getModeByIndex(2).isToggled()) {
                        SwingAnimate.c(f4);
                    } else if (SwingAnimate.e.getModeByIndex(3).isToggled()) {
                        SwingAnimate.d(f4);
                    } else if (SwingAnimate.e.getModeByIndex(4).isToggled()) {
                        SwingAnimate.e(f12);
                    }
                } else {
                    GlStateManager.translate((float)((float)n3 * f11), (float)f12, (float)f13);
                    this.a(enumHandSide, f5, f4);
                    this.a(enumHandSide, f4);
                }
            }
            this.renderItem((EntityLivingBase)abstractClientPlayer, itemStack, bl2 ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, !bl2);
        }
        GlStateManager.popMatrix();
    }

    private /* synthetic */ void a(EnumHandSide enumHandSide, float f2) {
        int n2 = enumHandSide == EnumHandSide.RIGHT ? 1 : -1;
        float f3 = MathHelper.sin((float)(f2 * f2 * (float)Math.PI));
        GlStateManager.rotate((float)((float)n2 * (45.0f + f3 * -20.0f)), (float)0.0f, (float)1.0f, (float)0.0f);
        float f4 = MathHelper.sin((float)(MathHelper.sqrt((float)f2) * (float)Math.PI));
        GlStateManager.rotate((float)((float)n2 * f4 * -20.0f), (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.rotate((float)(f4 * -80.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)((float)n2 * -45.0f), (float)0.0f, (float)1.0f, (float)0.0f);
    }

    private /* synthetic */ void a(EnumHandSide enumHandSide, float f2, float f3) {
        boolean bl = SwingAnimate.a(enumHandSide);
        int n2 = enumHandSide == EnumHandSide.RIGHT ? 1 : -1;
        float f4 = (float)n2 * 0.56f;
        float f5 = -0.52f + f2 * -0.6f;
        float f6 = -0.72f;
        if (bl) {
            GlStateManager.translate((float)f4, (float)0.312f, (float)f6);
        } else {
            GlStateManager.translate((float)f4, (float)f5, (float)f6);
        }
        if (Item360.b() && !(f3 > 0.0f)) {
            float f7 = (float)(System.currentTimeMillis() % 22600L) * Item360.c.getValue().floatValue();
            if (bl) {
                GlStateManager.rotate((float)f7, (float)f4, (float)f5, (float)f6);
            } else if (Item360.b.getModeByIndex(0).isToggled()) {
                GlStateManager.rotate((float)f7, (float)f4, (float)(f5 + 20.0f), (float)f6);
            } else if (Item360.b.getModeByIndex(1).isToggled()) {
                GlStateManager.rotate((float)f7, (float)f4, (float)0.0f, (float)0.0f);
            }
        }
    }

    private /* synthetic */ void a(float f2, EnumHandSide enumHandSide, ItemStack itemStack) {
        float f3;
        float f4 = (float)this.c.player.getItemInUseCount() - f2 + 1.0f;
        float f5 = f4 / (float)itemStack.getMaxItemUseDuration();
        if (f5 < 0.8f) {
            f3 = MathHelper.abs((float)(MathHelper.cos((float)(f4 / 4.0f * (float)Math.PI)) * 0.1f));
            GlStateManager.translate((float)0.0f, (float)f3, (float)0.0f);
        }
        f3 = 1.0f - (float)Math.pow(f5, 27.0);
        int n2 = enumHandSide == EnumHandSide.RIGHT ? 1 : -1;
        GlStateManager.translate((float)(f3 * 0.6f * (float)n2), (float)(f3 * -0.5f), (float)(f3 * 0.0f));
        GlStateManager.rotate((float)((float)n2 * f3 * 90.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(f3 * 10.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)((float)n2 * f3 * 30.0f), (float)0.0f, (float)0.0f, (float)1.0f);
    }

    public void b(float f2) {
        GlStateManager.disableAlpha();
        if (this.c.player.isEntityInsideOpaqueBlock()) {
            IBlockState iBlockState = this.c.world.getBlockState(new BlockPos((Entity)this.c.player));
            BlockPos blockPos = new BlockPos((Entity)this.c.player);
            EntityPlayerSP entityPlayerSP = this.c.player;
            for (int i2 = 0; i2 < 8; ++i2) {
                double d2 = entityPlayerSP.posX + (double)(((float)((i2 >> 0) % 2) - 0.5f) * entityPlayerSP.width * 0.8f);
                double d3 = entityPlayerSP.posY + (double)(((float)((i2 >> 1) % 2) - 0.5f) * 0.1f);
                double d4 = entityPlayerSP.posZ + (double)(((float)((i2 >> 2) % 2) - 0.5f) * entityPlayerSP.width * 0.8f);
                BlockPos blockPos2 = new BlockPos(d2, d3 + (double)entityPlayerSP.getEyeHeight(), d4);
                IBlockState iBlockState2 = this.c.world.getBlockState(blockPos2);
                if (!iBlockState2.causesSuffocation()) continue;
                iBlockState = iBlockState2;
                blockPos = blockPos2;
            }
            if (iBlockState.getRenderType() != EnumBlockRenderType.INVISIBLE && !ForgeEventFactory.renderBlockOverlay((EntityPlayer)this.c.player, (float)f2, (RenderBlockOverlayEvent.OverlayType)RenderBlockOverlayEvent.OverlayType.BLOCK, (IBlockState)iBlockState, (BlockPos)blockPos)) {
                this.a(this.c.getBlockRendererDispatcher().getBlockModelShapes().getTexture(iBlockState));
            }
        }
        if (!this.c.player.isSpectator()) {
            if (this.c.player.isInsideOfMaterial(Material.WATER) && !ForgeEventFactory.renderWaterOverlay((EntityPlayer)this.c.player, (float)f2)) {
                this.e(f2);
            }
            if (this.c.player.isBurning() && !ForgeEventFactory.renderFireOverlay((EntityPlayer)this.c.player, (float)f2)) {
                this.d();
            }
        }
        GlStateManager.enableAlpha();
    }

    private /* synthetic */ void a(TextureAtlasSprite textureAtlasSprite) {
        this.c.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.color((float)0.1f, (float)0.1f, (float)0.1f, (float)0.5f);
        GlStateManager.pushMatrix();
        float f2 = textureAtlasSprite.getMinU();
        float f3 = textureAtlasSprite.getMaxU();
        float f4 = textureAtlasSprite.getMinV();
        float f5 = textureAtlasSprite.getMaxV();
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(-1.0, -1.0, -0.5).tex((double)f3, (double)f5).endVertex();
        bufferBuilder.pos(1.0, -1.0, -0.5).tex((double)f2, (double)f5).endVertex();
        bufferBuilder.pos(1.0, 1.0, -0.5).tex((double)f2, (double)f4).endVertex();
        bufferBuilder.pos(-1.0, 1.0, -0.5).tex((double)f3, (double)f4).endVertex();
        tessellator.draw();
        GlStateManager.popMatrix();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    private /* synthetic */ void e(float f2) {
        this.c.getTextureManager().bindTexture(this.b);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        float f3 = this.c.player.getBrightness();
        GlStateManager.color((float)f3, (float)f3, (float)f3, (float)0.5f);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.pushMatrix();
        float f4 = -this.c.player.rotationYaw / 64.0f;
        float f5 = this.c.player.rotationPitch / 64.0f;
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(-1.0, -1.0, -0.5).tex((double)(4.0f + f4), (double)(4.0f + f5)).endVertex();
        bufferBuilder.pos(1.0, -1.0, -0.5).tex((double)(0.0f + f4), (double)(4.0f + f5)).endVertex();
        bufferBuilder.pos(1.0, 1.0, -0.5).tex((double)(0.0f + f4), (double)(0.0f + f5)).endVertex();
        bufferBuilder.pos(-1.0, 1.0, -0.5).tex((double)(4.0f + f4), (double)(0.0f + f5)).endVertex();
        tessellator.draw();
        GlStateManager.popMatrix();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.disableBlend();
    }

    private /* synthetic */ void d() {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)0.9f);
        GlStateManager.depthFunc((int)519);
        GlStateManager.depthMask((boolean)false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        for (int i2 = 0; i2 < 2; ++i2) {
            GlStateManager.pushMatrix();
            TextureAtlasSprite textureAtlasSprite = this.c.getTextureMapBlocks().getAtlasSprite("minecraft:blocks/fire_layer_1");
            this.c.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float f2 = textureAtlasSprite.getMinU();
            float f3 = textureAtlasSprite.getMaxU();
            float f4 = textureAtlasSprite.getMinV();
            float f5 = textureAtlasSprite.getMaxV();
            GlStateManager.translate((float)((float)(-(i2 * 2 - 1)) * 0.24f), (float)-0.3f, (float)0.0f);
            GlStateManager.rotate((float)((float)(i2 * 2 - 1) * 10.0f), (float)0.0f, (float)1.0f, (float)0.0f);
            bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
            bufferBuilder.pos(-0.5, -0.5, -0.5).tex((double)f3, (double)f5).endVertex();
            bufferBuilder.pos(0.5, -0.5, -0.5).tex((double)f2, (double)f5).endVertex();
            bufferBuilder.pos(0.5, 0.5, -0.5).tex((double)f2, (double)f4).endVertex();
            bufferBuilder.pos(-0.5, 0.5, -0.5).tex((double)f3, (double)f4).endVertex();
            tessellator.draw();
            GlStateManager.popMatrix();
        }
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.disableBlend();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.depthFunc((int)515);
    }

    public void a() {
        this.g = this.f;
        this.i = this.h;
        EntityPlayerSP entityPlayerSP = this.c.player;
        ItemStack itemStack = entityPlayerSP.getHeldItemMainhand();
        ItemStack itemStack2 = entityPlayerSP.getHeldItemOffhand();
        if (entityPlayerSP.isRowingBoat()) {
            this.f = MathHelper.clamp((float)(this.f - 0.4f), (float)0.0f, (float)1.0f);
            this.h = MathHelper.clamp((float)(this.h - 0.4f), (float)0.0f, (float)1.0f);
        } else {
            float f2 = entityPlayerSP.getCooledAttackStrength(1.0f);
            boolean bl = ForgeHooksClient.shouldCauseReequipAnimation((ItemStack)this.d, (ItemStack)itemStack, (int)entityPlayerSP.inventory.currentItem);
            boolean bl2 = ForgeHooksClient.shouldCauseReequipAnimation((ItemStack)this.e, (ItemStack)itemStack2, (int)-1);
            if (!bl && !Objects.equals(this.d, itemStack)) {
                this.d = itemStack;
            }
            if (!bl && !Objects.equals(this.e, itemStack2)) {
                this.e = itemStack2;
            }
            this.f += MathHelper.clamp((float)((!bl ? f2 * f2 * f2 : 0.0f) - this.f), (float)-0.4f, (float)0.4f);
            this.h += MathHelper.clamp((float)((float)(!bl2 ? 1 : 0) - this.h), (float)-0.4f, (float)0.4f);
        }
        if (this.f < 0.1f) {
            this.d = itemStack;
        }
        if (this.h < 0.1f) {
            this.e = itemStack2;
        }
    }

    public void a(EnumHand enumHand) {
        if (enumHand == EnumHand.MAIN_HAND) {
            this.f = 0.0f;
        } else {
            this.h = 0.0f;
        }
    }
}

