package practice.project.controller.application;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Getter
public class CustomUserDetails extends User {
    private static final String defaultAuthority = "USER";
    private final Long memberNo;
    private final String name;

    public CustomUserDetails(Long memberNo, String id, String password, String name) {
        super(id, password, AuthorityUtils.createAuthorityList(defaultAuthority));
        this.memberNo = memberNo;
        this.name = name;
    }
}
