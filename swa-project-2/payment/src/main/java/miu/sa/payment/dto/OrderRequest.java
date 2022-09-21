package miu.sa.payment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class OrderRequest {
    private int orderId;
    private Double amount;
    private String paymentMethod;

}
