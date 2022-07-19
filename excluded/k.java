/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.crash.ICrashReportDetail
 *  net.minecraft.item.ItemStack
 */
package excluded;

import excluded.j;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.item.ItemStack;

class k
implements ICrashReportDetail {
    final /* synthetic */ ItemStack a;
    final /* synthetic */ j b;

    k(j j2, ItemStack itemStack) {
        this.b = j2;
        this.a = itemStack;
    }

    public String a() {
        return String.valueOf(this.a.getItem());
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

