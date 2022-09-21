package miu.sa.customer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.sa.customer.dto.IPaymentMethod;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PaymentMethod {
    @Id
    @GeneratedValue
    private int id;
    private String type;
    private boolean defaultPaymentMethod;
}
