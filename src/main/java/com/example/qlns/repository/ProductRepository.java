package com.example.qlns.repository;

import com.example.qlns.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT p.id, p.code, p.name, p.screen,  p.chip, p.ram, p.price, p.discount FROM product p", nativeQuery = true)
    List<Product> getListProductsDAO();

    @Query(value = "select * from product p join category c\n" +
            "where p.category_id = c.id\n" +
            "and c.name = 'smartphones';", nativeQuery = true)
    List<Product> getPhoneProducts();

    @Query(value = "select * from product p join category c\n" +
            "where p.category_id = c.id\n" +
            "and c.name = 'laptops';", nativeQuery = true)
    List<Product> getLaptopProducts();

    @Query(value = "SELECT p.* FROM product p where p.name LIKE CONCAT('%',:query, '%')", nativeQuery = true)
    List<Product> searchProducts(String query);

}
