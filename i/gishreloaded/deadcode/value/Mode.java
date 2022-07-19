/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.value;

public class Mode {
    private String name;
    private boolean toggled;

    public Mode(String string) {
        this.name = string;
        this.toggled = false;
    }

    public Mode(String string, boolean bl) {
        this.name = string;
        this.toggled = bl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public boolean isToggled() {
        return this.toggled;
    }

    public void setToggled(boolean bl) {
        this.toggled = bl;
    }
}

