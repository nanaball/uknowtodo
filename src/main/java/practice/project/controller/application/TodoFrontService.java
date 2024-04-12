package practice.project.controller.application;

import practice.project.controller.api.dto.TodoRequestDto;
import practice.project.controller.pages.dto.PageDto;
import practice.project.controller.pages.dto.TodoResponseDto;

public interface TodoFrontService {
    PageDto<TodoResponseDto> getTodoList(int page);
    TodoResponseDto writeTodo(String todoName);
    TodoResponseDto updateTodo(Long todoNo, TodoRequestDto todoRequestDto);
    TodoResponseDto changeTodoStatus(Long todoNo, boolean status);
    void deleteTodo(Long todoNo);
}
