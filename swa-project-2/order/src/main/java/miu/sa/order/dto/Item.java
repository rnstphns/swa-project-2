package miu.sa.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Item {
    private int id, stock;

    public Item(int id, int stock) {
        this.id = id;
        this.stock = stock;
    }
}
