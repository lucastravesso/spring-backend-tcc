package com.system.backend.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User extends AbstractPersistenceEntity implements UserDetails {

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Email")
    private String mail;

    @Column(name = "Password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Profiles> profiles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.profiles;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UsernamePasswordAuthenticationToken converterUsername() {
        return new UsernamePasswordAuthenticationToken(userName, password);
    }
    public UsernamePasswordAuthenticationToken converterEmail() {
        return new UsernamePasswordAuthenticationToken(mail, password);
    }
}
