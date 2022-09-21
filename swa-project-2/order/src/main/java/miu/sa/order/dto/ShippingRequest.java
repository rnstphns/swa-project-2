package miu.sa.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ShippingRequest {
    private int orderId;
    private List<Item> items;
}
