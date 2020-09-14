package com.leysoft.optics.lens;

import java.util.function.Function;

public class Lens<A, B> {

    private final Function<A, B> getter;

    private final Function<A, Function<B, A>> setter;

    private Lens(
            Function<A, B> getter,
            Function<A, Function<B, A>> setter) {
        this.getter = getter;
        this.setter = setter;
    }

    public static <A, B> Lens<A, B> of(
            Function<A, B> getter,
            Function<A, Function<B, A>> setter) {
        return new Lens<>(getter, setter);
    }

    public B get(A target) {
        return this.getter.apply(target);
    }

    public A set(A target, B value) {
        return this.modify(target, ignored -> value);
    }

    public A modify(A target, Function<B, B> f) {
        return this.setter.apply(target).apply(f.apply(get(target)));
    }

    public <C> Lens<A, C> compose(Lens<B, C> other) {
        return Lens.of(
                (A a) -> other.getter.apply(this.get(a)),
                (A a) -> ((C c) -> this.set(
                        a, other.setter.apply(this.get(a)).apply(c)))
        );
    }
}
