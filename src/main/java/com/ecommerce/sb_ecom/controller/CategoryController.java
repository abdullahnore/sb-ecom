package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {


  private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
 categoryService.createCategory(category);
        return "Category Added succesfully";
    }
    @DeleteMapping ("/api/admin/categories/{categoryId}")
    public String deleteCategory( @PathVariable long categoryId){
        String status= categoryService.deleteCategory(categoryId);
        return  status;
    }
}
