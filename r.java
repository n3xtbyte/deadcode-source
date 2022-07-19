/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import java.io.File;

public class r
extends bh {
    public final /* synthetic */ File a;
    public final /* synthetic */ eJ b;

    public r(eJ eJ2, int n2, int n3, int n4, int n5, Component component, eC eC2, String string, int n6, File file) {
        this.b = eJ2;
        this.a = file;
        super(n2, n3, n4, n5, component, eC2, string, n6);
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        try {
            \u2001\u2000\u00a0.if(this.a.getName());
        }
        catch (Exception exception) {
            ChatUtils.exception("ConfigManager: delete", exception);
        }
        super.onMousePress(n2, n3, n4);
    }
}

