package com.example.qlns.controller;

import com.example.qlns.model.Bill;
import com.example.qlns.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("/bills")
    List<Bill> getListBills() {
        return billService.listBills();
    }
    @GetMapping("/bills/{id}")
    public ResponseEntity<Bill> get(@PathVariable Integer id) {
        try {
            Bill bill = billService.getBillById(id);
            return new ResponseEntity<Bill>(bill, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }
    }

}
