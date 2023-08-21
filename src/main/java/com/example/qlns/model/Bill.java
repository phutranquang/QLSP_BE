package com.example.qlns.model;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "saledate")
    private String saleDate;

    @Column(name = "totalbill")
    private float totalBill;

    @Column(name = "customer_id")
    private Integer customerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public float getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(float totalBill) {
        this.totalBill = totalBill;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Bill() {

    }

    public Bill(Integer id, String saleDate, float totalBill, Integer customerId) {
        this.id = id;
        this.saleDate = saleDate;
        this.totalBill = totalBill;
        this.customerId = customerId;
    }
}
