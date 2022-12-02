package softarex.gorbachev.springbootrestclassroom.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * The class is a description of the subject area of the model
 * <p>
 * I used database H2
 * <p>
 * Я назвал таблцу так как в H2 уже есть зарезервированая таблица, поэтому если назвать ее user то будет кидать исключение
 *
 * @author Gorabachev I. D.
 * @version 14.07.2022
 * @see <a href="https://stackoverflow.com/questions/71722483/org-h2-jdbc-jdbcsqlsyntaxerrorexception-syntax-error-in-sql-statement-drop-tab">Причина ошиби</a>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "uers")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "hand")
    private boolean hand;
}

