package softarex.gorbachev.springbootrestclassroom.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class User {
    private /*UUID*/ Integer id;
    private String name;
    private boolean isHand;
}
