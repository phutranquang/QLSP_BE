package com.example.qlns.repository;

import com.example.qlns.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Integer> {

}
