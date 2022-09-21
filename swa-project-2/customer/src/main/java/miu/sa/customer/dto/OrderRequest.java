package miu.sa.customer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.sa.customer.model.Address;
import miu.sa.customer.model.PaymentMethod;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {
    private int customerId;
    private Address shippingAddress;
    private PaymentMethod paymentMethodData;
    private List<Item> orderLines;
}
