/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.base.Predicates
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$LogicOp
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ChatAllowedCharacters
 *  net.minecraft.util.math.MathHelper
 */
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.math.MathHelper;

public class eg {
    private final bu e;
    private final int f = 64;
    public int a;
    public int b;
    public int c;
    public int d;
    private String g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private String o;
    private String p;
    private Predicate q = Predicates.alwaysTrue();

    public eg(bu bu2, int n2, int n3, int n4, int n5, String string) {
        this.e = bu2;
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.d = n5;
        this.g = "";
        this.i = true;
        this.k = true;
        this.j = true;
        this.o = "";
        this.p = string;
    }

    public void a(String string) {
        this.o = string;
    }

    public void a() {
        ++this.h;
    }

    public void b(String string) {
        if (this.q.apply((Object)string)) {
            this.g = string.length() > this.f ? string.substring(0, this.f) : string;
            this.e();
        }
    }

    public String b() {
        return this.g;
    }

    public String c() {
        int n2 = this.m < this.n ? this.m : this.n;
        int n3 = this.m < this.n ? this.n : this.m;
        return this.g.substring(n2, n3);
    }

    public void a(Predicate predicate) {
        this.q = predicate;
    }

    public void c(String string) {
        int n2;
        String string2 = "";
        String string3 = ChatAllowedCharacters.filterAllowedCharacters((String)string);
        int n3 = this.m < this.n ? this.m : this.n;
        int n4 = this.m < this.n ? this.n : this.m;
        int n5 = this.f - this.g.length() - (n3 - n4);
        if (!this.g.isEmpty()) {
            string2 = string2 + this.g.substring(0, n3);
        }
        if (n5 < string3.length()) {
            string2 = string2 + string3.substring(0, n5);
            n2 = n5;
        } else {
            string2 = string2 + string3;
            n2 = string3.length();
        }
        if (!this.g.isEmpty() && n4 < this.g.length()) {
            string2 = string2 + this.g.substring(n4);
        }
        if (this.q.apply((Object)string2)) {
            this.g = string2;
            this.d(n3 - this.n + n2);
        }
    }

    public void a(int n2) {
        if (!this.g.isEmpty()) {
            if (this.n != this.m) {
                this.c("");
            } else {
                this.b(this.c(n2) - this.m);
            }
        }
    }

    public void b(int n2) {
        if (!this.g.isEmpty()) {
            if (this.n != this.m) {
                this.c("");
            } else {
                boolean bl = n2 < 0;
                int n3 = bl ? this.m + n2 : this.m;
                int n4 = bl ? this.m : this.m + n2;
                String string = "";
                if (n3 >= 0) {
                    string = this.g.substring(0, n3);
                }
                if (n4 < this.g.length()) {
                    string = string + this.g.substring(n4);
                }
                if (this.q.apply((Object)string)) {
                    this.g = string;
                    if (bl) {
                        this.d(n2);
                    }
                }
            }
        }
    }

    public int c(int n2) {
        return this.a(n2, this.h());
    }

    public int a(int n2, int n3) {
        return this.a(n2, n3, true);
    }

    public int a(int n2, int n3, boolean bl) {
        int n4 = n3;
        boolean bl2 = n2 < 0;
        int n5 = Math.abs(n2);
        for (int i2 = 0; i2 < n5; ++i2) {
            if (!bl2) {
                int n6 = this.g.length();
                if ((n4 = this.g.indexOf(32, n4)) == -1) {
                    n4 = n6;
                    continue;
                }
                while (bl && n4 < n6 && this.g.charAt(n4) == ' ') {
                    ++n4;
                }
                continue;
            }
            while (bl && n4 > 0 && this.g.charAt(n4 - 1) == ' ') {
                --n4;
            }
            while (n4 > 0 && this.g.charAt(n4 - 1) != ' ') {
                --n4;
            }
        }
        return n4;
    }

    public void d(int n2) {
        this.e(this.n + n2);
    }

    public void e(int n2) {
        this.m = n2;
        int n3 = this.g.length();
        this.m = MathHelper.clamp((int)this.m, (int)0, (int)n3);
        this.f(this.m);
    }

    public void d() {
        this.e(0);
    }

    public void e() {
        this.e(this.g.length());
    }

    public boolean a(char c, int n2) {
        if (!this.j) {
            return false;
        }
        if (GuiScreen.isKeyComboCtrlA((int)n2)) {
            this.e();
            this.f(0);
            return true;
        }
        if (GuiScreen.isKeyComboCtrlC((int)n2)) {
            GuiScreen.setClipboardString((String)this.c());
            return true;
        }
        if (GuiScreen.isKeyComboCtrlV((int)n2)) {
            if (this.k) {
                this.c(GuiScreen.getClipboardString());
            }
            return true;
        }
        if (GuiScreen.isKeyComboCtrlX((int)n2)) {
            GuiScreen.setClipboardString((String)this.c());
            if (this.k) {
                this.c("");
            }
            return true;
        }
        switch (n2) {
            case 14: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.k) {
                        this.a(-1);
                    }
                } else if (this.k) {
                    this.b(-1);
                }
                return true;
            }
            case 199: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.f(0);
                } else {
                    this.d();
                }
                return true;
            }
            case 203: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.f(this.a(-1, this.k()));
                    } else {
                        this.f(this.k() - 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    this.e(this.c(-1));
                } else {
                    this.d(-1);
                }
                return true;
            }
            case 205: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.f(this.a(1, this.k()));
                    } else {
                        this.f(this.k() + 1);
                    }
                } else if (GuiScreen.isCtrlKeyDown()) {
                    this.e(this.c(1));
                } else {
                    this.d(1);
                }
                return true;
            }
            case 207: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.f(this.g.length());
                } else {
                    this.e();
                }
                return true;
            }
            case 211: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.k) {
                        this.a(1);
                    }
                } else if (this.k) {
                    this.b(1);
                }
                return true;
            }
        }
        if (ChatAllowedCharacters.isAllowedCharacter((char)c)) {
            if (this.k) {
                this.c(Character.toString(c));
            }
            return true;
        }
        return false;
    }

    public boolean a(int n2, int n3, int n4) {
        boolean bl;
        boolean bl2 = bl = n2 >= this.a && n2 < this.a + this.c && n3 >= this.b && n3 < this.b + this.d;
        if (this.i) {
            // empty if block
        }
        if (this.j && bl && n4 == 0) {
            int n5 = n2 - this.a;
            String string = Wrapper.INSTANCE.getMinecraft().fontRenderer.trimStringToWidth(this.g.substring(this.l), this.l());
            this.e(Wrapper.INSTANCE.getMinecraft().fontRenderer.trimStringToWidth(string, n5).length() + this.l);
            return true;
        }
        return false;
    }

    public void f() {
        aX.b(this.a, this.b, this.a + this.c, this.b + this.d);
        int n2 = aX.h;
        int n3 = this.m - this.l;
        if (n3 < 1) {
            n3 = 1;
        }
        int n4 = this.n - this.l;
        String string = Wrapper.INSTANCE.getMinecraft().fontRenderer.trimStringToWidth(this.g.substring(this.l), this.l());
        boolean bl = n3 >= 0 && n3 <= string.length();
        boolean bl2 = this.j && this.h / 6 % 2 == 0 && bl;
        int n5 = this.a + 4;
        int n6 = this.b + (this.d - 6) / 2;
        int n7 = n5;
        if (n4 > string.length()) {
            n4 = string.length();
        }
        if (!this.k) {
            this.e.a(this.o, n5, n6, n2);
            return;
        }
        if (!string.isEmpty()) {
            String string2 = bl ? string.substring(0, n3) : string;
            n7 = (int)this.e.a(string2, n5, n6, n2);
        } else {
            this.e.a(this.p, n5, n6, aX.m);
        }
        boolean bl3 = this.m < this.g.length() || this.g.length() >= this.g();
        int n8 = n7 + 2;
        if (!bl) {
            n8 = n3 > 0 ? n5 + this.c : n5;
        } else if (bl3) {
            n8 = n7 - 1;
            n7 += 4;
        }
        if (!string.isEmpty() && bl && n3 < string.length()) {
            n7 = (int)this.e.a(string.substring(n3), n7, n6, n2);
        }
        if (bl2) {
            if (bl3) {
                RenderUtils.a((double)(n8 + 3), (double)(n6 - 4), (double)(n8 + 4), (double)(n6 + 9), aX.i);
            } else {
                this.e.a("_", n8, n6, n2);
            }
        }
        if (n4 != n3 && n3 > 1) {
            int n9 = n5 + this.e.a(string.substring(0, n4));
            this.a(n8, n6 - 2, n9 - 1, n6 + 9 - 1);
        }
    }

    private /* synthetic */ void a(int n2, int n3, int n4, int n5) {
        int n6;
        if (n2 < n4) {
            n6 = n2;
            n2 = n4;
            n4 = n6;
        }
        if (n3 < n5) {
            n6 = n3;
            n3 = n5;
            n5 = n6;
        }
        if (n4 > this.a + this.c) {
            n4 = this.a + this.c;
        }
        if (n2 > this.a + this.c) {
            n2 = this.a + this.c;
        }
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.color((float)0.0f, (float)0.0f, (float)255.0f, (float)255.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.enableColorLogic();
        GlStateManager.colorLogicOp((GlStateManager.LogicOp)GlStateManager.LogicOp.OR_REVERSE);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double)n2, (double)n5, 0.0).endVertex();
        bufferBuilder.pos((double)n4, (double)n5, 0.0).endVertex();
        bufferBuilder.pos((double)n4, (double)n3, 0.0).endVertex();
        bufferBuilder.pos((double)n2, (double)n3, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.disableColorLogic();
        GlStateManager.enableTexture2D();
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.m;
    }

    public void a(boolean bl) {
        if (bl && !this.j) {
            this.h = 0;
        }
        this.j = bl;
        if (Minecraft.getMinecraft().currentScreen != null) {
            Minecraft.getMinecraft().currentScreen.setFocused(bl);
        }
    }

    public boolean i() {
        return this.j;
    }

    public void b(boolean bl) {
        this.k = bl;
    }

    public boolean j() {
        return this.k;
    }

    public int k() {
        return this.n;
    }

    public int l() {
        return this.c;
    }

    public void f(int n2) {
        int n3 = this.g.length();
        if (n2 > n3) {
            n2 = n3;
        }
        if (n2 < 0) {
            n2 = 0;
        }
        this.n = n2;
        if (this.e != null) {
            if (this.l > n3) {
                this.l = n3;
            }
            int n4 = this.l();
            String string = Wrapper.INSTANCE.getMinecraft().fontRenderer.trimStringToWidth(this.g.substring(this.l), n4);
            int n5 = string.length() + this.l;
            if (n2 == this.l) {
                this.l -= Wrapper.INSTANCE.getMinecraft().fontRenderer.trimStringToWidth(this.g, n4, true).length();
            }
            if (n2 > n5) {
                this.l += n2 - n5;
            } else if (n2 <= this.l) {
                this.l -= this.l - n2;
            }
            this.l = MathHelper.clamp((int)this.l, (int)0, (int)n3);
        }
    }

    public void c(boolean bl) {
        this.i = bl;
    }
}

