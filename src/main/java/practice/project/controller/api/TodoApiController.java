package practice.project.controller.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.project.controller.api.dto.ResponseDto;
import practice.project.controller.api.dto.TodoRequestDto;

@RestController
public class TodoApiController {

    @PostMapping("/api/todo")
    public ResponseDto<Long> write(TodoRequestDto data, HttpServletRequest request) {
        return ResponseDto.ofSuccess(1L);
    }
}
