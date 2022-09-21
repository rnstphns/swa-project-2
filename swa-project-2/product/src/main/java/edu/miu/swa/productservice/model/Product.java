package edu.miu.swa.productservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private Integer productId;
    private String productName;
    private String productCategory;
    private Double productPrice;
    private Integer numInStock;

    public Product(Integer productId, String productName, String productCategory, Double productPrice, Integer numInStock) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.numInStock = numInStock;
        this.productPrice = productPrice;
    }

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getNumInStock() {
        return numInStock;
    }

    public void setNumInStock(Integer num){
        this.numInStock = num;
    }

}
