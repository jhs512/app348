package com.ll.exam.app348.security.handler;

import com.ll.exam.app348.security.JwtProvider;
import com.ll.exam.app348.security.entity.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecuritySuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtProvider jwtProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(200);
        response.setContentType("application/json");
        String accessToken = jwtProvider.getAccessToken((MemberContext) authentication.getPrincipal());
        response.setHeader("accessToken", accessToken);
    }
}
