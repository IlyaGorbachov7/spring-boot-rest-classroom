package softarex.gorbachev.springbootrestclassroom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softarex.gorbachev.springbootrestclassroom.model.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    List<User> findAll();

    boolean existsById(UUID uuid);

    boolean existsByName(String name);
    //
    long countByName(String name);
}
