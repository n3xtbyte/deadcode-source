/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.EnumAction
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemShield
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumHand
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  org.lwjgl.input.Mouse
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.hacks.combat.Criticals;
import i.gishreloaded.deadcode.hacks.other.DiscordRPC;
import i.gishreloaded.deadcode.utils.MathUtils;
import i.gishreloaded.deadcode.utils.RandomUtils;
import i.gishreloaded.deadcode.utils.RaytraceUtils;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.utils.visual.RenderUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.ColorValue;
import i.gishreloaded.deadcode.value.types.DoubleValue;
import i.gishreloaded.deadcode.value.types.IntegerValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

public class KillAura
extends Hack {
    public ModeValue a;
    public static ModeValue b;
    public ModeValue c;
    public ModeValue d;
    public ModeValue e;
    public BooleanValue f;
    public BooleanValue g;
    public static BooleanValue h;
    public BooleanValue i;
    public static BooleanValue j;
    public BooleanValue k;
    public BooleanValue l;
    public BooleanValue m;
    public static BooleanValue n;
    public BooleanValue o;
    public BooleanValue p;
    public BooleanValue q;
    public BooleanValue r;
    public BooleanValue s;
    public IntegerValue t;
    public IntegerValue u;
    public DoubleValue v;
    public IntegerValue w;
    public BooleanValue B;
    public ColorValue C;
    public TimerUtils D;
    public TimerUtils E;
    public TimerUtils F;
    public TimerUtils G;
    public TimerUtils H;
    public TimerUtils I;
    public static EntityLivingBase J;
    public static float[] K;
    public float L = 0.1f;
    public boolean M;
    public double N;
    public int O = -2;
    public boolean P;
    public float Q;
    public float R;

    public KillAura(String string) {
        super(string, HackCategory.Combat);
        b = new ModeValue("Rotation", new Mode("Default", true), new Mode("Matrix"), new Mode("AAC"), new Mode("Static"), new Mode("SunRise"));
        this.c = new ModeValue("Mode", false, new Mode("Switch", true), new Mode("Single"));
        this.a = new ModeValue("Target priority", false, new Mode("Closest", true), new Mode("Health"), new Mode("Equip"));
        this.d = new ModeValue("Aim", false, new Mode("Head"), new Mode("Body", true), new Mode("Legs"), new Mode("All"));
        this.e = new ModeValue("Shield break mode", false, new Mode("Old", true), new Mode("New"));
        this.C = new ColorValue("Target color", er.a);
        this.f = new BooleanValue("Render distance", false);
        this.g = new BooleanValue("Render target", true);
        h = new BooleanValue("Auto crit", true);
        this.i = new BooleanValue("Stop sprinting", true);
        j = new BooleanValue("Look", false);
        this.k = new BooleanValue("Ray trace", false);
        this.l = new BooleanValue("Only weapon", false);
        this.m = new BooleanValue("Shield block", false);
        n = new BooleanValue("Shield break", true);
        this.o = new BooleanValue("Disable on death", false);
        this.p = new BooleanValue("Through walls", false);
        this.q = new BooleanValue("Teleport", false);
        this.r = new BooleanValue("Swing", true);
        this.s = new BooleanValue("Cooldown", true);
        this.B = new BooleanValue("Kill message", false);
        this.t = new IntegerValue("Min CPS", 6, 1, 30);
        this.u = new IntegerValue("Max CPS", 12, 1, 30);
        this.v = new DoubleValue("Distance", 3.8, 1.0, 7.0);
        this.w = new IntegerValue("FOV", 360, 1, 360);
        this.b("Rotation");
        this.a(b, this.d, j, this.k);
        this.b("Target");
        this.a(this.v, this.a, this.c, this.w);
        this.b("Attack");
        this.a(this.e, this.i, this.l, n, this.m, this.p, this.q);
        this.b("Delay");
        this.a(h, this.s, this.t, this.u);
        this.b("Render");
        this.a(this.f, this.g, this.r, this.C);
        this.b("Other");
        this.a(this.o, this.B);
        K = new float[2];
        this.D = new TimerUtils();
        this.E = new TimerUtils();
        this.F = new TimerUtils();
        this.G = new TimerUtils();
        this.H = new TimerUtils();
        this.I = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Attacks the entities around you.";
    }

    @Override
    public void onEnable() {
        this.b();
        this.N = 0.0;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.b();
        this.a(false);
        super.onDisable();
    }

    @Override
    public void onRenderWorldLastEvent(RenderWorldLastEvent renderWorldLastEvent) {
        this.g();
        if (((Boolean)this.f.getObjectValue()).booleanValue()) {
            RenderUtils.a((Entity)Wrapper.INSTANCE.getLocalPlayer(), this.N, 40, 1.0f, er.a, renderWorldLastEvent.getPartialTicks());
            if (this.N < this.v.getValue() && this.F.isReached(1L)) {
                this.N += 0.1;
                this.F.resetTime();
            }
        }
        if (((Boolean)this.g.getObjectValue()).booleanValue() && J != null) {
            RenderUtils.a(J, (int)this.C.getValue(), renderWorldLastEvent.getPartialTicks());
        }
        super.onRenderWorldLastEvent(renderWorldLastEvent);
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (!((Boolean)this.o.getObjectValue()).booleanValue()) {
            return;
        }
        if (et.h()) {
            this.c(false);
            this.onDisable();
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (KillAura.C() || KillAura.E()) {
            this.f();
        }
        if (((Boolean)this.m.getObjectValue()).booleanValue()) {
            this.c();
        }
        if (!KillAura.C() || KillAura.F() || KillAura.D() || KillAura.E() || Criticals.f()) {
            this.z();
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (bw2 != bw.b) {
            return true;
        }
        if ((object instanceof CPacketPlayer.PositionRotation || object instanceof CPacketPlayer.Rotation) && KillAura.C() && !KillAura.F() && !Criticals.f()) {
            this.z();
        }
        return super.a(object, bw2);
    }

    public void b() {
        J = null;
        KillAura.K[0] = 0.0f;
        KillAura.K[1] = 0.0f;
        this.Q = this.d();
        this.R = this.e();
        if (!KillAura.F()) {
            ef.j();
        }
        ef.l();
        this.L = b.getModeByIndex(4).isToggled() ? 0.5f : 0.1f;
    }

    public void a(EntityLivingBase entityLivingBase) {
        int n2;
        EntityPlayer entityPlayer;
        if (entityLivingBase instanceof EntityPlayer && et.b(entityPlayer = (EntityPlayer)entityLivingBase) && (n2 = bz.c()) != -2) {
            this.O = Wrapper.INSTANCE.getLocalPlayer().inventory.currentItem;
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(n2));
        }
    }

    public void b(EntityLivingBase entityLivingBase) {
        int n2;
        EntityPlayer entityPlayer;
        if (entityLivingBase instanceof EntityPlayer && (entityPlayer = (EntityPlayer)entityLivingBase).isActiveItemStackBlocking() && (n2 = bz.c()) != -2) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(n2));
            Wrapper.INSTANCE.getMinecraft().playerController.attackEntity((EntityPlayer)Wrapper.INSTANCE.getLocalPlayer(), (Entity)entityPlayer);
            cs.a.c();
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(Wrapper.INSTANCE.getLocalPlayer().inventory.currentItem));
        }
    }

    public void c() {
        EnumAction enumAction;
        if (!et.f()) {
            return;
        }
        ItemStack itemStack = Wrapper.INSTANCE.getLocalPlayer().getHeldItemMainhand();
        if (!(et.a(itemStack) || Mouse.isButtonDown((int)1) || (enumAction = itemStack.getItem().getItemUseAction(itemStack)) == EnumAction.NONE && !(itemStack.getItem() instanceof ItemBlock))) {
            this.a(false);
            this.M = false;
            return;
        }
        if (J == null) {
            if (this.M) {
                this.M = false;
                this.a(this.M);
            }
            return;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().getCooledAttackStrength(0.0f) >= 0.75f) {
            this.M = false;
        }
        if (Wrapper.INSTANCE.getLocalPlayer().getCooledAttackStrength(0.0f) <= 0.1f) {
            this.M = true;
        }
        if (this.G.isReached(RandomUtils.randomInt(0, 55))) {
            this.a(this.M);
            this.G.resetTime();
        }
    }

    public void a(boolean bl) {
        if (Wrapper.INSTANCE.getLocalPlayer().getHeldItemOffhand().getItem() instanceof ItemShield) {
            KeyBinding.setKeyBindState((int)Wrapper.INSTANCE.getGameSettings().keyBindUseItem.getKeyCode(), (boolean)bl);
        }
    }

    public float d() {
        return KillAura.F() ? Wrapper.INSTANCE.getLocalPlayer().rotationPitch : ef.e();
    }

    public float e() {
        return KillAura.F() ? Wrapper.INSTANCE.getLocalPlayer().rotationYaw : ef.d();
    }

    public void f() {
        if (J == null) {
            return;
        }
        if (b.getModeByIndex(0).isToggled()) {
            if (KillAura.F()) {
                K = MathUtils.a((Entity)J, this.A());
                Wrapper.INSTANCE.getLocalPlayer().rotationYaw = K[0];
                Wrapper.INSTANCE.getLocalPlayer().rotationPitch = K[1];
            }
        } else if (KillAura.B()) {
            if (!KillAura.E()) {
                boolean bl = b.getModeByIndex(4).isToggled();
                float f2 = 2.2f - RandomUtils.getRandom().nextFloat();
                if (bl) {
                    f2 = 5.0f - RandomUtils.getRandom().nextFloat();
                    f2 += RandomUtils.getRandom().nextFloat();
                }
                K = MathUtils.a((Entity)J, this.A(), f2);
                if (bl) {
                    this.R = MathUtils.c(this.e(), K[0], 75.0f + RandomUtils.randomFloat(0.1f, 1.0f));
                    this.Q = MathUtils.c(this.d(), K[1], 2.0f + RandomUtils.randomFloat(0.1f, 1.0f));
                    KillAura.K[0] = this.R;
                    KillAura.K[1] = this.Q;
                }
            } else {
                K = MathUtils.a((Entity)J, KillAura.F());
            }
            if (KillAura.F()) {
                Wrapper.INSTANCE.getLocalPlayer().rotationYaw = K[0];
                Wrapper.INSTANCE.getLocalPlayer().rotationPitch = K[1];
            } else {
                ef.a(K);
                Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
                if (this.E.isReached(1L)) {
                    Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw + 1.0E-4);
                }
                if (this.E.isReached(2L)) {
                    Wrapper.INSTANCE.getLocalPlayer().rotationYaw = (float)((double)Wrapper.INSTANCE.getLocalPlayer().rotationYaw - 2.0E-4);
                    this.E.resetTime();
                }
            }
        }
    }

    public void g() {
        for (Object e : et.b()) {
            EntityLivingBase entityLivingBase;
            if (!(e instanceof EntityLivingBase) || !this.h(entityLivingBase = (EntityLivingBase)e) || this.c.getModeByIndex(1).isToggled() && J != null) continue;
            J = entityLivingBase;
        }
    }

    public Entity h() {
        Entity entity = null;
        if (KillAura.B()) {
            float f2 = Wrapper.INSTANCE.getLocalPlayer().rotationYaw;
            float f3 = Wrapper.INSTANCE.getLocalPlayer().rotationPitch;
            if (!KillAura.F()) {
                f2 = ef.d();
                f3 = ef.e();
            }
            entity = RaytraceUtils.b(this.G(), f2, f3);
        }
        return entity;
    }

    public void z() {
        if (!this.g(J)) {
            this.b();
        }
        if (J == null) {
            return;
        }
        if (((Boolean)this.l.getObjectValue()).booleanValue() && !et.e()) {
            return;
        }
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        Criticals.b();
        if (!Criticals.h()) {
            return;
        }
        if (!this.e(J)) {
            return;
        }
        if (((Boolean)this.s.getObjectValue()).booleanValue()) {
            float f2;
            float f3 = f2 = Criticals.f() && Criticals.e() ? 1.0f : 0.92f;
            if (entityPlayerSP.getCooledAttackStrength(0.0f) >= f2) {
                if (Criticals.c && Criticals.a.getModeByIndex(4).isToggled()) {
                    if (!dV.a()) {
                        entityPlayerSP.setPosition(entityPlayerSP.posX, entityPlayerSP.posY + 0.01, entityPlayerSP.posZ);
                    }
                    if (entityPlayerSP.onGround) {
                        ef.a(false);
                        entityPlayerSP.motionY = 0.0042f;
                        this.P = true;
                    }
                } else {
                    this.c(J);
                    entityPlayerSP.resetCooldown();
                }
            }
            if (this.P && this.H.isReached(800L)) {
                this.c(J);
                entityPlayerSP.resetCooldown();
                ef.l();
                this.P = false;
                this.H.resetTime();
            }
        } else {
            int n2 = RandomUtils.randomInt(this.t.getValue(), this.u.getValue());
            if (this.D.isReached(1000 / n2)) {
                this.c(J);
                this.D.resetTime();
            }
        }
        if (!this.g(J) && this.c.getModeByIndex(0).isToggled()) {
            this.b();
        }
    }

    public void c(EntityLivingBase entityLivingBase) {
        boolean bl;
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        if (((Boolean)this.q.getObjectValue()).booleanValue()) {
            entityPlayerSP.setPosition(entityLivingBase.posX, entityPlayerSP.posY, entityLivingBase.posZ);
        }
        if (((Boolean)this.m.getObjectValue()).booleanValue() && et.f() && this.M) {
            return;
        }
        if (((Boolean)this.i.getObjectValue()).booleanValue()) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketEntityAction((Entity)entityPlayerSP, CPacketEntityAction.Action.STOP_SPRINTING));
        }
        if (KillAura.D()) {
            this.f();
        }
        EntityLivingBase entityLivingBase2 = entityLivingBase;
        if (KillAura.B() && (((Boolean)this.k.getObjectValue()).booleanValue() || b.getModeByIndex(4).isToggled())) {
            Entity entity = this.h();
            if (entity == null) {
                return;
            }
            entityLivingBase2 = (EntityLivingBase)entity;
        }
        if (((Boolean)n.getObjectValue()).booleanValue() && this.e.getModeByIndex(0).isToggled()) {
            this.a(entityLivingBase2);
        }
        boolean bl2 = bl = entityPlayerSP.fallDistance > 0.0f && !entityPlayerSP.onGround && !entityPlayerSP.isOnLadder() && !entityPlayerSP.isInWater() && entityPlayerSP.getRidingEntity() == null;
        if (bl) {
            Wrapper.INSTANCE.getLocalPlayer().onCriticalHit((Entity)entityLivingBase2);
        }
        Wrapper.INSTANCE.sendPacket((Packet)new CPacketUseEntity((Entity)entityLivingBase2));
        if (((Boolean)this.r.getObjectValue()).booleanValue()) {
            cs.a.c();
        } else {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
        }
        if (((Boolean)n.getObjectValue()).booleanValue() && this.e.getModeByIndex(1).isToggled()) {
            this.b(entityLivingBase2);
        }
        if (this.O != -2) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(this.O));
            this.O = -2;
        }
        this.M = true;
    }

    public cy_0 A() {
        if (this.d.getModeByIndex(0).isToggled()) {
            return cy_0.a;
        }
        if (this.d.getModeByIndex(1).isToggled()) {
            return cy_0.b;
        }
        if (this.d.getModeByIndex(2).isToggled()) {
            return cy_0.c;
        }
        if (this.d.getModeByIndex(3).isToggled()) {
            int n2 = RandomUtils.randomInt(0, 3);
            return cy_0.values()[n2];
        }
        return cy_0.b;
    }

    public static boolean B() {
        return KillAura.C() || KillAura.D() || KillAura.E();
    }

    public static boolean C() {
        return b.getModeByIndex(1).isToggled() || b.getModeByIndex(4).isToggled();
    }

    public static boolean D() {
        return b.getModeByIndex(2).isToggled();
    }

    public static boolean E() {
        return b.getModeByIndex(3).isToggled();
    }

    public static boolean F() {
        return (Boolean)j.getObjectValue() != false || KillAura.D();
    }

    public boolean d(EntityLivingBase entityLivingBase) {
        return this.a.getModeByIndex(0).isToggled() && eQ.c(entityLivingBase, J) || this.a.getModeByIndex(1).isToggled() && eQ.a(entityLivingBase, J) || this.a.getModeByIndex(2).isToggled() && eQ.b(entityLivingBase, J);
    }

    public boolean e(EntityLivingBase entityLivingBase) {
        return entityLivingBase.getDistance((Entity)Wrapper.INSTANCE.getLocalPlayer()) <= this.G() - this.L;
    }

    public boolean f(EntityLivingBase entityLivingBase) {
        return entityLivingBase.getDistance((Entity)Wrapper.INSTANCE.getLocalPlayer()) <= this.G() + this.L;
    }

    public boolean a(EntityLivingBase entityLivingBase, float f2) {
        return entityLivingBase.getDistance((Entity)Wrapper.INSTANCE.getLocalPlayer()) <= this.G() + f2;
    }

    public float G() {
        return (float)(Wrapper.INSTANCE.getLocalPlayer().isSprinting() ? (double)this.v.getValue().floatValue() - 0.1 : (double)this.v.getValue().floatValue());
    }

    public boolean g(EntityLivingBase entityLivingBase) {
        return entityLivingBase != null && !entityLivingBase.isDead && entityLivingBase.deathTime <= 0 && (this.f(entityLivingBase) || !this.c.getModeByIndex(0).isToggled()) && (this.a(entityLivingBase, 2.0f) || !this.c.getModeByIndex(1).isToggled());
    }

    public boolean h(EntityLivingBase entityLivingBase) {
        this.i(entityLivingBase);
        return !(entityLivingBase instanceof EntityPlayerSP) && !eQ.a((Entity)entityLivingBase) && eQ.a() && entityLivingBase != Wrapper.INSTANCE.getLocalPlayer() && !entityLivingBase.isDead && entityLivingBase.deathTime <= 0 && eQ.a(entityLivingBase) && eQ.c(entityLivingBase) && this.f(entityLivingBase) && eQ.b(entityLivingBase) && MathUtils.a((Entity)entityLivingBase, (double)this.w.getValue().intValue()) && ((Boolean)this.p.getObjectValue() != false || Wrapper.INSTANCE.getLocalPlayer().canEntityBeSeen((Entity)entityLivingBase)) && this.d(entityLivingBase);
    }

    public void i(EntityLivingBase entityLivingBase) {
        if (entityLivingBase != null && entityLivingBase instanceof EntityPlayer && entityLivingBase.deathTime > 0 && this.I.isReached(1000L)) {
            if (((Boolean)this.B.getObjectValue()).booleanValue()) {
                Wrapper.INSTANCE.sendPacket((Packet)new CPacketChatMessage(this.H()));
            }
            ++DiscordRPC.b;
            this.I.resetTime();
        }
    }

    public String H() {
        int n2 = RandomUtils.randomInt(0, 14);
        switch (n2) {
            case 0: {
                return "\u043a\u0438\u043a\u0430\u0435\u0442 \u0437\u0430 \u043a\u0438\u043b\u043b\u0430\u0443\u0440\u0443? \u043a\u0443\u043f\u0438 DeadCode";
            }
            case 1: {
                return "\u041d\u0435 \u043f\u0440\u043e\u0431\u0438\u0432\u0430\u0435\u0448\u044c \u0449\u0438\u0442 \u0447\u0435\u043b\u0430\u043c? \u0433\u0435\u0442\u043d\u0438 DeadCode";
            }
            case 2: {
                return "\u0435\u0441\u043b\u0438 \u043d\u0435 \u0445\u043e\u0447\u0435\u0448\u044c \u0441\u043b\u0438\u0432\u0430\u0442\u044c \u0441\u0432\u043e\u044e \u043f\u043e\u0441\u043b\u0435\u0434\u043d\u0438\u044e \u04374 - \u043f\u0440\u0438\u043e\u0431\u0440\u0435\u0442\u0438 DeadCode";
            }
            case 3: {
                return "\u0445\u043e\u0447\u0435\u0448\u044c \u043a\u0440\u0443\u0442\u0443\u044e \u043e\u043f\u0442\u0438\u043c\u0438\u0437\u0430\u0446\u0438\u044e, \u0447\u0442\u043e\u0431\u044b \u0438\u0433\u0440\u0430\u0442\u044c \u0431\u0435\u0437 \u043b\u0430\u0433\u043e\u0432? - \u0431\u0435\u0440\u0438 DeadCode";
            }
            case 4: {
                return "\u0425\u043e\u0447\u0435\u0448\u044c \u0432\u044b\u0432\u043e\u0437\u0438\u0442\u044c \u0432\u0441\u0435 \u0445\u0432\u0445? \u041a\u0443\u043f\u0438 DeadCode";
            }
            case 5: {
                return "\u0435\u0441\u043b\u0438 \u043d\u0435 \u0445\u043e\u0447\u0435\u0448\u044c \u043f\u043e\u0442\u0435\u0440\u044f\u0442\u044c \u043c\u0430\u0442\u044c - \u0433\u0435\u0442\u043d\u0438 DeadCode \u043a\u043b\u043e\u0443\u043d";
            }
            case 6: {
                return "\u0425\u043e\u0447\u0435\u0448\u044c \u043f\u043e\u0447\u0443\u0432\u0441\u0442\u0432\u043e\u0432\u0430\u0442\u044c \u0441\u0435\u0431\u044f \u0431\u043e\u0433\u043e\u043c \u0432 \u043c\u0430\u0439\u043d\u043a\u0440\u0430\u0444\u0442\u0435 - \u043f\u0440\u0438\u043e\u0431\u0440\u0435\u0442\u0438 DeadCode";
            }
            case 7: {
                return "\u0437\u0430\u04356\u0430\u043b\u0441\u044f \u0441\u043e\u0441\u0430\u0442\u044c? \u0433\u0435\u0442\u043d\u0438 \u0434\u043a";
            }
            case 8: {
                return "\u0441\u0432\u0438\u043d\u044c\u044f \u0442\u0443\u043f\u0430\u044f \u0433\u0435\u0442\u043d\u0438 DeadCode";
            }
            case 9: {
                return "\u043d\u0435 \u0438\u0433\u0440\u0430\u0439 \u0441 \u043f\u043e\u043c\u043e\u0439\u043a\u043e\u0439 \u043b\u0443\u0447\u0448\u0435 \u0433\u0435\u0442\u043d\u0438 deadcode";
            }
            case 10: {
                return "\u0421\u0430\u043c\u0430\u044f \u043b\u0443\u0447\u0448\u0430\u044f \u043a\u0438\u043b\u043b\u0430\u0443\u0440\u0430 \u0442\u043e\u043b\u044c\u043a\u043e \u0432 DeadCode, \u0432\u043e\u0442 \u0442\u044b \u0438 \u0441\u043e\u0441\u0435\u0448\u044c";
            }
            case 11: {
                return "\u0425\u043e\u0447\u0435\u0448\u044c \u043b\u0443\u0447\u0448\u0443\u044e \u043a\u0438\u043b\u043b\u0430\u0443\u0440\u0443 \u043d\u0430 4 \u0431\u043b\u043e\u043a\u0430? \u0431\u0435\u0440\u0438 DeadCode";
            }
            case 12: {
                return "\u0422\u0435\u0431\u044f \u0431\u0430\u043d\u044f\u0442 \u043c\u043e\u0434\u0435\u0440\u044b \u043d\u0430 \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0435? \u043a\u0443\u043f\u0438 \u0434\u0435\u0434\u043a\u043e\u0434, \u043d\u0435 \u0441\u043f\u0430\u043b\u044f\u0442!";
            }
            case 13: {
                return "\u0432 \u0434\u0435\u0434\u043a\u043e\u0434\u0435 \u0435\u0441\u0442\u044c \u043d\u0435 \u0442\u043e\u043b\u044c\u043a\u043e \u043b\u0443\u0447\u0448\u0430\u044f \u043a\u0438\u043b\u043b\u0430\u0443\u0440\u0430, \u0434\u0430\u043a \u0435\u0449\u0451 \u0438 \u043b\u0443\u0447\u0448\u0438\u0435 \u043e\u0431\u0445\u043e\u0434\u044b!";
            }
        }
        return "";
    }
}

