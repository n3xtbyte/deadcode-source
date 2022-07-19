/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class TextureChanger
extends Hack {
    public static ModeValue a;
    public cv b;

    public TextureChanger(String string) {
        super(string, HackCategory.Render);
        this.c(true);
        this.d(false);
        a = new ModeValue("Cape", false, new Mode("Default", true), new Mode("Default2"));
        this.b("General");
        this.a(a);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Changes different parts of your model.";
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        if (this.b == null) {
            this.b = new cv();
        }
        if (Wrapper.INSTANCE.getGameSettings().thirdPersonView == 0) {
            return;
        }
        try {
            this.a((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), renderWorldLastEvent.getPartialTicks());
        }
        catch (Exception exception) {
            ChatUtils.exception("renderEntityStatic", exception);
            this.e(true);
            this.c(false);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    public void a(EntityPlayer entityPlayer, float f2) {
        RenderManager renderManager = Wrapper.INSTANCE.getMinecraft().getRenderManager();
        if (entityPlayer.ticksExisted == 0) {
            entityPlayer.lastTickPosX = entityPlayer.posX;
            entityPlayer.lastTickPosY = entityPlayer.posY;
            entityPlayer.lastTickPosZ = entityPlayer.posZ;
        }
        double d2 = entityPlayer.lastTickPosX + (entityPlayer.posX - entityPlayer.lastTickPosX) * (double)f2;
        double d3 = entityPlayer.lastTickPosY + (entityPlayer.posY - entityPlayer.lastTickPosY) * (double)f2;
        double d4 = entityPlayer.lastTickPosZ + (entityPlayer.posZ - entityPlayer.lastTickPosZ) * (double)f2;
        float f3 = entityPlayer.prevRotationYaw + (entityPlayer.rotationYaw - entityPlayer.prevRotationYaw) * f2;
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.b.a(entityPlayer, d2 - renderManager.viewerPosX, d3 - renderManager.viewerPosY, d4 - renderManager.viewerPosZ, f3, f2);
    }
}

