/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  net.minecraft.entity.Entity
 */
package excluded;

import com.google.common.base.Predicate;
import i.gishreloaded.deadcode.excluded.EntityRendererHook;
import net.minecraft.entity.Entity;

class r
implements Predicate {
    final /* synthetic */ EntityRendererHook a;

    r(EntityRendererHook entityRendererHook) {
        this.a = entityRendererHook;
    }

    public boolean a(Entity entity) {
        return entity != null && entity.canBeCollidedWith();
    }
}

