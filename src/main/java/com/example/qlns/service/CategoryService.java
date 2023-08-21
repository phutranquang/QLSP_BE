package com.example.qlns.service;

import com.example.qlns.model.Category;
import com.example.qlns.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory () {
        return  categoryRepository.findAll();
    }
}
