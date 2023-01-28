package com.system.backend.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User extends AbstractPersistenceEntity {

    @Column(name = "Login")
    private String login;

    @Column(name = "Email")
    private String mail;

    @Column(name = "Password")
    private String password;

    @OneToOne
    private UserDetails userDetails;

}
