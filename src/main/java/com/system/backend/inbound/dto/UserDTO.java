package com.system.backend.inbound.dto;

import com.system.backend.core.entity.Profiles;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private UUID id;

    private String userName;

    private String mail;

    private String password;

    private Set<Profiles> profiles = new HashSet<>();


}
