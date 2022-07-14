package softarex.gorbachev.springbootrestclassroom.model.dto;

import lombok.*;
import softarex.gorbachev.springbootrestclassroom.model.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

import static softarex.gorbachev.springbootrestclassroom.model.dto.constants.UserDTOValidation.*;

/**
 * TThis class is a data transfer object represented by a domain model {@link User}
 *
 * @author Gorbachev I. D.
 * @version 13.07.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private UUID id;

    @Pattern(regexp = REGEX, message = MSG_USER_NAME_REGEX)
    @Size(min = MIN_LENGTH_NAME, max = MAX_LENGTH_NAME, message = MSG_USER_NAME_SIZE)
    @NotNull(message = MSG_USER_NAME_IS_NULL)
    private String name;

    private boolean hand;
}
