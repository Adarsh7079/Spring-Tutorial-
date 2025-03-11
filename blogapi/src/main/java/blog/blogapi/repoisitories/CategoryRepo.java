package blog.blogapi.repoisitories;


import org.springframework.data.jpa.repository.JpaRepository;

import blog.blogapi.entities.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer> {
    
}
