/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketSpawnGlobalEntity
 */
package i.gishreloaded.deadcode.hacks.world;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;

public class LightningDetect
extends Hack {
    public LightningDetect(String string) {
        super(string, HackCategory.World);
    }

    @Override
    public String getDescription() {
        return "Display the coords of a lightning strike.";
    }

    @Override
    public boolean a(Object object, bw bw2) {
        if (object instanceof SPacketSpawnGlobalEntity) {
            SPacketSpawnGlobalEntity sPacketSpawnGlobalEntity = (SPacketSpawnGlobalEntity)object;
            ChatUtils.warning(String.format("Lightning at: X: %s Y: %s Z: %s", sPacketSpawnGlobalEntity.getX(), sPacketSpawnGlobalEntity.getY(), sPacketSpawnGlobalEntity.getZ()));
        }
        return super.a(object, bw2);
    }
}

