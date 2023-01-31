package com.system.backend.inbound.mapper;

import com.system.backend.core.entity.User;
import com.system.backend.inbound.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    User toEntity(UserDTO userDTO);

}
