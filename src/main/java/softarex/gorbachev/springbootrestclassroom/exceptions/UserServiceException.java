package softarex.gorbachev.springbootrestclassroom.exceptions;

/**
 * This exception throw in case error inside {@link softarex.gorbachev.springbootrestclassroom.service.impl.UserService}
 *
 * @author Gorbachev I. D.
 * @version 18.07.2022
 */
public class UserServiceException extends RuntimeException {
    public UserServiceException() {
    }

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
