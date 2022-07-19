/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.ibm.icu.text.ArabicShaping
 *  com.ibm.icu.text.ArabicShapingException
 *  com.ibm.icu.text.Bidi
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiCreateWorld
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.client.renderer.texture.TextureUtil
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.client.resources.IResource
 *  net.minecraft.client.resources.IResourceManager
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.util.ResourceLocation
 *  org.apache.commons.io.IOUtils
 */
package i.gishreloaded.deadcode.excluded;

import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.ArabicShapingException;
import com.ibm.icu.text.Bidi;
import i.gishreloaded.deadcode.excluded.GuiDefault;
import i.gishreloaded.deadcode.hacks.other.Sleep;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public class FontRendererHook
extends FontRenderer {
    private final ResourceLocation[] h;
    protected final int[] a;
    public int b = 9;
    public Random c = new Random();
    protected final byte[] d;
    private final int[] i;
    protected final ResourceLocation e;
    private final TextureManager j;
    protected float f;
    protected float g;
    private boolean k;
    private boolean l;
    private float m;
    private float n;
    private float o;
    private float p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;

    public FontRendererHook(GameSettings gameSettings, ResourceLocation resourceLocation, TextureManager textureManager, boolean bl) {
        super(gameSettings, resourceLocation, textureManager, bl);
        this.h = new ResourceLocation[256];
        this.a = new int[256];
        this.d = new byte[65536];
        this.i = new int[32];
        this.e = resourceLocation;
        this.j = textureManager;
        this.k = bl;
        this.j.bindTexture(resourceLocation);
        for (int i2 = 0; i2 < 32; ++i2) {
            int n2 = (i2 >> 3 & 1) * 85;
            int n3 = (i2 >> 2 & 1) * 170 + n2;
            int n4 = (i2 >> 1 & 1) * 170 + n2;
            int n5 = (i2 >> 0 & 1) * 170 + n2;
            if (i2 == 6) {
                n3 += 85;
            }
            if (gameSettings.anaglyph) {
                int n6 = (n3 * 30 + n4 * 59 + n5 * 11) / 100;
                int n7 = (n3 * 30 + n4 * 70) / 100;
                int n8 = (n3 * 30 + n5 * 70) / 100;
                n3 = n6;
                n4 = n7;
                n5 = n8;
            }
            if (i2 >= 16) {
                n3 /= 4;
                n4 /= 4;
                n5 /= 4;
            }
            this.i[i2] = (n3 & 0xFF) << 16 | (n4 & 0xFF) << 8 | n5 & 0xFF;
        }
        this.onResourceManagerReload(Wrapper.INSTANCE.getMinecraft().getResourceManager());
    }

    public void onResourceManagerReload(IResourceManager iResourceManager) {
        this.readFontTexture();
        this.readGlyphSizes();
    }

    private /* synthetic */ void readFontTexture() {
        BufferedImage bufferedImage;
        IResource iResource = null;
        try {
            iResource = this.getResource(this.e);
            bufferedImage = TextureUtil.readBufferedImage((InputStream)iResource.getInputStream());
        }
        catch (IOException iOException) {
            try {
                throw new RuntimeException(iOException);
            }
            catch (Throwable throwable) {
                IOUtils.closeQuietly(iResource);
                throw throwable;
            }
        }
        IOUtils.closeQuietly((Closeable)iResource);
        int n2 = bufferedImage.getWidth();
        int n3 = bufferedImage.getHeight();
        int[] nArray = new int[n2 * n3];
        bufferedImage.getRGB(0, 0, n2, n3, nArray, 0, n2);
        int n4 = n3 / 16;
        int n5 = n2 / 16;
        float f2 = 8.0f / (float)n5;
        for (int i2 = 0; i2 < 256; ++i2) {
            int n6;
            int n7 = i2 % 16;
            int n8 = i2 / 16;
            if (i2 == 32) {
                this.a[i2] = 4;
            }
            for (n6 = n5 - 1; n6 >= 0; --n6) {
                int n9 = n7 * n5 + n6;
                boolean bl = true;
                for (int i3 = 0; i3 < n4 && bl; ++i3) {
                    int n10 = (n8 * n5 + i3) * n2;
                    if ((nArray[n9 + n10] >> 24 & 0xFF) == 0) continue;
                    bl = false;
                }
                if (!bl) break;
            }
            this.a[i2] = (int)(0.5 + (double)((float)(++n6) * f2)) + 1;
        }
    }

    private /* synthetic */ void readGlyphSizes() {
        IResource iResource = null;
        try {
            iResource = this.getResource(new ResourceLocation("font/glyph_sizes.bin"));
            iResource.getInputStream().read(this.d);
        }
        catch (IOException iOException) {
            try {
                throw new RuntimeException(iOException);
            }
            catch (Throwable throwable) {
                IOUtils.closeQuietly(iResource);
                throw throwable;
            }
        }
        IOUtils.closeQuietly((Closeable)iResource);
    }

    private /* synthetic */ float b(char c, boolean bl) {
        if (c == '\u00a0') {
            return 4.0f;
        }
        if (c == ' ') {
            return 4.0f;
        }
        int n2 = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(c);
        return n2 != -1 && !this.k ? this.renderDefaultChar(n2, bl) : this.renderUnicodeChar(c, bl);
    }

    protected float renderDefaultChar(int n2, boolean bl) {
        int n3 = n2 % 16 * 8;
        int n4 = n2 / 16 * 8;
        boolean bl2 = bl;
        this.j.bindTexture(this.e);
        int n5 = this.a[n2];
        float f2 = (float)n5 - 0.01f;
        GlStateManager.glBegin((int)5);
        GlStateManager.glTexCoord2f((float)((float)n3 / 128.0f), (float)((float)n4 / 128.0f));
        GlStateManager.glVertex3f((float)(this.f + (float)bl2), (float)this.g, (float)0.0f);
        GlStateManager.glTexCoord2f((float)((float)n3 / 128.0f), (float)(((float)n4 + 7.99f) / 128.0f));
        GlStateManager.glVertex3f((float)(this.f - (float)bl2), (float)(this.g + 7.99f), (float)0.0f);
        GlStateManager.glTexCoord2f((float)(((float)n3 + f2 - 1.0f) / 128.0f), (float)((float)n4 / 128.0f));
        GlStateManager.glVertex3f((float)(this.f + f2 - 1.0f + (float)bl2), (float)this.g, (float)0.0f);
        GlStateManager.glTexCoord2f((float)(((float)n3 + f2 - 1.0f) / 128.0f), (float)(((float)n4 + 7.99f) / 128.0f));
        GlStateManager.glVertex3f((float)(this.f + f2 - 1.0f - (float)bl2), (float)(this.g + 7.99f), (float)0.0f);
        GlStateManager.glEnd();
        return n5;
    }

    private /* synthetic */ ResourceLocation getUnicodePageLocation(int n2) {
        if (this.h[n2] == null) {
            this.h[n2] = new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", n2));
        }
        return this.h[n2];
    }

    private /* synthetic */ void loadGlyphTexture(int n2) {
        this.j.bindTexture(this.getUnicodePageLocation(n2));
    }

    protected float renderUnicodeChar(char c, boolean bl) {
        int n2 = this.d[c] & 0xFF;
        if (n2 == 0) {
            return 0.0f;
        }
        int n3 = c / 256;
        this.loadGlyphTexture(n3);
        int n4 = n2 >>> 4;
        int n5 = n2 & 0xF;
        float f2 = n4;
        float f3 = n5 + 1;
        float f4 = (float)(c % 16 * 16) + f2;
        float f5 = (c & 0xFF) / 16 * 16;
        float f6 = f3 - f2 - 0.02f;
        float f7 = bl ? 1.0f : 0.0f;
        GlStateManager.glBegin((int)5);
        GlStateManager.glTexCoord2f((float)(f4 / 256.0f), (float)(f5 / 256.0f));
        GlStateManager.glVertex3f((float)(this.f + f7), (float)this.g, (float)0.0f);
        GlStateManager.glTexCoord2f((float)(f4 / 256.0f), (float)((f5 + 15.98f) / 256.0f));
        GlStateManager.glVertex3f((float)(this.f - f7), (float)(this.g + 7.99f), (float)0.0f);
        GlStateManager.glTexCoord2f((float)((f4 + f6) / 256.0f), (float)(f5 / 256.0f));
        GlStateManager.glVertex3f((float)(this.f + f6 / 2.0f + f7), (float)this.g, (float)0.0f);
        GlStateManager.glTexCoord2f((float)((f4 + f6) / 256.0f), (float)((f5 + 15.98f) / 256.0f));
        GlStateManager.glVertex3f((float)(this.f + f6 / 2.0f - f7), (float)(this.g + 7.99f), (float)0.0f);
        GlStateManager.glEnd();
        return (f3 - f2) / 2.0f + 1.0f;
    }

    public int drawStringWithShadow(String string, float f2, float f3, int n2) {
        return this.drawString(string, f2, f3, n2, true);
    }

    public int drawStringWithShadow(String string, int n2, int n3, int n4) {
        return this.drawString(string, n2, n3, n4, false);
    }

    public int drawString(String string, float f2, float f3, int n2, boolean bl) {
        int n3;
        this.enableAlpha();
        this.resetStyles();
        if (!(Sleep.a || Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiDefault || Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiMainMenu || Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiMultiplayer || Wrapper.INSTANCE.getMinecraft().currentScreen instanceof GuiCreateWorld)) {
            if (string.contains("&q")) {
                string = string.replace("&q", "");
            } else if (RenderUtils.d.containsKey(string)) {
                string = (String)RenderUtils.d.get(string);
            } else if (!RenderUtils.e.contains(string)) {
                String string2 = string;
                boolean bl2 = true;
                for (dH dH2 : \u2007\u2008\u00a0.l.a()) {
                    if (!(string2 = et.c(string2)).contains(dH2.b())) continue;
                    String string3 = string2.replace(dH2.b(), dH2.a());
                    RenderUtils.d.put(string, string3);
                    string = string3;
                    bl2 = false;
                    break;
                }
                if (bl2) {
                    RenderUtils.e.add(string);
                }
            }
        }
        if (bl) {
            n3 = this.renderString(string, f2 + 1.0f, f3 + 1.0f, n2, true);
            n3 = Math.max(n3, this.renderString(string, f2, f3, n2, false));
        } else {
            n3 = this.renderString(string, f2, f3, n2, false);
        }
        return n3;
    }

    private /* synthetic */ String bidiReorder(String string) {
        try {
            Bidi bidi = new Bidi(new ArabicShaping(8).shape(string), 127);
            bidi.setReorderingMode(0);
            return bidi.writeReordered(2);
        }
        catch (ArabicShapingException arabicShapingException) {
            return string;
        }
    }

    private /* synthetic */ void resetStyles() {
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
    }

    private /* synthetic */ void renderStringAtPos(String string, boolean bl) {
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c;
            int n2;
            int n3;
            char c2 = string.charAt(i2);
            if (c2 == '\u00a7' && i2 + 1 < string.length()) {
                n3 = "0123456789abcdefklmnor".indexOf(String.valueOf(string.charAt(i2 + 1)).toLowerCase(Locale.ROOT).charAt(0));
                if (n3 < 16) {
                    this.r = false;
                    this.s = false;
                    this.v = false;
                    this.u = false;
                    this.t = false;
                    if (n3 < 0 || n3 > 15) {
                        n3 = 15;
                    }
                    if (bl) {
                        n3 += 16;
                    }
                    this.q = n2 = this.i[n3];
                    this.setColor((float)(n2 >> 16) / 255.0f, (float)(n2 >> 8 & 0xFF) / 255.0f, (float)(n2 & 0xFF) / 255.0f, this.p);
                } else if (n3 == 16) {
                    this.r = true;
                } else if (n3 == 17) {
                    this.s = true;
                } else if (n3 == 18) {
                    this.v = true;
                } else if (n3 == 19) {
                    this.u = true;
                } else if (n3 == 20) {
                    this.t = true;
                } else if (n3 == 21) {
                    this.r = false;
                    this.s = false;
                    this.v = false;
                    this.u = false;
                    this.t = false;
                    this.setColor(this.m, this.n, this.o, this.p);
                }
                ++i2;
                continue;
            }
            n3 = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(c2);
            if (this.r && n3 != -1) {
                n2 = this.getCharWidth(c2);
                while (n2 != this.getCharWidth(c = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".charAt(n3 = this.c.nextInt("\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".length())))) {
                }
                c2 = c;
            }
            float f2 = n3 == -1 || this.k ? 0.5f : 1.0f;
            char c3 = c = (c2 == '\u0000' || n3 == -1 || this.k) && bl ? (char)'\u0001' : '\u0000';
            if (c != '\u0000') {
                this.f -= f2;
                this.g -= f2;
            }
            float f3 = this.b(c2, this.t);
            if (c != '\u0000') {
                this.f += f2;
                this.g += f2;
            }
            if (this.s) {
                this.f += f2;
                if (c != '\u0000') {
                    this.f -= f2;
                    this.g -= f2;
                }
                this.b(c2, this.t);
                this.f -= f2;
                if (c != '\u0000') {
                    this.f += f2;
                    this.g += f2;
                }
                f3 += 1.0f;
            }
            this.doDraw(f3);
        }
    }

    protected void doDraw(float f2) {
        BufferBuilder bufferBuilder;
        Tessellator tessellator;
        if (this.v) {
            tessellator = Tessellator.getInstance();
            bufferBuilder = tessellator.getBuffer();
            GlStateManager.disableTexture2D();
            bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
            bufferBuilder.pos((double)this.f, (double)(this.g + (float)(this.b / 2)), 0.0).endVertex();
            bufferBuilder.pos((double)(this.f + f2), (double)(this.g + (float)(this.b / 2)), 0.0).endVertex();
            bufferBuilder.pos((double)(this.f + f2), (double)(this.g + (float)(this.b / 2) - 1.0f), 0.0).endVertex();
            bufferBuilder.pos((double)this.f, (double)(this.g + (float)(this.b / 2) - 1.0f), 0.0).endVertex();
            tessellator.draw();
            GlStateManager.enableTexture2D();
        }
        if (this.u) {
            tessellator = Tessellator.getInstance();
            bufferBuilder = tessellator.getBuffer();
            GlStateManager.disableTexture2D();
            bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
            int n2 = this.u ? -1 : 0;
            bufferBuilder.pos((double)(this.f + (float)n2), (double)(this.g + (float)this.b), 0.0).endVertex();
            bufferBuilder.pos((double)(this.f + f2), (double)(this.g + (float)this.b), 0.0).endVertex();
            bufferBuilder.pos((double)(this.f + f2), (double)(this.g + (float)this.b - 1.0f), 0.0).endVertex();
            bufferBuilder.pos((double)(this.f + (float)n2), (double)(this.g + (float)this.b - 1.0f), 0.0).endVertex();
            tessellator.draw();
            GlStateManager.enableTexture2D();
        }
        this.f += (float)((int)f2);
    }

    private /* synthetic */ int renderStringAligned(String string, int n2, int n3, int n4, int n5, boolean bl) {
        if (this.l) {
            int n6 = this.getStringWidth(this.bidiReorder(string));
            n2 = n2 + n4 - n6;
        }
        return this.renderString(string, n2, n3, n5, bl);
    }

    private /* synthetic */ int renderString(String string, float f2, float f3, int n2, boolean bl) {
        if (string == null) {
            return 0;
        }
        if (this.l) {
            string = this.bidiReorder(string);
        }
        if ((n2 & 0xFC000000) == 0) {
            n2 |= 0xFF000000;
        }
        if (bl) {
            n2 = (n2 & 0xFCFCFC) >> 2 | n2 & 0xFF000000;
        }
        this.m = (float)(n2 >> 16 & 0xFF) / 255.0f;
        this.n = (float)(n2 >> 8 & 0xFF) / 255.0f;
        this.o = (float)(n2 & 0xFF) / 255.0f;
        this.p = (float)(n2 >> 24 & 0xFF) / 255.0f;
        this.setColor(this.m, this.n, this.o, this.p);
        this.f = f2;
        this.g = f3;
        this.renderStringAtPos(string, bl);
        return (int)this.f;
    }

    public int getStringWidth(String string) {
        if (string == null) {
            return 0;
        }
        int n2 = 0;
        boolean bl = false;
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c = string.charAt(i2);
            int n3 = this.getCharWidth(c);
            if (n3 < 0 && i2 < string.length() - 1) {
                if ((c = string.charAt(++i2)) != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl = false;
                    }
                } else {
                    bl = true;
                }
                n3 = 0;
            }
            n2 += n3;
            if (!bl || n3 <= 0) continue;
            ++n2;
        }
        return n2;
    }

    public int getCharWidth(char c) {
        if (c == '\u00a0') {
            return 4;
        }
        if (c == '\u00a7') {
            return -1;
        }
        if (c == ' ') {
            return 4;
        }
        int n2 = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261\u00b1\u2265\u2264\u2320\u2321\u00f7\u2248\u00b0\u2219\u00b7\u221a\u207f\u00b2\u25a0\u0000".indexOf(c);
        if (c > '\u0000' && n2 != -1 && !this.k) {
            return this.a[n2];
        }
        if (this.d[c] != 0) {
            int n3 = this.d[c] & 0xFF;
            int n4 = n3 >>> 4;
            int n5 = n3 & 0xF;
            return (++n5 - n4) / 2 + 1;
        }
        return 0;
    }

    public String trimStringToWidth(String string, int n2) {
        return this.trimStringToWidth(string, n2, false);
    }

    public String trimStringToWidth(String string, int n2, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = 0;
        int n4 = bl ? string.length() - 1 : 0;
        int n5 = bl ? -1 : 1;
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i2 = n4; i2 >= 0 && i2 < string.length() && n3 < n2; i2 += n5) {
            char c = string.charAt(i2);
            int n6 = this.getCharWidth(c);
            if (bl2) {
                bl2 = false;
                if (c != 'l' && c != 'L') {
                    if (c == 'r' || c == 'R') {
                        bl3 = false;
                    }
                } else {
                    bl3 = true;
                }
            } else if (n6 < 0) {
                bl2 = true;
            } else {
                n3 += n6;
                if (bl3) {
                    ++n3;
                }
            }
            if (n3 > n2) break;
            if (bl) {
                stringBuilder.insert(0, c);
                continue;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private /* synthetic */ String trimStringNewline(String string) {
        while (string != null && string.endsWith("\n")) {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    public void drawSplitString(String string, int n2, int n3, int n4, int n5) {
        this.resetStyles();
        this.q = n5;
        string = this.trimStringNewline(string);
        this.renderSplitString(string, n2, n3, n4, false);
    }

    private /* synthetic */ void renderSplitString(String string, int n2, int n3, int n4, boolean bl) {
        for (String string2 : this.listFormattedStringToWidth(string, n4)) {
            this.renderStringAligned(string2, n2, n3, n4, this.q, bl);
            n3 += this.b;
        }
    }

    public int getWordWrappedHeight(String string, int n2) {
        return this.b * this.listFormattedStringToWidth(string, n2).size();
    }

    public void setUnicodeFlag(boolean bl) {
        this.k = bl;
    }

    public boolean getUnicodeFlag() {
        return this.k;
    }

    public void setBidiFlag(boolean bl) {
        this.l = bl;
    }

    public List listFormattedStringToWidth(String string, int n2) {
        return Arrays.asList(this.wrapFormattedStringToWidth(string, n2).split("\n"));
    }

    String wrapFormattedStringToWidth(String string, int n2) {
        int n3 = this.sizeStringToWidth(string, n2);
        if (string.length() <= n3) {
            return string;
        }
        String string2 = string.substring(0, n3);
        char c = string.charAt(n3);
        boolean bl = c == ' ' || c == '\n';
        String string3 = FontRendererHook.getFormatFromString(string2) + string.substring(n3 + (bl ? 1 : 0));
        return string2 + "\n" + this.wrapFormattedStringToWidth(string3, n2);
    }

    private /* synthetic */ int sizeStringToWidth(String string, int n2) {
        int n3;
        int n4 = string.length();
        int n5 = 0;
        int n6 = -1;
        boolean bl = false;
        for (n3 = 0; n3 < n4; ++n3) {
            char c = string.charAt(n3);
            switch (c) {
                case '\n': {
                    --n3;
                    break;
                }
                case ' ': {
                    n6 = n3;
                }
                default: {
                    n5 += this.getCharWidth(c);
                    if (!bl) break;
                    ++n5;
                    break;
                }
                case '\u00a7': {
                    char c2;
                    if (n3 >= n4 - 1) break;
                    if ((c2 = string.charAt(++n3)) != 'l' && c2 != 'L') {
                        if (c2 != 'r' && c2 != 'R' && !FontRendererHook.isFormatColor(c2)) break;
                        bl = false;
                        break;
                    }
                    bl = true;
                }
            }
            if (c == '\n') {
                n6 = ++n3;
                break;
            }
            if (n5 > n2) break;
        }
        return n3 != n4 && n6 != -1 && n6 < n3 ? n6 : n3;
    }

    private static /* synthetic */ boolean isFormatColor(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F';
    }

    private static /* synthetic */ boolean isFormatSpecial(char c) {
        return c >= 'k' && c <= 'o' || c >= 'K' && c <= 'O' || c == 'r' || c == 'R';
    }

    public static String getFormatFromString(String string) {
        String string2 = "";
        int n2 = -1;
        int n3 = string.length();
        while ((n2 = string.indexOf(167, n2 + 1)) != -1) {
            if (n2 >= n3 - 1) continue;
            char c = string.charAt(n2 + 1);
            if (FontRendererHook.isFormatColor(c)) {
                string2 = "\u00a7" + c;
                continue;
            }
            if (!FontRendererHook.isFormatSpecial(c)) continue;
            string2 = string2 + "\u00a7" + c;
        }
        return string2;
    }

    public boolean getBidiFlag() {
        return this.l;
    }

    public int getColorCode(char c) {
        int n2 = "0123456789abcdef".indexOf(c);
        return n2 >= 0 && n2 < this.i.length ? this.i[n2] : -1;
    }
}

