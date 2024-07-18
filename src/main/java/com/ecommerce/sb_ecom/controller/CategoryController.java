package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.constants.AppConstant;
import com.ecommerce.sb_ecom.model.Category;
import com.ecommerce.sb_ecom.payload.CategoryDTO;
import com.ecommerce.sb_ecom.payload.CategoryResponse;
import com.ecommerce.sb_ecom.service.CategoryService;
import jakarta.validation.Valid;
import org.hibernate.metamodel.mapping.NonAggregatedIdentifierMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
public class CategoryController {


  private CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @GetMapping("/api/public/categories")
    @RequestMapping(value ="/public/categories" ,method = RequestMethod.GET)
    public ResponseEntity<CategoryResponse> getAllCategories(
            @RequestParam(name = "pageNumber",defaultValue = AppConstant.PAGE_NUMBER ,required = false) Integer pageNumber,
            @RequestParam(name = "pageSize",defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "SortBy" ,defaultValue = AppConstant.SORT_CATEGORIES_BY,required = false) String sortBy,
            @RequestParam(name = "sortOrder",defaultValue = AppConstant.SORT_DIR,required = false) String sortOrder
    ){
         CategoryResponse categoryResponse = categoryService.getAllCategories(pageNumber,pageSize,sortBy,sortOrder);
        return  new ResponseEntity<>(categoryResponse,HttpStatus.OK) ;
    }

//    @PostMapping("/api/public/categories")
@RequestMapping(value ="/public/categories" ,method = RequestMethod.    POST)


public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){

 CategoryDTO savedCategoryDTO=categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>( savedCategoryDTO,HttpStatus.CREATED);
    }
    @DeleteMapping ("/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory( @PathVariable long categoryId){
        CategoryDTO deleteCategory= categoryService.deleteCategory(categoryId);
            return  new ResponseEntity<>(deleteCategory, HttpStatus.OK);


    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO,
                                                 @PathVariable long categoryId){

           CategoryDTO savedCategoryDTO= categoryService.updateCategory(categoryDTO,categoryId);
            return  new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);

    }
}
