package com.leysoft.optics.domain;

import com.leysoft.optics.inmutable.NoBuilder;
import com.leysoft.optics.inmutable.Primitive;
import com.leysoft.optics.lens.Lens;
import org.immutables.value.Value;

@NoBuilder
@Value.Immutable
public abstract class AbstractCityName extends Primitive<String> {

    public Lens<CityName, String> valueLens() {
        return Lens.of(CityName::value, n -> (CityName::of));
    }
}
