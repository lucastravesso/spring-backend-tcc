package com.system.backend.inbound.facade.impl;

import com.system.backend.core.entity.User;
import com.system.backend.core.service.UserService;
import com.system.backend.inbound.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Override
    public void createUser(User user) {

    }

    @Override
    public void createUsers(List<User> userList) {

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
