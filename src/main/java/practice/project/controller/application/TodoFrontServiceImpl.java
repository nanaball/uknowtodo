package practice.project.controller.application;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import practice.project.controller.api.dto.TodoRequestDto;
import practice.project.controller.pages.dto.PageDto;
import practice.project.controller.pages.dto.TodoResponseDto;
import practice.project.domain.application.TodoService;
import practice.project.domain.entity.Todo;
import practice.project.util.LoginUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoFrontServiceImpl implements TodoFrontService {
    private final TodoService todoService;
    private int pageSize = 3;

    @Override
    public PageDto<TodoResponseDto> getTodoList(int page) {
        Long memberNo = LoginUtil.getMemberNo();
        Page<Todo> content = todoService.findTodo(memberNo, page - 1, pageSize);
        if (content.getContent().isEmpty()) {
            return PageDto.of(List.of(), page, 0, pageSize);
        }
        List<TodoResponseDto> convertedContentList =
                content.getContent().stream().map(TodoResponseDto::toDto).toList();
        return PageDto.of(convertedContentList, page, content.getTotalElements(), pageSize);
    }

    @Override
    public TodoResponseDto writeTodo(String todoName) {
        Long memberNo = LoginUtil.getMemberNo();
        Todo todoResult = todoService.save(todoName, memberNo);
        return TodoResponseDto.toDto(todoResult);
    }

    @Override
    public TodoResponseDto updateTodo(Long todoNo, TodoRequestDto todoRequestDto) {
        Todo todoResult = todoService.updateTodo(todoNo, todoRequestDto);
        return TodoResponseDto.toDto(todoResult);
    }

    @Override
    public TodoResponseDto changeTodoStatus(Long todoNo, boolean completed) {
        Todo todoResult = todoService.changeCompleted(todoNo, completed);
        return TodoResponseDto.toDto(todoResult);
    }

    @Override
    public void deleteTodo(Long todoNo) {
        todoService.deleteTodo(todoNo);
    }
}
