package miu.sa.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.sa.order.model.OrderLine;
import miu.sa.order.model.PaymentMethod;
import miu.sa.order.model.ShippingAddress;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class OrderRequest {
    private int customerId;
    private ShippingAddress shippingAddress;
    private PaymentMethod paymentMethodData;
    private List<OrderLine> orderLines;
}
