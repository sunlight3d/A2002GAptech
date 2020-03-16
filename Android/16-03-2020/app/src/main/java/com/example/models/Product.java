package com.example.models;

public class Product {
    private Integer productId;
    private String productName;
    private String productURL;
    private Integer productYear;
    private String productDescription;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    public Integer getProductYear() {
        return productYear;
    }

    public void setProductYear(Integer productYear) {
        this.productYear = productYear;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductId() {
        return productId;
    }

    public Product(
                    Integer productId,
                    String productName, String productURL,
                   Integer productYear, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productURL = productURL;
        this.productYear = productYear;
        this.productDescription = productDescription;
    }
}
