/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.play.server.SPacketSpawnPlayer
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.managers.HackManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.value.Mode;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.value.types.ModeValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import java.util.LinkedList;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AntiBot
extends Hack {
    public ModeValue a;
    public ModeValue b;
    public BooleanValue c;
    public BooleanValue d;
    public BooleanValue e;
    public BooleanValue f;
    public LinkedList g;

    public AntiBot(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.a = new ModeValue("Mode", new Mode("Custom"), new Mode("Matrix", true));
        this.b = new ModeValue("Custom mode", false, new Mode("All", true), new Mode("Single"));
        this.c = new BooleanValue("Tab analysis", true);
        this.d = new BooleanValue("Entity analysis", false);
        this.e = new BooleanValue("Equip analysis", true);
        this.f = new BooleanValue("Only KillAura", true);
        this.a(this.a, this.b, new cs_0("Analysis"), this.c, this.d, this.e, new cs_0("Other"), this.f);
        this.g = new LinkedList();
    }

    @Override
    public String getDescription() {
        return "Remove anti cheat bots.";
    }

    @Override
    public void onEnable() {
        this.g.clear();
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        for (Entity entity : et.b()) {
            EntityOtherPlayerMP entityOtherPlayerMP;
            if (this.a.getModeByIndex(1).isToggled()) {
                if (!(entity instanceof EntityOtherPlayerMP)) continue;
                entityOtherPlayerMP = (EntityOtherPlayerMP)entity;
                NetHandlerPlayClient netHandlerPlayClient = Wrapper.INSTANCE.getMinecraft().getConnection();
                NetworkPlayerInfo networkPlayerInfo = null;
                if (netHandlerPlayClient != null) {
                    networkPlayerInfo = netHandlerPlayClient.getPlayerInfo(entityOtherPlayerMP.getUniqueID());
                }
                if (entityOtherPlayerMP.ticksExisted >= 5 || entityOtherPlayerMP.hurtTime <= 0 || !(Wrapper.INSTANCE.getLocalPlayer().getDistance((Entity)entityOtherPlayerMP) <= 25.0f) || networkPlayerInfo == null || networkPlayerInfo.getResponseTime() == 0) continue;
                this.a((Entity)entityOtherPlayerMP);
                continue;
            }
            if (!this.a.getModeByIndex(0).isToggled() || !(entity instanceof EntityPlayer) || (entityOtherPlayerMP = (EntityPlayer)entity) == null || !this.g.contains(entityOtherPlayerMP.getUniqueID())) continue;
            boolean bl = entityOtherPlayerMP.getActivePotionEffect(MobEffects.SPEED) == null && entityOtherPlayerMP.getActivePotionEffect(MobEffects.JUMP_BOOST) == null && entityOtherPlayerMP.getActivePotionEffect(MobEffects.LEVITATION) == null && !entityOtherPlayerMP.isInWater() && !entityOtherPlayerMP.isRiding() && entityOtherPlayerMP.getLastAttackedEntity() == null && entityOtherPlayerMP.fallDistance == 0.0f && !entityOtherPlayerMP.isAirBorne && !entityOtherPlayerMP.collided && !entityOtherPlayerMP.onGround && !entityOtherPlayerMP.capabilities.isFlying && !entityOtherPlayerMP.capabilities.allowFlying && !entityOtherPlayerMP.capabilities.disableDamage && (double)entityOtherPlayerMP.experience == 0.0 && entityOtherPlayerMP.experienceLevel == 0 && entityOtherPlayerMP.experienceTotal == 0;
            int n2 = 0;
            if (((Boolean)this.c.getObjectValue()).booleanValue()) {
                for (NetworkPlayerInfo networkPlayerInfo : Wrapper.INSTANCE.getMinecraft().getConnection().getPlayerInfoMap()) {
                    if (!networkPlayerInfo.getGameProfile().getName().equals(entityOtherPlayerMP.getGameProfile().getName()) && networkPlayerInfo.getGameProfile().getName().contains("\u00a7")) continue;
                    ++n2;
                }
            }
            ArrayList arrayList = new ArrayList();
            if (((Boolean)this.e.getObjectValue()).booleanValue()) {
                ItemStack[] itemStackArray;
                NetworkPlayerInfo networkPlayerInfo;
                networkPlayerInfo = entityOtherPlayerMP.inventory;
                ItemStack itemStack = entityOtherPlayerMP.getHeldItemMainhand();
                ItemStack itemStack2 = networkPlayerInfo.armorItemInSlot(0);
                ItemStack itemStack3 = networkPlayerInfo.armorItemInSlot(1);
                ItemStack itemStack4 = networkPlayerInfo.armorItemInSlot(2);
                ItemStack itemStack5 = networkPlayerInfo.armorItemInSlot(3);
                for (ItemStack itemStack6 : itemStackArray = new ItemStack[]{itemStack, itemStack5, itemStack4, itemStack3, itemStack2}) {
                    if (et.a(itemStack6)) continue;
                    arrayList.add(itemStack6);
                }
            }
            boolean bl2 = (Boolean)this.d.getObjectValue() != false && bl;
            boolean bl3 = (Boolean)this.c.getObjectValue() != false && n2 > 1;
            boolean bl4 = (Boolean)this.e.getObjectValue() != false && arrayList.size() > 2;
            boolean bl5 = false;
            if (this.b.getModeByIndex(0).isToggled()) {
                bl5 = bl2 && bl3 && bl4 || bl2 && bl3 || bl2 && bl4 || bl3 && bl2 || bl3 && bl4 || bl4 && bl2 || bl4 && bl3;
            } else if (this.b.getModeByIndex(1).isToggled()) {
                boolean bl6 = bl5 = bl2 || bl3 || bl4;
            }
            if (bl5) {
                this.a((Entity)entityOtherPlayerMP);
            }
            this.g.remove(entityOtherPlayerMP.getUniqueID());
        }
        super.onClientTickEvent(clientTickEvent);
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (object instanceof SPacketSpawnPlayer && this.a.getModeByIndex(0).isToggled()) {
            if (((Boolean)this.f.getObjectValue()).booleanValue() && !HackManager.getHack("KillAura").isToggled()) {
                return true;
            }
            SPacketSpawnPlayer sPacketSpawnPlayer = (SPacketSpawnPlayer)object;
            EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
            double d2 = entityPlayerSP.getDistance(sPacketSpawnPlayer.getX(), sPacketSpawnPlayer.getY(), sPacketSpawnPlayer.getZ());
            double d3 = entityPlayerSP.posY - 1.0;
            double d4 = entityPlayerSP.posY + 1.0;
            if (d2 < 18.0 && sPacketSpawnPlayer.getY() >= d3 && sPacketSpawnPlayer.getY() <= d4) {
                this.g.add(sPacketSpawnPlayer.getUniqueId());
            }
        }
        return true;
    }

    public void a(Entity entity) {
        Wrapper.INSTANCE.getWorld().removeEntity(entity);
        ChatUtils.info("AntiBot: Removed \"" + entity.getName() + "\" from world.");
    }
}

