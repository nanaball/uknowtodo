package practice.project.controller.pages.dto;

import lombok.Getter;
import lombok.Setter;
import practice.project.domain.entity.Todo;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class TodoResponseDto implements Serializable {
    private Long todoNo;
    private String todoName;
    private String todoContent;
    private boolean completed;
    private String todoDate;
    private String todoTime;
    private String createdDate;
    private String updatedDate;

    public static TodoResponseDto toDto(Todo todo) {
        TodoResponseDto dto = new TodoResponseDto();
        dto.todoNo = todo.getTodoNo();
        dto.todoName = todo.getTodoName();
        dto.todoContent = todo.getTodoContent();
        dto.completed = todo.isCompleted();
        dto.todoDate = todo.getTodoDate() == null
                ? null : todo.getTodoDate().format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"));
        dto.todoTime = todo.getTodoTime() == null ? null :
                todo.getTodoTime().getMinute() == 0 ?
                        todo.getTodoTime().format(DateTimeFormatter.ofPattern("a h시 정각")) :
                        todo.getTodoTime().format(DateTimeFormatter.ofPattern("a h시 m분"));
        dto.createdDate = todo.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분 s초"));
        dto.updatedDate = todo.getUpdatedDate().format(DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분 s초"));

        return dto;
    }
}
