package miu.sa.shipping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shipment {
    @Id
    @GeneratedValue
    private int id;
    private int orderId;
    private String status;
    private String trackingNumber;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "shipment_id")
    private List<Item> items;




}
