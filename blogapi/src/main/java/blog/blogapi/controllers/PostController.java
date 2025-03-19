package blog.blogapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.blogapi.entities.Post;
import blog.blogapi.payloads.PostDto;
import blog.blogapi.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    

    @Autowired
    private PostService postService;
    // Create 
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
        @RequestBody PostDto postDto,
        @PathVariable Integer userId,
        @PathVariable Integer categoryId){

        PostDto createdPost= this.postService.createPost(postDto, userId, categoryId);
         return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
    }
}
