package softarex.gorbachev.springbootrestclassroom.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import softarex.gorbachev.springbootrestclassroom.exceptions.UserServiceException;

@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
