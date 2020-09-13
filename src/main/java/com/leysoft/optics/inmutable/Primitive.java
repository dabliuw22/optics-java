package com.leysoft.optics.inmutable;

import org.immutables.value.Value;

public abstract class Primitive<A> {

    @Value.Parameter
    public abstract A value();

    @Override
    public String toString() {
        return value().toString();
    }
}
