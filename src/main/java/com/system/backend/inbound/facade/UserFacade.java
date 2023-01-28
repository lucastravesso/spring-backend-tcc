package com.system.backend.inbound.facade;

import com.system.backend.core.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserFacade {

    void createUser(User user);

    void createUsers(List<User> userList);

    void updateUser(User user);

    void deleteUser(UUID idUser);

    User getUser(UUID idUser);

    List<User> getUsersByIds(List<UUID> idList);
}
