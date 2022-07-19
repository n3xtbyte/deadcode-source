/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.hacks.render;

import i.gishreloaded.deadcode.hack.Hack;
import i.gishreloaded.deadcode.hack.HackCategory;
import i.gishreloaded.deadcode.wrappers.Wrapper;

public class ReloadChunks
extends Hack {
    public ReloadChunks(String string) {
        super(string, HackCategory.Render);
    }

    @Override
    public String getDescription() {
        return "Reload chunks.";
    }

    @Override
    public void onEnable() {
        Wrapper.INSTANCE.getMinecraft().renderGlobal.loadRenderers();
        this.c(false);
        super.onEnable();
    }
}

