/*
 * Decompiled with CFR 0.152.
 */
import i.gishreloaded.deadcode.hack.Hack;
import java.util.Comparator;

public final class eK
implements Comparator {
    public int a(Hack hack, Hack hack2) {
        String string = hack.l();
        String string2 = hack2.l();
        int n2 = hack.v();
        int n3 = hack2.v();
        int n4 = n3 - n2;
        return n4 != 0 ? n4 : string2.compareTo(string);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((Hack)object, (Hack)object2);
    }
}

