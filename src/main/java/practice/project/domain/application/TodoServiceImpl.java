package practice.project.domain.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.project.domain.entity.Todo;
import practice.project.domain.entity.TodoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public void saveTodo() {
        // todo for 수연
    }

    @Transactional
    public void updateTodoStatus() {
        // todo for 수연
    }

    @Transactional
    public List<Todo> findTodo(Long memberNo) {
        // todo for 수연

        return null;
    }
}
