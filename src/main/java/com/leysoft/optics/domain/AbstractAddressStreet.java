package com.leysoft.optics.domain;

import com.leysoft.optics.inmutable.NoBuilder;
import com.leysoft.optics.inmutable.Primitive;
import com.leysoft.optics.lens.Lens;
import org.immutables.value.Value;

@NoBuilder
@Value.Immutable
public abstract class AbstractAddressStreet extends Primitive<String> {

    public Lens<AddressStreet, String> valueLens() {
        return Lens.of(AddressStreet::value, n -> (AddressStreet::of));
    }
}
