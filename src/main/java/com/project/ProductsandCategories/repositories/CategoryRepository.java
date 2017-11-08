package com.project.ProductsandCategories.repositories;

import com.project.ProductsandCategories.models.Category;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    List<Category> findByNameNotIn(List<String> name);
    

}