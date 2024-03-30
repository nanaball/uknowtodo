package practice.project.domain.application.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberInfoVO {
    Long memberNo;
    String id;
    String encryptedPassword;
    String name;
}
