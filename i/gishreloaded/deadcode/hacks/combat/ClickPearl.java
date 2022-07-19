/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.lwjgl.input.Mouse
 */
package i.gishreloaded.deadcode.hacks.combat;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Mouse;

public class ClickPearl
extends Hack {
    public BooleanValue a;
    public TimerUtils b;
    public int c = -2;

    public ClickPearl(String string) {
        super(string, HackCategory.Combat);
        this.b("General");
        this.a = new BooleanValue("Middle", false);
        this.a(this.a);
        this.b("Other");
        this.b = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Automatically thorw ender-pearl on click.";
    }

    @Override
    public void onEnable() {
        this.c = -2;
        if (((Boolean)this.a.getObjectValue()).booleanValue()) {
            return;
        }
        this.b();
        this.c(false);
        super.onEnable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (!((Boolean)this.a.getObjectValue()).booleanValue()) {
            return;
        }
        if (Mouse.isButtonDown((int)2) && this.b.isReached(200L) && Wrapper.INSTANCE.getMinecraft().currentScreen == null) {
            this.b();
            this.b.resetTime();
        }
        super.onClientTickEvent(clientTickEvent);
    }

    public void b() {
        EntityPlayerSP entityPlayerSP = Wrapper.INSTANCE.getLocalPlayer();
        int n2 = bz.b(Items.ENDER_PEARL);
        if (n2 != -2) {
            Wrapper.INSTANCE.sendPacket((Packet)new CPacketHeldItemChange(n2));
            cs.a.b().processRightClick((EntityPlayer)entityPlayerSP, (World)Wrapper.INSTANCE.getWorld(), EnumHand.MAIN_HAND);
            new i.gishreloaded.deadcode.hacks.thread.ClickPearl(this, entityPlayerSP).start();
        }
    }
}

