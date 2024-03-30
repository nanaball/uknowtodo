package practice.project.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import practice.project.controller.api.dto.PageDto;

import java.util.List;

@Controller
public class TodoController {

    @GetMapping("/")
    public String base() {
        return "redirect:/todo";
    }

    @GetMapping("/todo")
    public String todo(@RequestParam(defaultValue = "1") int page, Model model) {
        List<String> l = List.of("aa","bb", "cdd", "c1c", "c3c", "c5c", "c3c2", "c42c", "c223c", "2226cc");
        PageDto<String> content = PageDto.of(l, page, 13);
        model.addAttribute("content", content);
        return "todo";
    }
}
