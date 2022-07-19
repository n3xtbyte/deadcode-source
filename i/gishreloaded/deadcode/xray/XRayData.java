/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.xray;

public class XRayData {
    private int id;
    private int meta;
    private int red;
    private int green;
    private int blue;

    public XRayData(int n2, int n3, int n4, int n5, int n6) {
        this.id = n2;
        this.meta = n3;
        this.red = n4;
        this.green = n5;
        this.blue = n6;
    }

    public int getId() {
        return this.id;
    }

    public int getMeta() {
        return this.meta;
    }

    public void setId(int n2) {
        this.id = n2;
    }

    public int getRed() {
        return this.red;
    }

    public void setRed(int n2) {
        this.red = n2;
    }

    public int getGreen() {
        return this.green;
    }

    public void setGreen(int n2) {
        this.green = n2;
    }

    public int getBlue() {
        return this.blue;
    }

    public void setBlue(int n2) {
        this.blue = n2;
    }
}

