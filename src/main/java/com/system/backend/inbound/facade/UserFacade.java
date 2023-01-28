package com.system.backend.inbound.facade;

import com.system.backend.core.entity.User;
import com.system.backend.inbound.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserFacade {

    void createUser(UserDTO user);

    void createUsers(List<UserDTO> userList);

    void updateUser(UserDTO user);

    void deleteUser(UUID idUser);

    User getUser(UUID idUser);

    List<User> getUsersByIds(List<UUID> idList);
}
