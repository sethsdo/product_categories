package com.project.ProductsandCategories.repositories;

import com.project.ProductsandCategories.models.Category;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    @Query(value="select * from categories_products join categories on categories.id= categories_products.category_id join products on products.id=categories_products.product_id", nativeQuery=true)
    public List<Object> join();
    

}