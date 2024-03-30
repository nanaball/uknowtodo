package practice.project.domain.application.exception;

import lombok.Getter;
import org.springframework.security.core.AuthenticationException;

@Getter
public class LoginFailException extends AuthenticationException {
    public LoginFailException(String msg) {
        super(msg);
    }
}
