/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.base.Component;
import java.io.File;

public class cn
extends bh {
    public final /* synthetic */ File a;
    public final /* synthetic */ eJ b;

    public cn(eJ eJ2, int n2, int n3, int n4, int n5, Component component, eC eC2, String string, int n6, File file) {
        this.b = eJ2;
        this.a = file;
        super(n2, n3, n4, n5, component, eC2, string, n6);
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        this.b.a(this.a.getName());
        super.onMousePress(n2, n3, n4);
    }
}

