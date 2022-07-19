/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.value.types;

import i.gishreloaded.deadcode.value.Value;

public class ColorValue
extends Value {
    public ColorValue(String string, int n2) {
        super(string, n2);
    }

    public Integer getValue() {
        Number number = (Number)super.getObjectValue();
        int n2 = number.intValue();
        return n2;
    }

    @Override
    public /* synthetic */ Object getObjectValue() {
        return this.getValue();
    }
}

