package softarex.gorbachev.springbootrestclassroom.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import softarex.gorbachev.springbootrestclassroom.exceptions.UserServiceException;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represent space for to handle certain
 * exception within entire application
 *
 * @author Gorabachev I. D.
 * @version 14.07.2022
 */
@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {UserServiceException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, String> handleException(Exception ex) {
        Map<String, String> map = new HashMap<>();
        map.put("internalError", ex.getMessage());

        return map;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> map = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError -> map.put(fieldError.getField(),
                fieldError.getDefaultMessage()));

        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Map<String, String> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, String> map = new HashMap<>();
        e.getConstraintViolations().forEach(violation -> map.put(violation.getPropertyPath().toString(),
                violation.getMessage()));

        return map;
    }
}
