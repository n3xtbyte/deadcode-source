/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.managers;

import i.gishreloaded.deadcode.hacks.render.TextureChanger;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.value.Mode;
import java.io.File;
import java.util.ArrayList;

public class ModelManager {
    public final File a = new File(\u2001\u2000\u00a0.d, "Models");
    public final ArrayList b = new ArrayList();
    public boolean c;
    public boolean d;

    public void a() {
        if (this.d) {
            return;
        }
        try {
            if (!this.a.exists()) {
                this.a.mkdir();
            }
            for (Mode mode : TextureChanger.a.getModes()) {
                this.b.add(new an(mode.getName()));
            }
            this.d = true;
            ChatUtils.debug("ModelManager: initialized.");
        }
        catch (Exception exception) {
            ChatUtils.exception("ModelManager", exception);
        }
    }

    public void b() {
        if (this.c) {
            return;
        }
        for (an an2 : this.b) {
            an2.a();
        }
        this.c = true;
    }

    public an c() {
        for (int i2 = 0; i2 < TextureChanger.a.getModes().length; ++i2) {
            if (!TextureChanger.a.getModes()[i2].isToggled()) continue;
            return (an)this.b.get(i2);
        }
        return null;
    }
}

