package com.transport.bus_service.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponse {
    private String firstName;
    private String lastName;
    private String email;
    private long contact;

    private long address;


    public RegistrationResponse() {

    }
}
