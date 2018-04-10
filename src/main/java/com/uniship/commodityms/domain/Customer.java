package com.uniship.commodityms.domain;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "customer_number", nullable = false)
    private String customerNumber;
    @Column(name = "customer_name", nullable = false)
    private String customerName;
    @Column(name = "ups_account_number")
    private String upsAccountNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
