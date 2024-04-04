package practice.project.controller.pages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import practice.project.controller.application.TodoFrontService;
import practice.project.controller.pages.dto.PageDto;
import practice.project.controller.pages.dto.TodoResponseDto;
import practice.project.controller.pages.exception.BadInputException;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoFrontService todoFrontService;

    @GetMapping("/")
    public String base() {
        return "redirect:/todo";
    }

    @GetMapping("/todo")
    public String todo(@RequestParam(defaultValue = "1") int page, Model model) {
        if (page < 1) {
            return "redirect:/todo";
        }
        PageDto<TodoResponseDto> content = todoFrontService.getTodoList(page);
        if (page > content.getTotalPages()) {
            throw new BadInputException();
        }
        model.addAttribute("content", content);
        return "todo";
    }

    @ExceptionHandler(value = { MethodArgumentTypeMismatchException.class, BadInputException.class })
    public String pageInputErrorControl() {
        return "redirect:todo";
    }

}
