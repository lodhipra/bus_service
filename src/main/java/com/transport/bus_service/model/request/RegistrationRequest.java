package com.transport.bus_service.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private long contact;
    private String address;
    private String retryPassword;
    private String password;

}
