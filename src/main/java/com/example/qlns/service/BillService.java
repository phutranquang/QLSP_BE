package com.example.qlns.service;

import com.example.qlns.model.Bill;
import com.example.qlns.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BillService {
    @Autowired
    BillRepository billRepository;

    public List<Bill> listBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Integer id) {
        return billRepository.findById(id).get();
    }

}
