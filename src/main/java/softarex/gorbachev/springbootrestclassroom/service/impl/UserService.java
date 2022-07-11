package softarex.gorbachev.springbootrestclassroom.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
        if (Objects.isNull(uuid)) {
            throw new NullPointerException("");
        }

        Optional<User> row = repository.findById(uuid);
        if (row.isPresent()) {
            User user = row.get();
            return user;
        } else {
            // ?? Что если не существует объекта ? как бросить исключение ?
        }
        return null;
    }

    @Override
    public User create(User entity) {
        if (Objects.isNull(entity)) {
            throw new NullPointerException(""); // ?
        }
        boolean exist = repository.existsByName(entity.getName());
        if (exist) {
            throw new UnsupportedOperationException("User with same name already exist");
        }


        return repository.save(entity);
    }

    @Override
    public void update(User rscEntity) {
        if (Objects.isNull(rscEntity) || Objects.isNull(rscEntity.getId())) {
            throw new NullPointerException(""); // ?
        }

        Optional<User> row = repository.findById(rscEntity.getId());
        if (row.isPresent()) {
            User existUser = row.get();
            existUser.update(rscEntity);
            repository.save(existUser);
        } else {
            // ?? Что если не существует объекта ? как бросить исключение ?
        }
    }

    @Override
    public void deleteById(UUID uuid) {
        if (Objects.isNull(uuid)) {
            throw new NullPointerException(""); // ?
        }
        repository.deleteById(uuid);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
