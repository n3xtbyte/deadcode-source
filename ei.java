/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.shader.Framebuffer
 *  net.minecraft.util.ScreenShotHelper
 */
import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.value.types.ColorValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.awt.Color;
import java.awt.image.BufferedImage;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ScreenShotHelper;

public class ei
extends Component {
    public ColorValue a;
    public Hack b;
    public dc c;
    public dc d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public BufferedImage j;
    public int k;

    public ei(int n2, int n3, int n4, int n5, Component component, Hack hack, ColorValue colorValue) {
        super(n2, n3, n4, n5, ComponentType.COLOR_PICKER, component);
        this.b = hack;
        this.a = colorValue;
        Color color = new Color(colorValue.getValue());
        float[] fArray = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        DoubleValue doubleValue = new DoubleValue("HUE", fArray[0], 0.0, 1.0);
        this.c = new dc(n2, n3, n4, n5, doubleValue.getMin(), doubleValue.getMax(), Float.valueOf(doubleValue.getValue().floatValue()), this, hack, doubleValue);
        DoubleValue doubleValue2 = new DoubleValue("Opacity", fArray[2], 0.0, 1.0);
        this.d = new dc(n2, n3, n4, n5, doubleValue2.getMin(), doubleValue2.getMax(), Float.valueOf(doubleValue2.getValue().floatValue()), this, hack, doubleValue2);
    }

    public void a() {
        this.e = this.getX() + 3;
        this.f = this.getX() + this.getWidth() - 3;
        this.g = this.getY() + 25;
        this.h = this.g + 28;
    }

    public boolean f(int n2, int n3) {
        int n4 = this.f;
        int n5 = this.h;
        int n6 = this.e;
        int n7 = this.g;
        return n2 >= n6 && n3 >= n7 && n2 <= n4 - 1 && n3 <= n5;
    }

    public void g(int n2, int n3) {
        if (this.j == null) {
            return;
        }
        int n4 = er.b(this.j.getRGB(n2 * 2, n3 * 2), (float)this.d.f);
        this.a.setValue(n4);
    }

    @Override
    public void c() {
        this.c.c();
        this.d.c();
        this.k = Color.HSBtoRGB((float)this.c.f, 1.0f, 1.0f);
        if (this.k == 0) {
            this.a.setValue(this.k);
        }
        super.c();
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        this.c.onMousePress(n2, n3, n4);
        this.d.onMousePress(n2, n3, n4);
        if (this.f(n2, n3)) {
            if (this.j == null) {
                this.j = ScreenShotHelper.createScreenshot((int)Wrapper.INSTANCE.getMinecraft().displayWidth, (int)Wrapper.INSTANCE.getMinecraft().displayHeight, (Framebuffer)Wrapper.INSTANCE.getMinecraft().getFramebuffer());
            }
            this.g(n2, n3);
            this.i = true;
        }
        super.onMousePress(n2, n3, n4);
    }

    @Override
    public void onMouseDrag(int n2, int n3) {
        this.c.onMouseDrag(n2, n3);
        this.d.onMouseDrag(n2, n3);
        if (this.i && this.f(n2, n3)) {
            this.g(n2, n3);
        }
        super.onMouseDrag(n2, n3);
    }

    @Override
    public void onMouseRelease(int n2, int n3, int n4) {
        this.c.onMouseRelease(n2, n3, n4);
        this.d.onMouseRelease(n2, n3, n4);
        this.i = false;
        this.j = null;
        super.onMouseRelease(n2, n3, n4);
    }

    @Override
    public void c(int n2, int n3) {
        this.c.setXY(this.getX(), this.getY());
        this.d.setXY(this.getX(), this.getY());
        this.c.d();
        this.d.d();
        this.a();
        super.c(n2, n3);
    }
}

