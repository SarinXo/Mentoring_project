package mvc.project.handler;

import mvc.project.handler.exception.BaseApiException;
import mvc.project.handler.model.ErrorDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ErrorDto convertErrorToDto(BaseApiException e){
        ErrorDto err = new ErrorDto();
        err.id("---");
        err.code(e.getCode());
        err.message(e.getMessage());
        err.description(e.getDescription());
        return err;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> catchResourceNotFoundException
            (BaseApiException e) {
        return new ResponseEntity<>(convertErrorToDto(e), HttpStatusCode.valueOf(500));
    }
}
