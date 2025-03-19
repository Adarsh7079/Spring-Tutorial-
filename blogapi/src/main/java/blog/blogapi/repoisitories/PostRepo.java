package blog.blogapi.repoisitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.blogapi.entities.Category;
import blog.blogapi.entities.Post;
import blog.blogapi.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post>findByUser(User user);
    List<Post>findByCategory(Category category);

} 