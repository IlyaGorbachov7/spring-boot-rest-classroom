package softarex.gorbachev.springbootrestclassroom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

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
    private boolean isHand;

    public void update(User user) {
        name = user.name;
        isHand = user.isHand;
    }
}

