package practice.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import practice.project.util.LoginUtil;

@Controller
public class SignInController {

    @GetMapping("/sign-in")
    public String signInPage() {
        if (LoginUtil.isLogin()) {
            return "redirect:/todo";
        }
        return "sign-in";
    }

    @GetMapping("/sign-up")
    public String signUpPage() {
        return "sign-up";
    }
}
