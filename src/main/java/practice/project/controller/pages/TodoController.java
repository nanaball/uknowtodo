package practice.project.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    @GetMapping("/")
    public String base() {
        return "redirect:/todo";
    }

    @GetMapping("/todo")
    public String todo() {
        return "todo";
    }
}
