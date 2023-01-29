package com.system.backend.core.repository;

import com.system.backend.core.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    User findByUserNameAndActive(String username);

    User findByMailAndActive(String email);

    List<User> findAllByIdAndActive(List<UUID> usersId);

    User findByIdAndActive(UUID userId);
}
