/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  org.lwjgl.opengl.GL11
 */
package i.gishreloaded.deadcode.utils.fontrenderer;

import i.gishreloaded.deadcode.utils.fontrenderer.CharData;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.lwjgl.opengl.GL11;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class DCFont {
    private final float h = 512.0f;
    public CharData[] a = new CharData[1104];
    public Font b;
    public boolean c;
    public boolean d;
    public int e = -1;
    public int f = 0;
    public DynamicTexture g;

    public DCFont(Font font, boolean bl, boolean bl2) {
        this.b = font;
        this.c = bl;
        this.d = bl2;
        this.g = this.createTexture(font, bl, bl2, this.a);
    }

    public DynamicTexture createTexture(Font font, boolean bl, boolean bl2, CharData[] charDataArray) {
        BufferedImage bufferedImage = this.createTexture(font, bl, bl2, charDataArray);
        try {
            return new DynamicTexture(bufferedImage);
        }
        catch (Exception exception) {
            ChatUtils.exception("DCFont: setupTexture", exception);
            return null;
        }
    }

    public BufferedImage createTexture(Font font, boolean bl, boolean bl2, CharData[] charDataArray) {
        this.getClass();
        int n2 = 512;
        BufferedImage bufferedImage = new BufferedImage(n2, n2, 2);
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setFont(font);
        graphics2D.setColor(new Color(255, 255, 255, 0));
        graphics2D.fillRect(0, 0, n2, n2);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, bl2 ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, bl ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, bl ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int n3 = 0;
        int n4 = 0;
        int n5 = 1;
        for (int i2 = 0; i2 < charDataArray.length; ++i2) {
            char c = (char)i2;
            if ((c <= '\u040f' || c >= '\u0450') && c >= '\u0100') continue;
            CharData charData = new CharData();
            Rectangle2D rectangle2D = fontMetrics.getStringBounds(String.valueOf(c), graphics2D);
            charData.width = rectangle2D.getBounds().width + 8;
            charData.height = rectangle2D.getBounds().height;
            if (n4 + charData.width >= n2) {
                n4 = 0;
                n5 += n3;
                n3 = 0;
            }
            if (charData.height > n3) {
                n3 = charData.height;
            }
            charData.x = n4;
            charData.y = n5;
            if (charData.height > this.e) {
                this.e = charData.height;
            }
            charDataArray[i2] = charData;
            graphics2D.drawString(String.valueOf(c), n4 + 2, n5 + fontMetrics.getAscent());
            n4 += charData.width;
        }
        return bufferedImage;
    }

    public void drawCharArray(CharData[] charDataArray, char c, float f2, float f3) {
        try {
            this.drawTexturedRect(f2, f3, charDataArray[c].width, charDataArray[c].height, charDataArray[c].x, charDataArray[c].y, charDataArray[c].width, charDataArray[c].height);
        }
        catch (Exception exception) {
            ChatUtils.exception("DCFont: drawChar", exception);
        }
    }

    public void drawTexturedRect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f6 / 512.0f;
        float f11 = f7 / 512.0f;
        float f12 = f8 / 512.0f;
        float f13 = f9 / 512.0f;
        GL11.glTexCoord2f((float)(f10 + f12), (float)f11);
        GL11.glVertex2d((double)(f2 + f4), (double)f3);
        GL11.glTexCoord2f((float)f10, (float)f11);
        GL11.glVertex2d((double)f2, (double)f3);
        GL11.glTexCoord2f((float)f10, (float)(f11 + f13));
        GL11.glVertex2d((double)f2, (double)(f3 + f5));
        GL11.glTexCoord2f((float)f10, (float)(f11 + f13));
        GL11.glVertex2d((double)f2, (double)(f3 + f5));
        GL11.glTexCoord2f((float)(f10 + f12), (float)(f11 + f13));
        GL11.glVertex2d((double)(f2 + f4), (double)(f3 + f5));
        GL11.glTexCoord2f((float)(f10 + f12), (float)f11);
        GL11.glVertex2d((double)(f2 + f4), (double)f3);
    }

    public int getStringHeight(String string) {
        return this.getHeight();
    }

    public int getHeight() {
        return (this.e - 8) / 2;
    }

    public int getStringWidth(String string) {
        int n2 = 0;
        for (char c : string.toCharArray()) {
            if (c >= this.a.length) continue;
            n2 += this.a[c].width - 8 + this.f;
        }
        return n2 / 2;
    }

    public boolean b() {
        return this.c;
    }

    public void a(boolean bl) {
        if (this.c != bl) {
            this.c = bl;
            this.g = this.createTexture(this.b, bl, this.d, this.a);
        }
    }

    public boolean c() {
        return this.d;
    }

    public void b(boolean bl) {
        if (this.d != bl) {
            this.d = bl;
            this.g = this.createTexture(this.b, this.c, bl, this.a);
        }
    }

    public Font d() {
        return this.b;
    }

    public void a(Font font) {
        this.b = font;
        this.g = this.createTexture(font, this.c, this.d, this.a);
    }
}

