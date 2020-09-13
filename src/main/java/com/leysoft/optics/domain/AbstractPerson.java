package com.leysoft.optics.domain;

import com.leysoft.optics.inmutable.Builder;
import com.leysoft.optics.lens.Lens;
import org.immutables.value.Value;

@Builder
@Value.Immutable
public abstract class AbstractPerson {

    abstract PersonName name();

    abstract Address address();

    public Lens<Person, PersonName> nameLens() {
        return Lens.of(Person::name, p -> (p::withName));
    }

    public Lens<Person, Address> addressLens() {
        return Lens.of(Person::address, p -> (p::withAddress));
    }
}
