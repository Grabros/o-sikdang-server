package dev.grabros.osikdang.global.error;

import dev.grabros.osikdang.global.error.exception.CategoryNotFoundException;
import dev.grabros.osikdang.global.error.exception.openApi.InvalidRequestException;
import dev.grabros.osikdang.global.error.exception.openApi.KakaoApiException;
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

    @ExceptionHandler
    public ResponseEntity<Void> catchInvalidRequestException(InvalidRequestException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Void> catchKakaoApiException(KakaoApiException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
