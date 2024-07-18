package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.payload.CategoryDTO;
import com.ecommerce.sb_ecom.payload.CategoryResponse;

//this is an interface for loose coupling
public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber , Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO,long categoryId);
}
