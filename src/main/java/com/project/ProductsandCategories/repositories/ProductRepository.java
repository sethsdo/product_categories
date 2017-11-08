package com.project.ProductsandCategories.repositories;

import com.project.ProductsandCategories.models.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

    List<Product> findByNameNotIn(List<String> name);
}