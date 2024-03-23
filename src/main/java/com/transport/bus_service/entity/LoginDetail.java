package com.transport.bus_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "loginDetail")
public class LoginDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

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

}
