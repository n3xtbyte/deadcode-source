/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
import i.gishreloaded.deadcode.utils.shader.ShaderProgram;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import org.lwjgl.opengl.GL11;

public class o
extends ShaderProgram {
    public float a;

    public o() {
        this.a(\u200b\u2000.break()[2]);
    }

    public void a(double d2, double d3, double d4, double d5) {
        if (!this.d) {
            return;
        }
        super.startUseShader();
        this.d();
        this.uniform2f("resolution", Wrapper.INSTANCE.getMinecraft().displayWidth, Wrapper.INSTANCE.getMinecraft().displayHeight);
        this.uniform1f("iTime", this.a);
        GL11.glBegin((int)7);
        GL11.glVertex2d((double)d4, (double)d3);
        GL11.glVertex2d((double)d2, (double)d3);
        GL11.glVertex2d((double)d2, (double)d5);
        GL11.glVertex2d((double)d4, (double)d5);
        GL11.glEnd();
        super.stopUseShader();
        this.a += 0.01f;
    }

    public void a() {
        this.a = 0.0f;
    }
}

