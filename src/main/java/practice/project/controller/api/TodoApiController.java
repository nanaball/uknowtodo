package practice.project.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practice.project.controller.api.dto.ResponseDto;
import practice.project.controller.api.dto.TodoRequestDto;
import practice.project.controller.application.TodoFrontService;
import practice.project.controller.pages.dto.TodoResponseDto;

@RestController
@RequiredArgsConstructor
public class TodoApiController {
    private final TodoFrontService todoFrontService;

    @PostMapping("/api/todo")
    public ResponseDto<TodoResponseDto> write(@RequestBody String todoName) {
        TodoResponseDto dto = todoFrontService.writeTodo(todoName);
        return ResponseDto.ofSuccess(dto);
    }

    @PostMapping("/api/todo/{todoNo}")
    public ResponseDto<TodoResponseDto> update(@PathVariable("todoNo") String todoNo, TodoRequestDto data) {
        Long todoLong = Long.parseLong(todoNo);
        TodoResponseDto dto = todoFrontService.updateTodo(todoLong, data);
        return ResponseDto.ofSuccess(dto);
    }

    @PostMapping("/api/todo/{todoNo}/status")
    public ResponseDto<TodoResponseDto> updateStatus(@PathVariable("todoNo") String todoNo, @RequestBody Boolean completed) {
        Long todoLong = Long.parseLong(todoNo);
        TodoResponseDto dto = todoFrontService.changeTodoStatus(todoLong, completed);
        return ResponseDto.ofSuccess(dto);
    }

    @PostMapping("/api/todo/{todoNo}/delete")
    public ResponseDto<Long> delete(@PathVariable("todoNo") String todoNo) {
        Long todoLong = Long.parseLong(todoNo);
        todoFrontService.deleteTodo(todoLong);
        return ResponseDto.ofSuccess(todoLong);
    }
}
