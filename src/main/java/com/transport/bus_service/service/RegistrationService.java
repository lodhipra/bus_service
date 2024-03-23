package com.transport.bus_service.service;

import com.transport.bus_service.model.request.RegistrationRequest;
import com.transport.bus_service.model.response.RegistrationResponse;

public interface RegistrationService {

    String createRegistration(RegistrationRequest request);

    RegistrationResponse getRegistration(String userName);

    void deleteRegistration(String username);
}
