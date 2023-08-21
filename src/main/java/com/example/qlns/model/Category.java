package com.example.qlns.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String nameCategory;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("category")
//    private List<Product> lstProduct = new ArrayList<>();

    public Category() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

//    public List<Product> getLstProduct() {
//        return lstProduct;
//    }
//
//    public void setLstProduct(List<Product> lstProduct) {
//        this.lstProduct = lstProduct;
//    }
}
