package com.system.backend.core.security.service;

import com.system.backend.core.entity.User;
import com.system.backend.core.security.inf.UserTokenDetails;
import com.system.backend.core.exception.UserExceptionHandler;
import com.system.backend.core.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try{
            UserDetails ud;
            if (userRepository.findByUserName(login) != null){
                ud = userRepository.findByUserName(login);
            }else{
                ud = userRepository.findByMail(login);
            }
            return ud;
        }catch (Exception e){
            log.error("Fail to bring user details from server");
            throw UserExceptionHandler.UserException001_UserNotFound();
        }
    }

    public UserTokenDetails getCurrent() {
        // TODO resolver problema do /me ao retornar dados do usuario
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User ud;
        if (userRepository.findByUserName(userDetails.getUsername()) != null){
            ud = userRepository.findByUserName(userDetails.getUsername());
        }else{
            ud = userRepository.findByMail(userDetails.getUsername());
        }
        return UserTokenDetails.builder()
                .id(ud.getId().toString())
                .email(ud.getMail())
                .profiles(ud.getProfiles())
                .build();
    }

}
