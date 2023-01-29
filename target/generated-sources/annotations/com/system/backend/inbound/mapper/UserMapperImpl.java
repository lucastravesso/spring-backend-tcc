package com.system.backend.inbound.mapper;

import com.system.backend.core.entity.Profiles;
import com.system.backend.core.entity.User;
import com.system.backend.inbound.dto.UserDTO;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T13:53:22-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setUserName( userDTO.getUserName() );
        user.setMail( userDTO.getMail() );
        user.setPassword( userDTO.getPassword() );
        Set<Profiles> set = userDTO.getProfiles();
        if ( set != null ) {
            user.setProfiles( new HashSet<Profiles>( set ) );
        }

        return user;
    }
}
