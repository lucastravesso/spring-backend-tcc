package com.system.backend.inbound.mapper;

import com.system.backend.core.entity.User;
import com.system.backend.inbound.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDTO);

}
