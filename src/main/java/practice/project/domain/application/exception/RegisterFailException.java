package practice.project.domain.application.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterFailException extends Exception {
    private final String failReason;
}
