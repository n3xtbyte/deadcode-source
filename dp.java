/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 */
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class dp
extends Component {
    public double s;
    private double a;
    private double b;
    private double c;
    public int t;

    public dp(int n2, int n3, int n4, int n5, ComponentType componentType, Component component) {
        super(n2, n3, n4, n5, componentType, component);
    }

    public void a(int n2, int n3) {
        GL11.glEnable((int)3089);
        int n4 = 2;
        if (Display.getWidth() < 640 || Display.getHeight() < 480) {
            n4 = 1;
        }
        GL11.glScissor((int)(this.getX() * n4), (int)(Display.getHeight() - (this.getY() + this.getHeight()) * n4), (int)(this.getWidth() * n4), (int)(this.getHeight() * n4));
        for (Component component : this.b()) {
            component.c(n2, n3);
        }
        GL11.glDisable((int)3089);
    }

    public void c(int n2) {
        this.a += (double)n2;
        this.s += (double)n2;
    }

    public void o() {
        this.a(this.c + this.a);
        this.a *= 0.84;
        this.s = this.a();
        if (this.s < (double)this.p()) {
            this.c = this.s = (double)this.p();
        }
        if (this.s > 0.0) {
            this.s = 0.0;
            this.c = 0.0;
        }
    }

    private /* synthetic */ double a() {
        return this.b + (this.c - this.b) * (double)Wrapper.INSTANCE.getMinecraft().getTickLength();
    }

    private /* synthetic */ void a(double d2) {
        this.b = this.c;
        this.c = d2;
    }

    public int p() {
        if (this.b().size() == 0) {
            return 0;
        }
        Component component = (Component)this.b().get(this.b().size() - 1);
        int n2 = component.g() + component.getHeight();
        return this.d() - n2;
    }

    private /* synthetic */ int d() {
        return this.getY() + this.getHeight();
    }
}

