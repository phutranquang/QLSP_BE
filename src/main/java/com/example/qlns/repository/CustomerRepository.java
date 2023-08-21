package com.example.qlns.repository;

import com.example.qlns.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "SELECT c.* FROM customer c where c.name LIKE CONCAT('%',:query, '%')", nativeQuery = true)
    List<Customer> searchCustomers(String query);
}
