package com.system.backend.core.repository;

import com.system.backend.core.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    User findByUserName(String username);

    User findByMail(String email);
}
