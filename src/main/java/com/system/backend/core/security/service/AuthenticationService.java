package com.system.backend.core.security.service;

import com.system.backend.core.entity.User;
import com.system.backend.core.exception.SecurityExceptionHandler;
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
            if (userRepository.findByUserNameAndActive(login) != null){
                ud = userRepository.findByUserNameAndActive(login);
            }else{
                ud = userRepository.findByMailAndActive(login);
            }
            return ud;
        }catch (Exception e){
            log.error("Fail to bring user details from server");
            throw UserExceptionHandler.UserException001_UserNotFound();
        }
    }

    public UserTokenDetails getCurrent() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User ud;
        try{
            ud = userRepository.findByUserNameAndActive(userDetails.getUsername());
        }catch (Exception e){
            throw SecurityExceptionHandler.SecurityException001_UserNotFound();
        }
        if (ud == null){
            ud = userRepository.findByMailAndActive(userDetails.getUsername());
        }
        return UserTokenDetails.builder()
                .id(ud.getId().toString())
                .userName(ud.getUsername())
                .email(ud.getMail())
                .profiles(ud.getProfiles())
                .build();
    }

}
