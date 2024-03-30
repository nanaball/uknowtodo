package practice.project.util;

import org.springframework.security.core.context.SecurityContextHolder;
import practice.project.controller.application.CustomUserDetails;

public class LoginUtil {
    private LoginUtil () {

    }
    public static boolean isLogin() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return !(principal instanceof String);
    }

    public static Long getMemberNo() {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getMemberNo();
    }
}
