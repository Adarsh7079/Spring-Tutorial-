package blog.blogapi.services;

import java.util.List;

import blog.blogapi.payloads.CategoryDto;

public interface CategoryService {

    // Create
    CategoryDto createCategory(CategoryDto categoryDto);

    // Update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    
    // Delete 
    public void deleteCategory(Integer categoryId);
    
    // Get 
    public CategoryDto getCategory(Integer categoryId);

    // Get All 
    List<CategoryDto>getCategories();

}
