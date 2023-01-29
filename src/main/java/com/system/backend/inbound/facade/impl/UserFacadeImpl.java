package com.system.backend.inbound.facade.impl;

import com.system.backend.core.entity.User;
import com.system.backend.core.exception.UserExceptionHandler;
import com.system.backend.core.service.UserService;
import com.system.backend.inbound.dto.UserDTO;
import com.system.backend.inbound.facade.UserFacade;
import com.system.backend.inbound.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void createUser(UserDTO user) {
        User userConverted;
        try {
            userConverted = userMapper.toEntity(user);
        } catch (Exception e) {
            throw UserExceptionHandler.UserException003_FailToConvertUser();
        }
        userService.createUser(userConverted);
    }

    @Override
    public void createUsers(List<UserDTO> userListDto) {
        try {
            List<User> userList = userListDto.stream().map(userMapper::toEntity).collect(Collectors.toList());
            userService.createUsers(userList);
        } catch (Exception e) {
            throw UserExceptionHandler.UserException003_FailToConvertUser();
        }
    }

    @Override
    public void updateUser(UserDTO user) {
        User userConverted;
        try {
            userConverted = userMapper.toEntity(user);
        } catch (Exception e) {
            throw UserExceptionHandler.UserException003_FailToConvertUser();
        }
        userService.updateUser(userConverted);
    }

    @Override
    public void deleteUser(UUID idUser) {
        try {
            userService.deleteUser(idUser);
        } catch (Exception e) {
            throw UserExceptionHandler.UserException003_FailToConvertUser();
        }
    }

    @Override
    public User getUser(UUID idUser) {
        try {
            return userService.getUser(idUser);
        } catch (Exception e) {
            throw UserExceptionHandler.UserException003_FailToConvertUser();
        }
    }

    @Override
    public List<User> getUsersByIds(List<UUID> idList) {
        try {
            return userService.getUsersByIds(idList);
        } catch (Exception e) {
            throw UserExceptionHandler.UserException003_FailToConvertUser();
        }
    }
}
