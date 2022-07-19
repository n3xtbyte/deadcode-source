/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.value;

public class Value {
    public Object c;
    private String name;
    private Object b;

    public Value(String string, Object object) {
        this.name = string;
        this.b = object;
        this.c = object;
    }

    public String getName() {
        return this.name;
    }

    public Object getDefaultValue() {
        return this.b;
    }

    public Object getObjectValue() {
        return this.c;
    }

    public void setValue(Object object) {
        this.c = object;
    }
}

