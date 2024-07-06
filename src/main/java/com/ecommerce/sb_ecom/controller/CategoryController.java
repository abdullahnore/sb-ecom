package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {


  private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
         List<Category> categories = categoryService.getAllCategories();
        return  new ResponseEntity<>(categories,HttpStatus.OK) ;
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
 categoryService.createCategory(category);
        return new ResponseEntity<>( "Category Added succesfully",HttpStatus.CREATED);
    }
    @DeleteMapping ("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory( @PathVariable long categoryId){
        try{   String status= categoryService.deleteCategory(categoryId);
            return  new ResponseEntity<>(status, HttpStatus.OK);}catch(ResponseStatusException e){
           return new ResponseEntity<>( e.getReason(),e.getStatusCode());
        }


    }

    @PutMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,
                                                 @PathVariable long categoryId){
        try{
           Category savedCategory= categoryService.updateCategory(category,categoryId);
            return  new ResponseEntity<>("category updated with id : " +  categoryId, HttpStatus.OK);
        }catch(ResponseStatusException e){
            return new ResponseEntity<>( e.getReason(),e.getStatusCode());
        }
    }
}
