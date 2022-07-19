/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.value.types;

import i.gishreloaded.deadcode.value.Value;

public class IntegerValue
extends Value {
    public int min;
    public int max;

    public IntegerValue(String string, int n2, int n3, int n4) {
        super(string, n2);
        this.min = n3;
        this.max = n4;
    }

    public Integer getValue() {
        Number number = (Number)super.getObjectValue();
        int n2 = number.intValue();
        return n2;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    @Override
    public /* synthetic */ Object getObjectValue() {
        return this.getValue();
    }
}

