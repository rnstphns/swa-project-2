package miu.sa.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue
    private int id;
    private int productId;
    private int quantity;
    private double price;
}
