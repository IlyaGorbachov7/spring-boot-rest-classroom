package softarex.gorbachev.springbootrestclassroom.service;

import org.springframework.stereotype.Service;
import softarex.gorbachev.springbootrestclassroom.model.User;
import softarex.gorbachev.springbootrestclassroom.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.getAll();
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(int idUser) {
        repository.deleteById(idUser);
    }

    public void updateUser(User user) {
        repository.update(user);
    }

    public User getUser(Integer userId) {
        return repository.getUserById(userId);
    }
}
