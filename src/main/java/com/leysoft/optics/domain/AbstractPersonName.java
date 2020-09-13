package com.leysoft.optics.domain;

import com.leysoft.optics.inmutable.NoBuilder;
import com.leysoft.optics.inmutable.Primitive;
import com.leysoft.optics.lens.Lens;
import org.immutables.value.Value;

@NoBuilder
@Value.Immutable
public abstract class AbstractPersonName extends Primitive<String> {

    public Lens<PersonName, String> valueLens() {
        return Lens.of(PersonName::value, n -> (PersonName::of));
    }
}
