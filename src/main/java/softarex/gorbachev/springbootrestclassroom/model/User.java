package softarex.gorbachev.springbootrestclassroom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.UUID;

/**
 * The class is a description of the subject area of the model
 *
 * @author Gorabachev I. D.
 * @version 14.07.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("User")
public class User implements Serializable {

    @Id
    private UUID id;
    @Indexed
    private String name;
    @Indexed
    private boolean hand;
}

