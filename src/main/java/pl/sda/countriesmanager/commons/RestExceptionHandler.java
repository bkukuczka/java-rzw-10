package pl.sda.countriesmanager.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sda.countriesmanager.commons.exceptions.ResourceNotFound;

@ControllerAdvice
public class RestExceptionHandler {

    //TODO implement fancy json body exception message
    @ExceptionHandler(value = {ResourceNotFound.class})
    public ResponseEntity<Object> handleResourceNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), null, HttpStatus.NOT_FOUND);
    }
}
