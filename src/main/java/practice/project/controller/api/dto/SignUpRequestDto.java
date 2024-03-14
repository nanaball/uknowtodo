package practice.project.controller.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class SignUpRequestDto implements Serializable {

    private String username;
    private String password;
    private String name;
}
