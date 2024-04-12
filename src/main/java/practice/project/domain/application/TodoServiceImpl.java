package practice.project.domain.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import practice.project.controller.api.dto.TodoRequestDto;
import practice.project.domain.entity.Todo;
import practice.project.domain.entity.TodoRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    @Transactional
    public Todo save(String todoName, Long memberNo) {
        Todo todo = new Todo();
        todo.setTodoName(todoName);
        todo.setMemberNo(memberNo);
        return todoRepository.save(todo);
    }

    @Override
    @Transactional
    public Todo updateTodo(Long todoNo, TodoRequestDto requestDto) {
        Todo findResult = todoRepository.findById(todoNo).orElseThrow();
        if (requestDto.getTodoName() != null) {
            findResult.setTodoName(requestDto.getTodoName());
        }
        if (requestDto.getTodoContent() != null) {
            findResult.setTodoContent(requestDto.getTodoContent());
        }
        if (requestDto.getTodoDate() != null) {
            findResult.setTodoDate(LocalDate.parse(requestDto.getTodoDate()));
        }
        if (requestDto.getTodoTime() != null) {
            findResult.setTodoTime(LocalTime.parse(requestDto.getTodoTime()));
        }
        return todoRepository.save(findResult);
    }

    @Override
    @Transactional
    public Todo changeCompleted(Long todoNo, boolean completed) {
        Todo findResult = todoRepository.findById(todoNo).orElseThrow();
        if (findResult.isCompleted() == completed) {
            return findResult;
        }
        findResult.setCompleted(completed);
        return todoRepository.save(findResult);
    }

    @Override
    @Transactional
    public void deleteTodo(Long todoNo) {
        Todo findResult = todoRepository.findById(todoNo).orElseThrow();
        if (!findResult.isDeleted()) {
            findResult.setDeleted(true);
            todoRepository.save(findResult);
        }
    }

    @Override
    @Transactional
    public Page<Todo> findTodo(Long memberNo, int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return todoRepository.findAllByMemberNoAndDeletedOrderByUpdatedDateDesc(memberNo, false, pageRequest);
    }
}
