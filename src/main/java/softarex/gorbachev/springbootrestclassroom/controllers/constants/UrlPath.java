package softarex.gorbachev.springbootrestclassroom.controllers.constants;

/**
 * This interface is contains define url path constants
 *
 * @author Gorabachev I. D.
 * @version 13.07.2022
 */
public interface UrlPath {
    String CROSS_ORIGIN = "http://localhost:3000";
    String USER_PATH = "/users";
    String USER_ID_PATH = "/{userId}";

    String END_POINT = "/ws";
    String[] APPLICATION_DES_PREFIXES = {"/app"};
    String[] BROKER_DES_PREFIXES = {"/topic"};
    String USER_DES_PREFIX = "/user";

    String DES_TOPIC_CLASSROOM = "/topic/classroom";
}
