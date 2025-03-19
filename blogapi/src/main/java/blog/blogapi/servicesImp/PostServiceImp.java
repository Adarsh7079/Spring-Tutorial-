package blog.blogapi.servicesImp;

import java.sql.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.blogapi.entities.Category;
import blog.blogapi.entities.Post;
import blog.blogapi.entities.User;
import blog.blogapi.exceptions.ReourceNotFoundException;
import blog.blogapi.payloads.PostDto;
import blog.blogapi.repoisitories.CategoryRepo;
import blog.blogapi.repoisitories.PostRepo;
import blog.blogapi.repoisitories.UserRepo;
import blog.blogapi.services.PostService;


@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public PostDto createPost(PostDto postDto,Integer userId, Integer categoryId) {

        User user=this.userRepo.findById(userId)
        .orElseThrow(() -> new ReourceNotFoundException("User", "Id", userId));

        Category category=this.categoryRepo.findById(categoryId)
        .orElseThrow(() -> new ReourceNotFoundException("Category", "category id", categoryId));

        Post post=this.modelMapper.map(postDto,Post.class);
        //post.setImageName("default.png");
        post.setImageName("asdad"); 
        post.setAddedDate(new Date(0));
        post.setUser(user);
        post.setCategory(category);

        Post newPost= this.postRepo.save(post);
        return this.modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePost'");
    }

    @Override
    public void deletePost(Integer postId) {
       
    }

    @Override
    public List<Post> getAllPost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPost'");
    }

    @Override
    public Post getPostById(Integer postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostById'");
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostByCategory'");
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostByUser'");
    }

    @Override
    public List<Post> searchPost(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPost'");
    }
    
}
