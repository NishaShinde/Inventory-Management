package com.example.nisha.inventorymanagement.data;

/**
 * Created by nisha on 09-Jan-18.
 */

public class Product {
    private String productName;
    private double price;
    private int quantity;
    private String imagePath;
    private String supplierName;
    private String supplierEmail;
    private String supplierPhoneNumber;

    public Product(String productName, double price, int quantity, String imagePath, String supplierName, String supplierEmail, String supplierPhoneNumber) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierPhoneNumber = supplierPhoneNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }
}
