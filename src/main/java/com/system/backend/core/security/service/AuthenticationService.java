package com.system.backend.core.security.service;

import com.system.backend.core.exception.UserExceptionHandler;
import com.system.backend.core.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            return (UserDetails) userRepository.findByUserName(username);
        }catch (Exception e){
            log.error("Fail to bring user details from server");
            throw UserExceptionHandler.UserException001_UserNotFound();
        }

    }
}
