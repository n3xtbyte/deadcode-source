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

class n
implements ICrashReportDetail {
    final /* synthetic */ ItemStack a;
    final /* synthetic */ j b;

    n(j j2, ItemStack itemStack) {
        this.b = j2;
        this.a = itemStack;
    }

    public String a() {
        return String.valueOf(this.a.hasEffect());
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

