package com.system.backend.inbound.controller;

import com.system.backend.core.entity.User;
import com.system.backend.core.security.inf.UserTokenDetails;
import com.system.backend.core.security.service.AuthenticationService;
import com.system.backend.core.security.service.TokenService;
import com.system.backend.inbound.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v01/tcc-spring-api/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDTO> authenticate(@RequestParam(value = "email", required = false) String email,
                                                 @RequestParam(value = "username", required = false) String username,
                                                 @RequestParam(value = "password", required = false) String password) {

        UsernamePasswordAuthenticationToken dadosLogin;
        if (email != null) {
            User user = new User();
            user.setMail(email);
            user.setPassword(password);
            dadosLogin = user.converterEmail();
        } else {
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            dadosLogin = user.converterUsername();
        }

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "me")
    public UserTokenDetails getCurrent() {
        return authService.getCurrent();
    }
}
