package practice.project.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import practice.project.controller.api.dto.ResponseDto;

@ControllerAdvice(basePackages = "practice.project.controller.api")
public class ApiErrorControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto<String> errorHandler(final Throwable e) {
        e.printStackTrace();
        return ResponseDto.ofFailure(e.getMessage());
    }
}
