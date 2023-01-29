package com.system.backend.core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "UserProfile")
public class Profiles extends AbstractPersistenceEntity implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Column(name = "ProfileName")
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
