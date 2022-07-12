package softarex.gorbachev.springbootrestclassroom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softarex.gorbachev.springbootrestclassroom.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    boolean existsById(UUID uuid);

    boolean existsByName(String name);
}
