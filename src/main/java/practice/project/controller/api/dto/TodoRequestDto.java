package practice.project.controller.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TodoRequestDto implements Serializable {
    private String todoName;
    private String todoContent;
    private String todoDate; // YYYY-MM-dd
    private String todoTime; // HH:mm
}
