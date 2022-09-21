package miu.sa.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductCheckRequest {
    private List<Item> items;
}
