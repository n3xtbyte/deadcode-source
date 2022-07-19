/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.material.Material
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.enchantment.EnchantmentFrostWalker
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.movement;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.EnchantmentFrostWalker;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Jesus
extends Hack {
    public ModeValue a;
    public DoubleValue b;
    public IntegerValue c;

    public Jesus(String string) {
        super(string, HackCategory.Movement);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("FrostWalker", true), new Mode("NCP"), new Mode("Matrix"), new Mode("SunRise"), new Mode("MatrixTP"), new Mode("SunRiseDamage"), new Mode("SunRiseDamage2"), new Mode("ReallyWorldTP"));
        this.b = new DoubleValue("Matrix speed", 1.2, 0.1, 2.0);
        this.c = new IntegerValue("TP Speed", 5, 1, 10);
        this.a(this.a, this.b, this.c);
        this.b("Other");
    }

    @Override
    public String getDescription() {
        return "Lets you walk on water.";
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (this.a.getModeByIndex(0).isToggled()) {
            EnchantmentFrostWalker.freezeNearby((EntityLivingBase)entityPlayerSP, (World)Wrapper.INSTANCE.getWorld(), (BlockPos)entityPlayerSP.getPosition(), (int)2);
        } else if (this.a.getModeByIndex(1).isToggled()) {
            if (eS.a(entityPlayerSP.getEntityBoundingBox(), block -> block instanceof BlockLiquid) && entityPlayerSP.isInsideOfMaterial(Material.AIR) && !entityPlayerSP.isSneaking()) {
                entityPlayerSP.motionY = 0.08;
            } else if (!entityPlayerSP.collidedHorizontally && !entityPlayerSP.isSneaking() && dV.a() && eS.b(entityPlayerSP.getPosition().down()) == Blocks.WATER) {
                AxisAlignedBB axisAlignedBB = entityPlayerSP.getEntityBoundingBox();
                axisAlignedBB.intersects(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ, axisAlignedBB.maxX + 1.0, axisAlignedBB.maxY + 1.0, axisAlignedBB.maxZ + 1.0);
                entityPlayerSP.setEntityBoundingBox(axisAlignedBB);
            }
        } else if (this.a.getModeByIndex(2).isToggled()) {
            if (!entityPlayerSP.isInWater() && !entityPlayerSP.isInLava()) {
                return;
            }
            entityPlayerSP.motionY = 0.0;
            if (!dV.a()) {
                return;
            }
            dV.a(this.b.getValue().floatValue());
            entityPlayerSP.jump();
        } else if (this.a.getModeByIndex(3).isToggled()) {
            if (!entityPlayerSP.isInWater() && !entityPlayerSP.isInLava()) {
                return;
            }
            entityPlayerSP.motionY = 0.0;
            entityPlayerSP.setSprinting(false);
            if (!dV.a()) {
                return;
            }
            dV.a(0.16f);
            if (entityPlayerSP.collidedHorizontally) {
                entityPlayerSP.jump();
            } else {
                entityPlayerSP.motionY += 0.001;
            }
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        return super.a(object, bw2);
    }

    @Override
    public void onInputEvent(InputUpdateEvent inputUpdateEvent) {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        boolean bl = this.a.getModeByIndex(7).isToggled();
        if (this.a.getModeByIndex(4).isToggled() || bl) {
            if (eS.a(entityPlayerSP.getEntityBoundingBox(), block -> block instanceof BlockLiquid) && entityPlayerSP.isInsideOfMaterial(Material.AIR) && !entityPlayerSP.isSneaking()) {
                entityPlayerSP.motionY = bl ? 0.038 : 0.03;
                entityPlayerSP.motionX = 0.0;
                entityPlayerSP.motionZ = 0.0;
            } else if (!(entityPlayerSP.collidedHorizontally || entityPlayerSP.isSneaking() || !dV.a() || eS.b(entityPlayerSP.getPosition().down()) != Blocks.WATER || entityPlayerSP.isInWater() || entityPlayerSP.isInLava())) {
                entityPlayerSP.motionX = 0.0;
                entityPlayerSP.motionZ = 0.0;
                float f2 = entityPlayerSP.ticksExisted;
                float f3 = bl ? (f2 % 2.0f == 0.0f ? (float)this.c.getValue().intValue() - 0.01f : 0.14f) : (float)this.c.getValue().intValue();
                dV.a(f3);
                if (bl) {
                    double d2 = entityPlayerSP.posY + (f2 % 2.0f == 0.0f ? -0.02 : (f2 % 3.0f == 1.0f ? 0.02 : 0.03));
                    entityPlayerSP.setPosition(entityPlayerSP.posX, d2, entityPlayerSP.posZ);
                }
            }
        } else if (this.a.getModeByIndex(5).isToggled()) {
            if (entityPlayerSP.isInWater()) {
                entityPlayerSP.setSprinting(true);
                if (entityPlayerSP.isSprinting()) {
                    if (dV.a()) {
                        KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
                    }
                    entityPlayerSP.motionY = 0.0;
                    entityPlayerSP.jump();
                    entityPlayerSP.motionY = 0.0;
                }
            }
        } else if (this.a.getModeByIndex(6).isToggled() && entityPlayerSP.isInWater()) {
            entityPlayerSP.setSprinting(true);
            entityPlayerSP.motionY = 0.008f;
            if (entityPlayerSP.isSprinting()) {
                if (dV.a()) {
                    KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindJump.getKeyCode(), (boolean)false);
                    entityPlayerSP.fallDistance = 0.1f;
                    entityPlayerSP.motionY = 0.15699f;
                }
                float f4 = MathUtils.a((Entity)entityPlayerSP);
                entityPlayerSP.motionX -= (double)MathHelper.sin((float)f4) * 0.11;
                entityPlayerSP.motionZ += (double)MathHelper.cos((float)f4) * 0.11;
            }
        }
        super.onInputEvent(inputUpdateEvent);
    }
}

