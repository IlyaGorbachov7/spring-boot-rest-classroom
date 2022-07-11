package softarex.gorbachev.springbootrestclassroom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("User")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1603714798906422731L;
    private UUID id;
    private String name;
    private boolean isHand;

    public void update(User user){
        name = user.name;
        isHand = user.isHand;
    }
}
