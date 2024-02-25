package practice.project.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class LoginUtil {
    private LoginUtil () {

    }
    public static boolean isLogin() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return !(principal instanceof String);
    }
}
