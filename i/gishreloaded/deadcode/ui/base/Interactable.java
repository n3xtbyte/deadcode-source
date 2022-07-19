/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.ui.base;

public class Interactable {
    private final int a;
    private final int b;
    private int xPos;
    private int yPos;
    private int e;
    private int width;
    private int height;

    public Interactable(int n2, int n3, int n4, int n5) {
        this.xPos = n2;
        this.yPos = n3;
        this.a = n2;
        this.b = n3;
        this.width = n4;
        this.height = n5;
    }

    public void onMousePress(int n2, int n3, int n4) {
    }

    public void onMouseRelease(int n2, int n3, int n4) {
    }

    public void onMouseDrag(int n2, int n3) {
    }

    public void c(int n2, int n3, int n4) {
    }

    public void onMouseScroll(int n2) {
    }

    public boolean isMouseOver(int n2, int n3) {
        return n2 >= this.xPos && n3 >= this.yPos && n2 <= this.xPos + this.width && n3 <= this.yPos + this.height;
    }

    public void onKeyReleased(int n2, char c) {
    }

    public void b(int n2, char c) {
    }

    public int g() {
        return this.e;
    }

    public void b(int n2) {
        this.e = n2;
    }

    public int getX() {
        return this.xPos;
    }

    public int getY() {
        return this.yPos;
    }

    public int j() {
        return this.a;
    }

    public int k() {
        return this.b;
    }

    public void setXY(int n2, int n3) {
        this.xPos = n2;
        this.yPos = n3;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setDimension(int n2, int n3) {
        this.width = n2;
        this.height = n3;
    }
}

