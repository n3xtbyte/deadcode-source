/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.GuiOpenEvent
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent
 *  net.minecraftforge.client.event.RenderPlayerEvent
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.client.event.ScreenshotEvent
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingJumpEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.event.entity.player.EntityItemPickupEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  net.minecraftforge.fml.common.network.FMLNetworkEvent$ClientConnectedToServerEvent
 */
package i.gishreloaded.deadcode.managers;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hacks.combat.AimBot;
import i.gishreloaded.deadcode.hacks.combat.AntiAim;
import i.gishreloaded.deadcode.hacks.combat.AntiBot;
import i.gishreloaded.deadcode.hacks.combat.AutoBuff;
import i.gishreloaded.deadcode.hacks.combat.AutoDebuff;
import i.gishreloaded.deadcode.hacks.combat.AutoGApple;
import i.gishreloaded.deadcode.hacks.combat.AutoHeal;
import i.gishreloaded.deadcode.hacks.combat.AutoTotem;
import i.gishreloaded.deadcode.hacks.combat.BowAimBot;
import i.gishreloaded.deadcode.hacks.combat.ClickPearl;
import i.gishreloaded.deadcode.hacks.combat.Criticals;
import i.gishreloaded.deadcode.hacks.combat.FastBow;
import i.gishreloaded.deadcode.hacks.combat.GoldenAppleDelay;
import i.gishreloaded.deadcode.hacks.combat.HitBox;
import i.gishreloaded.deadcode.hacks.combat.KillAura;
import i.gishreloaded.deadcode.hacks.combat.NoDamage;
import i.gishreloaded.deadcode.hacks.combat.Reach;
import i.gishreloaded.deadcode.hacks.combat.Refill;
import i.gishreloaded.deadcode.hacks.combat.ShieldBreaker;
import i.gishreloaded.deadcode.hacks.combat.TargetStrafe;
import i.gishreloaded.deadcode.hacks.combat.TriggerBot;
import i.gishreloaded.deadcode.hacks.combat.Velocity;
import i.gishreloaded.deadcode.hacks.exploit.BedrockTeleport;
import i.gishreloaded.deadcode.hacks.exploit.Blackout;
import i.gishreloaded.deadcode.hacks.exploit.DeathBow;
import i.gishreloaded.deadcode.hacks.exploit.HClip;
import i.gishreloaded.deadcode.hacks.exploit.NoCom;
import i.gishreloaded.deadcode.hacks.exploit.PluginsGetter;
import i.gishreloaded.deadcode.hacks.exploit.PortalGodMode;
import i.gishreloaded.deadcode.hacks.exploit.RodLeave;
import i.gishreloaded.deadcode.hacks.exploit.SelfDamage;
import i.gishreloaded.deadcode.hacks.exploit.Teleport;
import i.gishreloaded.deadcode.hacks.exploit.TeleportDown;
import i.gishreloaded.deadcode.hacks.exploit.TeleportUp;
import i.gishreloaded.deadcode.hacks.exploit.VClip;
import i.gishreloaded.deadcode.hacks.exploit.XCarry;
import i.gishreloaded.deadcode.hacks.movement.AirJump;
import i.gishreloaded.deadcode.hacks.movement.AntiWeb;
import i.gishreloaded.deadcode.hacks.movement.AutoSprint;
import i.gishreloaded.deadcode.hacks.movement.AutoStep;
import i.gishreloaded.deadcode.hacks.movement.AutoWalk;
import i.gishreloaded.deadcode.hacks.movement.FastLadder;
import i.gishreloaded.deadcode.hacks.movement.FastStairs;
import i.gishreloaded.deadcode.hacks.movement.Flight;
import i.gishreloaded.deadcode.hacks.movement.Glide;
import i.gishreloaded.deadcode.hacks.movement.HighJump;
import i.gishreloaded.deadcode.hacks.movement.Jesus;
import i.gishreloaded.deadcode.hacks.movement.LongJump;
import i.gishreloaded.deadcode.hacks.movement.NoClip;
import i.gishreloaded.deadcode.hacks.movement.NoJumpDelay;
import i.gishreloaded.deadcode.hacks.movement.Parkour;
import i.gishreloaded.deadcode.hacks.movement.Speed;
import i.gishreloaded.deadcode.hacks.movement.Spider;
import i.gishreloaded.deadcode.hacks.movement.Strafe;
import i.gishreloaded.deadcode.hacks.movement.WaterLeave;
import i.gishreloaded.deadcode.hacks.movement.WaterSpeed;
import i.gishreloaded.deadcode.hacks.movement.WebLeave;
import i.gishreloaded.deadcode.hacks.other.AutoAccept;
import i.gishreloaded.deadcode.hacks.other.AutoImgur;
import i.gishreloaded.deadcode.hacks.other.AutoJoin;
import i.gishreloaded.deadcode.hacks.other.AutoLeave;
import i.gishreloaded.deadcode.hacks.other.ChatCalc;
import i.gishreloaded.deadcode.hacks.other.Debug;
import i.gishreloaded.deadcode.hacks.other.Disconnect;
import i.gishreloaded.deadcode.hacks.other.DiscordRPC;
import i.gishreloaded.deadcode.hacks.other.FakeCreative;
import i.gishreloaded.deadcode.hacks.other.FlagDetect;
import i.gishreloaded.deadcode.hacks.other.HitSound;
import i.gishreloaded.deadcode.hacks.other.MCF;
import i.gishreloaded.deadcode.hacks.other.NoGuiEvents;
import i.gishreloaded.deadcode.hacks.other.Optimization;
import i.gishreloaded.deadcode.hacks.other.PacketFilter;
import i.gishreloaded.deadcode.hacks.other.Sleep;
import i.gishreloaded.deadcode.hacks.other.StaffDetector;
import i.gishreloaded.deadcode.hacks.other.Targets;
import i.gishreloaded.deadcode.hacks.other.Teams;
import i.gishreloaded.deadcode.hacks.other.TestHack;
import i.gishreloaded.deadcode.hacks.player.AntiAfk;
import i.gishreloaded.deadcode.hacks.player.AntiFall;
import i.gishreloaded.deadcode.hacks.player.AntiLevitate;
import i.gishreloaded.deadcode.hacks.player.AutoArmor;
import i.gishreloaded.deadcode.hacks.player.AutoEat;
import i.gishreloaded.deadcode.hacks.player.AutoRespawn;
import i.gishreloaded.deadcode.hacks.player.AutoTool;
import i.gishreloaded.deadcode.hacks.player.GuiWalk;
import i.gishreloaded.deadcode.hacks.player.NoPush;
import i.gishreloaded.deadcode.hacks.player.NoRotate;
import i.gishreloaded.deadcode.hacks.player.NoSlow;
import i.gishreloaded.deadcode.hacks.player.PickupFilter;
import i.gishreloaded.deadcode.hacks.render.Ambience;
import i.gishreloaded.deadcode.hacks.render.AntiBadEffects;
import i.gishreloaded.deadcode.hacks.render.AntiFire;
import i.gishreloaded.deadcode.hacks.render.BeaconDistance;
import i.gishreloaded.deadcode.hacks.render.BlockOverlay;
import i.gishreloaded.deadcode.hacks.render.CameraClip;
import i.gishreloaded.deadcode.hacks.render.ChestESP;
import i.gishreloaded.deadcode.hacks.render.ChinaHat;
import i.gishreloaded.deadcode.hacks.render.Crosshair;
import i.gishreloaded.deadcode.hacks.render.CustomChat;
import i.gishreloaded.deadcode.hacks.render.CustomFog;
import i.gishreloaded.deadcode.hacks.render.CustomRain;
import i.gishreloaded.deadcode.hacks.render.CustomSnow;
import i.gishreloaded.deadcode.hacks.render.DeathCoords;
import i.gishreloaded.deadcode.hacks.render.ESP;
import i.gishreloaded.deadcode.hacks.render.EnchantColor;
import i.gishreloaded.deadcode.hacks.render.FreeCam;
import i.gishreloaded.deadcode.hacks.render.Glowing;
import i.gishreloaded.deadcode.hacks.render.HUD;
import i.gishreloaded.deadcode.hacks.render.Item360;
import i.gishreloaded.deadcode.hacks.render.ItemESP;
import i.gishreloaded.deadcode.hacks.render.JumpCircle;
import i.gishreloaded.deadcode.hacks.render.NameProtect;
import i.gishreloaded.deadcode.hacks.render.NightVision;
import i.gishreloaded.deadcode.hacks.render.NoHurtCam;
import i.gishreloaded.deadcode.hacks.render.NoScoreboard;
import i.gishreloaded.deadcode.hacks.render.NoVisualBlock;
import i.gishreloaded.deadcode.hacks.render.PlayerRadar;
import i.gishreloaded.deadcode.hacks.render.Profiler;
import i.gishreloaded.deadcode.hacks.render.Projectiles;
import i.gishreloaded.deadcode.hacks.render.ReloadChunks;
import i.gishreloaded.deadcode.hacks.render.SwingAnimate;
import i.gishreloaded.deadcode.hacks.render.TargetDirection;
import i.gishreloaded.deadcode.hacks.render.TextureChanger;
import i.gishreloaded.deadcode.hacks.render.TotemCounter;
import i.gishreloaded.deadcode.hacks.render.Tracers;
import i.gishreloaded.deadcode.hacks.render.Trails;
import i.gishreloaded.deadcode.hacks.render.Trajectories;
import i.gishreloaded.deadcode.hacks.render.UserInterface;
import i.gishreloaded.deadcode.hacks.render.ViewModel;
import i.gishreloaded.deadcode.hacks.render.WallHack;
import i.gishreloaded.deadcode.hacks.render.WaterVision;
import i.gishreloaded.deadcode.hacks.render.WeatherClear;
import i.gishreloaded.deadcode.hacks.render.WorldTime;
import i.gishreloaded.deadcode.hacks.render.XRay;
import i.gishreloaded.deadcode.hacks.render.XRayBypass;
import i.gishreloaded.deadcode.hacks.render.Zoom;
import i.gishreloaded.deadcode.hacks.world.AntiArmorStand;
import i.gishreloaded.deadcode.hacks.world.BedFucker;
import i.gishreloaded.deadcode.hacks.world.ChestStealer;
import i.gishreloaded.deadcode.hacks.world.FastBreak;
import i.gishreloaded.deadcode.hacks.world.LightningDetect;
import i.gishreloaded.deadcode.hacks.world.MagicCarpet;
import i.gishreloaded.deadcode.hacks.world.NoInteract;
import i.gishreloaded.deadcode.hacks.world.Nuker;
import i.gishreloaded.deadcode.hacks.world.Timer;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.value.Value;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.ScreenshotEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class HackManager {
    private static Hack a = null;
    private static ArrayList b;

    public HackManager() {
        \u2001\u2000\u00a0.if();
        b = new ArrayList();
        HackManager.addHack(new Debug(\u200b\u2000.final()[0]));
        HackManager.addHack(new UserInterface(\u200b\u2000.final()[1]));
        HackManager.addHack(new HUD(\u200b\u2000.final()[2]));
        HackManager.addHack(new Blackout(\u200b\u2000.final()[3]));
        HackManager.addHack(new Targets(\u200b\u2000.final()[4]));
        HackManager.addHack(new Teams(\u200b\u2000.final()[5]));
        HackManager.addHack(new NoGuiEvents(\u200b\u2000.final()[6]));
        HackManager.addHack(new Glowing(\u200b\u2000.final()[7]));
        HackManager.addHack(new Trajectories(\u200b\u2000.final()[8]));
        HackManager.addHack(new Projectiles(\u200b\u2000.final()[9]));
        HackManager.addHack(new XRay(\u200b\u2000.final()[10]));
        HackManager.addHack(new XRayBypass(\u200b\u2000.final()[11]));
        HackManager.addHack(new EnchantColor(\u200b\u2000.final()[12]));
        HackManager.addHack(new ESP(\u200b\u2000.final()[13]));
        HackManager.addHack(new ItemESP(\u200b\u2000.final()[14]));
        HackManager.addHack(new ChestESP(\u200b\u2000.final()[15]));
        HackManager.addHack(new Tracers(\u200b\u2000.final()[16]));
        HackManager.addHack(new TargetDirection(\u200b\u2000.final()[17]));
        HackManager.addHack(new Profiler(\u200b\u2000.final()[18]));
        HackManager.addHack(new TextureChanger(\u200b\u2000.final()[19]));
        HackManager.addHack(new Trails(\u200b\u2000.final()[20]));
        HackManager.addHack(new WallHack(\u200b\u2000.final()[21]));
        HackManager.addHack(new Flight(\u200b\u2000.final()[22]));
        HackManager.addHack(new NoPush(\u200b\u2000.final()[23]));
        HackManager.addHack(new Jesus(\u200b\u2000.final()[24]));
        HackManager.addHack(new SwingAnimate(\u200b\u2000.final()[25]));
        HackManager.addHack(new Crosshair(\u200b\u2000.final()[26]));
        HackManager.addHack(new NightVision(\u200b\u2000.final()[27]));
        HackManager.addHack(new WaterVision(\u200b\u2000.final()[28]));
        HackManager.addHack(new NoVisualBlock(\u200b\u2000.final()[29]));
        HackManager.addHack(new Ambience(\u200b\u2000.final()[30]));
        HackManager.addHack(new WorldTime(\u200b\u2000.final()[31]));
        HackManager.addHack(new AirJump(\u200b\u2000.final()[32]));
        HackManager.addHack(new AutoTool(\u200b\u2000.final()[33]));
        HackManager.addHack(new AntiBot(\u200b\u2000.final()[34]));
        HackManager.addHack(new AntiArmorStand(\u200b\u2000.final()[35]));
        HackManager.addHack(new AimBot(\u200b\u2000.final()[36]));
        HackManager.addHack(new BowAimBot(\u200b\u2000.final()[37]));
        HackManager.addHack(new TriggerBot(\u200b\u2000.final()[38]));
        HackManager.addHack(new AutoGApple(\u200b\u2000.final()[39]));
        HackManager.addHack(new GoldenAppleDelay(\u200b\u2000.final()[40]));
        HackManager.addHack(new Criticals(\u200b\u2000.final()[41]));
        HackManager.addHack(new KillAura(\u200b\u2000.final()[42]));
        HackManager.addHack(new ShieldBreaker(\u200b\u2000.final()[43]));
        HackManager.addHack(new Reach(\u200b\u2000.final()[44]));
        HackManager.addHack(new SelfDamage(\u200b\u2000.final()[45]));
        HackManager.addHack(new Timer(\u200b\u2000.final()[46]));
        HackManager.addHack(new TotemCounter(\u200b\u2000.final()[47]));
        HackManager.addHack(new NoInteract(\u200b\u2000.final()[48]));
        HackManager.addHack(new Velocity(\u200b\u2000.final()[49]));
        HackManager.addHack(new FastBow(\u200b\u2000.final()[50]));
        HackManager.addHack(new AutoSprint(\u200b\u2000.final()[51]));
        HackManager.addHack(new AutoArmor(\u200b\u2000.final()[52]));
        HackManager.addHack(new AutoHeal(\u200b\u2000.final()[53]));
        HackManager.addHack(new MCF(\u200b\u2000.final()[54]));
        HackManager.addHack(new HitSound(\u200b\u2000.final()[55]));
        HackManager.addHack(new AutoAccept(\u200b\u2000.final()[56]));
        HackManager.addHack(new Disconnect(\u200b\u2000.final()[57]));
        HackManager.addHack(new StaffDetector(\u200b\u2000.final()[58]));
        HackManager.addHack(new ChestStealer(\u200b\u2000.final()[59]));
        HackManager.addHack(new ClickPearl(\u200b\u2000.final()[60]));
        HackManager.addHack(new NoHurtCam(\u200b\u2000.final()[61]));
        HackManager.addHack(new JumpCircle(\u200b\u2000.final()[62]));
        HackManager.addHack(new ViewModel(\u200b\u2000.final()[63]));
        HackManager.addHack(new CustomChat(\u200b\u2000.final()[64]));
        HackManager.addHack(new CustomFog(\u200b\u2000.final()[65]));
        HackManager.addHack(new CustomRain(\u200b\u2000.final()[66]));
        HackManager.addHack(new CustomSnow(\u200b\u2000.final()[67]));
        HackManager.addHack(new CameraClip(\u200b\u2000.final()[68]));
        HackManager.addHack(new WebLeave(\u200b\u2000.final()[69]));
        HackManager.addHack(new WaterLeave(\u200b\u2000.final()[70]));
        HackManager.addHack(new RodLeave(\u200b\u2000.final()[71]));
        HackManager.addHack(new WaterSpeed(\u200b\u2000.final()[72]));
        HackManager.addHack(new NoJumpDelay(\u200b\u2000.final()[73]));
        HackManager.addHack(new NoRotate(\u200b\u2000.final()[74]));
        HackManager.addHack(new NoDamage(\u200b\u2000.final()[75]));
        HackManager.addHack(new NoSlow(\u200b\u2000.final()[76]));
        HackManager.addHack(new NameProtect(\u200b\u2000.final()[77]));
        HackManager.addHack(new NoScoreboard(\u200b\u2000.final()[78]));
        HackManager.addHack(new BeaconDistance(\u200b\u2000.final()[79]));
        HackManager.addHack(new ReloadChunks(\u200b\u2000.final()[80]));
        HackManager.addHack(new Glide(\u200b\u2000.final()[81]));
        HackManager.addHack(new Item360(\u200b\u2000.final()[82]));
        HackManager.addHack(new AutoBuff(\u200b\u2000.final()[83]));
        HackManager.addHack(new AutoDebuff(\u200b\u2000.final()[84]));
        HackManager.addHack(new AntiLevitate(\u200b\u2000.final()[85]));
        HackManager.addHack(new Refill(\u200b\u2000.final()[86]));
        HackManager.addHack(new AutoEat(\u200b\u2000.final()[87]));
        HackManager.addHack(new AutoJoin(\u200b\u2000.final()[88]));
        HackManager.addHack(new Nuker(\u200b\u2000.final()[89]));
        HackManager.addHack(new AntiFall(\u200b\u2000.final()[90]));
        HackManager.addHack(new NoClip(\u200b\u2000.final()[91]));
        HackManager.addHack(new DeathBow(\u200b\u2000.final()[92]));
        HackManager.addHack(new VClip(\u200b\u2000.final()[93]));
        HackManager.addHack(new HClip(\u200b\u2000.final()[94]));
        HackManager.addHack(new TeleportUp(\u200b\u2000.final()[95]));
        HackManager.addHack(new TeleportDown(\u200b\u2000.final()[96]));
        HackManager.addHack(new BedrockTeleport(\u200b\u2000.final()[97]));
        HackManager.addHack(new HighJump(\u200b\u2000.final()[98]));
        HackManager.addHack(new LongJump(\u200b\u2000.final()[99]));
        HackManager.addHack(new MagicCarpet(\u200b\u2000.final()[100]));
        HackManager.addHack(new TargetStrafe(\u200b\u2000.final()[101]));
        HackManager.addHack(new AutoStep(\u200b\u2000.final()[102]));
        HackManager.addHack(new FreeCam(\u200b\u2000.final()[103]));
        HackManager.addHack(new NoCom(\u200b\u2000.final()[104]));
        HackManager.addHack(new BlockOverlay(\u200b\u2000.final()[105]));
        HackManager.addHack(new PluginsGetter(\u200b\u2000.final()[106]));
        HackManager.addHack(new Teleport(\u200b\u2000.final()[107]));
        HackManager.addHack(new GuiWalk(\u200b\u2000.final()[108]));
        HackManager.addHack(new PlayerRadar(\u200b\u2000.final()[109]));
        HackManager.addHack(new DeathCoords(\u200b\u2000.final()[110]));
        HackManager.addHack(new Parkour(\u200b\u2000.final()[111]));
        HackManager.addHack(new WeatherClear(\u200b\u2000.final()[112]));
        HackManager.addHack(new AntiAim(\u200b\u2000.final()[113]));
        HackManager.addHack(new AntiWeb(\u200b\u2000.final()[114]));
        HackManager.addHack(new AutoTotem(\u200b\u2000.final()[115]));
        HackManager.addHack(new AntiBadEffects(\u200b\u2000.final()[116]));
        HackManager.addHack(new AutoRespawn(\u200b\u2000.final()[117]));
        HackManager.addHack(new HitBox(\u200b\u2000.final()[118]));
        HackManager.addHack(new Speed(\u200b\u2000.final()[119]));
        HackManager.addHack(new FastStairs(\u200b\u2000.final()[120]));
        HackManager.addHack(new Strafe(\u200b\u2000.final()[121]));
        HackManager.addHack(new Spider(\u200b\u2000.final()[122]));
        HackManager.addHack(new FastLadder(\u200b\u2000.final()[123]));
        HackManager.addHack(new AutoWalk(\u200b\u2000.final()[124]));
        HackManager.addHack(new XCarry(\u200b\u2000.final()[125]));
        HackManager.addHack(new AntiAfk(\u200b\u2000.final()[126]));
        HackManager.addHack(new AntiFire(\u200b\u2000.final()[127]));
        HackManager.addHack(new ChinaHat(\u200b\u2000.final()[128]));
        HackManager.addHack(new ChatCalc(\u200b\u2000.final()[129]));
        HackManager.addHack(new TestHack(\u200b\u2000.final()[130]));
        HackManager.addHack(new FastBreak(\u200b\u2000.final()[131]));
        HackManager.addHack(new AutoLeave(\u200b\u2000.final()[132]));
        HackManager.addHack(new FlagDetect(\u200b\u2000.final()[133]));
        HackManager.addHack(new Sleep(\u200b\u2000.final()[134]));
        HackManager.addHack(new \u2009\u2008(\u200b\u2000.final()[135]));
        HackManager.addHack(new BedFucker(\u200b\u2000.final()[136]));
        HackManager.addHack(new PortalGodMode(\u200b\u2000.final()[137]));
        HackManager.addHack(new PickupFilter(\u200b\u2000.final()[138]));
        HackManager.addHack(new PacketFilter(\u200b\u2000.final()[139]));
        HackManager.addHack(new FakeCreative(\u200b\u2000.final()[140]));
        HackManager.addHack(new Zoom(\u200b\u2000.final()[141]));
        HackManager.addHack(new LightningDetect(\u200b\u2000.final()[142]));
        HackManager.addHack(new DiscordRPC(\u200b\u2000.final()[143]));
        HackManager.addHack(new Optimization(\u200b\u2000.final()[144]));
        HackManager.addHack(new AutoImgur(\u200b\u2000.final()[145]));
        ChatUtils.debug("Loaded [" + b.size() + "] hacks.");
        ChatUtils.debug("HackManager: initialized.");
    }

    public static Hack getHack(String string) {
        Hack hack = null;
        for (Hack hack2 : HackManager.getHacks()) {
            if (!hack2.getName().equalsIgnoreCase(string)) continue;
            hack = hack2;
            break;
        }
        return hack;
    }

    public static List getSortedHacks() {
        List list = HackManager.c();
        list.sort(new eK());
        return list;
    }

    public static void addHack(Hack hack) {
        b.add(hack);
    }

    public static ArrayList getHacks() {
        return b;
    }

    public static List c() {
        return b.stream().filter(hack -> hack.isShown() && hack.isToggled()).collect(Collectors.toList());
    }

    public static Hack d() {
        return a;
    }

    public static void a(int n2) {
        if (Wrapper.INSTANCE.getMinecraft().currentScreen != null) {
            return;
        }
        for (Hack hack : HackManager.getHacks()) {
            if (hack.r() != n2) continue;
            hack.toggle();
            a = hack;
        }
    }

    public static void b(int n2) {
        if (Wrapper.INSTANCE.getMinecraft().currentScreen != null) {
            return;
        }
        for (Hack hack : HackManager.getHacks()) {
            if (hack.getKey() == n2) {
                hack.toggle();
                a = hack;
            }
            for (Value value : hack.getSettings()) {
                BooleanValue booleanValue;
                if (!(value instanceof BooleanValue) || (booleanValue = (BooleanValue)value).a() != n2) continue;
                booleanValue.a(hack.getName());
            }
        }
    }

    public static void a(PlayerSPPushOutOfBlocksEvent playerSPPushOutOfBlocksEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onPushOutOfBlocksEvent(playerSPPushOutOfBlocksEvent);
        }
    }

    public static void a(LivingEntityUseItemEvent livingEntityUseItemEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onEntityUseItemEvent(livingEntityUseItemEvent);
        }
    }

    public static void a(ScreenshotEvent screenshotEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onScreenshotEvent(screenshotEvent);
        }
    }

    public static void a(LivingEvent.LivingJumpEvent livingJumpEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onJumpEvent(livingJumpEvent);
        }
    }

    public static void a(GuiOpenEvent guiOpenEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onGuiOpenEvent(guiOpenEvent);
        }
    }

    public static void a(FMLNetworkEvent.ClientConnectedToServerEvent clientConnectedToServerEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onConnectedToServerEvent(clientConnectedToServerEvent);
        }
    }

    public static void a(InputUpdateEvent inputUpdateEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onInputEvent(inputUpdateEvent);
        }
    }

    public static void a(EntityItemPickupEvent entityItemPickupEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onItemPickupEvent(entityItemPickupEvent);
        }
    }

    public static void a(TickEvent.PlayerTickEvent playerTickEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onPlayerTickEvent(playerTickEvent);
        }
    }

    public static void a(TickEvent.ClientTickEvent clientTickEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onClientTickEvent(clientTickEvent);
        }
    }

    public static void a(LivingEvent.LivingUpdateEvent livingUpdateEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onUpdateEvent(livingUpdateEvent);
        }
    }

    public static void a(RenderPlayerEvent renderPlayerEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onRenderPlayerEvent(renderPlayerEvent);
        }
    }

    public static void a(RenderWorldLastEvent renderWorldLastEvent) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.onRenderWorldLastEvent(renderWorldLastEvent);
            for (Object e : et.b()) {
                hack.onRenderWorldLastEvent(renderWorldLastEvent, e);
            }
        }
    }

    public static void a(float f2) {
        for (Hack hack : HackManager.getHacks()) {
            if (!hack.isToggled()) continue;
            hack.a(f2);
        }
    }
}

