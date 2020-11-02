package dev.grabros.osikdang.global.error;

import dev.grabros.osikdang.global.error.exception.CategoryNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<Void> catchCategoryNotFoundException(CategoryNotFoundException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
