package blog.blogapi.servicesImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.blogapi.entities.User;
import blog.blogapi.exceptions.ReourceNotFoundException;
import blog.blogapi.payloads.UserDto;
import blog.blogapi.repoisitories.UserRepo;
import blog.blogapi.services.UserService;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelmapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        // Parse the userDto in to user
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        // Parse user in to Dto
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
        .orElseThrow(() -> new ReourceNotFoundException("User", "Id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user);
        UserDto UserDto1 = this.userToDto(updatedUser);
        return UserDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ReourceNotFoundException("User", "Id", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();

        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ReourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto) {
        // User user=new User();
        // user.setId(userDto.getId());
        // user.setName(userDto.getName());
        // user.setEmail(userDto.getEmail());
        // user.setAbout(userDto.getAbout());
        // user.setPassword(userDto.getPassword());
        // return user;

        // ******** Using Model Mapper *******
        User user = this.modelmapper.map(userDto, User.class);
        return user;
    }

    private UserDto userToDto(User user) {
        // UserDto userDto=new UserDto();
        // userDto.setId(user.getId());
        // userDto.setName(user.getName());
        // userDto.setEmail(user.getEmail());
        // userDto.setAbout(user.getAbout());
        // userDto.setPassword(user.getPassword());
        // return userDto;

        // ******** Using Model Mapper *******
        UserDto userDto = this.modelmapper.map(user, UserDto.class);
        return userDto;

    }

}
