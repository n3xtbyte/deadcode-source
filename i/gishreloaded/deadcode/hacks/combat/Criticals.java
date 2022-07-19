/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.MobEffects
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.network.play.client.CPacketUseEntity$Action
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.combat.KillAura;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Criticals
extends Hack {
    public static ModeValue a;
    private IntegerValue d;
    private static DoubleValue e;
    private BooleanValue f;
    private DoubleValue g;
    private static BooleanValue h;
    public EntityLivingBase b;
    private TimerUtils i;
    public static boolean c;

    public Criticals(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        a = new ModeValue("Mode", new Mode("Packet"), new Mode("Jump"), new Mode("Fall", true), new Mode("MatrixDisabler"), new Mode("Matrix"));
        e = new DoubleValue("Fall distance", 0.2, 0.01, 0.41);
        this.d = new IntegerValue("Delay", 0, 0, 500);
        this.f = new BooleanValue("Fall auto jump", false);
        this.g = new DoubleValue("Auto jump distance", 6.0, 1.0, 20.0);
        h = new BooleanValue("Smart criticals", true);
        this.a(a, e, this.d, h, new cs_0("AutoJump"), this.f, this.g);
        this.b("Other");
        this.i = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Changes all your hits to critical hits.";
    }

    @Override
    public void onEnable() {
        this.b = null;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        c = false;
        super.onDisable();
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (bw2 == bw.b && object instanceof CPacketUseEntity) {
            CPacketUseEntity cPacketUseEntity = (CPacketUseEntity)object;
            if (cPacketUseEntity.getAction() != CPacketUseEntity.Action.ATTACK) {
                return true;
            }
            Entity entity = cPacketUseEntity.getEntityFromWorld((World)Wrapper.INSTANCE.getWorld());
            if (entity != null && entity instanceof EntityLivingBase) {
                this.a((EntityLivingBase)entity);
            }
        }
        return true;
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        c = true;
        this.c();
        super.onClientTickEvent(clientTickEvent);
    }

    public void a(EntityLivingBase entityLivingBase) {
        if (!this.d() || this.d.getValue() > 0 && !this.i.isReached(this.d.getValue().intValue())) {
            return;
        }
        if (a.getModeByIndex(0).isToggled()) {
            if (entityLivingBase.hurtTime >= 7) {
                return;
            }
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position(cs.a.d(), cs.a.e() + 0.0625, cs.a.f(), true));
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketPlayer.Position(cs.a.d(), cs.a.e(), cs.a.f(), false));
            Wrapper.INSTANCE.getLocalPlayer().onCriticalHit((Entity)entityLivingBase);
        } else if (a.getModeByIndex(1).isToggled()) {
            et.i();
        }
        this.i.resetTime();
    }

    public static void b() {
        if (c && a.getModeByIndex(3).isToggled()) {
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            if (entityPlayerSP.onGround) {
                entityPlayerSP.motionY = 0.16f;
                entityPlayerSP.onGround = false;
            }
        }
    }

    public void c() {
        if (!(((Boolean)this.f.getObjectValue()).booleanValue() && a.getModeByIndex(2).isToggled() && HackManager.getHack("KillAura").isToggled())) {
            return;
        }
        for (Object e : et.b()) {
            EntityLivingBase entityLivingBase;
            if (!(e instanceof EntityLivingBase) || !this.c(entityLivingBase = (EntityLivingBase)e)) continue;
            this.b = entityLivingBase;
        }
        if (this.b != null) {
            et.i();
            this.b = null;
        }
    }

    public boolean b(EntityLivingBase entityLivingBase) {
        return (double)entityLivingBase.getDistance((Entity)Wrapper.INSTANCE.getLocalPlayer()) <= this.g.getValue();
    }

    public boolean c(EntityLivingBase entityLivingBase) {
        return !(entityLivingBase instanceof EntityPlayerSP) && !eQ.a((Entity)entityLivingBase) && eQ.a() && entityLivingBase != Wrapper.INSTANCE.getLocalPlayer() && !entityLivingBase.isDead && entityLivingBase.deathTime <= 0 && eQ.a(entityLivingBase) && eQ.c(entityLivingBase) && this.b(entityLivingBase) && eQ.b(entityLivingBase);
    }

    public boolean d() {
        if (!Wrapper.INSTANCE.getLocalPlayer().onGround) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isOnLadder()) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isInWater()) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isInLava()) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isSneaking()) {
            return false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().isRiding()) {
            return false;
        }
        return !Wrapper.INSTANCE.getLocalPlayer().isPotionActive(MobEffects.BLINDNESS);
    }

    private static /* synthetic */ boolean z() {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        return entityPlayerSP.isInWater() || entityPlayerSP.isInLava() || entityPlayerSP.isOnLadder() || entityPlayerSP.isRiding();
    }

    private static /* synthetic */ boolean A() {
        return eS.a((EntityLivingBase)Wrapper.INSTANCE.getLocalPlayer(), Blocks.WEB) && dV.a();
    }

    public static boolean e() {
        return Criticals.z() || Criticals.A();
    }

    public static boolean f() {
        return (Boolean)KillAura.h.getObjectValue() != false || Criticals.B();
    }

    private static /* synthetic */ boolean B() {
        return c && (a.getModeByIndex(2).isToggled() || a.getModeByIndex(3).isToggled());
    }

    public static boolean g() {
        return c && (a.getModeByIndex(4).isToggled() || a.getModeByIndex(0).isToggled() || a.getModeByIndex(1).isToggled());
    }

    public static boolean h() {
        if (Criticals.g()) {
            return true;
        }
        if (Criticals.f()) {
            boolean bl;
            float f2 = 0.2f;
            if (Criticals.B()) {
                f2 = e.getValue().floatValue();
            }
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            boolean bl2 = bl = (Boolean)h.getObjectValue() != false && Wrapper.INSTANCE.getLocalPlayer().onGround && eS.b(new BlockPos(entityPlayerSP.posX, entityPlayerSP.posY + 2.0, entityPlayerSP.posZ)) != Blocks.AIR;
            return Wrapper.INSTANCE.getLocalPlayer().fallDistance >= f2 && !Wrapper.INSTANCE.getLocalPlayer().onGround || bl || Criticals.e();
        }
        return true;
    }
}

