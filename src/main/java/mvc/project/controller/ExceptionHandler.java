package mvc.project.controller;

import mvc.project.handler.exception.NotFoundApiException;
import mvc.project.handler.model.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class ExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    public ExceptionHandler() {
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDto> exceptionHandle(Exception ex) {
        log.error(ex.toString(), ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setId(UUID.randomUUID().toString());
        errorDto.setCode("internal_error");
        errorDto.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorDto.setDescription("Внутренняя ошибка сервера");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({NotFoundApiException.class})
    public ResponseEntity<ErrorDto> exceptionHandle(NotFoundApiException ex) {
        log.error(ex.toString(), ex);
        ErrorDto errorDto = new ErrorDto();
        errorDto.setId(UUID.randomUUID().toString());
        errorDto.setCode("not_found");
        errorDto.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
        errorDto.setDescription("Ресурс не найден");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

}

