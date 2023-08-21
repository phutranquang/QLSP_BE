package com.example.qlns.controller;

import com.example.qlns.model.Category;
import com.example.qlns.model.Customer;
import com.example.qlns.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        System.out.println("Da lay danh sach khach hang");
        return customerService.listCustomers();
    }
}
