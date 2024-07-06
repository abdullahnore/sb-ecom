package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Category;

import java.util.List;

//this is an interface for loose coupling
public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(long categoryId);

    Category updateCategory(Category category,long categoryId);
}
