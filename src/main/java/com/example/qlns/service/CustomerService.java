package com.example.qlns.service;

import com.example.qlns.model.Customer;
import com.example.qlns.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        if(customer.getName() == null || customer.getName().isEmpty()) {
            customer.setName("khách lẻ");
        }
        return customerRepository.save(customer);
    }

    public List<Customer> searchCustomer(String query) {
        List<Customer> customers = customerRepository.searchCustomers(query);
        return customers;
    }

    public Customer get(Integer id) {
        return customerRepository.findById(id).get();
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
