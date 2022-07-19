/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.base.Predicates
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.EntitySelectors
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 */
package i.gishreloaded.deadcode.utils;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import i.gishreloaded.deadcode.hacks.combat.Reach;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class RaytraceUtils {
    public static double a() {
        return (double)Wrapper.INSTANCE.getMinecraft().playerController.getBlockReachDistance() - 1.5;
    }

    public static double b() {
        double d2 = RaytraceUtils.a();
        Reach reach = (Reach)HackManager.getHack("Reach");
        if (reach.isToggled()) {
            d2 = reach.c.getMode("Packet").isToggled() ? reach.b.getValue().doubleValue() : reach.a.getValue().doubleValue();
        }
        return d2;
    }

    public static RayTraceResult a(double d2) {
        return RaytraceUtils.a(d2, Wrapper.INSTANCE.getMinecraft().getRenderPartialTicks());
    }

    public static RayTraceResult a(double d2, float f2, float f3) {
        return RaytraceUtils.a(d2, f2, f3, Wrapper.INSTANCE.getMinecraft().getRenderPartialTicks());
    }

    public static Entity b(double d2) {
        return RaytraceUtils.b(d2, Wrapper.INSTANCE.getMinecraft().getRenderPartialTicks());
    }

    public static Entity b(double d2, float f2, float f3) {
        return RaytraceUtils.b(d2, f2, f3, Wrapper.INSTANCE.getMinecraft().getRenderPartialTicks());
    }

    public static RayTraceResult a(double d2, float f2) {
        Entity entity = Wrapper.INSTANCE.getMinecraft().getRenderViewEntity();
        Vec3d vec3d = entity.getPositionEyes(f2);
        Vec3d vec3d2 = entity.getLook(f2);
        Vec3d vec3d3 = vec3d.add(vec3d2.x * d2, vec3d2.y * d2, vec3d2.z * d2);
        return Wrapper.INSTANCE.getWorld().rayTraceBlocks(vec3d, vec3d3, false, false, true);
    }

    public static RayTraceResult a(double d2, float f2, float f3, float f4) {
        Entity entity = Wrapper.INSTANCE.getMinecraft().getRenderViewEntity();
        Vec3d vec3d = entity.getPositionEyes(f4);
        Vec3d vec3d2 = RaytraceUtils.a(f3, f2);
        Vec3d vec3d3 = vec3d.add(vec3d2.x * d2, vec3d2.y * d2, vec3d2.z * d2);
        return Wrapper.INSTANCE.getWorld().rayTraceBlocks(vec3d, vec3d3, false, false, true);
    }

    public static Entity b(double d2, float f2) {
        Entity entity = Wrapper.INSTANCE.getMinecraft().getRenderViewEntity();
        Vec3d vec3d = entity.getPositionEyes(f2);
        Vec3d vec3d2 = entity.getLook(f2);
        Vec3d vec3d3 = vec3d.add(vec3d2.x * d2, vec3d2.y * d2, vec3d2.z * d2);
        return RaytraceUtils.a(entity, d2, vec3d, vec3d2, vec3d3);
    }

    public static Entity b(double d2, float f2, float f3, float f4) {
        Entity entity = Wrapper.INSTANCE.getMinecraft().getRenderViewEntity();
        Vec3d vec3d = entity.getPositionEyes(f4);
        Vec3d vec3d2 = RaytraceUtils.a(f3, f2);
        Vec3d vec3d3 = vec3d.add(vec3d2.x * d2, vec3d2.y * d2, vec3d2.z * d2);
        return RaytraceUtils.a(entity, d2, vec3d, vec3d2, vec3d3);
    }

    public static Entity a(Entity entity, double d2, Vec3d vec3d, Vec3d vec3d2, Vec3d vec3d3) {
        Entity entity2 = null;
        try {
            List list = Wrapper.INSTANCE.getWorld().getEntitiesInAABBexcluding(entity, entity.getEntityBoundingBox().expand(vec3d2.x * d2, vec3d2.y * d2, vec3d2.z * d2).grow(1.0, 1.0, 1.0), Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, (Predicate)new H()));
            for (int i2 = 0; i2 < list.size(); ++i2) {
                double d3;
                Entity entity3 = (Entity)list.get(i2);
                AxisAlignedBB axisAlignedBB = entity3.getEntityBoundingBox().grow((double)entity3.getCollisionBorderSize());
                RayTraceResult rayTraceResult = axisAlignedBB.calculateIntercept(vec3d, vec3d3);
                if (axisAlignedBB.contains(vec3d)) {
                    if (!(d2 >= 0.0)) continue;
                    entity2 = entity3;
                    d2 = 0.0;
                    continue;
                }
                if (rayTraceResult == null || !((d3 = vec3d.distanceTo(rayTraceResult.hitVec)) < d2) && d2 != 0.0) continue;
                if (entity3.getLowestRidingEntity() == entity.getLowestRidingEntity() && !entity3.canRiderInteract()) {
                    if (d2 != 0.0) continue;
                    entity2 = entity3;
                    continue;
                }
                entity2 = entity3;
            }
        }
        catch (Exception exception) {
            ChatUtils.exception("rayTraceEntity: ", exception);
        }
        return entity2;
    }

    public static Vec3d a(float f2, float f3) {
        float f4 = MathHelper.cos((float)(-f3 * ((float)Math.PI / 180) - (float)Math.PI));
        float f5 = MathHelper.sin((float)(-f3 * ((float)Math.PI / 180) - (float)Math.PI));
        float f6 = -MathHelper.cos((float)(-f2 * ((float)Math.PI / 180)));
        float f7 = MathHelper.sin((float)(-f2 * ((float)Math.PI / 180)));
        return new Vec3d((double)(f5 * f6), (double)f7, (double)(f4 * f6));
    }
}

