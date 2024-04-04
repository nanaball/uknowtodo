package practice.project.domain.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import practice.project.domain.entity.Todo;
import practice.project.domain.entity.TodoRepository;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public void saveTodo() {
        // todo for 수연
    }

    @Transactional
    public Long updateTodoStatus(Long todoNo, boolean status) {
        Todo todo = todoRepository.getReferenceById(todoNo);
        todo.setCompleted(status);
        todoRepository.save(todo);
        return todo.getTodoNo();
    }

    @Transactional
    public Page<Todo> findTodo(Long memberNo, int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return todoRepository.findAllByMemberNoOrderByUpdatedDateDesc(memberNo, pageRequest);
    }
}
