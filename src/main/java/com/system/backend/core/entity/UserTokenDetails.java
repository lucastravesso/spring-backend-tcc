package com.system.backend.core.entity;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTokenDetails extends AbstractPersistenceEntity {

    private String id;
    private String username;
    private String email;
    private Set<Profiles> profiles;
}
