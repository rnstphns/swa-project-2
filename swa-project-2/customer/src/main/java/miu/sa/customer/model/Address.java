package miu.sa.customer.model;

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
public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String name, street, apartment, country;
    private int zip;
    private boolean defaultAddress;
}
