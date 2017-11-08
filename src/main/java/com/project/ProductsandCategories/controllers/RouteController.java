package com.project.ProductsandCategories.controllers;

import com.project.ProductsandCategories.models.Category;
import com.project.ProductsandCategories.models.Product;
import com.project.ProductsandCategories.services.CategoryService;
import com.project.ProductsandCategories.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public RouteController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("product") Product product){
        return "index";
    }
    
    @PostMapping("/addProduct")
    public String newProduct(Model model, @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("there was an Errrr");
            System.out.println(result);
            return "index";
        } else {
            productService.addProduct(product);
            return "redirect:/products/" + product.getId();
        }
    }

    @RequestMapping("/categories/new")
    public String category(Model model, @ModelAttribute("category") Category category) {
        return "index.1";
    }

    @PostMapping("/addCategory")
    public String newCategory(Model model, @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("there was an Errrr");
            System.out.println(result);
            return "index.1";
        } else {
            categoryService.addCategory(category);
            return "redirect:/categories/" + category.getId();
        }
    }

    @RequestMapping("/products/{id}")
    public String products(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProduct(id);
        Object catProd = categoryService.join();
        model.addAttribute("cat_prod", catProd);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.allCategories());
        return "index.2";
    }

    @RequestMapping("/categories/{id}")
    public String categories(@PathVariable("id") Long id, Model model) {
        Category curCat = categoryService.getCategory(id);
        model.addAttribute("category", curCat);
        model.addAttribute("products", productService.allProducts());
        return "index.3";
    }

    @PostMapping("/productCat/{id}")
    public String addCategory(@PathVariable("id") Long id, @RequestParam(value="product") Long productId) {
        System.out.println(productId);
        Product product = productService.getProduct(productId);
        Category category = categoryService.getCategory(id); 
        category.getProducts().add(product);  
        categoryService.addCategory(category);
        return "redirect:/categories/" + category.getId();
    }

    @PostMapping("/categoryPro/{id}")
    public String addProduct(@PathVariable("id") Long id, @RequestParam(value="category") Long catId) {
        System.out.println("hello");
        System.out.println(catId);
        Product product = productService.getProduct(id);
        Category category = categoryService.getCategory(catId);
        product.getCategories().add(category);
        productService.addProduct(product);
        return "redirect:/products/" + product.getId();
    }

}