package miu.sa.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue
    private int id;
    private int customerId;
    private double totalAmount;
    private String status;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLines;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private ShippingAddress address;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private PaymentMethod paymentMethod;
}
