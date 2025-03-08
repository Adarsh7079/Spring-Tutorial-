package blog.blogapi.repoisitories;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.blogapi.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
    
}
