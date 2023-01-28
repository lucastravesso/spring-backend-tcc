package com.system.backend.core.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncoderService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String encoder(String value) {
        return this.passwordEncoder.encode(value);
    }

    public boolean verifyPassword(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
