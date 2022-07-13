package softarex.gorbachev.springbootrestclassroom.model.dto;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
//    @NonNull
    private UUID id;
    private String name;
    private boolean hand;
}
