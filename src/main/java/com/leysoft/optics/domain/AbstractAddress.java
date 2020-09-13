package com.leysoft.optics.domain;

import com.leysoft.optics.inmutable.Builder;
import com.leysoft.optics.lens.Lens;
import org.immutables.value.Value;

@Builder
@Value.Immutable
public abstract class AbstractAddress {

    abstract AddressStreet street();

    abstract CityName city();

    public Lens<Address, AddressStreet> streetLens() {
        return Lens.of(Address::street, a -> (a::withStreet));
    }

    public Lens<Address, CityName> cityLens() {
        return Lens.of(Address::city, a -> (a::withCity));
    }
}
