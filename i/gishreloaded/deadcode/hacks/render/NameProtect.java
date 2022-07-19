/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.managers.FriendManager;
import i.gishreloaded.deadcode.utils.TimerUtils;
import i.gishreloaded.deadcode.value.types.BooleanValue;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NameProtect
extends Hack {
    public BooleanValue a;
    public TimerUtils b;

    public NameProtect(String string) {
        super(string, HackCategory.Render);
        this.b("General");
        this.a = new BooleanValue("Friends", false);
        this.a(this.a);
        this.b("Other");
        this.b = new TimerUtils();
    }

    @Override
    public String getDescription() {
        return "Changes player names client side.";
    }

    @Override
    public void onDisable() {
        if (\u2007\u2008\u00a0.l != null) {
            \u2007\u2008\u00a0.l.a(Wrapper.INSTANCE.getLocalPlayer().getName());
            if (((Boolean)this.a.getObjectValue()).booleanValue()) {
                for (String string : FriendManager.a) {
                    \u2007\u2008\u00a0.l.a(string);
                }
            }
        }
        super.onDisable();
    }

    @Override
    public void onClientTickEvent(TickEvent.ClientTickEvent clientTickEvent) {
        if (\u2007\u2008\u00a0.l != null && this.b.isReached(1000L)) {
            String string = Wrapper.INSTANCE.getLocalPlayer().getName();
            this.a(string, "DeadCode");
            if (((Boolean)this.a.getObjectValue()).booleanValue()) {
                for (int i2 = 0; i2 < FriendManager.a.size(); ++i2) {
                    this.a((String)FriendManager.a.get(i2), "DeadCode_" + i2);
                }
            }
            this.b.resetTime();
        }
        super.onClientTickEvent(clientTickEvent);
    }

    public void a(String string, String string2) {
        if (!\u2007\u2008\u00a0.l.b(string)) {
            \u2007\u2008\u00a0.l.a(string, string2);
        }
    }
}

