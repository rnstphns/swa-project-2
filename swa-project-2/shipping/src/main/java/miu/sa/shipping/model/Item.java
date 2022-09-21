package miu.sa.shipping.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private int productId;
    private int quantity;
}
