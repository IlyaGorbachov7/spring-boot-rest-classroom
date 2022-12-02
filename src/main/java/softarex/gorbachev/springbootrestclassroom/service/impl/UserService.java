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

/**
 * This class is the main place for processing a client request.
 *
 * @author Gorabachev I. D.
 * @version 14.07.2022
 */
@Service
@AllArgsConstructor
public class UserService implements ServiceTemplate<UserDTO, Integer> {

    private final UserRepository repository;

    private final UserMapper mapper;

    @Override
    public List<UserDTO> getAll() {
        return mapper.mapList(repository.findAll());
    }

    @Override
    public UserDTO getById(Integer uuid) {

        Optional<User> row = repository.findById(uuid);
        if (!row.isPresent()) {
            throw new UserServiceException(MessageException.USER_NO_FOUND_BY_ID);
        }

        User user = row.get();

        return mapper.map(user);
    }

    @Override
    public UserDTO create(UserDTO entity) {

        if (repository.existsByName(entity.getName())) {
            throw new UserServiceException(MessageException.USERNAME_IS_EXIST);
        }

        User user = mapper.map(entity);
        User saveUser = repository.save(user);

        return mapper.map(saveUser);
    }

    @Override
    public UserDTO update(UserDTO rscEntity) {
        Optional<User> row = repository.findById(rscEntity.getId());
        if (!row.isPresent()) {
            throw new UserServiceException(MessageException.USER_NO_FOUND_BY_ID);
        }

        // if rsc is resource to update, and contains username that already exist to the other user
        List<User> list = repository.findByName(rscEntity.getName());
        if (!list.isEmpty() && !list.get(0).getId().equals(rscEntity.getId())) {
            throw new UserServiceException(MessageException.USERNAME_IS_EXIST);
        }

        User existUser = row.get();
        mapper.update(existUser, rscEntity);
        existUser = repository.save(existUser);
        return mapper.map(existUser);
    }

    @Override
    public void deleteById(Integer uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}