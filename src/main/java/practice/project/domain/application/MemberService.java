package practice.project.domain.application;

import org.springframework.security.core.AuthenticationException;
import practice.project.domain.application.exception.RegisterFailException;
import practice.project.domain.application.vo.MemberInfoVO;

public interface MemberService {
    Long register(String id, String encryptedPassword, String name) throws RegisterFailException;
    MemberInfoVO login(String id) throws AuthenticationException;

    boolean hasSameId(String id);
}
