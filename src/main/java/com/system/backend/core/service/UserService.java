package com.system.backend.core.service;

import com.system.backend.core.entity.User;
import jdk.jfr.Description;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void createUser(User user);
    @Description("Only to add so many users in one request")
    void createUsers(List<User> userList);
    void updateUser(User user);
    @Description("Only inactivate the user passed by Id")
    void deleteUser(UUID idUser);
    User getUser(UUID idUser);
    List<User> getUsersByIds(List<UUID> idList);
}
