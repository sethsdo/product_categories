package com.project.ProductsandCategories.services;

import com.project.ProductsandCategories.models.Category;
import com.project.ProductsandCategories.repositories.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    
    //SHOW ALL
    public List<Category> allCategories() {
        return categoryRepo.findAll();
    }

    //ADD CATEGORY
    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    //GET CATEGORY
    public Category getCategory(Long id) {
        return categoryRepo.findOne(id);
    }

    public List<Object> join() {
        return categoryRepo.join();
    }

}