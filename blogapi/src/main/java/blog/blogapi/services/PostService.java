package blog.blogapi.services;

import java.util.List;

import blog.blogapi.entities.Post;
import blog.blogapi.payloads.PostDto;

public interface PostService {

    // Create
    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);

    // Update
    Post updatePost(PostDto postDto, Integer postId);

    // Delete Post
    void deletePost(Integer postId);

    // Get all post
    List<Post> getAllPost();

    // Get Single Post
    Post getPostById(Integer postId);

    // Get Post By Category
    List<Post> getPostByCategory(Integer categoryId);

    // Get all post by User
    List<Post> getPostByUser(Integer userId);

    // Search Post
    List<Post> searchPost(String keyword);

} 