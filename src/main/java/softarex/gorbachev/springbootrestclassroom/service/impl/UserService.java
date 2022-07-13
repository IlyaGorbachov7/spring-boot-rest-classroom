package softarex.gorbachev.springbootrestclassroom.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import softarex.gorbachev.springbootrestclassroom.exceptions.UserServiceException;
import softarex.gorbachev.springbootrestclassroom.exceptions.constant.MessageException;
import softarex.gorbachev.springbootrestclassroom.model.User;
import softarex.gorbachev.springbootrestclassroom.model.dto.UserDTO;
import softarex.gorbachev.springbootrestclassroom.model.mappers.UserMapper;
import softarex.gorbachev.springbootrestclassroom.repository.UserRepository;
import softarex.gorbachev.springbootrestclassroom.service.ServiceTemplate;

import java.util.*;


@Service
@AllArgsConstructor
public class UserService implements ServiceTemplate<UserDTO, UUID> {

    private final UserRepository repository;

    private final UserMapper mapper;

    @Override
    public List<UserDTO> getAll() {
        return mapper.mapList(repository.findAll());
    }

    @Override
    public UserDTO getById(UUID uuid) {
        if (Objects.isNull(uuid)) {
            throw new UserServiceException(MessageException.ID_IS_NULL);
        }

        Optional<User> row = repository.findById(uuid);
        if (!row.isPresent()) {
            throw new UserServiceException(MessageException.USER_NO_FOUND_BY_ID);
        }

        User user = row.get();

        return mapper.map(user);
    }

    @Override
    public UserDTO create(UserDTO entity) {
        if (Objects.isNull(entity)) {
            throw new UserServiceException(MessageException.REQUEST_BODY_IS_NULL);
        }

        if (!Objects.isNull(entity.getId()) && repository.existsById(entity.getId())) {
            throw new UserServiceException(MessageException.USER_ID_IS_EXIST);
        }

        if (Objects.isNull(entity.getName()) || entity.getName().isEmpty()
            || repository.existsByName(entity.getName())) {
            throw new UserServiceException(MessageException.USERNAME_IS_EXIST);
        }

        User user = mapper.map(entity); //  if isHand == true, then before conversation isHand == false
        User saveUser = repository.save(user);

        return mapper.map(saveUser);
    }

    @Override
    public UserDTO update(UserDTO rscEntity) {
        if (Objects.isNull(rscEntity) || Objects.isNull(rscEntity.getId())
            || Objects.isNull(rscEntity.getName()))
            throw new UserServiceException(MessageException.REQUEST_BODY_IS_NULL
                                           + " or " + MessageException.ID_IS_NULL
                                           + " or " + MessageException.NAME_IS_NULL);

        List<User> list = repository.findByIdOrName(rscEntity.getId(),rscEntity/)

        return /*mapper.map("existUser")*/ null;
    }

    @Override
    public void deleteById(UUID uuid) {
        if (Objects.isNull(uuid)) {
            throw new UserServiceException(MessageException.ID_IS_NULL);
        }

        repository.deleteById(uuid);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
