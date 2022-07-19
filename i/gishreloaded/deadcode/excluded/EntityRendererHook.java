/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.base.Predicates
 *  com.google.gson.JsonSyntaxException
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.gui.MapItemRenderer
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.particle.ParticleManager
 *  net.minecraft.client.renderer.ActiveRenderInfo
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.GLAllocation
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$FogMode
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.ItemRenderer
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.client.renderer.culling.ClippingHelperImpl
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.client.renderer.texture.TextureMap
 *  net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.client.resources.IResourceManager
 *  net.minecraft.client.shader.ShaderGroup
 *  net.minecraft.client.shader.ShaderLinkHelper
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityItemFrame
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.MobEffects
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.BlockRenderLayer
 *  net.minecraft.util.EntitySelectors
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.MouseFilter
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$MutableBlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.GameType
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.Biome
 *  net.minecraftforge.client.ForgeHooksClient
 *  net.minecraftforge.client.IRenderHandler
 *  net.minecraftforge.client.event.EntityViewRenderEvent$CameraSetup
 *  net.minecraftforge.client.event.EntityViewRenderEvent$FogColors
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GLContext
 *  org.lwjgl.util.glu.Project
 */
package i.gishreloaded.deadcode.excluded;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.gson.JsonSyntaxException;
import excluded.r;
import i.gishreloaded.deadcode.excluded.ItemRendererHook;
import i.gishreloaded.deadcode.excluded.UIScreen;
import i.gishreloaded.deadcode.hacks.other.Optimization;
import i.gishreloaded.deadcode.hacks.render.Ambience;
import i.gishreloaded.deadcode.hacks.render.AntiBadEffects;
import i.gishreloaded.deadcode.hacks.render.CameraClip;
import i.gishreloaded.deadcode.hacks.render.CustomFog;
import i.gishreloaded.deadcode.hacks.render.CustomRain;
import i.gishreloaded.deadcode.hacks.render.CustomSnow;
import i.gishreloaded.deadcode.hacks.render.NightVision;
import i.gishreloaded.deadcode.hacks.render.NoHurtCam;
import i.gishreloaded.deadcode.hacks.render.Profiler;
import i.gishreloaded.deadcode.hacks.render.Tracers;
import i.gishreloaded.deadcode.hacks.render.UserInterface;
import i.gishreloaded.deadcode.hacks.render.WaterVision;
import i.gishreloaded.deadcode.hacks.render.WeatherClear;
import i.gishreloaded.deadcode.hacks.render.Zoom;
import i.gishreloaded.deadcode.hacks.world.NoInteract;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.culling.ClippingHelperImpl;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderLinkHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MouseFilter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;

public class EntityRendererHook
extends EntityRenderer {
    private final ResourceLocation e;
    private final ResourceLocation f;
    public static boolean a;
    public static int b;
    private final Minecraft g;
    private final IResourceManager h;
    private final Random i;
    private float j;
    public final ItemRenderer c;
    private final MapItemRenderer k;
    private int l;
    private Entity m;
    private final MouseFilter n;
    private final MouseFilter o;
    private float p = 4.0f;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private boolean z;
    private boolean A = true;
    private boolean B = true;
    private long C = Minecraft.getSystemTime();
    private final DynamicTexture D;
    private final int[] E;
    private final ResourceLocation F;
    private boolean G;
    private float H;
    private float I;
    private int J;
    private final float[] K = new float[1024];
    private final float[] L = new float[1024];
    private final FloatBuffer M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private boolean T;
    private double U = 1.0;
    private double V;
    private double W;
    private ItemStack X;
    private int Y;
    private float Z;
    private float aa;
    private ShaderGroup ab;
    private final ResourceLocation[] ac;
    public final int d;
    private int ad;
    private boolean ae;
    private int af;

    public EntityRendererHook(Minecraft minecraft, IResourceManager iResourceManager) {
        super(minecraft, iResourceManager);
        this.i = new Random();
        this.M = GLAllocation.createDirectFloatBuffer((int)16);
        this.ac = new ResourceLocation[]{new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json"), new ResourceLocation("shaders/post/creeper.json"), new ResourceLocation("shaders/post/spider.json")};
        this.d = this.ac.length;
        this.e = new ResourceLocation("textures/environment/rain.png");
        this.f = new ResourceLocation("textures/environment/snow.png");
        this.n = new MouseFilter();
        this.o = new MouseFilter();
        this.ad = this.d;
        this.g = minecraft;
        this.h = iResourceManager;
        this.c = new ItemRendererHook(minecraft);
        this.k = new MapItemRenderer(minecraft.getTextureManager());
        this.D = new DynamicTexture(16, 16);
        this.F = minecraft.getTextureManager().getDynamicTextureLocation("lightMap", this.D);
        this.E = this.D.getTextureData();
        this.ab = null;
        for (int i2 = 0; i2 < 32; ++i2) {
            for (int i3 = 0; i3 < 32; ++i3) {
                float f2 = i3 - 16;
                float f3 = i2 - 16;
                float f4 = MathHelper.sqrt((float)(f2 * f2 + f3 * f3));
                this.K[i2 << 5 | i3] = -f3 / f4;
                this.L[i2 << 5 | i3] = f2 / f4;
            }
        }
    }

    public boolean isShaderActive() {
        return OpenGlHelper.shadersSupported && this.ab != null;
    }

    public void stopUseShader() {
        if (this.ab != null) {
            this.ab.deleteShaderGroup();
        }
        this.ab = null;
        this.ad = this.d;
    }

    public void switchUseShader() {
        this.ae = !this.ae;
    }

    public void loadEntityShader(Entity entity) {
        if (OpenGlHelper.shadersSupported) {
            if (this.ab != null) {
                this.ab.deleteShaderGroup();
            }
            this.ab = null;
            if (entity instanceof EntityCreeper) {
                this.loadShader(new ResourceLocation("shaders/post/creeper.json"));
            } else if (entity instanceof EntitySpider) {
                this.loadShader(new ResourceLocation("shaders/post/spider.json"));
            } else if (entity instanceof EntityEnderman) {
                this.loadShader(new ResourceLocation("shaders/post/invert.json"));
            } else {
                ForgeHooksClient.loadEntityShader((Entity)entity, (EntityRenderer)this);
            }
        }
    }

    public void loadShader(ResourceLocation resourceLocation) {
        try {
            this.ab = new ShaderGroup(this.g.getTextureManager(), this.h, this.g.getFramebuffer(), resourceLocation);
            this.ab.createBindFramebuffers(this.g.displayWidth, this.g.displayHeight);
            this.ae = true;
        }
        catch (IOException iOException) {
            this.ad = this.d;
            this.ae = false;
        }
        catch (JsonSyntaxException jsonSyntaxException) {
            this.ad = this.d;
            this.ae = false;
        }
    }

    public void onResourceManagerReload(IResourceManager iResourceManager) {
        if (this.ab != null) {
            this.ab.deleteShaderGroup();
        }
        this.ab = null;
        if (this.ad == this.d) {
            this.loadEntityShader(this.g.getRenderViewEntity());
        } else {
            this.loadShader(this.ac[this.ad]);
        }
    }

    public void updateRenderer() {
        float f2;
        float f3;
        if (OpenGlHelper.shadersSupported && ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
            ShaderLinkHelper.setNewStaticShaderLinkHelper();
        }
        this.updateFovModifierHand();
        this.updateTorchFlicker();
        this.Q = this.R;
        float f4 = this.p = CameraClip.a ? CameraClip.b.getValue().floatValue() / 8.0f : 4.0f;
        if (this.g.gameSettings.smoothCamera) {
            f3 = this.g.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            f2 = f3 * f3 * f3 * 8.0f;
            this.s = this.n.smooth(this.q, 0.05f * f2);
            this.t = this.o.smooth(this.r, 0.05f * f2);
            this.q = 0.0f;
            this.r = 0.0f;
        } else {
            this.s = 0.0f;
            this.t = 0.0f;
            this.n.reset();
            this.o.reset();
        }
        if (this.g.getRenderViewEntity() == null) {
            this.g.setRenderViewEntity((Entity)this.g.player);
        }
        f3 = this.g.world.getLightBrightness(new BlockPos(this.g.getRenderViewEntity().getPositionEyes(1.0f)));
        f2 = (float)this.g.gameSettings.renderDistanceChunks / 32.0f;
        float f5 = f3 * (1.0f - f2) + f2;
        this.R += (f5 - this.R) * 0.1f;
        ++this.l;
        this.c.updateEquippedItem();
        this.addRainParticles();
        this.y = this.x;
        if (this.g.ingameGUI.getBossOverlay().shouldDarkenSky()) {
            this.x += 0.05f;
            if (this.x > 1.0f) {
                this.x = 1.0f;
            }
        } else if (this.x > 0.0f) {
            this.x -= 0.0125f;
        }
        if (this.Y > 0) {
            --this.Y;
            if (this.Y == 0) {
                this.X = null;
            }
        }
    }

    public ShaderGroup getShaderGroup() {
        return this.ab;
    }

    public void updateShaderGroupSize(int n2, int n3) {
        if (OpenGlHelper.shadersSupported) {
            if (this.ab != null) {
                this.ab.createBindFramebuffers(n2, n3);
            }
            this.g.renderGlobal.createBindEntityOutlineFbs(n2, n3);
        }
    }

    public void getMouseOver(float f2) {
        try {
            Entity entity = this.g.getRenderViewEntity();
            if (entity != null && this.g.world != null) {
                this.g.profiler.startSection("pick");
                this.g.pointedEntity = null;
                double d2 = this.g.playerController.getBlockReachDistance();
                RayTraceResult rayTraceResult = entity.rayTrace(d2, f2);
                boolean bl = true;
                if (NoInteract.a && rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && rayTraceResult.getBlockPos() != null) {
                    for (Block block : NoInteract.b) {
                        if (eS.b(rayTraceResult.getBlockPos()) != block) continue;
                        bl = false;
                    }
                }
                if (bl) {
                    this.g.objectMouseOver = rayTraceResult;
                }
                Vec3d vec3d = entity.getPositionEyes(f2);
                int n2 = 0;
                double d3 = d2;
                if (this.g.playerController.extendedReach()) {
                    d2 = d3 = 6.0;
                } else if (d2 > 3.0) {
                    n2 = 1;
                }
                if (this.g.objectMouseOver != null) {
                    d3 = this.g.objectMouseOver.hitVec.distanceTo(vec3d);
                }
                Vec3d vec3d2 = entity.getLook(1.0f);
                Vec3d vec3d3 = vec3d.add(vec3d2.x * d2, vec3d2.y * d2, vec3d2.z * d2);
                this.m = null;
                Vec3d vec3d4 = null;
                List list = this.g.world.getEntitiesInAABBexcluding(entity, entity.getEntityBoundingBox().expand(vec3d2.x * d2, vec3d2.y * d2, vec3d2.z * d2).grow(1.0, 1.0, 1.0), Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, (Predicate)new r(this)));
                double d4 = d3;
                for (int i2 = 0; i2 < list.size(); ++i2) {
                    double d5;
                    Entity entity2 = (Entity)list.get(i2);
                    AxisAlignedBB axisAlignedBB = entity2.getEntityBoundingBox().grow((double)entity2.getCollisionBorderSize());
                    RayTraceResult rayTraceResult2 = axisAlignedBB.calculateIntercept(vec3d, vec3d3);
                    if (axisAlignedBB.contains(vec3d)) {
                        if (!(d4 >= 0.0)) continue;
                        this.m = entity2;
                        vec3d4 = rayTraceResult2 == null ? vec3d : rayTraceResult2.hitVec;
                        d4 = 0.0;
                        continue;
                    }
                    if (rayTraceResult2 == null || !((d5 = vec3d.distanceTo(rayTraceResult2.hitVec)) < d4) && d4 != 0.0) continue;
                    if (entity2.getLowestRidingEntity() == entity.getLowestRidingEntity() && !entity2.canRiderInteract()) {
                        if (d4 != 0.0) continue;
                        this.m = entity2;
                        vec3d4 = rayTraceResult2.hitVec;
                        continue;
                    }
                    this.m = entity2;
                    vec3d4 = rayTraceResult2.hitVec;
                    d4 = d5;
                }
                if (this.m != null && n2 != 0 && vec3d.distanceTo(vec3d4) > 3.0) {
                    this.m = null;
                    this.g.objectMouseOver = new RayTraceResult(RayTraceResult.Type.MISS, vec3d4, (EnumFacing)null, new BlockPos(vec3d4));
                }
                if (this.m != null && (d4 < d3 || this.g.objectMouseOver == null)) {
                    this.g.objectMouseOver = new RayTraceResult(this.m, vec3d4);
                    if (this.m instanceof EntityLivingBase || this.m instanceof EntityItemFrame) {
                        this.g.pointedEntity = this.m;
                    }
                }
                this.g.profiler.endSection();
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("getMouseOver", exception);
        }
    }

    private /* synthetic */ void updateFovModifierHand() {
        float f2 = 1.0f;
        if (this.g.getRenderViewEntity() instanceof AbstractClientPlayer) {
            AbstractClientPlayer abstractClientPlayer = (AbstractClientPlayer)this.g.getRenderViewEntity();
            f2 = abstractClientPlayer.getFovModifier();
        }
        this.w = this.v;
        this.v += (f2 - this.v) * 0.5f;
        if (this.v > 1.5f) {
            this.v = 1.5f;
        }
        if (this.v < 0.1f) {
            this.v = 0.1f;
        }
    }

    private /* synthetic */ float getFOVModifier(float f2, boolean bl) {
        IBlockState iBlockState;
        if (this.T) {
            return 90.0f;
        }
        Entity entity = this.g.getRenderViewEntity();
        float f3 = 70.0f;
        if (bl) {
            f3 = this.g.gameSettings.fovSetting;
            if (this.g.gameSettings.viewBobbing) {
                f3 *= this.w + (this.v - this.w) * f2;
            }
        }
        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getHealth() <= 0.0f) {
            float f4 = (float)((EntityLivingBase)entity).deathTime + f2;
            f3 /= (1.0f - 500.0f / (f4 + 500.0f)) * 2.0f + 1.0f;
        }
        if ((iBlockState = ActiveRenderInfo.getBlockStateAtEntityViewpoint((World)this.g.world, (Entity)entity, (float)f2)).getMaterial() == Material.WATER) {
            f3 = f3 * 60.0f / 70.0f;
        }
        if (Zoom.a) {
            f3 /= Zoom.b;
        }
        return ForgeHooksClient.getFOVModifier((EntityRenderer)this.g.entityRenderer, (Entity)entity, (IBlockState)iBlockState, (double)f2, (float)f3);
    }

    private /* synthetic */ void hurtCameraEffect(float f2) {
        if (!NoHurtCam.a && this.g.getRenderViewEntity() instanceof EntityLivingBase) {
            float f3;
            EntityLivingBase entityLivingBase = (EntityLivingBase)this.g.getRenderViewEntity();
            float f4 = (float)entityLivingBase.hurtTime - f2;
            if (entityLivingBase.getHealth() <= 0.0f) {
                f3 = (float)entityLivingBase.deathTime + f2;
                GlStateManager.rotate((float)(40.0f - 8000.0f / (f3 + 200.0f)), (float)0.0f, (float)0.0f, (float)1.0f);
            }
            if (f4 < 0.0f) {
                return;
            }
            f4 /= (float)entityLivingBase.maxHurtTime;
            f4 = MathHelper.sin((float)(f4 * f4 * f4 * f4 * (float)Math.PI));
            f3 = entityLivingBase.attackedAtYaw;
            GlStateManager.rotate((float)(-f3), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)(-f4 * 14.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GlStateManager.rotate((float)f3, (float)0.0f, (float)1.0f, (float)0.0f);
        }
    }

    private /* synthetic */ void applyBobbing(float f2) {
        if (!this.g.gameSettings.viewBobbing) {
            return;
        }
        if (this.g.getRenderViewEntity() instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)this.g.getRenderViewEntity();
            float f3 = entityPlayer.distanceWalkedModified - entityPlayer.prevDistanceWalkedModified;
            float f4 = -(entityPlayer.distanceWalkedModified + f3 * f2);
            float f5 = entityPlayer.prevCameraYaw + (entityPlayer.cameraYaw - entityPlayer.prevCameraYaw) * f2;
            float f6 = entityPlayer.prevCameraPitch + (entityPlayer.cameraPitch - entityPlayer.prevCameraPitch) * f2;
            GlStateManager.translate((float)(MathHelper.sin((float)(f4 * (float)Math.PI)) * f5 * 0.5f), (float)(-Math.abs(MathHelper.cos((float)(f4 * (float)Math.PI)) * f5)), (float)0.0f);
            GlStateManager.rotate((float)(MathHelper.sin((float)(f4 * (float)Math.PI)) * f5 * 3.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GlStateManager.rotate((float)(Math.abs(MathHelper.cos((float)(f4 * (float)Math.PI - 0.2f)) * f5) * 5.0f), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.rotate((float)f6, (float)1.0f, (float)0.0f, (float)0.0f);
        }
    }

    private /* synthetic */ void orientCamera(float f2) {
        float f3;
        Entity entity = this.g.getRenderViewEntity();
        float f4 = entity.getEyeHeight();
        double d2 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)f2;
        double d3 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)f2 + (double)f4;
        double d4 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)f2;
        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPlayerSleeping()) {
            f4 = (float)((double)f4 + 1.0);
            GlStateManager.translate((float)0.0f, (float)0.3f, (float)0.0f);
            if (!this.g.gameSettings.debugCamEnable) {
                BlockPos blockPos = new BlockPos(entity);
                IBlockState iBlockState = this.g.world.getBlockState(blockPos);
                ForgeHooksClient.orientBedCamera((IBlockAccess)this.g.world, (BlockPos)blockPos, (IBlockState)iBlockState, (Entity)entity);
                GlStateManager.rotate((float)(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f2 + 180.0f), (float)0.0f, (float)-1.0f, (float)0.0f);
                GlStateManager.rotate((float)(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f2), (float)-1.0f, (float)0.0f, (float)0.0f);
            }
        } else if (this.g.gameSettings.thirdPersonView > 0) {
            double d5 = this.p;
            if (this.g.gameSettings.debugCamEnable) {
                GlStateManager.translate((float)0.0f, (float)0.0f, (float)((float)(-d5)));
            } else {
                float f5;
                f3 = entity.rotationYaw;
                float f6 = entity.rotationPitch;
                if (this.g.gameSettings.thirdPersonView == 2) {
                    f6 += 180.0f;
                }
                double d6 = (double)(-MathHelper.sin((float)(f3 * ((float)Math.PI / 180))) * MathHelper.cos((float)(f6 * ((float)Math.PI / 180)))) * d5;
                double d7 = (double)(MathHelper.cos((float)(f3 * ((float)Math.PI / 180))) * MathHelper.cos((float)(f6 * ((float)Math.PI / 180)))) * d5;
                double d8 = (double)(-MathHelper.sin((float)(f6 * ((float)Math.PI / 180)))) * d5;
                for (int i2 = 0; i2 < 8; ++i2) {
                    double d9;
                    RayTraceResult rayTraceResult;
                    f5 = (i2 & 1) * 2 - 1;
                    float f7 = (i2 >> 1 & 1) * 2 - 1;
                    float f8 = (i2 >> 2 & 1) * 2 - 1;
                    if ((rayTraceResult = this.g.world.rayTraceBlocks(new Vec3d(d2 + (double)(f5 *= 0.1f), d3 + (double)(f7 *= 0.1f), d4 + (double)(f8 *= 0.1f)), new Vec3d(d2 - d6 + (double)f5 + (double)f8, d3 - d8 + (double)f7, d4 - d7 + (double)f8))) == null || CameraClip.a || !((d9 = rayTraceResult.hitVec.distanceTo(new Vec3d(d2, d3, d4))) < d5)) continue;
                    d5 = d9;
                }
                if (this.g.gameSettings.thirdPersonView == 2) {
                    GlStateManager.rotate((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                }
                float f9 = CameraClip.a ? CameraClip.c.getValue().floatValue() : 0.0f;
                f5 = CameraClip.a ? CameraClip.d.getValue().floatValue() : 0.0f;
                GlStateManager.rotate((float)(entity.rotationPitch - f6), (float)1.0f, (float)0.0f, (float)0.0f);
                GlStateManager.rotate((float)(entity.rotationYaw - f3), (float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.translate((float)f9, (float)f5, (float)((float)(-d5)));
                GlStateManager.rotate((float)(f3 - entity.rotationYaw), (float)0.0f, (float)1.0f, (float)0.0f);
                GlStateManager.rotate((float)(f6 - entity.rotationPitch), (float)1.0f, (float)0.0f, (float)0.0f);
            }
        } else {
            GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.05f);
        }
        if (!this.g.gameSettings.debugCamEnable) {
            float f10 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f2 + 180.0f;
            float f11 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f2;
            f3 = 0.0f;
            if (entity instanceof EntityAnimal) {
                EntityAnimal entityAnimal = (EntityAnimal)entity;
                f10 = entityAnimal.prevRotationYawHead + (entityAnimal.rotationYawHead - entityAnimal.prevRotationYawHead) * f2 + 180.0f;
            }
            IBlockState iBlockState = ActiveRenderInfo.getBlockStateAtEntityViewpoint((World)this.g.world, (Entity)entity, (float)f2);
            EntityViewRenderEvent.CameraSetup cameraSetup = new EntityViewRenderEvent.CameraSetup((EntityRenderer)this, entity, iBlockState, (double)f2, f10, f11, f3);
            MinecraftForge.EVENT_BUS.post((Event)cameraSetup);
            GlStateManager.rotate((float)cameraSetup.getRoll(), (float)0.0f, (float)0.0f, (float)1.0f);
            GlStateManager.rotate((float)cameraSetup.getPitch(), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.rotate((float)cameraSetup.getYaw(), (float)0.0f, (float)1.0f, (float)0.0f);
        }
        GlStateManager.translate((float)0.0f, (float)(-f4), (float)0.0f);
        d2 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double)f2;
        d3 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double)f2 + (double)f4;
        d4 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)f2;
        this.z = this.g.renderGlobal.hasCloudFog(d2, d3, d4, f2);
    }

    private /* synthetic */ void setupCameraTransform(float f2, int n2) {
        float f3;
        this.j = this.g.gameSettings.renderDistanceChunks * 16;
        this.j *= 0.83f;
        GlStateManager.matrixMode((int)5889);
        GlStateManager.loadIdentity();
        if (this.g.gameSettings.anaglyph) {
            GlStateManager.translate((float)((float)(-(n2 * 2 - 1)) * 0.07f), (float)0.0f, (float)0.0f);
        }
        if (this.U != 1.0) {
            GlStateManager.translate((float)((float)this.V), (float)((float)(-this.W)), (float)0.0f);
            GlStateManager.scale((double)this.U, (double)this.U, (double)1.0);
        }
        Project.gluPerspective((float)this.getFOVModifier(f2, true), (float)((float)this.g.displayWidth / (float)this.g.displayHeight), (float)0.05f, (float)(this.j * MathHelper.SQRT_2));
        GlStateManager.matrixMode((int)5888);
        GlStateManager.loadIdentity();
        if (this.g.gameSettings.anaglyph) {
            GlStateManager.translate((float)((float)(n2 * 2 - 1) * 0.1f), (float)0.0f, (float)0.0f);
        }
        this.hurtCameraEffect(f2);
        if (this.g.gameSettings.viewBobbing && !Tracers.e) {
            this.applyBobbing(f2);
        }
        if ((f3 = this.g.player.prevTimeInPortal + (this.g.player.timeInPortal - this.g.player.prevTimeInPortal) * f2) > 0.0f && !AntiBadEffects.a) {
            int n3 = 20;
            if (this.g.player.isPotionActive(MobEffects.NAUSEA)) {
                n3 = 7;
            }
            float f4 = 5.0f / (f3 * f3 + 5.0f) - f3 * 0.04f;
            f4 *= f4;
            GlStateManager.rotate((float)(((float)this.l + f2) * (float)n3), (float)0.0f, (float)1.0f, (float)1.0f);
            GlStateManager.scale((float)(1.0f / f4), (float)1.0f, (float)1.0f);
            GlStateManager.rotate((float)(-((float)this.l + f2) * (float)n3), (float)0.0f, (float)1.0f, (float)1.0f);
        }
        this.orientCamera(f2);
        if (this.T) {
            switch (this.S) {
                case 0: {
                    GlStateManager.rotate((float)90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    break;
                }
                case 1: {
                    GlStateManager.rotate((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    break;
                }
                case 2: {
                    GlStateManager.rotate((float)-90.0f, (float)0.0f, (float)1.0f, (float)0.0f);
                    break;
                }
                case 3: {
                    GlStateManager.rotate((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                    break;
                }
                case 4: {
                    GlStateManager.rotate((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                }
            }
        }
    }

    private /* synthetic */ void renderHand(float f2, int n2) {
        if (Tracers.e && Tracers.b.getModeByIndex(1).isToggled()) {
            for (Entity entity : et.b()) {
                if (!(entity instanceof EntityLivingBase)) continue;
                Profiler.a(entity, f2, false, false, false, false, false, false, true, false, false);
            }
        }
        if (!this.T) {
            boolean bl;
            GlStateManager.matrixMode((int)5889);
            GlStateManager.loadIdentity();
            if (this.g.gameSettings.anaglyph) {
                GlStateManager.translate((float)((float)(-(n2 * 2 - 1)) * 0.07f), (float)0.0f, (float)0.0f);
            }
            Project.gluPerspective((float)this.getFOVModifier(f2, false), (float)((float)this.g.displayWidth / (float)this.g.displayHeight), (float)0.05f, (float)(this.j * 2.0f));
            GlStateManager.matrixMode((int)5888);
            GlStateManager.loadIdentity();
            if (this.g.gameSettings.anaglyph) {
                GlStateManager.translate((float)((float)(n2 * 2 - 1) * 0.1f), (float)0.0f, (float)0.0f);
            }
            GlStateManager.pushMatrix();
            this.hurtCameraEffect(f2);
            if (this.g.gameSettings.viewBobbing) {
                this.applyBobbing(f2);
            }
            boolean bl2 = bl = this.g.getRenderViewEntity() instanceof EntityLivingBase && ((EntityLivingBase)this.g.getRenderViewEntity()).isPlayerSleeping();
            if (!(ForgeHooksClient.renderFirstPersonHand((RenderGlobal)this.g.renderGlobal, (float)f2, (int)n2) || this.g.gameSettings.thirdPersonView != 0 || bl || this.g.gameSettings.hideGUI || this.g.playerController.isSpectator())) {
                this.enableLightmap();
                this.c.renderItemInFirstPerson(f2);
                this.disableLightmap();
            }
            GlStateManager.popMatrix();
            if (this.g.gameSettings.thirdPersonView == 0 && !bl) {
                this.c.renderOverlays(f2);
                this.hurtCameraEffect(f2);
            }
            if (this.g.gameSettings.viewBobbing) {
                this.applyBobbing(f2);
            }
        }
    }

    public void disableLightmap() {
        GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
    }

    public void enableLightmap() {
        GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
        GlStateManager.matrixMode((int)5890);
        GlStateManager.loadIdentity();
        GlStateManager.scale((float)0.00390625f, (float)0.00390625f, (float)0.00390625f);
        GlStateManager.translate((float)8.0f, (float)8.0f, (float)8.0f);
        GlStateManager.matrixMode((int)5888);
        this.g.getTextureManager().bindTexture(this.F);
        GlStateManager.glTexParameteri((int)3553, (int)10241, (int)9729);
        GlStateManager.glTexParameteri((int)3553, (int)10240, (int)9729);
        GlStateManager.glTexParameteri((int)3553, (int)10242, (int)10496);
        GlStateManager.glTexParameteri((int)3553, (int)10243, (int)10496);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
    }

    private /* synthetic */ void updateTorchFlicker() {
        this.I = (float)((double)this.I + (Math.random() - Math.random()) * Math.random() * Math.random());
        this.I = (float)((double)this.I * 0.9);
        this.H += this.I - this.H;
        this.G = true;
    }

    private /* synthetic */ void updateLightmap(float f2) {
        if (this.G) {
            this.g.profiler.startSection("lightTex");
            WorldClient worldClient = this.g.world;
            if (worldClient != null) {
                float f3 = worldClient.getSunBrightness(1.0f);
                float f4 = f3 * 0.95f + 0.05f;
                for (int i2 = 0; i2 < 256; ++i2) {
                    float f5;
                    float f6;
                    float f7 = worldClient.provider.getLightBrightnessTable()[i2 / 16] * f4;
                    float f8 = worldClient.provider.getLightBrightnessTable()[i2 % 16] * (this.H * 0.1f + 1.5f);
                    if (worldClient.getLastLightningBolt() > 0) {
                        f7 = worldClient.provider.getLightBrightnessTable()[i2 / 16];
                    }
                    float f9 = f7 * (f3 * 0.65f + 0.35f);
                    float f10 = f7 * (f3 * 0.65f + 0.35f);
                    float f11 = f8 * ((f8 * 0.6f + 0.4f) * 0.6f + 0.4f);
                    float f12 = f8 * (f8 * f8 * 0.6f + 0.4f);
                    float f13 = f9 + f8;
                    float f14 = f10 + f11;
                    float f15 = f7 + f12;
                    f13 = f13 * 0.96f + 0.03f;
                    f14 = f14 * 0.96f + 0.03f;
                    f15 = f15 * 0.96f + 0.03f;
                    if (this.x > 0.0f) {
                        float f16 = this.y + (this.x - this.y) * f2;
                        f13 = f13 * (1.0f - f16) + f13 * 0.7f * f16;
                        f14 = f14 * (1.0f - f16) + f14 * 0.6f * f16;
                        f15 = f15 * (1.0f - f16) + f15 * 0.6f * f16;
                    }
                    if (worldClient.provider.getDimensionType().getId() == 1) {
                        f13 = 0.22f + f8 * 0.75f;
                        f14 = 0.28f + f11 * 0.75f;
                        f15 = 0.25f + f12 * 0.75f;
                    }
                    float[] fArray = new float[]{f13, f14, f15};
                    worldClient.provider.getLightmapColors(f2, f3, f7, f8, fArray);
                    f13 = fArray[0];
                    f14 = fArray[1];
                    f15 = fArray[2];
                    f13 = MathHelper.clamp((float)f13, (float)0.0f, (float)1.0f);
                    f14 = MathHelper.clamp((float)f14, (float)0.0f, (float)1.0f);
                    f15 = MathHelper.clamp((float)f15, (float)0.0f, (float)1.0f);
                    if (this.g.player.isPotionActive(MobEffects.NIGHT_VISION) || NightVision.a) {
                        f6 = this.getNightVisionBrightness((EntityLivingBase)this.g.player, f2);
                        f5 = 1.0f / f13;
                        if (f5 > 1.0f / f14) {
                            f5 = 1.0f / f14;
                        }
                        if (f5 > 1.0f / f15) {
                            f5 = 1.0f / f15;
                        }
                        f13 = f13 * (1.0f - f6) + f13 * f5 * f6;
                        f14 = f14 * (1.0f - f6) + f14 * f5 * f6;
                        f15 = f15 * (1.0f - f6) + f15 * f5 * f6;
                    }
                    if (f13 > 1.0f) {
                        f13 = 1.0f;
                    }
                    if (f14 > 1.0f) {
                        f14 = 1.0f;
                    }
                    if (f15 > 1.0f) {
                        f15 = 1.0f;
                    }
                    f6 = this.g.gameSettings.gammaSetting;
                    f5 = 1.0f - f13;
                    float f17 = 1.0f - f14;
                    float f18 = 1.0f - f15;
                    f5 = 1.0f - f5 * f5 * f5 * f5;
                    f17 = 1.0f - f17 * f17 * f17 * f17;
                    f18 = 1.0f - f18 * f18 * f18 * f18;
                    f13 = f13 * (1.0f - f6) + f5 * f6;
                    f14 = f14 * (1.0f - f6) + f17 * f6;
                    f15 = f15 * (1.0f - f6) + f18 * f6;
                    f13 = f13 * 0.96f + 0.03f;
                    f14 = f14 * 0.96f + 0.03f;
                    f15 = f15 * 0.96f + 0.03f;
                    if (f13 > 1.0f) {
                        f13 = 1.0f;
                    }
                    if (f14 > 1.0f) {
                        f14 = 1.0f;
                    }
                    if (f15 > 1.0f) {
                        f15 = 1.0f;
                    }
                    if (f13 < 0.0f) {
                        f13 = 0.0f;
                    }
                    if (f14 < 0.0f) {
                        f14 = 0.0f;
                    }
                    if (f15 < 0.0f) {
                        f15 = 0.0f;
                    }
                    int n2 = (int)(f13 * 255.0f);
                    int n3 = (int)(f14 * 255.0f);
                    int n4 = (int)(f15 * 255.0f);
                    this.E[i2] = Ambience.a ? Ambience.b.getValue() : 0xFF000000 | n2 << 16 | n3 << 8 | n4;
                }
                this.D.updateDynamicTexture();
                this.G = false;
                this.g.profiler.endSection();
            }
        }
    }

    private /* synthetic */ float getNightVisionBrightness(EntityLivingBase entityLivingBase, float f2) {
        if (NightVision.a) {
            return 1.0f;
        }
        int n2 = entityLivingBase.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration();
        return n2 > 200 ? 1.0f : 0.7f + MathHelper.sin((float)(((float)n2 - f2) * (float)Math.PI * 0.2f)) * 0.3f;
    }

    public void renderStreamIndicator(float f2) {
        this.setupOverlayRendering();
    }

    private /* synthetic */ boolean isDrawBlockOutline() {
        boolean bl;
        if (!this.B) {
            return false;
        }
        Entity entity = this.g.getRenderViewEntity();
        boolean bl2 = bl = entity instanceof EntityPlayer && !this.g.gameSettings.hideGUI;
        if (bl && !((EntityPlayer)entity).capabilities.allowEdit) {
            ItemStack itemStack = ((EntityPlayer)entity).getHeldItemMainhand();
            if (this.g.objectMouseOver != null && this.g.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                BlockPos blockPos = this.g.objectMouseOver.getBlockPos();
                Block block = this.g.world.getBlockState(blockPos).getBlock();
                bl = this.g.playerController.getCurrentGameType() == GameType.SPECTATOR ? block.hasTileEntity(this.g.world.getBlockState(blockPos)) && this.g.world.getTileEntity(blockPos) instanceof IInventory : !itemStack.isEmpty() && (itemStack.canDestroy(block) || itemStack.canPlaceOn(block));
            }
        }
        return bl;
    }

    public void renderWorld(float f2, long l2) {
        this.updateLightmap(f2);
        if (this.g.getRenderViewEntity() == null) {
            this.g.setRenderViewEntity((Entity)this.g.player);
        }
        this.getMouseOver(f2);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc((int)516, (float)0.5f);
        this.g.profiler.startSection("center");
        if (this.g.gameSettings.anaglyph) {
            b = 0;
            GlStateManager.colorMask((boolean)false, (boolean)true, (boolean)true, (boolean)false);
            this.renderWorldPass(0, f2, l2);
            b = 1;
            GlStateManager.colorMask((boolean)true, (boolean)false, (boolean)false, (boolean)false);
            this.renderWorldPass(1, f2, l2);
            GlStateManager.colorMask((boolean)true, (boolean)true, (boolean)true, (boolean)false);
        } else {
            this.renderWorldPass(2, f2, l2);
        }
        this.g.profiler.endSection();
    }

    private /* synthetic */ void renderWorldPass(int n2, float f2, long l2) {
        RenderGlobal renderGlobal = this.g.renderGlobal;
        ParticleManager particleManager = this.g.effectRenderer;
        boolean bl = this.isDrawBlockOutline();
        GlStateManager.enableCull();
        this.g.profiler.endStartSection("clear");
        GlStateManager.viewport((int)0, (int)0, (int)this.g.displayWidth, (int)this.g.displayHeight);
        this.updateFogColor(f2);
        GlStateManager.clear((int)16640);
        this.g.profiler.endStartSection("camera");
        this.setupCameraTransform(f2, n2);
        ActiveRenderInfo.updateRenderInfo((Entity)this.g.getRenderViewEntity(), (this.g.gameSettings.thirdPersonView == 2 ? 1 : 0) != 0);
        this.g.profiler.endStartSection("frustum");
        ClippingHelperImpl.getInstance();
        this.g.profiler.endStartSection("culling");
        Frustum frustum = new Frustum();
        Entity entity = this.g.getRenderViewEntity();
        double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2;
        double d3 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2;
        double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2;
        frustum.setPosition(d2, d3, d4);
        if (this.g.gameSettings.renderDistanceChunks >= 4 && !Optimization.a) {
            this.setupFog(-1, f2);
            this.g.profiler.endStartSection("sky");
            GlStateManager.matrixMode((int)5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective((float)this.getFOVModifier(f2, true), (float)((float)this.g.displayWidth / (float)this.g.displayHeight), (float)0.05f, (float)(this.j * 2.0f));
            GlStateManager.matrixMode((int)5888);
            renderGlobal.renderSky(f2, n2);
            GlStateManager.matrixMode((int)5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective((float)this.getFOVModifier(f2, true), (float)((float)this.g.displayWidth / (float)this.g.displayHeight), (float)0.05f, (float)(this.j * MathHelper.SQRT_2));
            GlStateManager.matrixMode((int)5888);
        }
        this.setupFog(0, f2);
        GlStateManager.shadeModel((int)7425);
        if (entity.posY + (double)entity.getEyeHeight() < 128.0) {
            this.renderCloudsCheck(renderGlobal, f2, n2, d2, d3, d4);
        }
        this.g.profiler.endStartSection("prepareterrain");
        this.setupFog(0, f2);
        this.g.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        RenderHelper.disableStandardItemLighting();
        this.g.profiler.endStartSection("terrain_setup");
        renderGlobal.setupTerrain(entity, (double)f2, (ICamera)frustum, this.af++, this.g.player.isSpectator());
        if (n2 == 0 || n2 == 2) {
            this.g.profiler.endStartSection("updatechunks");
            this.g.renderGlobal.updateChunks(l2);
        }
        this.g.profiler.endStartSection("terrain");
        GlStateManager.matrixMode((int)5888);
        GlStateManager.pushMatrix();
        GlStateManager.disableAlpha();
        renderGlobal.renderBlockLayer(BlockRenderLayer.SOLID, (double)f2, n2, entity);
        GlStateManager.enableAlpha();
        this.g.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, this.g.gameSettings.mipmapLevels > 0);
        renderGlobal.renderBlockLayer(BlockRenderLayer.CUTOUT_MIPPED, (double)f2, n2, entity);
        this.g.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
        this.g.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
        renderGlobal.renderBlockLayer(BlockRenderLayer.CUTOUT, (double)f2, n2, entity);
        this.g.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.alphaFunc((int)516, (float)0.1f);
        if (!this.T) {
            GlStateManager.matrixMode((int)5888);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            RenderHelper.enableStandardItemLighting();
            this.g.profiler.endStartSection("entities");
            ForgeHooksClient.setRenderPass((int)0);
            renderGlobal.renderEntities(entity, (ICamera)frustum, f2);
            ForgeHooksClient.setRenderPass((int)0);
            RenderHelper.disableStandardItemLighting();
            this.disableLightmap();
        }
        GlStateManager.matrixMode((int)5888);
        GlStateManager.popMatrix();
        if (bl && this.g.objectMouseOver != null && !entity.isInsideOfMaterial(Material.WATER)) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            GlStateManager.disableAlpha();
            this.g.profiler.endStartSection("outline");
            if (!ForgeHooksClient.onDrawBlockHighlight((RenderGlobal)renderGlobal, (EntityPlayer)entityPlayer, (RayTraceResult)this.g.objectMouseOver, (int)0, (float)f2)) {
                renderGlobal.drawSelectionBox(entityPlayer, this.g.objectMouseOver, 0, f2);
            }
            GlStateManager.enableAlpha();
        }
        if (this.g.debugRenderer.shouldRender()) {
            this.g.debugRenderer.renderDebug(f2, l2);
        }
        this.g.profiler.endStartSection("destroyProgress");
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        this.g.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
        renderGlobal.drawBlockDamageTexture(Tessellator.getInstance(), Tessellator.getInstance().getBuffer(), entity, f2);
        this.g.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
        GlStateManager.disableBlend();
        if (!this.T) {
            this.enableLightmap();
            this.g.profiler.endStartSection("litParticles");
            particleManager.renderLitParticles(entity, f2);
            RenderHelper.disableStandardItemLighting();
            this.setupFog(0, f2);
            this.g.profiler.endStartSection("particles");
            particleManager.renderParticles(entity, f2);
            this.disableLightmap();
        }
        GlStateManager.depthMask((boolean)false);
        GlStateManager.enableCull();
        this.g.profiler.endStartSection("weather");
        this.renderRainSnow(f2);
        GlStateManager.depthMask((boolean)true);
        renderGlobal.renderWorldBorder(entity, f2);
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.alphaFunc((int)516, (float)0.1f);
        this.setupFog(0, f2);
        GlStateManager.enableBlend();
        GlStateManager.depthMask((boolean)false);
        this.g.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        GlStateManager.shadeModel((int)7425);
        this.g.profiler.endStartSection("translucent");
        renderGlobal.renderBlockLayer(BlockRenderLayer.TRANSLUCENT, (double)f2, n2, entity);
        if (!this.T) {
            RenderHelper.enableStandardItemLighting();
            this.g.profiler.endStartSection("entities");
            ForgeHooksClient.setRenderPass((int)1);
            renderGlobal.renderEntities(entity, (ICamera)frustum, f2);
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            ForgeHooksClient.setRenderPass((int)-1);
            RenderHelper.disableStandardItemLighting();
        }
        GlStateManager.shadeModel((int)7424);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.disableFog();
        if (entity.posY + (double)entity.getEyeHeight() >= 128.0) {
            this.g.profiler.endStartSection("aboveClouds");
            this.renderCloudsCheck(renderGlobal, f2, n2, d2, d3, d4);
        }
        this.g.profiler.endStartSection("forge_render_last");
        ForgeHooksClient.dispatchRenderLast((RenderGlobal)renderGlobal, (float)f2);
        this.g.profiler.endStartSection("hand");
        if (this.A) {
            GlStateManager.clear((int)256);
            this.renderHand(f2, n2);
        }
    }

    private /* synthetic */ void renderCloudsCheck(RenderGlobal renderGlobal, float f2, int n2, double d2, double d3, double d4) {
        if (this.g.gameSettings.shouldRenderClouds() != 0 && !Optimization.a) {
            this.g.profiler.endStartSection("clouds");
            GlStateManager.matrixMode((int)5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective((float)this.getFOVModifier(f2, true), (float)((float)this.g.displayWidth / (float)this.g.displayHeight), (float)0.05f, (float)(this.j * 4.0f));
            GlStateManager.matrixMode((int)5888);
            GlStateManager.pushMatrix();
            this.setupFog(0, f2);
            renderGlobal.renderClouds(f2, n2, d2, d3, d4);
            GlStateManager.disableFog();
            GlStateManager.popMatrix();
            GlStateManager.matrixMode((int)5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective((float)this.getFOVModifier(f2, true), (float)((float)this.g.displayWidth / (float)this.g.displayHeight), (float)0.05f, (float)(this.j * MathHelper.SQRT_2));
            GlStateManager.matrixMode((int)5888);
        }
    }

    private /* synthetic */ void addRainParticles() {
        float f2;
        float f3 = f2 = WeatherClear.a ? 0.0f : this.g.world.getRainStrength(1.0f);
        if (!this.g.gameSettings.fancyGraphics) {
            f2 /= 2.0f;
        }
        if (f2 != 0.0f) {
            this.i.setSeed((long)this.l * 312987231L);
            Entity entity = this.g.getRenderViewEntity();
            WorldClient worldClient = this.g.world;
            BlockPos blockPos = new BlockPos(entity);
            double d2 = 0.0;
            double d3 = 0.0;
            double d4 = 0.0;
            int n2 = 0;
            int n3 = (int)(100.0f * f2 * f2);
            if (this.g.gameSettings.particleSetting == 1) {
                n3 >>= 1;
            } else if (this.g.gameSettings.particleSetting == 2) {
                n3 = 0;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                BlockPos blockPos2 = worldClient.getPrecipitationHeight(blockPos.add(this.i.nextInt(10) - this.i.nextInt(10), 0, this.i.nextInt(10) - this.i.nextInt(10)));
                Biome biome = worldClient.getBiome(blockPos2);
                BlockPos blockPos3 = blockPos2.down();
                IBlockState iBlockState = worldClient.getBlockState(blockPos3);
                if (blockPos2.getY() > blockPos.getY() + 10 || blockPos2.getY() < blockPos.getY() - 10 || !biome.canRain() || !(biome.getTemperature(blockPos2) >= 0.15f)) continue;
                double d5 = this.i.nextDouble();
                double d6 = this.i.nextDouble();
                AxisAlignedBB axisAlignedBB = iBlockState.getBoundingBox((IBlockAccess)worldClient, blockPos3);
                if (iBlockState.getMaterial() != Material.LAVA && iBlockState.getBlock() != Blocks.MAGMA) {
                    if (iBlockState.getMaterial() == Material.AIR) continue;
                    if (this.i.nextInt(++n2) == 0) {
                        d2 = (double)blockPos3.getX() + d5;
                        d3 = (double)((float)blockPos3.getY() + 0.1f) + axisAlignedBB.maxY - 1.0;
                        d4 = (double)blockPos3.getZ() + d6;
                    }
                    this.g.world.spawnParticle(EnumParticleTypes.WATER_DROP, (double)blockPos3.getX() + d5, (double)((float)blockPos3.getY() + 0.1f) + axisAlignedBB.maxY, (double)blockPos3.getZ() + d6, 0.0, 0.0, 0.0, new int[0]);
                    continue;
                }
                this.g.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double)blockPos2.getX() + d5, (double)((float)blockPos2.getY() + 0.1f) - axisAlignedBB.minY, (double)blockPos2.getZ() + d6, 0.0, 0.0, 0.0, new int[0]);
            }
            if (n2 > 0 && this.i.nextInt(3) < this.J++) {
                this.J = 0;
                if (d3 > (double)(blockPos.getY() + 1) && worldClient.getPrecipitationHeight(blockPos).getY() > MathHelper.floor((float)blockPos.getY())) {
                    this.g.world.playSound(d2, d3, d4, SoundEvents.WEATHER_RAIN_ABOVE, SoundCategory.WEATHER, 0.1f, 0.5f, false);
                } else {
                    this.g.world.playSound(d2, d3, d4, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, 0.2f, 1.0f, false);
                }
            }
        }
    }

    protected void renderRainSnow(float f2) {
        float f3;
        IRenderHandler iRenderHandler = this.g.world.provider.getWeatherRenderer();
        if (iRenderHandler != null) {
            iRenderHandler.render(f2, this.g.world, this.g);
            return;
        }
        float f4 = CustomRain.a || CustomSnow.a ? 1.0f : (f3 = WeatherClear.a ? 0.0f : this.g.world.getRainStrength(f2));
        if (f3 > 0.0f) {
            this.enableLightmap();
            Entity entity = this.g.getRenderViewEntity();
            WorldClient worldClient = this.g.world;
            int n2 = MathHelper.floor((double)entity.posX);
            int n3 = MathHelper.floor((double)entity.posY);
            int n4 = MathHelper.floor((double)entity.posZ);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferBuilder = tessellator.getBuffer();
            GlStateManager.disableCull();
            GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            GlStateManager.alphaFunc((int)516, (float)0.1f);
            double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2;
            double d3 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2;
            double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2;
            int n5 = MathHelper.floor((double)d3);
            int n6 = 5;
            if (this.g.gameSettings.fancyGraphics) {
                n6 = 10;
            }
            int n7 = -1;
            float f5 = (float)this.l + f2;
            bufferBuilder.setTranslation(-d2, -d3, -d4);
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            for (int i2 = n4 - n6; i2 <= n4 + n6; ++i2) {
                for (int i3 = n2 - n6; i3 <= n2 + n6; ++i3) {
                    double d5;
                    double d6;
                    float f6;
                    float f7;
                    int n8 = (i2 - n4 + 16) * 32 + i3 - n2 + 16;
                    double d7 = (double)this.K[n8] * 0.5;
                    double d8 = (double)this.L[n8] * 0.5;
                    mutableBlockPos.setPos(i3, 0, i2);
                    Biome biome = worldClient.getBiome((BlockPos)mutableBlockPos);
                    if (!biome.canRain() && !biome.getEnableSnow() && !CustomRain.a && !CustomSnow.a) continue;
                    int n9 = worldClient.getPrecipitationHeight((BlockPos)mutableBlockPos).getY();
                    int n10 = n3 - n6;
                    int n11 = n3 + n6;
                    if (n10 < n9) {
                        n10 = n9;
                    }
                    if (n11 < n9) {
                        n11 = n9;
                    }
                    int n12 = n9;
                    if (n9 < n5) {
                        n12 = n5;
                    }
                    if (n10 == n11) continue;
                    this.i.setSeed(i3 * i3 * 3121 + i3 * 45238971 ^ i2 * i2 * 418711 + i2 * 13761);
                    mutableBlockPos.setPos(i3, n10, i2);
                    float f8 = biome.getTemperature((BlockPos)mutableBlockPos);
                    if (CustomRain.a || CustomSnow.a) {
                        double d9;
                        double d10;
                        double d11;
                        if (CustomRain.a) {
                            if (n7 != 0) {
                                if (n7 >= 0) {
                                    tessellator.draw();
                                }
                                n7 = 0;
                                this.g.getTextureManager().bindTexture(this.e);
                                bufferBuilder.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                            }
                            d11 = -((double)(this.l + i3 * i3 * 3121 + i3 * 45238971 + i2 * i2 * 418711 + i2 * 13761 & 0x1F) + (double)f2) / 32.0 * (3.0 + this.i.nextDouble());
                            d10 = (double)((float)i3 + 0.5f) - entity.posX;
                            d9 = (double)((float)i2 + 0.5f) - entity.posZ;
                            float f9 = MathHelper.sqrt((double)(d10 * d10 + d9 * d9)) / (float)n6;
                            float f10 = ((1.0f - f9 * f9) * 0.5f + 0.5f) * f3;
                            mutableBlockPos.setPos(i3, n12, i2);
                            int n13 = worldClient.getCombinedLight((BlockPos)mutableBlockPos, 0);
                            int n14 = n13 >> 16 & 0xFFFF;
                            int n15 = n13 & 0xFFFF;
                            int n16 = CustomRain.b.getValue();
                            float[] fArray = er.a(n16);
                            f7 = fArray[0];
                            f6 = fArray[1];
                            float f11 = fArray[2];
                            bufferBuilder.pos((double)i3 - d7 + 0.5, (double)n11, (double)i2 - d8 + 0.5).tex(0.0, (double)n10 * 0.25 + d11).color(f7, f6, f11, f10).lightmap(n14, n15).endVertex();
                            bufferBuilder.pos((double)i3 + d7 + 0.5, (double)n11, (double)i2 + d8 + 0.5).tex(1.0, (double)n10 * 0.25 + d11).color(f7, f6, f11, f10).lightmap(n14, n15).endVertex();
                            bufferBuilder.pos((double)i3 + d7 + 0.5, (double)n10, (double)i2 + d8 + 0.5).tex(1.0, (double)n11 * 0.25 + d11).color(f7, f6, f11, f10).lightmap(n14, n15).endVertex();
                            bufferBuilder.pos((double)i3 - d7 + 0.5, (double)n10, (double)i2 - d8 + 0.5).tex(0.0, (double)n11 * 0.25 + d11).color(f7, f6, f11, f10).lightmap(n14, n15).endVertex();
                        }
                        if (!CustomSnow.a) continue;
                        if (n7 != 1) {
                            if (n7 >= 0) {
                                tessellator.draw();
                            }
                            n7 = 1;
                            this.g.getTextureManager().bindTexture(this.f);
                            bufferBuilder.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                        }
                        d11 = -((float)(this.l & 0x1FF) + f2) / 512.0f;
                        d10 = this.i.nextDouble() + (double)f5 * 0.01 * (double)((float)this.i.nextGaussian());
                        d9 = this.i.nextDouble() + (double)(f5 * (float)this.i.nextGaussian()) * 0.001;
                        double d12 = (double)((float)i3 + 0.5f) - entity.posX;
                        double d13 = (double)((float)i2 + 0.5f) - entity.posZ;
                        float f12 = MathHelper.sqrt((double)(d12 * d12 + d13 * d13)) / (float)n6;
                        float f13 = ((1.0f - f12 * f12) * 0.3f + 0.5f) * f3;
                        mutableBlockPos.setPos(i3, n12, i2);
                        int n17 = (worldClient.getCombinedLight((BlockPos)mutableBlockPos, 0) * 3 + 0xF000F0) / 4;
                        int n18 = n17 >> 16 & 0xFFFF;
                        int n19 = n17 & 0xFFFF;
                        int n20 = CustomSnow.b.getValue();
                        float[] fArray = er.a(n20);
                        float f14 = fArray[0];
                        float f15 = fArray[1];
                        float f16 = fArray[2];
                        bufferBuilder.pos((double)i3 - d7 + 0.5, (double)n11, (double)i2 - d8 + 0.5).tex(0.0 + d10, (double)n10 * 0.25 + d11 + d9).color(f14, f15, f16, f13).lightmap(n18, n19).endVertex();
                        bufferBuilder.pos((double)i3 + d7 + 0.5, (double)n11, (double)i2 + d8 + 0.5).tex(1.0 + d10, (double)n10 * 0.25 + d11 + d9).color(f14, f15, f16, f13).lightmap(n18, n19).endVertex();
                        bufferBuilder.pos((double)i3 + d7 + 0.5, (double)n10, (double)i2 + d8 + 0.5).tex(1.0 + d10, (double)n11 * 0.25 + d11 + d9).color(f14, f15, f16, f13).lightmap(n18, n19).endVertex();
                        bufferBuilder.pos((double)i3 - d7 + 0.5, (double)n10, (double)i2 - d8 + 0.5).tex(0.0 + d10, (double)n11 * 0.25 + d11 + d9).color(f14, f15, f16, f13).lightmap(n18, n19).endVertex();
                        continue;
                    }
                    float f17 = 1.0f;
                    float f18 = 1.0f;
                    float f19 = 1.0f;
                    if (worldClient.getBiomeProvider().getTemperatureAtHeight(f8, n9) >= 0.15f) {
                        if (n7 != 0) {
                            if (n7 >= 0) {
                                tessellator.draw();
                            }
                            n7 = 0;
                            this.g.getTextureManager().bindTexture(this.e);
                            bufferBuilder.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                        }
                        d6 = -((double)(this.l + i3 * i3 * 3121 + i3 * 45238971 + i2 * i2 * 418711 + i2 * 13761 & 0x1F) + (double)f2) / 32.0 * (3.0 + this.i.nextDouble());
                        d5 = (double)((float)i3 + 0.5f) - entity.posX;
                        double d14 = (double)((float)i2 + 0.5f) - entity.posZ;
                        float f20 = MathHelper.sqrt((double)(d5 * d5 + d14 * d14)) / (float)n6;
                        float f21 = ((1.0f - f20 * f20) * 0.5f + 0.5f) * f3;
                        mutableBlockPos.setPos(i3, n12, i2);
                        int n21 = worldClient.getCombinedLight((BlockPos)mutableBlockPos, 0);
                        int n22 = n21 >> 16 & 0xFFFF;
                        int n23 = n21 & 0xFFFF;
                        bufferBuilder.pos((double)i3 - d7 + 0.5, (double)n11, (double)i2 - d8 + 0.5).tex(0.0, (double)n10 * 0.25 + d6).color(f17, f18, f19, f21).lightmap(n22, n23).endVertex();
                        bufferBuilder.pos((double)i3 + d7 + 0.5, (double)n11, (double)i2 + d8 + 0.5).tex(1.0, (double)n10 * 0.25 + d6).color(f17, f18, f19, f21).lightmap(n22, n23).endVertex();
                        bufferBuilder.pos((double)i3 + d7 + 0.5, (double)n10, (double)i2 + d8 + 0.5).tex(1.0, (double)n11 * 0.25 + d6).color(f17, f18, f19, f21).lightmap(n22, n23).endVertex();
                        bufferBuilder.pos((double)i3 - d7 + 0.5, (double)n10, (double)i2 - d8 + 0.5).tex(0.0, (double)n11 * 0.25 + d6).color(f17, f18, f19, f21).lightmap(n22, n23).endVertex();
                        continue;
                    }
                    if (n7 != 1) {
                        if (n7 >= 0) {
                            tessellator.draw();
                        }
                        n7 = 1;
                        this.g.getTextureManager().bindTexture(this.f);
                        bufferBuilder.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                    }
                    d6 = -((float)(this.l & 0x1FF) + f2) / 512.0f;
                    d5 = this.i.nextDouble() + (double)f5 * 0.01 * (double)((float)this.i.nextGaussian());
                    double d15 = this.i.nextDouble() + (double)(f5 * (float)this.i.nextGaussian()) * 0.001;
                    double d16 = (double)((float)i3 + 0.5f) - entity.posX;
                    double d17 = (double)((float)i2 + 0.5f) - entity.posZ;
                    f7 = MathHelper.sqrt((double)(d16 * d16 + d17 * d17)) / (float)n6;
                    f6 = ((1.0f - f7 * f7) * 0.3f + 0.5f) * f3;
                    mutableBlockPos.setPos(i3, n12, i2);
                    int n24 = (worldClient.getCombinedLight((BlockPos)mutableBlockPos, 0) * 3 + 0xF000F0) / 4;
                    int n25 = n24 >> 16 & 0xFFFF;
                    int n26 = n24 & 0xFFFF;
                    bufferBuilder.pos((double)i3 - d7 + 0.5, (double)n11, (double)i2 - d8 + 0.5).tex(0.0 + d5, (double)n10 * 0.25 + d6 + d15).color(f17, f18, f19, f6).lightmap(n25, n26).endVertex();
                    bufferBuilder.pos((double)i3 + d7 + 0.5, (double)n11, (double)i2 + d8 + 0.5).tex(1.0 + d5, (double)n10 * 0.25 + d6 + d15).color(f17, f18, f19, f6).lightmap(n25, n26).endVertex();
                    bufferBuilder.pos((double)i3 + d7 + 0.5, (double)n10, (double)i2 + d8 + 0.5).tex(1.0 + d5, (double)n11 * 0.25 + d6 + d15).color(f17, f18, f19, f6).lightmap(n25, n26).endVertex();
                    bufferBuilder.pos((double)i3 - d7 + 0.5, (double)n10, (double)i2 - d8 + 0.5).tex(0.0 + d5, (double)n11 * 0.25 + d6 + d15).color(f17, f18, f19, f6).lightmap(n25, n26).endVertex();
                }
            }
            if (n7 >= 0) {
                tessellator.draw();
            }
            bufferBuilder.setTranslation(0.0, 0.0, 0.0);
            GlStateManager.enableCull();
            GlStateManager.disableBlend();
            GlStateManager.alphaFunc((int)516, (float)0.1f);
            this.disableLightmap();
        }
    }

    public void setupOverlayRendering() {
        ScaledResolution scaledResolution = new ScaledResolution(this.g);
        GlStateManager.clear((int)256);
        GlStateManager.matrixMode((int)5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho((double)0.0, (double)scaledResolution.getScaledWidth_double(), (double)scaledResolution.getScaledHeight_double(), (double)0.0, (double)1000.0, (double)3000.0);
        GlStateManager.matrixMode((int)5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)-2000.0f);
    }

    public void setupCOverlayRendering() {
        cy cy2 = new cy(this.g);
        GlStateManager.clear((int)256);
        GlStateManager.matrixMode((int)5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho((double)0.0, (double)cy2.c(), (double)cy2.d(), (double)0.0, (double)1000.0, (double)3000.0);
        GlStateManager.matrixMode((int)5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)-2000.0f);
    }

    private /* synthetic */ void updateFogColor(float f2) {
        float f3;
        Vec3d vec3d;
        Vec3d vec3d2;
        float f4;
        float f5;
        Object object;
        Vec3d vec3d3;
        float f6;
        float f7;
        float f8;
        float[] fArray;
        int n2;
        WorldClient worldClient = this.g.world;
        Entity entity = this.g.getRenderViewEntity();
        float f9 = 0.25f + 0.75f * (float)this.g.gameSettings.renderDistanceChunks / 32.0f;
        f9 = 1.0f - (float)Math.pow(f9, 0.25);
        Vec3d vec3d4 = worldClient.getSkyColor(this.g.getRenderViewEntity(), f2);
        if (CustomFog.a) {
            n2 = CustomFog.b.getValue();
            fArray = er.a(n2);
            f8 = fArray[0];
            f7 = fArray[1];
            f6 = fArray[2];
        } else {
            f8 = (float)vec3d4.x;
            f7 = (float)vec3d4.y;
            f6 = (float)vec3d4.z;
        }
        if (CustomFog.a) {
            n2 = CustomFog.b.getValue();
            fArray = er.a(n2);
            this.N = fArray[0];
            this.O = fArray[1];
            this.P = fArray[2];
        } else {
            Vec3d vec3d5 = worldClient.getFogColor(f2);
            this.N = (float)vec3d5.x;
            this.O = (float)vec3d5.y;
            this.P = (float)vec3d5.z;
        }
        if (this.g.gameSettings.renderDistanceChunks >= 4) {
            double d2 = MathHelper.sin((float)worldClient.getCelestialAngleRadians(f2)) > 0.0f ? -1.0 : 1.0;
            vec3d3 = new Vec3d(d2, 0.0, 0.0);
            float f10 = (float)entity.getLook(f2).dotProduct(vec3d3);
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            if (f10 > 0.0f && (object = worldClient.provider.calcSunriseSunsetColors(worldClient.getCelestialAngle(f2), f2)) != null) {
                this.N = this.N * (1.0f - (f10 *= object[3])) + object[0] * f10;
                this.O = this.O * (1.0f - f10) + object[1] * f10;
                this.P = this.P * (1.0f - f10) + object[2] * f10;
            }
        }
        this.N += (f8 - this.N) * f9;
        this.O += (f7 - this.O) * f9;
        this.P += (f6 - this.P) * f9;
        float f11 = f5 = WeatherClear.a ? 0.0f : worldClient.getRainStrength(f2);
        if (f5 > 0.0f) {
            float f12 = 1.0f - f5 * 0.5f;
            float f13 = 1.0f - f5 * 0.4f;
            this.N *= f12;
            this.O *= f12;
            this.P *= f13;
        }
        if ((f4 = worldClient.getThunderStrength(f2)) > 0.0f) {
            float f14 = 1.0f - f4 * 0.5f;
            this.N *= f14;
            this.O *= f14;
            this.P *= f14;
        }
        vec3d3 = ActiveRenderInfo.getBlockStateAtEntityViewpoint((World)this.g.world, (Entity)entity, (float)f2);
        if (this.z) {
            vec3d2 = worldClient.getCloudColour(f2);
            this.N = (float)vec3d2.x;
            this.O = (float)vec3d2.y;
            this.P = (float)vec3d2.z;
        } else {
            vec3d2 = ActiveRenderInfo.projectViewFromEntity((Entity)entity, (double)f2);
            object = new BlockPos(vec3d2);
            IBlockState iBlockState = this.g.world.getBlockState((BlockPos)object);
            vec3d = iBlockState.getBlock().getFogColor((World)this.g.world, (BlockPos)object, iBlockState, entity, new Vec3d((double)this.N, (double)this.O, (double)this.P), f2);
            this.N = (float)vec3d.x;
            this.O = (float)vec3d.y;
            this.P = (float)vec3d.z;
        }
        float f15 = this.Q + (this.R - this.Q) * f2;
        this.N *= f15;
        this.O *= f15;
        this.P *= f15;
        double d3 = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2) * worldClient.provider.getVoidFogYFactor();
        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPotionActive(MobEffects.BLINDNESS)) {
            int n3 = ((EntityLivingBase)entity).getActivePotionEffect(MobEffects.BLINDNESS).getDuration();
            d3 = n3 < 20 ? (d3 *= (double)(1.0f - (float)n3 / 20.0f)) : 0.0;
        }
        if (d3 < 1.0) {
            if (d3 < 0.0) {
                d3 = 0.0;
            }
            d3 *= d3;
            this.N = (float)((double)this.N * d3);
            this.O = (float)((double)this.O * d3);
            this.P = (float)((double)this.P * d3);
        }
        if (this.x > 0.0f) {
            float f16 = this.y + (this.x - this.y) * f2;
            this.N = this.N * (1.0f - f16) + this.N * 0.7f * f16;
            this.O = this.O * (1.0f - f16) + this.O * 0.6f * f16;
            this.P = this.P * (1.0f - f16) + this.P * 0.6f * f16;
        }
        if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPotionActive(MobEffects.NIGHT_VISION) || NightVision.a) {
            float f17 = this.getNightVisionBrightness((EntityLivingBase)entity, f2);
            f3 = 1.0f / this.N;
            if (f3 > 1.0f / this.O) {
                f3 = 1.0f / this.O;
            }
            if (f3 > 1.0f / this.P) {
                f3 = 1.0f / this.P;
            }
            if (Float.isInfinite(f3)) {
                f3 = Math.nextAfter(f3, 0.0);
            }
            this.N = this.N * (1.0f - f17) + this.N * f3 * f17;
            this.O = this.O * (1.0f - f17) + this.O * f3 * f17;
            this.P = this.P * (1.0f - f17) + this.P * f3 * f17;
        }
        if (this.g.gameSettings.anaglyph) {
            float f18 = (this.N * 30.0f + this.O * 59.0f + this.P * 11.0f) / 100.0f;
            f3 = (this.N * 30.0f + this.O * 70.0f) / 100.0f;
            float f19 = (this.N * 30.0f + this.P * 70.0f) / 100.0f;
            this.N = f18;
            this.O = f3;
            this.P = f19;
        }
        vec3d = new EntityViewRenderEvent.FogColors((EntityRenderer)this, entity, (IBlockState)vec3d3, (double)f2, this.N, this.O, this.P);
        MinecraftForge.EVENT_BUS.post((Event)vec3d);
        this.N = vec3d.getRed();
        this.O = vec3d.getGreen();
        this.P = vec3d.getBlue();
        GlStateManager.clearColor((float)this.N, (float)this.O, (float)this.P, (float)0.0f);
    }

    private /* synthetic */ void setupFog(int n2, float f2) {
        n2 = CustomFog.a ? -1 : n2;
        Entity entity = this.g.getRenderViewEntity();
        this.setupFogColor(false);
        GlStateManager.glNormal3f((float)0.0f, (float)-1.0f, (float)0.0f);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        IBlockState iBlockState = ActiveRenderInfo.getBlockStateAtEntityViewpoint((World)this.g.world, (Entity)entity, (float)f2);
        float f3 = ForgeHooksClient.getFogDensity((EntityRenderer)this.g.entityRenderer, (Entity)entity, (IBlockState)iBlockState, (float)f2, (float)0.1f);
        if (f3 >= 0.0f) {
            GlStateManager.setFogDensity((float)f3);
        } else if (entity instanceof EntityLivingBase && ((EntityLivingBase)entity).isPotionActive(MobEffects.BLINDNESS) && !AntiBadEffects.a) {
            float f4 = 5.0f;
            int n3 = ((EntityLivingBase)entity).getActivePotionEffect(MobEffects.BLINDNESS).getDuration();
            if (n3 < 20) {
                f4 = 5.0f + (this.j - 5.0f) * (1.0f - (float)n3 / 20.0f);
            }
            GlStateManager.setFog((GlStateManager.FogMode)GlStateManager.FogMode.LINEAR);
            if (n2 == -1) {
                GlStateManager.setFogStart((float)0.0f);
                GlStateManager.setFogEnd((float)(f4 * 0.8f));
            } else {
                GlStateManager.setFogStart((float)(f4 * 0.25f));
                GlStateManager.setFogEnd((float)f4);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                GlStateManager.glFogi((int)34138, (int)34140);
            }
        } else if (this.z) {
            GlStateManager.setFog((GlStateManager.FogMode)GlStateManager.FogMode.EXP);
            GlStateManager.setFogDensity((float)10.0f);
        } else if (iBlockState.getMaterial() == Material.WATER) {
            if (!WaterVision.a) {
                GlStateManager.setFog((GlStateManager.FogMode)GlStateManager.FogMode.EXP);
                if (entity instanceof EntityLivingBase) {
                    if (((EntityLivingBase)entity).isPotionActive(MobEffects.WATER_BREATHING)) {
                        GlStateManager.setFogDensity((float)0.01f);
                    } else {
                        GlStateManager.setFogDensity((float)(0.1f - (float)EnchantmentHelper.getRespirationModifier((EntityLivingBase)((EntityLivingBase)entity)) * 0.03f));
                    }
                } else {
                    GlStateManager.setFogDensity((float)0.1f);
                }
            }
        } else if (iBlockState.getMaterial() == Material.LAVA) {
            GlStateManager.setFog((GlStateManager.FogMode)GlStateManager.FogMode.EXP);
            GlStateManager.setFogDensity((float)2.0f);
        } else {
            float f5 = this.j;
            GlStateManager.setFog((GlStateManager.FogMode)GlStateManager.FogMode.LINEAR);
            GL11.glFogf((int)2914, (float)0.35f);
            if (n2 == -1) {
                GlStateManager.setFogStart((float)0.0f);
                GlStateManager.setFogEnd((float)(f5 * CustomFog.c.getValue().floatValue()));
            } else {
                GlStateManager.setFogStart((float)(f5 * 0.75f));
                GlStateManager.setFogEnd((float)f5);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                GlStateManager.glFogi((int)34138, (int)34139);
            }
            if (this.g.world.provider.doesXZShowFog((int)entity.posX, (int)entity.posZ) || this.g.ingameGUI.getBossOverlay().shouldCreateFog()) {
                GlStateManager.setFogStart((float)(f5 * 0.05f));
                GlStateManager.setFogEnd((float)(Math.min(f5, 192.0f) * 0.5f));
            }
            ForgeHooksClient.onFogRender((EntityRenderer)this, (Entity)entity, (IBlockState)iBlockState, (float)f2, (int)n2, (float)f5);
        }
        GlStateManager.enableColorMaterial();
        GlStateManager.enableFog();
        GlStateManager.colorMaterial((int)1028, (int)4608);
    }

    public void setupFogColor(boolean bl) {
        if (bl) {
            GlStateManager.glFog((int)2918, (FloatBuffer)this.setFogColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        } else if (CustomFog.a) {
            int n2 = CustomFog.b.getValue();
            float[] fArray = er.a(n2);
            GlStateManager.glFog((int)2918, (FloatBuffer)this.setFogColorBuffer(fArray[0], fArray[1], fArray[2], 1.0f));
        } else {
            GlStateManager.glFog((int)2918, (FloatBuffer)this.setFogColorBuffer(this.N, this.O, this.P, 1.0f));
        }
    }

    private /* synthetic */ FloatBuffer setFogColorBuffer(float f2, float f3, float f4, float f5) {
        this.M.clear();
        this.M.put(f2).put(f3).put(f4).put(f5);
        this.M.flip();
        return this.M;
    }

    public void resetData() {
        this.X = null;
        this.k.clearLoadedMaps();
    }

    public MapItemRenderer getMapItemRenderer() {
        return this.k;
    }

    public void displayItemActivation(ItemStack itemStack) {
        this.X = itemStack;
        this.Y = 40;
        this.Z = this.i.nextFloat() * 2.0f - 1.0f;
        this.aa = this.i.nextFloat() * 2.0f - 1.0f;
    }

    public void renderShaders(int n2, int n3, int n4, int n5, float f2) {
        if (OpenGlHelper.shadersSupported) {
            this.g.renderGlobal.renderEntityOutlineFramebuffer();
            if (this.ab != null && this.ae) {
                GlStateManager.matrixMode((int)5890);
                GlStateManager.pushMatrix();
                GlStateManager.disableBlend();
                GlStateManager.disableAlpha();
                GlStateManager.loadIdentity();
                GL11.glEnable((int)3089);
                int n6 = 2;
                if (Display.getWidth() < 640 || Display.getHeight() < 480) {
                    n6 = 1;
                }
                GL11.glScissor((int)(n2 * n6), (int)(Display.getHeight() - (n3 + n5) * n6), (int)(n4 * n6), (int)(n5 * n6));
                this.ab.render(f2);
                GL11.glDisable((int)3089);
                GlStateManager.enableBlend();
                GlStateManager.enableAlpha();
                GlStateManager.popMatrix();
            }
            this.g.getFramebuffer().bindFramebuffer(true);
        }
    }

    public void updateCameraAndRender(float f2, long l2) {
        int n2;
        boolean bl = Display.isActive();
        if (!(bl || !this.g.gameSettings.pauseOnLostFocus || this.g.gameSettings.touchscreen && Mouse.isButtonDown((int)1))) {
            if (Minecraft.getSystemTime() - this.C > 500L) {
                this.g.displayInGameMenu();
            }
        } else {
            this.C = Minecraft.getSystemTime();
        }
        this.g.profiler.startSection("mouse");
        if (bl && Minecraft.IS_RUNNING_ON_MAC && this.g.inGameHasFocus && !Mouse.isInsideWindow()) {
            Mouse.setGrabbed((boolean)false);
            Mouse.setCursorPosition((int)(Display.getWidth() / 2), (int)(Display.getHeight() / 2 - 20));
            Mouse.setGrabbed((boolean)true);
        }
        if (this.g.inGameHasFocus && bl) {
            this.g.mouseHelper.mouseXYChange();
            this.g.getTutorial().handleMouse(this.g.mouseHelper);
            float f3 = this.g.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            float f4 = f3 * f3 * f3 * 8.0f;
            float f5 = (float)this.g.mouseHelper.deltaX * f4;
            float f6 = (float)this.g.mouseHelper.deltaY * f4;
            n2 = 1;
            if (this.g.gameSettings.invertMouse) {
                n2 = -1;
            }
            if (this.g.gameSettings.smoothCamera) {
                this.q += f5;
                this.r += f6;
                float f7 = f2 - this.u;
                this.u = f2;
                f5 = this.s * f7;
                f6 = this.t * f7;
                this.g.player.turn(f5, f6 * (float)n2);
            } else {
                this.q = 0.0f;
                this.r = 0.0f;
                this.g.player.turn(f5, f6 * (float)n2);
            }
        }
        this.g.profiler.endSection();
        if (!this.g.skipRenderWorld) {
            a = this.g.gameSettings.anaglyph;
            ScaledResolution scaledResolution = new ScaledResolution(this.g);
            int n3 = scaledResolution.getScaledWidth();
            int n4 = scaledResolution.getScaledHeight();
            int n5 = Mouse.getX() * n3 / this.g.displayWidth;
            n2 = n4 - Mouse.getY() * n4 / this.g.displayHeight - 1;
            int n6 = this.g.gameSettings.limitFramerate;
            if (this.g.world != null) {
                this.g.profiler.startSection("level");
                int n7 = Math.min(Minecraft.getDebugFPS(), n6);
                n7 = Math.max(n7, 60);
                long l3 = System.nanoTime() - l2;
                long l4 = Math.max((long)(1000000000 / n7 / 4) - l3, 0L);
                this.renderWorld(f2, System.nanoTime() + l4);
                if (OpenGlHelper.shadersSupported && !(this.g.currentScreen instanceof UIScreen)) {
                    this.g.renderGlobal.renderEntityOutlineFramebuffer();
                    if (this.ab != null && this.ae) {
                        GlStateManager.matrixMode((int)5890);
                        GlStateManager.pushMatrix();
                        GlStateManager.loadIdentity();
                        this.ab.render(f2);
                        GlStateManager.popMatrix();
                    }
                    this.g.getFramebuffer().bindFramebuffer(true);
                }
                this.g.profiler.endStartSection("gui");
                if (!this.g.gameSettings.hideGUI || this.g.currentScreen != null) {
                    GlStateManager.alphaFunc((int)516, (float)0.1f);
                    this.setupOverlayRendering();
                    GlStateManager.disableLighting();
                    \u2007\u2008\u00a0.r.a(f2);
                    this.renderItemActivation(n3, n4, f2);
                    this.g.ingameGUI.renderGameOverlay(f2);
                }
                this.g.profiler.endSection();
            } else {
                GlStateManager.viewport((int)0, (int)0, (int)this.g.displayWidth, (int)this.g.displayHeight);
                GlStateManager.matrixMode((int)5889);
                GlStateManager.loadIdentity();
                GlStateManager.matrixMode((int)5888);
                GlStateManager.loadIdentity();
                this.setupOverlayRendering();
                TileEntityRendererDispatcher.instance.renderEngine = this.g.getTextureManager();
                TileEntityRendererDispatcher.instance.fontRenderer = this.g.fontRenderer;
            }
            if (this.g.currentScreen != null) {
                GlStateManager.clear((int)256);
                try {
                    if (this.g.currentScreen instanceof UIScreen) {
                        if (((Boolean)UserInterface.a.getObjectValue()).booleanValue()) {
                            cL cL2 = \u2007\u2008\u00a0.s.if().k();
                            int n8 = cL2.getX();
                            int n9 = cL2.getY();
                            int n10 = cL2.getWidth();
                            int n11 = cL2.getHeight();
                            if (!UIScreen.isFullAlpha() && UIScreen.d > 0.0f) {
                                n8 = (int)((float)n8 * UIScreen.d);
                                n9 = (int)((float)n9 * UIScreen.d);
                                n10 = (int)((float)n10 / UIScreen.d);
                                n11 = (int)((float)n11 / UIScreen.d);
                            }
                            this.renderShaders(n8, n9, n10, n11, f2);
                        }
                        this.setupCOverlayRendering();
                    }
                    this.g.currentScreen.drawScreen(n5, n2, this.g.getTickLength());
                }
                catch (Exception exception) {
                    ChatUtils.exception("Rendering screen", exception);
                }
            }
        }
    }

    private /* synthetic */ void renderItemActivation(int n2, int n3, float f2) {
        if (this.X != null && this.Y > 0) {
            int n4 = 40 - this.Y;
            float f3 = ((float)n4 + f2) / 40.0f;
            float f4 = f3 * f3;
            float f5 = f3 * f4;
            float f6 = 10.25f * f5 * f4 + -24.95f * f4 * f4 + 25.5f * f5 + -13.8f * f4 + 4.0f * f3;
            float f7 = f6 * (float)Math.PI;
            float f8 = this.Z * (float)(n2 / 4);
            float f9 = this.aa * (float)(n3 / 4);
            GlStateManager.enableAlpha();
            GlStateManager.pushMatrix();
            GlStateManager.pushAttrib();
            GlStateManager.enableDepth();
            GlStateManager.disableCull();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.translate((float)((float)(n2 / 2) + f8 * MathHelper.abs((float)MathHelper.sin((float)(f7 * 2.0f)))), (float)((float)(n3 / 2) + f9 * MathHelper.abs((float)MathHelper.sin((float)(f7 * 2.0f)))), (float)-50.0f);
            float f10 = 50.0f + 175.0f * MathHelper.sin((float)f7);
            GlStateManager.scale((float)f10, (float)(-f10), (float)f10);
            GlStateManager.rotate((float)(900.0f * MathHelper.abs((float)MathHelper.sin((float)f7))), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)(6.0f * MathHelper.cos((float)(f3 * 8.0f))), (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.rotate((float)(6.0f * MathHelper.cos((float)(f3 * 8.0f))), (float)0.0f, (float)0.0f, (float)1.0f);
            this.g.getRenderItem().renderItem(this.X, ItemCameraTransforms.TransformType.FIXED);
            GlStateManager.popAttrib();
            GlStateManager.popMatrix();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableCull();
            GlStateManager.disableDepth();
        }
    }
}

