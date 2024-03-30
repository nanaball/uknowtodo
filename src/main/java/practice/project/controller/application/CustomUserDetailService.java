package practice.project.controller.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import practice.project.domain.application.MemberService;
import practice.project.domain.application.exception.RegisterFailException;
import practice.project.domain.application.vo.MemberInfoVO;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final BCryptPasswordEncoder encoder;
    private final MemberService memberService;

    public Long joinMember(String id, String password, String name) throws RegisterFailException {
        String encryptedPassword = encoder.encode(password);
        return memberService.register(id, encryptedPassword, name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws AuthenticationException {
        MemberInfoVO memberInfoVO = memberService.login(username);
        return new CustomUserDetails(memberInfoVO.getMemberNo(), memberInfoVO.getId(), memberInfoVO.getEncryptedPassword(), memberInfoVO.getName());
    }
}
