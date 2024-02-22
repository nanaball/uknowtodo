package practice.project.domain.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.project.domain.application.exception.LoginFailException;
import practice.project.domain.application.exception.RegisterFailException;
import practice.project.domain.application.vo.MemberInfoVO;
import practice.project.domain.entity.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void register(String id, String password, String name) throws RegisterFailException {
        // todo for 수연

        // try catch
        // 실패시 throw new RegisterFailException();
    }

    public MemberInfoVO login (String id, String password) throws LoginFailException {
        // todo for 수연

        // 얘도 비슷하게 해보셈 (내코드 수정해도 댐)

        return MemberInfoVO.builder().build();
    }
}
