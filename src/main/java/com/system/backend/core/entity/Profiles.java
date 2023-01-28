package com.system.backend.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Profiles")
public class Profiles extends AbstractPersistenceEntity implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Column(name = "ProfileName")
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
