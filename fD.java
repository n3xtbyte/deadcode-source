/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 */
import i.gishreloaded.deadcode.managers.CommandManager;
import i.gishreloaded.deadcode.ui.base.Component;
import i.gishreloaded.deadcode.ui.base.ComponentType;
import i.gishreloaded.deadcode.utils.visual.ChatUtils;
import i.gishreloaded.deadcode.wrappers.Wrapper;
import java.util.ArrayList;
import java.util.Collections;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class fD
extends dp {
    public bu a;
    public int b = 20;
    public int c = 4;
    public eg d;
    public eC e = \u2007\u2008\u00a0.n.a("Other", "Arrows-Run");
    public eC f = \u2007\u2008\u00a0.n.a("Other", "Search");
    private bh g;
    private bh h;

    public fD(int n2, int n3, int n4, int n5, Component component) {
        super(n2, n3, n4, n5, ComponentType.j, component);
        this.g = new er_0(this, n2, n3, 41, 16, this, this.f, "Help", aX.h);
        this.h = new x(this, n2, n3, 16, 16, this, this.e, null, aX.h);
        this.h.g = 0.5f;
        this.a = Wrapper.INSTANCE.n();
        this.d = new eg(this.a, n2, n3, n4, this.b, "Type your command...");
    }

    public void a() {
        String string = this.d.b().trim();
        this.a(string);
    }

    public void a(String string) {
        CommandManager.executeCommand(string);
        try {
            \u2001\u2000\u00a0.g.true();
        }
        catch (Exception exception) {
            ChatUtils.exception("Console: runCommands", exception);
        }
    }

    public void b(String string) {
        bi bi2 = new bi(this.getX(), this.getY(), this.a.a(string), 10, this, string);
        this.a(bi2);
    }

    public boolean d() {
        aD aD2 = \u2007\u2008\u00a0.s.if().k().a().a;
        return aD2 != null && aD2.e == aT.c;
    }

    @Override
    public void a(int n2, int n3) {
        this.g.c(n2, n3);
        this.h.c(n2, n3);
        GL11.glEnable((int)3089);
        int n4 = 2;
        if (Display.getWidth() < 640 || Display.getHeight() < 480) {
            n4 = 1;
        }
        GL11.glScissor((int)((this.getX() - this.c) * n4), (int)(Display.getHeight() - (this.getY() + this.getHeight() - (this.b + this.c * 3)) * n4), (int)(this.getWidth() * n4), (int)((this.getHeight() - (this.b + this.c * 4)) * n4));
        for (Component component : this.b()) {
            component.c(n2, n3);
        }
        GL11.glDisable((int)3089);
    }

    @Override
    public void onMousePress(int n2, int n3, int n4) {
        if (!this.d()) {
            return;
        }
        if (this.g.isMouseOver(n2, n3)) {
            this.g.onMousePress(n2, n3, n4);
        }
        if (this.h.isMouseOver(n2, n3)) {
            this.h.onMousePress(n2, n3, n4);
        }
        if (this.d.j()) {
            this.d.a(n2, n3, n4);
        }
        super.onMousePress(n2, n3, n4);
    }

    @Override
    public void c(int n2, int n3) {
        this.e();
        super.c(n2, n3);
    }

    @Override
    public void onKeyReleased(int n2, char c) {
        if (!this.d()) {
            return;
        }
        if (n2 == 28) {
            this.a();
            return;
        }
        this.d.a(c, n2);
        super.onKeyReleased(n2, c);
    }

    @Override
    public void c() {
        for (Component component : this.b()) {
            component.c();
        }
        super.c();
    }

    public void e() {
        int n2 = 4;
        this.d.a = this.getX() + n2;
        this.d.b = this.getY() + this.getHeight() - this.b - n2;
        this.d.c = this.getWidth() - n2 * 2;
        int n3 = this.getX() + this.getWidth() - n2 * 2 - this.h.getWidth();
        int n4 = this.d.b + n2 / 2;
        this.h.setXY(n3, n4);
        this.g.setXY(n3 - n2 - this.g.getWidth() - 2, n4);
        int n5 = this.d.b - this.getY() - this.b + n2;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.b());
        Collections.reverse(arrayList);
        for (Component component : arrayList) {
            int n6 = this.getY() + n5;
            component.b(n6);
            component.setXY(this.getX() + n2 * 2, component.g());
            n5 -= component.getHeight() + n2;
        }
    }
}

