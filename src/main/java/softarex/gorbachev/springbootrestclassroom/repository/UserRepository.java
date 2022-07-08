package softarex.gorbachev.springbootrestclassroom.repository;

import org.springframework.stereotype.Repository;
import softarex.gorbachev.springbootrestclassroom.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepository {
    private final List<User> listUsers = new ArrayList<>(Arrays.asList(new User(1, "ILya", true),
            new User(2, "Nasty", false)));

    public List<User> getAll() {
        return listUsers;
    }

    public User save(User user) {
        listUsers.add(user);
        user.setId(listUsers.size());
        return user;
    }

    public void deleteById(Integer userId) {
        listUsers.remove(find(userId));
    }

    public User update(User userUpdate) {
        User user = listUsers.get(find(userUpdate.getId()));
        user.setName(userUpdate.getName());
        user.setHand(userUpdate.isHand());
        return user;
    }

    private int find(Integer userId) {
        int i = 0;
        for (var user : listUsers) {
            if (Objects.equals(user.getId(), userId)) {
                break;
            } else ++i;
        }
        if (i == listUsers.size()) throw new IndexOutOfBoundsException("Пользователя токого нет ");
        return i;
    }

    public User getUserById(Integer userId) {
        return listUsers.get(find(userId));
    }
}
