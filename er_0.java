/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.base.Component;

/*
 * Renamed from eR
 */
public class er_0
extends bh {
    public final /* synthetic */ fD a;

    public er_0(fD fD2, int n2, int n3, int n4, int n5, Component component, eC eC2, String string, int n6) {
        this.a = fD2;
        super(n2, n3, n4, n5, component, eC2, string, n6);
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        this.a.a("help");
        super.onMousePress(n2, n3, n4);
    }
}

