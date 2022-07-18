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
    /**
     * Generates list all users from database
     *
     * @return list users
     */
    List<User> findAll();

    /**
     * Checking an existing user by ID in the database
     *
     * @param uuid unique user ID
     * @return {@code true}, if exist otherwise  {@code false}
     */
    boolean existsById(UUID uuid);

    /**
     * Checking an existing user by username in the database
     *
     * @param name username
     * @return {@code true}, if exist otherwise  {@code false}
     */
    boolean existsByName(String name);

    /**
     * Returns a list of users who have the specified username from the database
     *
     * @param name username
     * @return list users
     */
    List<User> findByName(String name);
}
