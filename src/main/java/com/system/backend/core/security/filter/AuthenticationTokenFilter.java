package com.system.backend.core.security.filter;

import com.system.backend.core.entity.User;
import com.system.backend.core.exception.UserExceptionHandler;
import com.system.backend.core.repository.UserRepository;
import com.system.backend.core.security.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = restoreToken(request);
        boolean valid = tokenService.isValidToken(token);
        if (valid) {
            authenticateUser(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticateUser(String token) {

        UUID idUser = tokenService.getIdUser(token);
        Optional<User> user = userRepository.findById(idUser);
        if(user.isEmpty()) throw UserExceptionHandler.UserException001_UserNotFound();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.get(), null, user.get().getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String restoreToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7);
    }

}
