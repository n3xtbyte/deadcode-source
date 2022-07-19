/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumActionResult
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  org.apache.commons.lang3.RandomUtils
 */
package i.gishreloaded.deadcode.hacks.world;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.RaytraceUtils;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.commons.lang3.RandomUtils;

public class MagicCarpet
extends Hack {
    public ModeValue a;
    public TimerUtils b;
    public TimerUtils c;
    public TimerUtils d;
    public BlockPos e = null;
    public boolean f = false;

    public MagicCarpet(String string) {
        super(string, HackCategory.World);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Default", true), new Mode("Matrix"));
        this.a(this.a);
        this.b("Other");
        this.c = new TimerUtils();
        this.d = new TimerUtils();
        this.b = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Automatically places blocks below your feet.";
    }

    @Override
    public void onDisable() {
        this.b();
        super.onDisable();
    }

    @Override
    public void onEnable() {
        this.b();
        super.onEnable();
    }

    public void b() {
        this.f = false;
        ef.j();
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (this.a.getMode("Matrix").isToggled()) {
            this.c();
        } else if (this.a.getMode("Default").isToggled()) {
            this.d();
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        if (this.e != null) {
            RenderUtils.a(this.e, 1.0f, 1.0f, 1.0f);
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    public void c() {
        int n2;
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        int n3 = -1;
        if (!this.g()) {
            if (this.f) {
                this.e();
                this.f = false;
                if (n3 != -1) {
                    entityPlayerSP.inventory.currentItem = n3;
                }
            }
            this.e = null;
            ef.j();
            return;
        }
        KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindRight.getKeyCode(), (boolean)false);
        KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindLeft.getKeyCode(), (boolean)false);
        this.e = new BlockPos((Entity)entityPlayerSP).down();
        float f2 = new Random().nextFloat();
        if (f2 == 1.0f) {
            f2 -= 1.0f;
        }
        if ((n2 = this.f()) == -1) {
            return;
        }
        n3 = entityPlayerSP.inventory.currentItem;
        entityPlayerSP.inventory.currentItem = n2;
        Vec3d vec3d = new Vec3d(cs.a.d(), cs.a.e() + (double)Wrapper.INSTANCE.getLocalPlayer().getEyeHeight(), cs.a.f());
        for (EnumFacing enumFacing : EnumFacing.values()) {
            Vec3d vec3d2;
            BlockPos blockPos = this.e.offset(enumFacing);
            EnumFacing enumFacing2 = enumFacing.getOpposite();
            if (vec3d.squareDistanceTo(new Vec3d((Vec3i)this.e).add(0.5, 0.5, 0.5)) >= vec3d.squareDistanceTo(new Vec3d((Vec3i)blockPos).add(0.5, 0.5, 0.5)) || !eS.b(blockPos).canCollideCheck(Wrapper.INSTANCE.getWorld().getBlockState(blockPos), false) || vec3d.squareDistanceTo(vec3d2 = new Vec3d((Vec3i)blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5))) > 18.0625) continue;
            float[] fArray = MathUtils.a(vec3d2, false);
            fArray[0] = fArray[0] + f2;
            fArray[1] = fArray[1] - f2;
            ef.a(fArray);
            if (this.b.isReached(1L)) {
                Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
            }
            if (this.b.isReached(2L)) {
                Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw - 2.0E-4);
                this.b.resetTime();
            }
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindSneak.getKeyCode(), (boolean)true);
            RayTraceResult rayTraceResult = RaytraceUtils.a(2.0, ef.d(), ef.e());
            int n4 = RandomUtils.nextInt((int)3, (int)4);
            if (rayTraceResult != null && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK && this.c.isReached(1000 / n4)) {
                EnumActionResult enumActionResult = cs.a.b().processRightClickBlock(entityPlayerSP, Wrapper.INSTANCE.getWorld(), blockPos, enumFacing2, vec3d2, EnumHand.MAIN_HAND);
                cs.a.c();
                this.c.resetTime();
            }
            this.f = true;
            this.e();
        }
    }

    public void d() {
        this.e = new BlockPos((Entity)Wrapper.INSTANCE.getLocalPlayer()).down();
        if (!eS.b(this.e).getMaterial(eS.b(this.e).getDefaultState()).isReplaceable()) {
            return;
        }
        int n2 = this.f();
        if (n2 == -1) {
            return;
        }
        int n3 = cs.a.a().currentItem;
        cs.a.a().currentItem = n2;
        Vec3d vec3d = new Vec3d(cs.a.d(), cs.a.e() + (double)Wrapper.INSTANCE.getLocalPlayer().getEyeHeight(), cs.a.f());
        for (EnumFacing enumFacing : EnumFacing.values()) {
            Vec3d vec3d2;
            BlockPos blockPos = this.e.offset(enumFacing);
            EnumFacing enumFacing2 = enumFacing.getOpposite();
            if (!eS.b(blockPos).canCollideCheck(eS.a(blockPos), false) || vec3d.squareDistanceTo(vec3d2 = new Vec3d((Vec3i)blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing2.getDirectionVec()).scale(0.5))) > 36.0) continue;
            cs.a.b().processRightClickBlock(Wrapper.INSTANCE.getLocalPlayer(), Wrapper.INSTANCE.getWorld(), blockPos, enumFacing2, vec3d2, EnumHand.MAIN_HAND);
            cs.a.c();
        }
        cs.a.a().currentItem = n3;
    }

    public void e() {
        KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindSneak.getKeyCode(), (boolean)eS.a(new BlockPos((Entity)Wrapper.INSTANCE.getLocalPlayer()).down(), Blocks.AIR));
    }

    public int f() {
        for (int i2 = 0; i2 < 9; ++i2) {
            Block block;
            ItemStack itemStack = cs.a.a().getStackInSlot(i2);
            if (itemStack == null || !(itemStack.getItem() instanceof ItemBlock) || !(block = Block.getBlockFromItem((Item)itemStack.getItem()).getDefaultState().getBlock()).isFullBlock(eS.b(this.e).getDefaultState()) || block == Blocks.SAND || block == Blocks.GRAVEL) continue;
            return i2;
        }
        return -1;
    }

    public boolean g() {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        ItemStack itemStack = entityPlayerSP.inventory.getCurrentItem();
        if (itemStack == null) {
            return false;
        }
        if (!entityPlayerSP.onGround || entityPlayerSP.isOnLadder() || entityPlayerSP.isInLava() || entityPlayerSP.isInWater()) {
            return false;
        }
        return Wrapper.INSTANCE.getGameSettings().keyBindForward.isKeyDown();
    }
}

