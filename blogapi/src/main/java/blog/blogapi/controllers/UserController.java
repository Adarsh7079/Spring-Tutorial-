package blog.blogapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.blogapi.payloads.ApiResponse;
import blog.blogapi.payloads.UserDto;
import blog.blogapi.services.UserService;
import blog.blogapi.servicesImp.UserServiceImp;
import jakarta.validation.Valid;
    
@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) { // Constructor Injection
        this.userService = userService;
    }

    // Create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<UserDto>(createUserDto, HttpStatus.CREATED);
    }

    // Update User
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
       UserDto updatedUser= this.userService.updateUser(userDto, uid);
       return ResponseEntity.ok(updatedUser);
    }

    // Deleted User
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid ){
      this.userService.deleteUser(uid);
      return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted succefully",true),HttpStatus.OK);
    }

    //get all user
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

     //get single user
     @GetMapping("/{userId}")
     public ResponseEntity<UserDto> getSingleUsers(@PathVariable("userId") Integer uid){
         return ResponseEntity.ok(this.userService.getUserById(uid));
     }
}
