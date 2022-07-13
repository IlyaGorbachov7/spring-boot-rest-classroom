package softarex.gorbachev.springbootrestclassroom.model.mappers;

import org.mapstruct.Mapper;
import softarex.gorbachev.springbootrestclassroom.model.User;
import softarex.gorbachev.springbootrestclassroom.model.dto.UserDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract User map(UserDTO userDTO);

    public abstract UserDTO map(User user);

    public abstract List<UserDTO> mapList(List<User> list);

    public User update(User target,UserDTO rsc) {
        target.setName(rsc.getName());
        target.setHand(rsc.isHand());
        return target;
    }
}
