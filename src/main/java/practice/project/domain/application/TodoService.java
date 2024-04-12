package practice.project.domain.application;

import org.springframework.data.domain.Page;
import practice.project.controller.api.dto.TodoRequestDto;
import practice.project.domain.entity.Todo;

public interface TodoService {
    Todo save(String todoName, Long memberNo);
    Todo updateTodo(Long todoNo, TodoRequestDto requestDto);
    Todo changeCompleted(Long todoNo, boolean completed);
    void deleteTodo(Long todoNo);
    Page<Todo> findTodo(Long memberNo, int page, int pageSize);
}
