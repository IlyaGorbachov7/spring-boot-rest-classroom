package softarex.gorbachev.springbootrestclassroom.controllers;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import softarex.gorbachev.springbootrestclassroom.model.dto.UserDTO;
import softarex.gorbachev.springbootrestclassroom.service.impl.UserService;

import java.util.List;
import java.util.UUID;

import static softarex.gorbachev.springbootrestclassroom.controllers.constants.UrlPath.*;

/**
 * This class is place to handle WebSocket-request.
 *
 * @author Gorbachev I. D.
 * @version 18.07.2022
 */
@Controller
@AllArgsConstructor
public class WSUserController {

    private final UserService service;

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping(USER_PATH) // /app/users
    @SendTo(DES_TOPIC_CLASSROOM)
    public List<UserDTO> getAll() {
        return service.getAll();
    }

    @MessageMapping(PRIVATE_DELETE_PATH)
    public void sendDeleteById(@Payload UUID uuid) {
        simpMessagingTemplate.convertAndSendToUser(uuid.toString(), DES_DELETE, uuid);
    }
}

