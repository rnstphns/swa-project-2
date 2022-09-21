package edu.miu.swa.productservice.dto;

import java.util.List;

public class OrderRequest {

    private List<OrderItem> items;

    public OrderRequest(List<OrderItem> items) {
        this.items = items;
    }
    public OrderRequest() {
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
