package com.project.ProductsandCategories.services;

import com.project.ProductsandCategories.models.Product;
import com.project.ProductsandCategories.repositories.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepo;

    public ProductService(ProductRepository productRepo){
        this.productRepo = productRepo;
    }
    
    //SHOW ALL
    public List<Product> allProducts() {
        return productRepo.findAll();
    }

    //ADD CATEGORY
    public void addProduct(Product product) {
        productRepo.save(product);
    }

    //GET PRODUCT
    public Product getProduct(Long id) {
        return productRepo.findOne(id);
    }
}