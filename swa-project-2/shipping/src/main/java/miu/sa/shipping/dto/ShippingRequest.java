package miu.sa.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class ShippingRequest {
    private int orderId;
    private List<ItemRequest> items;
}
