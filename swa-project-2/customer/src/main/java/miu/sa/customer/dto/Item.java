package miu.sa.customer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Item {
    private int productId;
    private int quantity;
    private double price;
}
