package miu.sa.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PaymentRequest {
    private int orderId;
    private Double amount;
    private String paymentMethod;
}
