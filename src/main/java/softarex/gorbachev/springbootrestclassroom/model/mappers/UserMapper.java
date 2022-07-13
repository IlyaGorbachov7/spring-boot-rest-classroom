package softarex.gorbachev.springbootrestclassroom.model.mappers;

import org.mapstruct.Mapper;
import softarex.gorbachev.springbootrestclassroom.model.User;
import softarex.gorbachev.springbootrestclassroom.model.dto.UserDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(UserDTO userDTO);

    UserDTO map(User user);

    List<UserDTO> mapList(List<User> list);

//    User update(UserDTO from, User to);
}
