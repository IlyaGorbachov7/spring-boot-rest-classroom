package softarex.gorbachev.springbootrestclassroom.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import softarex.gorbachev.springbootrestclassroom.controllers.constant.UrlPath;
import softarex.gorbachev.springbootrestclassroom.model.User;
import softarex.gorbachev.springbootrestclassroom.service.impl.UserService;

import java.util.List;
import java.util.UUID;

import static softarex.gorbachev.springbootrestclassroom.controllers.constant.PathVariableParam.USER_ID;
import static softarex.gorbachev.springbootrestclassroom.controllers.constant.UrlPath.USER_ID_PATH;

@CrossOrigin(UrlPath.CROSS_ORIGIN)
@RestController
@RequestMapping(UrlPath.USER_PATH)
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @DeleteMapping(USER_ID_PATH)
    public void delete(@PathVariable(USER_ID) UUID uuid) {
        service.deleteById(uuid);
    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }

    @PutMapping
    public void update(@RequestBody User user) {
        service.update(user);
    }

    @GetMapping(USER_ID_PATH)
    public User get(@PathVariable(USER_ID) UUID uuid) {
        return service.getById(uuid);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }
}

