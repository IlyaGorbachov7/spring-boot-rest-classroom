package softarex.gorbachev.springbootrestclassroom.controllers;

import org.springframework.web.bind.annotation.*;
import softarex.gorbachev.springbootrestclassroom.model.User;
import softarex.gorbachev.springbootrestclassroom.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping
    public List<User> getUsers() {
        System.out.println(UUID.randomUUID());
        return service.getUsers();
    }

    @CrossOrigin("http://localhost:3000")
    @PostMapping // UserDTO - is слой between front and back => User => Mapper library
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable("userId") Integer /* Id  => UUID */ id) {
        service.deleteUser(id);
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Integer userId) {
        return service.getUser(userId);
    }

    @CrossOrigin("http://localhost:3000")
    @PutMapping
    public void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }


}
