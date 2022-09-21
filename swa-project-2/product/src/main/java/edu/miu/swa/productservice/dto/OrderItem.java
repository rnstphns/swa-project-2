package edu.miu.swa.productservice.dto;

public class OrderItem {

    private int id;
    private Integer numOfItems;

    public OrderItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(Integer numOfItems) {
        this.numOfItems = numOfItems;
    }
}
