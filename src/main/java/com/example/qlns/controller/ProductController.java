package com.example.qlns.controller;

import com.example.qlns.model.Product;
import com.example.qlns.repository.ProductRepository;
import com.example.qlns.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/products")
    public List<Product> listProduct() {
        System.out.println("Da gui yue cau lay danh sach nhan vien");
        return  productService.listAllProduct();
    }


    @GetMapping("/products/smartphones")
    public List<Product> listSmartPhones() {
        return productRepository.getPhoneProducts();
    }

    @GetMapping("/products/laptops")
    public List<Product> getLaptopProducts() {
        return productRepository.getLaptopProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = productService.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(productService.searchProducts(query));
    }

    @PostMapping("/products")
    public void add(@RequestBody Product product) {

        Product newProduct = new Product();

        newProduct.setName(product.getName());
        newProduct.setCode(product.getCode());
        newProduct.setPrice(product.getPrice());
        //currentProduct.setDiscount(Float.parseFloat(product.getDiscount()));
        //newProduct.setDiscount(product.getDiscount());
        //newProduct.setCategoryId(product.getCategoryId());
        newProduct.setScreen(product.getScreen());
        newProduct.setChip(product.getChip());
        newProduct.setRam(product.getRam());
        newProduct.setMemory(product.getMemory());
        //newProduct.setColor(product.getColor());

        productService.save(newProduct);
    }




    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProductById(@RequestBody Product product, @PathVariable("id") String id) {
        Optional<Product> _currentProduct = productRepository.findById(Integer.parseInt(id));
        Product currentProduct = _currentProduct.get();


//        currentProduct.setId(Integer.parseInt(product.getId()));
        //currentProduct.setId(product.getId());
        System.out.println(product.getName());
        currentProduct.setName(product.getName());
        currentProduct.setCode(product.getCode());
        //currentProduct.setDiscount(Float.parseFloat(product.getDiscount()));
        currentProduct.setDiscount(product.getDiscount());
        currentProduct.setDescription(product.getDescription());
        currentProduct.setImage(product.getImage());
        currentProduct.setCategoryId(product.getCategoryId());
        currentProduct.setPrice(product.getPrice());
        //currentProduct.setDiscount(Float.parseFloat(product.getDiscount()));
        currentProduct.setDiscount(product.getDiscount());
        currentProduct.setScreen(product.getScreen());
        currentProduct.setChip(product.getChip());
        currentProduct.setRam(product.getRam());
        currentProduct.setMemory(product.getMemory());
        currentProduct.setColor(product.getColor());
        currentProduct.setBrand(product.getBrand());
        currentProduct.setQuantity(product.getQuantity());
        //currentProduct.setQuantity(Integer.parseInt(product.getQuantity()));

        productRepository.save(currentProduct);
        System.out.println("Vua update xong");
        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

}
