package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.exception.APIException;
import com.ecommerce.sb_ecom.exception.ResourceNotFoundException;
import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements  CategoryService {
//    private List<Category> categories = new ArrayList<>();
    private long nextId=1L;

    @Autowired
 private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories=categoryRepository.findAll();
        if(categories.isEmpty()){
            throw new APIException("NO category created till now .");
        }
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory=categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory!=null)
        {throw new APIException(  "category with name:" + category.getCategoryName()+" already exists");}
        categoryRepository.save(category);


    }

    @Override
    public String deleteCategory(long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        categoryRepository.delete(category);
        return "category with ID:" + categoryId + " deleted succesfully";
    }

    @Override
    public Category updateCategory(Category category ,long categoryId) {
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));
        Category savedCategory;
        category.setCategoryId(categoryId);
        savedCategory=categoryRepository.save(category);
        return savedCategory;


    }


}
