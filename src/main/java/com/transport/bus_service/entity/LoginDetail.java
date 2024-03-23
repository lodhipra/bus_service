package com.transport.bus_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@Entity
@Table(name = "loginDetail")
public class LoginDetail implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegistrationDetail getUser() {
        return user;
    }

    public void setUser(RegistrationDetail user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name="user_id", nullable=false)
    private RegistrationDetail user;

    @Column(name = "userName", length = 32, nullable = false)
    private String userName;

    @Column(name = "password", length = 256, nullable = false)
    private String password;

    public LoginDetail(RegistrationDetail user, String userName, String password) {
        this.user = user;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
