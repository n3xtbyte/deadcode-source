/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.OpenGlHelper
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL20
 */
package i.gishreloaded.deadcode.utils.shader;

import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;

public abstract class ShaderProgram {
    public int b = -1;
    public int c;
    private String a;
    public boolean d;

    public void b() {
        if (this.b == -1) {
            this.loadShader();
        }
    }

    public void a(String string) {
        String string2 = \u200b\u2000.void()[2];
        this.a = this.c(string + string2);
        this.b(string + string2);
    }

    public void b(String string) {
        String string2 = this.c(string);
        File file = new File(string2);
        if (file.exists()) {
            ChatUtils.debug("ShaderProgram: file " + string + " is found.");
            this.d = true;
        } else {
            try {
                fn.a(\u200b\u2000.void()[0] + \u200b\u2000.void()[1] + string.replace(\u200b\u2000.void()[2], ".txt"), string2);
                file = new File(string2);
                this.d = file.exists();
                ChatUtils.debug(String.format("ShaderProgram: Download file '%s' is '%s'.", string, this.d));
            }
            catch (Exception exception) {
                ChatUtils.exception("ShaderProgram", exception);
            }
        }
    }

    private /* synthetic */ String c(String string) {
        String string2 = \u2001\u2000\u00a0.e.getAbsolutePath();
        String string3 = new File(string2, string).getAbsolutePath();
        return string3;
    }

    public void loadShader() {
        if (!this.d) {
            ChatUtils.error("ShaderProgram: loadShader shouldRender is false.");
            return;
        }
        if (!et.a(this.a)) {
            this.c = this.readShaderFromFile(this.a, 35632);
        }
        if (!this.d) {
            ChatUtils.error("ShaderProgram: loadShader shouldRender is false.");
            return;
        }
        this.b = GL20.glCreateProgram();
        if (!et.a(this.a)) {
            GL20.glAttachShader((int)this.b, (int)this.c);
        }
        GL20.glLinkProgram((int)this.b);
        GL20.glValidateProgram((int)this.b);
    }

    public void d() {
        GL13.glActiveTexture((int)33986);
        GL11.glBindTexture((int)3553, (int)Wrapper.INSTANCE.getMinecraft().getFramebuffer().framebufferTexture);
        this.uniform1i("framebuffer", 2);
        GL13.glActiveTexture((int)33984);
    }

    public void uniform4f(String string, float f2, float f3, float f4, float f5) {
        int n2 = GL20.glGetUniformLocation((int)this.b, (CharSequence)string);
        GL20.glUniform4f((int)n2, (float)f2, (float)f3, (float)f4, (float)f5);
    }

    public void uniform1f(String string, float f2) {
        int n2 = GL20.glGetUniformLocation((int)this.b, (CharSequence)string);
        GL20.glUniform1f((int)n2, (float)f2);
    }

    public void uniform1i(String string, int n2) {
        int n3 = GL20.glGetUniformLocation((int)this.b, (CharSequence)string);
        GL20.glUniform1i((int)n3, (int)n2);
    }

    public void uniform2f(String string, float f2, float f3) {
        int n2 = GL20.glGetUniformLocation((int)this.b, (CharSequence)string);
        GL20.glUniform2f((int)n2, (float)f2, (float)f3);
    }

    public void startUseShader() {
        GL20.glUseProgram((int)this.b);
    }

    public void stopUseShader() {
        GL20.glUseProgram((int)0);
    }

    public void deleteShader() {
        this.stopUseShader();
        if (!et.a(this.a)) {
            GL20.glDetachShader((int)this.b, (int)this.c);
        }
        if (!et.a(this.a)) {
            GL20.glDeleteShader((int)this.c);
        }
        GL20.glDeleteProgram((int)this.b);
    }

    public boolean h() {
        return this.d;
    }

    private /* synthetic */ int readShaderFromFile(String string, int n2) {
        ChatUtils.debug("ShaderProgram: Trying to load shader...");
        int n3 = -1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String string2;
            String[] stringArray = \u200b\u2000.super();
            String string3 = System.getProperty("line.separator");
            FileReader fileReader = new FileReader(string);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((string2 = bufferedReader.readLine()) != null) {
                string2 = \u2008\u2001.goto(string2, stringArray[0], stringArray[1]);
                stringBuilder.append(string2).append(string3);
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (Exception exception) {
            ChatUtils.exception("ShaderProgram: readShaderFromFile", exception);
            this.d = false;
        }
        n3 = this.compileShader(stringBuilder, n2);
        stringBuilder = null;
        if (n3 == -1 || n3 == 0) {
            this.d = false;
        }
        return n3;
    }

    private /* synthetic */ int compileShader(CharSequence charSequence, int n2) {
        if (!OpenGlHelper.shadersSupported) {
            ChatUtils.error("ShaderProgram: PC does not support shaders.");
            this.d = false;
            return -1;
        }
        int n3 = 0;
        try {
            n3 = GL20.glCreateShader((int)n2);
            GL20.glShaderSource((int)n3, (CharSequence)charSequence);
            GL20.glCompileShader((int)n3);
            if (GL20.glGetShaderi((int)n3, (int)35713) == 0) {
                this.d = false;
                ChatUtils.error("ShaderProgram: Could not compile shader.");
                ChatUtils.error(GL20.glGetShaderInfoLog((int)n3, (int)500));
            } else {
                this.d = true;
                ChatUtils.debug(String.format("ShaderProgram: loadShader %s successful.", n3));
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("ShaderProgram: compileShader", exception);
            this.d = false;
        }
        return n3;
    }
}

