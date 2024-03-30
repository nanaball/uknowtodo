package practice.project.controller.api;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practice.project.controller.api.dto.ResponseDto;
import practice.project.controller.api.dto.SignUpRequestDto;
import practice.project.controller.application.CustomUserDetailService;
import practice.project.domain.application.MemberService;
import practice.project.domain.application.exception.RegisterFailException;

@RestController
@RequiredArgsConstructor
public class SignUpApiController {
    private final CustomUserDetailService customUserDetailService;
    private final MemberService memberService;

    @PostMapping("/api/sign-up")
    public ResponseDto<String> signUp(SignUpRequestDto data, HttpServletRequest request) {
        try {
            customUserDetailService.joinMember(data.getId(), data.getPassword(), data.getName());
            request.login(data.getId(), data.getPassword());
        } catch (RegisterFailException e) {
            return ResponseDto.ofFailure(e.getMessage());
        } catch (Exception e) {
            return ResponseDto.ofFailure("로그인에 오류가 발생했습니다.");
        }
        return ResponseDto.ofSuccess("/");
    }

    @PostMapping("/api/find-id")
    public ResponseDto<String> findId(@RequestBody String id) {
        if (StringUtils.containsWhitespace(id) || StringUtils.trimAllWhitespace(id).length() < 5) {
            return ResponseDto.ofFailure("잘못된 형식입니다. 다른 아이디를 이용하세요");
        }
        if (memberService.hasSameId(id)) {
            return ResponseDto.ofFailure("중복된 아이디입니다. 다른 아이디를 이용하세요");
        }
        return ResponseDto.ofSuccess("success");
    }
}
