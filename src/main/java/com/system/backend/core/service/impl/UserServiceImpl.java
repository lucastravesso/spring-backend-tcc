package com.system.backend.core.service.impl;

import com.system.backend.core.entity.User;
import com.system.backend.core.exception.UserExceptionHandler;
import com.system.backend.core.repository.UserRepository;
import com.system.backend.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        user.setActive(true);
        user.setInsertionDate(LocalDate.now());

        try{
            userRepository.save(user);
        }catch (Exception e){
            log.error("Fail to save user in database, check the exception to catch it.", e);
            throw UserExceptionHandler.UserException002_FailToCreateUser();
        }
    }

    @Override
    public void createUsers(List<User> userList) {
        userList.forEach(u -> {
            u.setActive(true);
            u.setInsertionDate(LocalDate.now());
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
        return null;
    }

    @Override
    public List<User> getUsersByIds(List<UUID> idList) {
        return null;
    }
}
