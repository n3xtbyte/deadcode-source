/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.ui.base.Component;
import java.util.Comparator;

public class cg
implements Comparator {
    public final /* synthetic */ au a;

    public cg(au au2) {
        this.a = au2;
    }

    public int a(Component component, Component component2) {
        boolean bl = component instanceof be && ((be)component).h > 0.0f;
        boolean bl2 = component2 instanceof be && ((be)component2).h > 0.0f;
        return Boolean.compare(bl, bl2);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((Component)object, (Component)object2);
    }
}

