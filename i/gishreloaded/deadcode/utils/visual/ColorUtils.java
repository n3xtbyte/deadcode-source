/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 */
package i.gishreloaded.deadcode.utils.visual;

import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;

public final class ColorUtils {
    public static void setColor(float f2, float f3, float f4, float f5) {
        GlStateManager.color((float)f2, (float)f3, (float)f4, (float)f5);
    }

    public static void setColor(Color color) {
        GlStateManager.color((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
    }

    public static void setColor(int n2) {
        GlStateManager.color((float)((float)(n2 >> 16 & 0xFF) / 255.0f), (float)((float)(n2 >> 8 & 0xFF) / 255.0f), (float)((float)(n2 & 0xFF) / 255.0f), (float)((float)(n2 >> 24 & 0xFF) / 255.0f));
    }
}

