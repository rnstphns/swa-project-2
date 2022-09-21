package miu.sa.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer orderId;
    private String paymentMethod;
    private Double amount;
    private String status;
}
