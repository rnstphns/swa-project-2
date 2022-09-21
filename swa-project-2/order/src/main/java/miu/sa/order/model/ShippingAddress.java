package miu.sa.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShippingAddress {
    @Id
    @GeneratedValue
    private int id;
    private String name, street, apartment, country;
    private int zip;

    public ShippingAddress(ShippingAddress address){
        name = address.name;
        street = address.getStreet();
        apartment = address.getApartment();
        country = address.getCountry();
        zip = address.getZip();
    }
}
