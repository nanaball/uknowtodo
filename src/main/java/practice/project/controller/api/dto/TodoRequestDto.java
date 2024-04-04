package practice.project.controller.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TodoRequestDto implements Serializable {
    private Long todoNo;
    private String todoName;
    private String todoContent;
    private boolean completed;
    private boolean deleted;
    private String todoDate; // YYYY-MM-ddTHH:mm:ss
}
