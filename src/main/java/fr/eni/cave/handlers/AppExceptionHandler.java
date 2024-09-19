package fr.eni.cave.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorWrapper> capturerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        CustomErrorWrapper wrapper = new CustomErrorWrapper();
        ex.getFieldErrors().forEach(err -> wrapper.addMessage(err.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(wrapper);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> capturerException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
    }
}
