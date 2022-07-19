/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import java.io.File;

public class dl
extends dp {
    public boolean a;
    public eC b = \u2007\u2008\u00a0.n.a("Other", "Avatar-Circle");
    public eC c = \u2007\u2008\u00a0.n.a("Other", "Avatar");
    public eC d = \u2007\u2008\u00a0.n.a("Other", "Profile-Style");

    public dl(int n2, int n3, int n4, int n5, Component component) {
        super(n2, n3, n4, n5, ComponentType.g, component);
        this.a = new File(\u2007\u2008\u00a0.n.a).exists();
    }
}

