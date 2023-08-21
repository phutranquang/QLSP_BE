package com.example.qlns.service;

import com.example.qlns.model.Product;
import com.example.qlns.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> listAllProduct() {
        return repo.findAll();
    }

    public Product save(Product product) {
        if(product.getName() == null || product.getName().isEmpty()) {
            return null;
        }
        if(product.getCode() == null || product.getCode().isEmpty()) {
            return null;
        }
        return repo.save(product);
    }
    
    public List<Product> searchProducts(String query) {
        List<Product> products = repo.searchProducts(query);
        return products;
    }

    public Product get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }


}
