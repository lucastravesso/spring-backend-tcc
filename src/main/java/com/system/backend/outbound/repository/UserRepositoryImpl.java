package com.system.backend.outbound.repository;

import com.system.backend.core.entity.User;
import com.system.backend.core.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepositoryImpl extends JpaRepository<User, UUID>, UserRepository {

    @Query(value = "SELECT a FROM User a WHERE a.userName = :username AND a.active is true")
    User findByUserNameAndActive(String username);

    @Query(value = "SELECT a FROM User a WHERE a.mail = :email AND a.active is true")
    User findByMailAndActive(String email);

    @Query(value = "SELECT a FROM User a WHERE a.active is true AND a.id in :usersId")
    List<User> findAllByIdAndActive(List<UUID> usersId);

    @Query(value = "SELECT a FROM User a WHERE a.active is true AND a.id = :userId")
    User findByIdAndActive(UUID userId);
}
