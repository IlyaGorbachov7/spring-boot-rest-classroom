package softarex.gorbachev.springbootrestclassroom.controllers;

import org.springframework.web.bind.annotation.*;
import softarex.gorbachev.springbootrestclassroom.model.User;
import softarex.gorbachev.springbootrestclassroom.service.UserService;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers() {
        System.out.println(UUID.randomUUID());
        return service.getUsers();
    }

    @PostMapping // UserDTO - is слой between front and back => User => Mapper library
    public User createUser(@RequestBody User user) {
/* Если Json будет
 пустым, тогда объект будет инициализирван по умлолчанию
   А что если вообще не будет передоватья json*/
        return service.createUser(user);
    }

    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable("userId") Integer /* Id  => UUID */ id) {
        service.deleteUser(id);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Integer userId) {
        return service.getUser(userId);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        service.updateUser(user);
    }


}
