package miu.sa.creditCardTransaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class CreditCard {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer paymentId;
    private Double amount;
    private Long cardNumber;
    private Integer ccv;
    private LocalDate expirationDate;

}
