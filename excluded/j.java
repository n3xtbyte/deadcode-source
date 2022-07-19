/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$CullFace
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.ItemModelMesher
 *  net.minecraft.client.renderer.RenderItem
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.block.model.BakedQuad
 *  net.minecraft.client.renderer.block.model.IBakedModel
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.client.renderer.block.model.ModelManager
 *  net.minecraft.client.renderer.block.model.ModelResourceLocation
 *  net.minecraft.client.renderer.color.ItemColors
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.client.renderer.texture.TextureMap
 *  net.minecraft.client.renderer.texture.TextureUtil
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.client.resources.IResourceManager
 *  net.minecraft.crash.CrashReport
 *  net.minecraft.crash.CrashReportCategory
 *  net.minecraft.crash.ICrashReportDetail
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.ReportedException
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 *  net.minecraftforge.client.ForgeHooksClient
 *  net.minecraftforge.client.model.pipeline.LightUtil
 *  net.minecraftforge.common.ForgeModContainer
 */
package excluded;

import excluded.k;
import excluded.l;
import excluded.n;
import excluded.o;
import i.gishreloaded.deadcode.hacks.render.EnchantColor;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.common.ForgeModContainer;

public class j
extends RenderItem {
    private final ResourceLocation b = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    public float a;
    private final ItemModelMesher c;
    private final TextureManager d;
    private final ItemColors e;

    public j(TextureManager textureManager, ModelManager modelManager, ItemColors itemColors) {
        super(textureManager, modelManager, itemColors);
        this.d = textureManager;
        this.c = Wrapper.INSTANCE.getMinecraft().getRenderItem().getItemModelMesher();
        this.e = itemColors;
    }

    public ItemModelMesher a() {
        return this.c;
    }

    protected void a(Item item, int n2, String string) {
        if (this.c != null) {
            this.c.register(item, n2, new ModelResourceLocation(string, "inventory"));
        }
    }

    protected void a(Block block, int n2, String string) {
        this.a(Item.getItemFromBlock((Block)block), n2, string);
    }

    private /* synthetic */ void a(IBakedModel iBakedModel, ItemStack itemStack) {
        this.a(iBakedModel, -1, itemStack);
    }

    private /* synthetic */ void a(IBakedModel iBakedModel, int n2) {
        this.a(iBakedModel, n2, ItemStack.EMPTY);
    }

    private /* synthetic */ void a(IBakedModel iBakedModel, int n2, ItemStack itemStack) {
        if (ForgeModContainer.allowEmissiveItems) {
            ForgeHooksClient.renderLitItem((RenderItem)this, (IBakedModel)iBakedModel, (int)n2, (ItemStack)itemStack);
            return;
        }
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(7, DefaultVertexFormats.ITEM);
        for (EnumFacing enumFacing : EnumFacing.values()) {
            this.a(bufferBuilder, iBakedModel.getQuads((IBlockState)null, enumFacing, 0L), n2, itemStack);
        }
        this.a(bufferBuilder, iBakedModel.getQuads((IBlockState)null, (EnumFacing)null, 0L), n2, itemStack);
        tessellator.draw();
    }

    public void a(ItemStack itemStack, IBakedModel iBakedModel) {
        if (!itemStack.isEmpty()) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)-0.5f, (float)-0.5f, (float)-0.5f);
            if (iBakedModel.isBuiltInRenderer()) {
                GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GlStateManager.enableRescaleNormal();
                itemStack.getItem().getTileEntityItemStackRenderer().renderByItem(itemStack);
            } else {
                this.a(iBakedModel, itemStack);
                if (itemStack.hasEffect()) {
                    this.a(iBakedModel);
                }
            }
            GlStateManager.popMatrix();
        }
    }

    private /* synthetic */ void a(IBakedModel iBakedModel) {
        int n2 = -8372020;
        int n3 = -8372020;
        if (EnchantColor.a) {
            n2 = EnchantColor.b.getValue();
            n3 = EnchantColor.c.getValue();
        }
        GlStateManager.depthMask((boolean)false);
        GlStateManager.depthFunc((int)514);
        GlStateManager.disableLighting();
        GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_COLOR, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE);
        this.d.bindTexture(this.b);
        GlStateManager.matrixMode((int)5890);
        GlStateManager.pushMatrix();
        GlStateManager.scale((float)8.0f, (float)8.0f, (float)8.0f);
        float f2 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0f / 8.0f;
        GlStateManager.translate((float)f2, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)-50.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        this.a(iBakedModel, n2);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.scale((float)8.0f, (float)8.0f, (float)8.0f);
        float f3 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0f / 8.0f;
        GlStateManager.translate((float)(-f3), (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)10.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        this.a(iBakedModel, n3);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode((int)5888);
        GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.enableLighting();
        GlStateManager.depthFunc((int)515);
        GlStateManager.depthMask((boolean)true);
        this.d.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
    }

    public void a(BufferBuilder bufferBuilder, List list, int n2, ItemStack itemStack) {
        boolean bl = n2 == -1 && !itemStack.isEmpty();
        int n3 = list.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            BakedQuad bakedQuad = (BakedQuad)list.get(i2);
            int n4 = n2;
            if (bl && bakedQuad.hasTintIndex()) {
                n4 = this.e.colorMultiplier(itemStack, bakedQuad.getTintIndex());
                if (EntityRenderer.anaglyphEnable) {
                    n4 = TextureUtil.anaglyphColor((int)n4);
                }
                n4 |= 0xFF000000;
            }
            LightUtil.renderQuadColor((BufferBuilder)bufferBuilder, (BakedQuad)bakedQuad, (int)n4);
        }
    }

    public boolean a(ItemStack itemStack) {
        IBakedModel iBakedModel = this.c.getItemModel(itemStack);
        return iBakedModel == null ? false : iBakedModel.isGui3d();
    }

    public void a(ItemStack itemStack, ItemCameraTransforms.TransformType transformType) {
        if (!itemStack.isEmpty()) {
            IBakedModel iBakedModel = this.a(itemStack, null, (EntityLivingBase)null);
            this.a(itemStack, iBakedModel, transformType, false);
        }
    }

    public IBakedModel a(ItemStack itemStack, World world, EntityLivingBase entityLivingBase) {
        IBakedModel iBakedModel = this.c.getItemModel(itemStack);
        return iBakedModel.getOverrides().handleItemState(iBakedModel, itemStack, world, entityLivingBase);
    }

    public void a(ItemStack itemStack, EntityLivingBase entityLivingBase, ItemCameraTransforms.TransformType transformType, boolean bl) {
        if (!itemStack.isEmpty() && entityLivingBase != null) {
            IBakedModel iBakedModel = this.a(itemStack, entityLivingBase.world, entityLivingBase);
            this.a(itemStack, iBakedModel, transformType, bl);
        }
    }

    protected void a(ItemStack itemStack, IBakedModel iBakedModel, ItemCameraTransforms.TransformType transformType, boolean bl) {
        if (!itemStack.isEmpty()) {
            this.d.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            this.d.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.enableRescaleNormal();
            GlStateManager.alphaFunc((int)516, (float)0.1f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            GlStateManager.pushMatrix();
            iBakedModel = ForgeHooksClient.handleCameraTransforms((IBakedModel)iBakedModel, (ItemCameraTransforms.TransformType)transformType, (boolean)bl);
            this.a(itemStack, iBakedModel);
            GlStateManager.cullFace((GlStateManager.CullFace)GlStateManager.CullFace.BACK);
            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
            this.d.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            this.d.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
        }
    }

    public void a(ItemStack itemStack, int n2, int n3) {
        this.a(itemStack, n2, n3, this.a(itemStack, null, (EntityLivingBase)null));
    }

    protected void a(ItemStack itemStack, int n2, int n3, IBakedModel iBakedModel) {
        GlStateManager.pushMatrix();
        this.d.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        this.d.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc((int)516, (float)0.1f);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.a(n2, n3, iBakedModel.isGui3d());
        iBakedModel = ForgeHooksClient.handleCameraTransforms((IBakedModel)iBakedModel, (ItemCameraTransforms.TransformType)ItemCameraTransforms.TransformType.GUI, (boolean)false);
        this.a(itemStack, iBakedModel);
        GlStateManager.disableAlpha();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableLighting();
        GlStateManager.popMatrix();
        this.d.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        this.d.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
    }

    private /* synthetic */ void a(int n2, int n3, boolean bl) {
        GlStateManager.translate((float)n2, (float)n3, (float)(100.0f + this.a));
        GlStateManager.translate((float)8.0f, (float)8.0f, (float)0.0f);
        GlStateManager.scale((float)1.0f, (float)-1.0f, (float)1.0f);
        GlStateManager.scale((float)16.0f, (float)16.0f, (float)16.0f);
        if (bl) {
            GlStateManager.enableLighting();
        } else {
            GlStateManager.disableLighting();
        }
    }

    public void b(ItemStack itemStack, int n2, int n3) {
        this.a((EntityLivingBase)Minecraft.getMinecraft().player, itemStack, n2, n3);
    }

    public void a(EntityLivingBase entityLivingBase, ItemStack itemStack, int n2, int n3) {
        if (!itemStack.isEmpty()) {
            this.a += 50.0f;
            try {
                this.a(itemStack, n2, n3, this.a(itemStack, null, entityLivingBase));
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport((Throwable)throwable, (String)"Rendering item");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Item being rendered");
                crashReportCategory.addDetail("Item Type", (ICrashReportDetail)new k(this, itemStack));
                crashReportCategory.addDetail("Registry Name", () -> String.valueOf(itemStack.getItem().getRegistryName()));
                crashReportCategory.addDetail("Item Aux", (ICrashReportDetail)new l(this, itemStack));
                crashReportCategory.addDetail("Item NBT", (ICrashReportDetail)new o(this, itemStack));
                crashReportCategory.addDetail("Item Foil", (ICrashReportDetail)new n(this, itemStack));
                throw new ReportedException(crashReport);
            }
            this.a -= 50.0f;
        }
    }

    public void a(FontRenderer fontRenderer, ItemStack itemStack, int n2, int n3) {
        this.a(fontRenderer, itemStack, n2, n3, null);
    }

    public void a(FontRenderer fontRenderer, ItemStack itemStack, int n2, int n3, String string) {
        if (!itemStack.isEmpty()) {
            float f2;
            String string2;
            if (itemStack.getCount() != 1 || string != null) {
                string2 = string == null ? String.valueOf(itemStack.getCount()) : string;
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableBlend();
                fontRenderer.drawStringWithShadow(string2, (float)(n2 + 19 - 2 - fontRenderer.getStringWidth(string2)), (float)(n3 + 6 + 3), 0xFFFFFF);
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
                GlStateManager.enableBlend();
            }
            if (itemStack.getItem().showDurabilityBar(itemStack)) {
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                GlStateManager.disableAlpha();
                GlStateManager.disableBlend();
                string2 = Tessellator.getInstance();
                BufferBuilder bufferBuilder = string2.getBuffer();
                double d2 = itemStack.getItem().getDurabilityForDisplay(itemStack);
                int n4 = itemStack.getItem().getRGBDurabilityForDisplay(itemStack);
                int n5 = Math.round(13.0f - (float)d2 * 13.0f);
                int n6 = n4;
                this.a(bufferBuilder, n2 + 2, n3 + 13, 13, 2, 0, 0, 0, 255);
                this.a(bufferBuilder, n2 + 2, n3 + 13, n5, 1, n6 >> 16 & 0xFF, n6 >> 8 & 0xFF, n6 & 0xFF, 255);
                GlStateManager.enableBlend();
                GlStateManager.enableAlpha();
                GlStateManager.enableTexture2D();
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
            float f3 = f2 = (string2 = Minecraft.getMinecraft().player) == null ? 0.0f : string2.getCooldownTracker().getCooldown(itemStack.getItem(), Minecraft.getMinecraft().getRenderPartialTicks());
            if (f2 > 0.0f) {
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferBuilder = tessellator.getBuffer();
                this.a(bufferBuilder, n2, n3 + MathHelper.floor((float)(16.0f * (1.0f - f2))), 16, MathHelper.ceil((float)(16.0f * f2)), 255, 255, 255, 127);
                GlStateManager.enableTexture2D();
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
        }
    }

    private /* synthetic */ void a(BufferBuilder bufferBuilder, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)(n2 + 0), (double)(n3 + 0), 0.0).color(n6, n7, n8, n9).endVertex();
        bufferBuilder.pos((double)(n2 + 0), (double)(n3 + n5), 0.0).color(n6, n7, n8, n9).endVertex();
        bufferBuilder.pos((double)(n2 + n4), (double)(n3 + n5), 0.0).color(n6, n7, n8, n9).endVertex();
        bufferBuilder.pos((double)(n2 + n4), (double)(n3 + 0), 0.0).color(n6, n7, n8, n9).endVertex();
        Tessellator.getInstance().draw();
    }

    public void a(IResourceManager iResourceManager) {
        this.c.rebuildCache();
    }
}

