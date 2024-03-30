package practice.project.domain.application.exception;

import lombok.Getter;
import org.springframework.security.core.AuthenticationException;

@Getter
public class RegisterFailException extends AuthenticationException {
    public RegisterFailException(String msg) {
        super(msg);
    }
}
