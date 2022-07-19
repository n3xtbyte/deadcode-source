/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ChatLine
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.GuiNewChat
 *  net.minecraft.client.gui.GuiUtilRenderComponents
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.EntityPlayer$EnumChatVisibility
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package excluded;

import com.google.common.collect.Lists;
import i.gishreloaded.deadcode.hacks.render.CustomChat;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class g
extends GuiNewChat {
    private final Minecraft a;
    private final List b = Lists.newArrayList();
    private final List c = Lists.newArrayList();
    private final List d = Lists.newArrayList();
    private int e;
    private boolean f;

    public g(Minecraft minecraft) {
        super(minecraft);
        this.a = minecraft;
    }

    public void a(int n2) {
        if (this.a.gameSettings.chatVisibility != EntityPlayer.EnumChatVisibility.HIDDEN) {
            try {
                int n3 = this.h();
                int n4 = this.d.size();
                float f2 = this.a.gameSettings.chatOpacity * 0.9f + 0.1f;
                if (n4 > 0) {
                    int n5;
                    int n6;
                    int n7;
                    int n8;
                    boolean bl = false;
                    if (this.d()) {
                        bl = true;
                    }
                    float f3 = this.g();
                    int n9 = MathHelper.ceil((float)((float)this.e() / f3));
                    GlStateManager.pushMatrix();
                    GlStateManager.translate((float)2.0f, (float)8.0f, (float)0.0f);
                    GlStateManager.scale((float)f3, (float)f3, (float)1.0f);
                    int n10 = 0;
                    for (n8 = 0; n8 + this.e < this.d.size() && n8 < n3; ++n8) {
                        ChatLine chatLine = (ChatLine)this.d.get(n8 + this.e);
                        if (chatLine == null || (n7 = n2 - chatLine.getUpdatedCounter()) >= 200 && !bl) continue;
                        double d2 = (double)n7 / 200.0;
                        d2 = 1.0 - d2;
                        d2 *= 10.0;
                        d2 = MathHelper.clamp((double)d2, (double)0.0, (double)1.0);
                        d2 *= d2;
                        n6 = (int)(255.0 * d2);
                        if (bl) {
                            n6 = 255;
                        }
                        n6 = (int)((float)n6 * f2);
                        ++n10;
                        if (n6 <= 3) continue;
                        n5 = -n8 * 9;
                        String string = chatLine.getChatComponent().getFormattedText();
                        int n11 = 0 + n9 + 4;
                        if (CustomChat.a) {
                            int n12 = Wrapper.INSTANCE.f().a(string);
                            if (n12 > n11) {
                                n11 = n12 + 3;
                            }
                            RenderUtils.a(-2.0, (double)n5 - 8.5, (double)n11, (double)n5 + 0.5, n6 / 2 << 24);
                        } else {
                            g.drawRect((int)-2, (int)(n5 - 9), (int)(0 + n9 + 4), (int)n5, (int)(n6 / 2 << 24));
                        }
                        GlStateManager.enableBlend();
                        if (CustomChat.a) {
                            RenderUtils.a(string, 0, n5 - 8, 0xFFFFFF + (n6 << 24));
                        } else {
                            this.a.fontRenderer.drawStringWithShadow(string, 0.0f, (float)(n5 - 8), 0xFFFFFF + (n6 << 24));
                        }
                        GlStateManager.disableAlpha();
                        GlStateManager.disableBlend();
                    }
                    if (bl) {
                        n8 = this.a.fontRenderer.FONT_HEIGHT;
                        GlStateManager.translate((float)-3.0f, (float)0.0f, (float)0.0f);
                        int n13 = n4 * n8 + n4;
                        n7 = n10 * n8 + n10;
                        int n14 = this.e * n7 / n4;
                        int n15 = n7 * n7 / n13;
                        if (n13 != n7) {
                            n6 = n14 > 0 ? 170 : 96;
                            n5 = this.f ? 0xCC3333 : 0x3333AA;
                            g.drawRect((int)0, (int)(-n14), (int)2, (int)(-n14 - n15), (int)(n5 + (n6 << 24)));
                            g.drawRect((int)2, (int)(-n14), (int)1, (int)(-n14 - n15), (int)(0xCCCCCC + (n6 << 24)));
                        }
                    }
                    GlStateManager.popMatrix();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public void a(boolean bl) {
        this.d.clear();
        this.c.clear();
        if (bl) {
            this.b.clear();
        }
    }

    public void a(ITextComponent iTextComponent) {
        this.a(iTextComponent, 0);
    }

    public void a(ITextComponent iTextComponent, int n2) {
        this.a(iTextComponent, n2, this.a.ingameGUI.getUpdateCounter(), false);
    }

    private /* synthetic */ void a(ITextComponent iTextComponent, int n2, int n3, boolean bl) {
        if (n2 != 0) {
            this.c(n2);
        }
        int n4 = MathHelper.floor((float)((float)this.e() / this.g()));
        List list = GuiUtilRenderComponents.splitText((ITextComponent)iTextComponent, (int)n4, (FontRenderer)this.a.fontRenderer, (boolean)false, (boolean)false);
        boolean bl2 = this.d();
        for (ITextComponent iTextComponent2 : list) {
            if (bl2 && this.e > 0) {
                this.f = true;
                this.b(1);
            }
            this.d.add(0, new ChatLine(n3, iTextComponent2, n2));
        }
        while (this.d.size() > 100) {
            this.d.remove(this.d.size() - 1);
        }
        if (!bl) {
            this.c.add(0, new ChatLine(n3, iTextComponent, n2));
            while (this.c.size() > 100) {
                this.c.remove(this.c.size() - 1);
            }
        }
    }

    public void a() {
        this.d.clear();
        this.c();
        for (int i2 = this.c.size() - 1; i2 >= 0; --i2) {
            ChatLine chatLine = (ChatLine)this.c.get(i2);
            this.a(chatLine.getChatComponent(), chatLine.getChatLineID(), chatLine.getUpdatedCounter(), true);
        }
    }

    public List b() {
        return this.b;
    }

    public void a(String string) {
        if (this.b.isEmpty() || !((String)this.b.get(this.b.size() - 1)).equals(string)) {
            this.b.add(string);
        }
    }

    public void c() {
        this.e = 0;
        this.f = false;
    }

    public void b(int n2) {
        this.e += n2;
        int n3 = this.d.size();
        if (this.e > n3 - this.h()) {
            this.e = n3 - this.h();
        }
        if (this.e <= 0) {
            this.e = 0;
            this.f = false;
        }
    }

    public ITextComponent a(int n2, int n3) {
        if (!this.d()) {
            return null;
        }
        ScaledResolution scaledResolution = new ScaledResolution(this.a);
        int n4 = scaledResolution.getScaleFactor();
        float f2 = this.g();
        int n5 = n2 / n4 - 2;
        int n6 = n3 / n4 - 40;
        n5 = MathHelper.floor((float)((float)n5 / f2));
        n6 = MathHelper.floor((float)((float)n6 / f2));
        if (n5 >= 0 && n6 >= 0) {
            int n7 = Math.min(this.h(), this.d.size());
            if (n5 <= MathHelper.floor((float)((float)this.e() / this.g())) && n6 < this.a.fontRenderer.FONT_HEIGHT * n7 + n7) {
                int n8 = n6 / this.a.fontRenderer.FONT_HEIGHT + this.e;
                if (n8 >= 0 && n8 < this.d.size()) {
                    ChatLine chatLine = (ChatLine)this.d.get(n8);
                    int n9 = 0;
                    for (ITextComponent iTextComponent : chatLine.getChatComponent()) {
                        if (!(iTextComponent instanceof TextComponentString) || (n9 += this.a.fontRenderer.getStringWidth(GuiUtilRenderComponents.removeTextColorsIfConfigured((String)((TextComponentString)iTextComponent).getText(), (boolean)false))) <= n5) continue;
                        return iTextComponent;
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public boolean d() {
        return this.a.currentScreen instanceof GuiChat;
    }

    public void c(int n2) {
        ChatLine chatLine;
        Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            chatLine = (ChatLine)iterator.next();
            if (chatLine.getChatLineID() != n2) continue;
            iterator.remove();
        }
        iterator = this.c.iterator();
        while (iterator.hasNext()) {
            chatLine = (ChatLine)iterator.next();
            if (chatLine.getChatLineID() != n2) continue;
            iterator.remove();
            break;
        }
    }

    public int e() {
        return g.a(this.a.gameSettings.chatWidth);
    }

    public int f() {
        return g.b(this.d() ? this.a.gameSettings.chatHeightFocused : this.a.gameSettings.chatHeightUnfocused);
    }

    public float g() {
        return this.a.gameSettings.chatScale;
    }

    public static int a(float f2) {
        return MathHelper.floor((float)(f2 * 280.0f + 40.0f));
    }

    public static int b(float f2) {
        return MathHelper.floor((float)(f2 * 160.0f + 20.0f));
    }

    public int h() {
        return this.f() / 9;
    }
}

