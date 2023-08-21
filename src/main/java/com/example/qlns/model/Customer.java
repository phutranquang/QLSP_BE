package com.example.qlns.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "totalpurchase")
    private float totalpurchase;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

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

    public float getTotalpurchase() {
        return totalpurchase;
    }

    public void setTotalpurchase(float totalpurchase) {
        this.totalpurchase = totalpurchase;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer() {

    }

    public Customer(Integer id, String name, float totalpurchase, String address, String phone) {
        this.id = id;
        this.name = name;
        this.totalpurchase = totalpurchase;
        this.address = address;
        this.phone = phone;
    }
}
