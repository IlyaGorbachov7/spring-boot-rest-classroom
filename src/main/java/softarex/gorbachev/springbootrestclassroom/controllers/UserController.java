package softarex.gorbachev.springbootrestclassroom.controllers;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import softarex.gorbachev.springbootrestclassroom.model.dto.UserDTO;
import softarex.gorbachev.springbootrestclassroom.model.dto.constants.OnCreate;
import softarex.gorbachev.springbootrestclassroom.model.dto.constants.OnUpdate;
import softarex.gorbachev.springbootrestclassroom.service.impl.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import static softarex.gorbachev.springbootrestclassroom.controllers.constants.PathVariableParam.USER_ID;
import static softarex.gorbachev.springbootrestclassroom.controllers.constants.UrlPath.*;
import static softarex.gorbachev.springbootrestclassroom.model.dto.constants.UserDTOValidation.MSG_USER_ID_IS_NULL;

/**
 * This class is place to handle http-request.
 *
 * @author Gorbachev I. D.
 * @version 13.07.2022
 */
@CrossOrigin(CROSS_ORIGIN)
@RestController
@RequestMapping(USER_PATH)
@Validated
@AllArgsConstructor
public class UserController {

    private final UserService service;

    private final SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping
    @Validated(value = {OnCreate.class})
    public UserDTO create(@RequestBody @Valid UserDTO user) {
        return service.create(user);
    }

    @DeleteMapping(USER_ID_PATH)
    public void delete(@PathVariable(USER_ID)
                       @NotNull(message = MSG_USER_ID_IS_NULL) UUID uuid) {
        service.deleteById(uuid);
    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }

    @PutMapping
    @Validated(value = {OnUpdate.class})
    public UserDTO update(@RequestBody @Valid UserDTO user) {
        return service.update(user);
    }

    @GetMapping(USER_ID_PATH)
    public UserDTO getById(@PathVariable(USER_ID)
                           @NotNull(message = MSG_USER_ID_IS_NULL) UUID uuid) {
        return service.getById(uuid);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return service.getAll();
    }

    /**
     * url-path @RESTController-a : {@code /users} - not taken into account
     * <p>
     * {@code PRIVATE_DELETE_PATH} - the path is added to this path : <b>/app</b>
     * certain from {@link softarex.gorbachev.springbootrestclassroom.SpringBootRestClassroomApplication#configureMessageBroker(MessageBrokerRegistry)}
     * <p>
     * // url in front-end : /app/private/delete
     */
    @MessageMapping(PRIVATE_DELETE_PATH)
    public void sendDeleteById(@Payload UUID uuid) {
        simpMessagingTemplate.convertAndSendToUser(uuid.toString(), DES_DELETE, uuid);
    }
}

