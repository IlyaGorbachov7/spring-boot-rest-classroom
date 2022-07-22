package softarex.gorbachev.springbootrestclassroom.model.dto.constants;

/**
 * This interface contains definitions of the
 * \text constants of the validation message,
 * as well as the necessary validation parameters
 *
 * @author Gorbachev I. D.
 * @version 14.07.2022
 */
public interface UserDTOValidation {

    int MIN_LENGTH_NAME = 3;

    int MAX_LENGTH_NAME = 30;

    String REGEX = "(^([A-ZА-ЯЁ][a-zа-яё]{" + (MIN_LENGTH_NAME - 1) + ",})((\\s([A-ZА-ЯЁ][a-zа-яё]{" +
                   (MIN_LENGTH_NAME - 1) + ",}))?)$)|";

    String MSG_USER_ID_IS_NULL = "The ID must be require specified";

    String MSG_USER_ID_NOT_NULL = "The ID must not be specified";

    String MSG_USER_NAME_REGEX = "Username for example: " +
                                 "Firstname (or: Firstname Lastname) " +
                                 "Consist literal symbols " +
                                 "Firstname and Lastname length  started with " + MIN_LENGTH_NAME + " symbols. " +
                                 "The first letters must be uppercase. ";

    String MSG_USER_NAME_SIZE = "General username length between " + MIN_LENGTH_NAME + " to " +
                                MAX_LENGTH_NAME + " literal symbol";

    String MSG_USER_NAME_IS_NULL = "Must specify username";
}
