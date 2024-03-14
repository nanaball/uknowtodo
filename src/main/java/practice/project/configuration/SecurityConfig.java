package practice.project.configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import practice.project.controller.application.CustomUserDetailService;
import practice.project.controller.api.dto.ResponseDto;
import practice.project.util.ObjectMapperUtil;

import java.io.IOException;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailService customUserDetailService;

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SimpleUrlAuthenticationSuccessHandler simpleUrlAuthenticationSuccessHandler() {
        return new SimpleUrlAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json");
                ObjectMapperUtil.getInstance().writeValue(response.getWriter(), ResponseDto.ofSuccess("/todo"));
            }
        };
    }

    @Bean
    public SimpleUrlAuthenticationFailureHandler simpleUrlAuthenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                ObjectMapperUtil.getInstance().writeValue(response.getWriter(), ResponseDto.ofFailure("아이디가 존재하지 않거나 비밀번호가 맞지 않습니다."));
            }
        };
    }

    @Bean
    public SecurityFilterChain webSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .securityMatcher(PathRequest.toStaticResources().atCommonLocations())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .requestCache(RequestCacheConfigurer::disable)
                .securityContext(SecurityContextConfigurer::disable)
                .sessionManagement(SessionManagementConfigurer::disable);
        return httpSecurity.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req.requestMatchers("/", "/sign-in", "/sign-up", "/api/find-id", "/api/sign-up")
                        .permitAll().anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/sign-in")
                        .loginProcessingUrl("/api/sign-in")
                        .successHandler(simpleUrlAuthenticationSuccessHandler())
                        .failureHandler(simpleUrlAuthenticationFailureHandler())
                        .permitAll())
                .logout(logout -> logout.logoutUrl("/sign-out")
                        .logoutSuccessUrl("/sign-in")
                        .permitAll());

        return httpSecurity.build();
    }
}
