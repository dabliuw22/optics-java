package com.leysoft.optics;

import com.leysoft.optics.domain.Address;
import com.leysoft.optics.domain.AddressStreet;
import com.leysoft.optics.domain.CityName;
import com.leysoft.optics.domain.Person;
import com.leysoft.optics.domain.PersonName;
import com.leysoft.optics.lens.Lens;

public class Main {

    public static void main(String[] args) {
        var person = Person.builder()
                .name(PersonName.of("Nick Doe"))
                .address(Address.builder()
                        .street(AddressStreet.of("Wall Street"))
                        .city(CityName.of("new York"))
                        .build())
                .build();

        Lens<Person, String> compose = person.addressLens()
                .compose(person.address().cityLens())
                .compose(person.address().city().valueLens());

        var newPerson = compose.modify(person, String::toUpperCase);

        System.out.println(newPerson);
    }
}
