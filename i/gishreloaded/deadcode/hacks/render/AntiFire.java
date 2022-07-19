/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.managers.MappingManager;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.lang.reflect.Field;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AntiFire
extends Hack {
    public AntiFire(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "No render fire.";
    }

    @Override
    public void onDisable() {
        this.a(false);
        super.onDisable();
    }

    @Override
    public void onPlayerTickEvent(TickEvent.PlayerTickEvent playerTickEvent) {
        if (Wrapper.INSTANCE.getLocalPlayer().isBurning()) {
            this.a(true);
        }
        super.onPlayerTickEvent(playerTickEvent);
    }

    public void a(boolean bl) {
        try {
            Field field = Entity.class.getDeclaredField(MappingManager.fieldIsImmuneToFire);
            field.setAccessible(true);
            field.setBoolean(Wrapper.INSTANCE.getLocalPlayer(), bl);
        }
        catch (Exception exception) {
            ChatUtils.exception("setImmuneToFire", exception);
        }
    }
}

