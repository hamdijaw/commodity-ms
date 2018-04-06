package com.uniship.commodityms.domain;

public class Customer {

    private int id;
    private String name;
    private String customerNumber;
    private String customerName;
    private String upsAccountNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getUpsAccountNumber() {
        return upsAccountNumber;
    }

    public void setUpsAccountNumber(String upsAccountNumber) {
        this.upsAccountNumber = upsAccountNumber;
    }
}
