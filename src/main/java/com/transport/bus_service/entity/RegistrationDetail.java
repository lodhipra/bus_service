package com.transport.bus_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name = "registrationDetail")
@Getter
@Setter
@NoArgsConstructor
public class RegistrationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Email
    @Column(name = "email", length = 32, nullable = false)
    private String email;

    @Column(name = "firstName", length = 32, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 32, nullable = false)
    private String lastName;

    @Column(name = "contact", length = 16, nullable = false)
    private long contact;

    @Column(name = "address", length = 256, nullable = false)
    private String address;

    public RegistrationDetail(String email,String firstName, String lastName, long contact, String address) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
    }
}