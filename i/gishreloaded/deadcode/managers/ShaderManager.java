/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.managers;

import i.gishreloaded.deadcode.utils.visual.ChatUtils;

public class ShaderManager {
    private static dW a;
    private static bx b;
    private static an_0 c;
    private static o d;
    private static fd_0 e;

    public ShaderManager() {
        a = new dW();
        b = new bx();
        c = new an_0();
        d = new o();
        e = new fd_0();
        ChatUtils.debug("ShaderManager: initialized.");
    }

    public static void a() {
        ShaderManager.b().b();
        ShaderManager.c().b();
        ShaderManager.d().b();
        ShaderManager.e().b();
        ShaderManager.f().b();
    }

    public static dW b() {
        return a;
    }

    public static bx c() {
        return b;
    }

    public static an_0 d() {
        return c;
    }

    public static o e() {
        return d;
    }

    public static fd_0 f() {
        return e;
    }
}

