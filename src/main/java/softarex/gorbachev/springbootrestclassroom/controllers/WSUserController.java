package softarex.gorbachev.springbootrestclassroom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import softarex.gorbachev.springbootrestclassroom.model.dto.UserDTO;
import softarex.gorbachev.springbootrestclassroom.service.impl.UserService;

import java.util.List;
import java.util.UUID;

import static softarex.gorbachev.springbootrestclassroom.controllers.constants.UrlPath.*;

@Controller
public class WSUserController {

    private final UserService service;

    @Autowired
    public WSUserController(UserService service) {
        this.service = service;
    }

    @MessageMapping(USER_PATH) // /app/users
    @SendTo(DES_TOPIC_CLASSROOM)
    public List<UserDTO> getAll() {
        return service.getAll();
    }
}

