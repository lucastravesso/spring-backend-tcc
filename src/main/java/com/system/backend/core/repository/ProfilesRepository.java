package com.system.backend.core.repository;

import com.system.backend.core.entity.Profiles;
import com.system.backend.core.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfilesRepository extends CrudRepository<Profiles, UUID> {

}
