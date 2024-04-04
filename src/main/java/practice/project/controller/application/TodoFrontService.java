package practice.project.controller.application;

import practice.project.controller.api.dto.TodoRequestDto;
import practice.project.controller.pages.dto.PageDto;
import practice.project.controller.pages.dto.TodoResponseDto;

public interface TodoFrontService {
    PageDto<TodoResponseDto> getTodoList(int page);
    Long writeTodo(TodoRequestDto todo);
    Long changeTodoStatus(Long todoNo, boolean status);
}
