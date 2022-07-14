package softarex.gorbachev.springbootrestclassroom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softarex.gorbachev.springbootrestclassroom.model.User;

import java.util.List;
import java.util.UUID;

/**
 * This interface is a regular crud-repository for making database queries.
 * <p>
 * Customer request methods are also defined here
 *
 * @author Gorabachev I. D.
 * @version 14.07.2022
 */
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    List<User> findAll();

    boolean existsById(UUID uuid);

    boolean existsByName(String name);

    List<User> findByName(String name);
}
