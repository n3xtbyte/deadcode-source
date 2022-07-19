/*
 * Decompiled with CFR 0.152.
 */
package i.gishreloaded.deadcode.value.types;

import i.gishreloaded.deadcode.value.Value;

public class DoubleValue
extends Value {
    public double min;
    public double max;

    public DoubleValue(String string, double d2, double d3, double d4) {
        super(string, d2);
        this.min = d3;
        this.max = d4;
    }

    public Double getValue() {
        Number number = (Number)super.getObjectValue();
        double d2 = number.doubleValue();
        return d2;
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    @Override
    public /* synthetic */ Object getObjectValue() {
        return this.getValue();
    }
}

