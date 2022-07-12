package softarex.gorbachev.springbootrestclassroom.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import softarex.gorbachev.springbootrestclassroom.exceptions.UserServiceException;
import softarex.gorbachev.springbootrestclassroom.exceptions.constant.MessageException;
import softarex.gorbachev.springbootrestclassroom.model.User;
import softarex.gorbachev.springbootrestclassroom.repository.UserRepository;
import softarex.gorbachev.springbootrestclassroom.service.ServiceTemplate;

import java.util.*;


@Service
@AllArgsConstructor
public class UserService implements ServiceTemplate<User, UUID> {

    private final UserRepository repository;

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);

        return users;
    }

    @Override
    public User getById(UUID uuid) {
        if (Objects.isNull(uuid)) throw new UserServiceException(MessageException.ID_IS_NULL);

        Optional<User> row = repository.findById(uuid);
        if (row.isEmpty()) throw new UserServiceException(MessageException.USER_NO_FOUND_BY_ID);

        User user = row.get();
        return user;
    }

    @Override
    public User create(User entity) {
        if (Objects.isNull(entity))
            throw new UserServiceException(MessageException.REQUEST_BODY_IS_NULL);

        if (!Objects.isNull(entity.getId()) && repository.existsById(entity.getId()))
            throw new UserServiceException(MessageException.USER_ID_IS_EXIST);

        if (Objects.isNull(entity.getName()) || entity.getName().isBlank()
            || repository.existsByName(entity.getName()))
            throw new UserServiceException(MessageException.USERNAME_IS_EXIST);


        return repository.save(entity);
    }

    @Override
    public void update(User rscEntity) {
        if (Objects.isNull(rscEntity) || Objects.isNull(rscEntity.getId()))
            throw new UserServiceException(MessageException.REQUEST_BODY_IS_NULL
                                           + " or " + MessageException.ID_IS_NULL);

        if (repository.existsByName(rscEntity.getName()))
            throw new UserServiceException(MessageException.USERNAME_IS_EXIST);

        Optional<User> row = repository.findById(rscEntity.getId());
        if (row.isEmpty()) throw new UserServiceException(MessageException.USER_NO_FOUND_BY_ID);

        User existUser = row.get();
        existUser.update(rscEntity);
        repository.save(existUser);
    }

    @Override
    public void deleteById(UUID uuid) {
        if (Objects.isNull(uuid)) throw new UserServiceException(MessageException.ID_IS_NULL);

        repository.deleteById(uuid);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
