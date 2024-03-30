package practice.project.domain.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practice.project.domain.application.exception.LoginFailException;
import practice.project.domain.application.exception.RegisterFailException;
import practice.project.domain.application.vo.MemberInfoVO;
import practice.project.domain.entity.Member;
import practice.project.domain.entity.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long register(String id, String encryptedPassword, String name) throws RegisterFailException {
        try {
            Member m = new Member();
            m.setId(id);
            m.setPassword(encryptedPassword);
            m.setName(name);
            memberRepository.save(m);

            return m.getMemberNo();
        } catch (Exception e) {
            // todo 로깅
            throw new RegisterFailException("회원가입에 실패하였습니다");
        }
    }

    @Override
    public MemberInfoVO login(String id) throws AuthenticationException {
        try {
            Member m = memberRepository.findFirstById(id);
            if (m == null) {
                // todo 로깅
                throw new UsernameNotFoundException("아이디 또는 비밀번호가 맞지 않습니다");
            }
            return MemberInfoVO.builder()
                    .memberNo(m.getMemberNo())
                    .id(m.getId())
                    .encryptedPassword(m.getPassword())
                    .name(m.getName())
                    .build();
        } catch (Exception e) {
            // todo 로깅
            throw new LoginFailException("로그인중 오류가 발생했습니다.");
        }
    }

    @Override
    public boolean hasSameId(String id) {
        return memberRepository.countById(id) > 0;
    }
}
