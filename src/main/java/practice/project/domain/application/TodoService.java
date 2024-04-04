package practice.project.domain.application;

import org.springframework.data.domain.Page;
import practice.project.domain.entity.Todo;

public interface TodoService {

    Long updateTodoStatus(Long todoNo, boolean status);
    Page<Todo> findTodo(Long memberNo, int page, int pageSize);
}
