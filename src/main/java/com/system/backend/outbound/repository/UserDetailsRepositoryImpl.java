package com.system.backend.outbound.repository;

import com.system.backend.core.entity.User;
import com.system.backend.core.entity.UserDetails;
import com.system.backend.core.repository.UserDetailsRepository;
import com.system.backend.core.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDetailsRepositoryImpl extends JpaRepository<UserDetails, UUID>, UserDetailsRepository {
}
