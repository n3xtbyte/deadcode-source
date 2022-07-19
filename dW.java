/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
import i.gishreloaded.deadcode.utils.shader.ShaderProgram;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import org.lwjgl.opengl.GL11;

public class dW
extends ShaderProgram {
    public dW() {
        this.a(\u200b\u2000.break()[4]);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, int n2, int n3) {
        this.a(f2 -= (float)n2, f3 -= (float)n2, f4 += (float)n2, f5 += (float)n2, f6, n3);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, int n2) {
        if (!this.d) {
            return;
        }
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3008);
        float[] fArray = er.a(n2);
        int n3 = 2;
        this.startUseShader();
        this.uniform4f("color", fArray[0], fArray[1], fArray[2], fArray[3]);
        this.d();
        this.uniform2f("resolution", Wrapper.INSTANCE.getMinecraft().displayWidth, Wrapper.INSTANCE.getMinecraft().displayHeight);
        this.uniform2f("center", (f2 + (f4 - f2) / (float)n3) * (float)n3, (f3 + (f5 - f3) / (float)n3) * (float)n3);
        this.uniform2f("dst", (f4 - f2 - f6) * 2.0f, (f5 - f3 - f6) * 2.0f);
        this.uniform1f("radius", f6);
        GL11.glBegin((int)7);
        GL11.glVertex2d((double)f4, (double)f3);
        GL11.glVertex2d((double)f2, (double)f3);
        GL11.glVertex2d((double)f2, (double)f5);
        GL11.glVertex2d((double)f4, (double)f5);
        GL11.glEnd();
        this.stopUseShader();
        GL11.glEnable((int)3008);
    }
}

