package com.system.backend.core.service.impl;

import com.system.backend.core.entity.Profiles;
import com.system.backend.core.entity.User;
import com.system.backend.core.exception.UserExceptionHandler;
import com.system.backend.core.repository.ProfilesRepository;
import com.system.backend.core.repository.UserRepository;
import com.system.backend.core.security.service.EncoderService;
import com.system.backend.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfilesRepository profilesRepository;

    @Autowired
    private EncoderService encoderService;
    @Override
    public void createUser(User user) {
        user.setActive(true);
        user.setInsertionDate(LocalDate.now());
        user.setPassword(encoderService.encoder(user.getPassword()));
        List<Profiles> profile = (List<Profiles>) profilesRepository.findAll();
        Set<Profiles> role = profile.stream().filter(p -> p.getName().equals("SIMPLE"))
                .collect(Collectors.toSet());
        user.setProfiles(role);

        try{
            userRepository.save(user);
        }catch (Exception e){
            log.error("Fail to save user in database, check the exception to catch it.", e);
            throw UserExceptionHandler.UserException002_FailToCreateUser();
        }
    }

    @Override
    public void createUsers(List<User> userList) {
        List<Profiles> profile = (List<Profiles>) profilesRepository.findAll();
        userList.forEach(u -> {
            u.setActive(true);
            u.setInsertionDate(LocalDate.now());
            Set<Profiles> role = profile.stream().filter(p -> p.getName().equals("ROLE_SIMPLES"))
                    .collect(Collectors.toSet());
            u.setProfiles(role);
        });

        try{
            userRepository.saveAll(userList);
        }catch (Exception e){
            log.error("Fail to save some user in database, check the exception to catch it.", e);
            throw UserExceptionHandler.UserException002_FailToCreateUser();
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(UUID idUser) {

    }

    @Override
    public User getUser(UUID idUser) {
        try {
            return userRepository.findByIdAndActive(idUser);
        }catch (Exception e){
            throw UserExceptionHandler.UserException001_UserNotFound();
        }
    }

    @Override
    public List<User> getUsersByIds(List<UUID> idList) {
        return null;
    }
}
