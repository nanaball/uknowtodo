package practice.project.controller.pages;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

@ControllerAdvice(basePackages = "practice.project.controller.pages")
public class ErrorControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String errorHandler(final Throwable e, final Model model) {
        model.addAttribute("e", e);
        model.addAttribute("list", Arrays.stream(e.getStackTrace()).map(StackTraceElement::toString));
        return "error";
    }
}
