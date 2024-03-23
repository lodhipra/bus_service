package com.transport.bus_service.service.impl;

import com.transport.bus_service.entity.LoginDetail;
import com.transport.bus_service.entity.RegistrationDetail;
import com.transport.bus_service.exception.RegistrationException;
import com.transport.bus_service.model.request.RegistrationRequest;
import com.transport.bus_service.model.response.RegistrationResponse;
import com.transport.bus_service.repository.LoginRepository;
import com.transport.bus_service.repository.RegistrationRepository;
import com.transport.bus_service.service.RegistrationService;
import com.transport.bus_service.util.Messages;
import com.transport.bus_service.util.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {


    private final RegistrationRepository registrationRepository;

    private final LoginRepository loginRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final Utils util;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository, LoginRepository loginRepository, ModelMapper mapper, PasswordEncoder passwordEncoder, Utils util) {
        this.registrationRepository = registrationRepository;
        this.loginRepository = loginRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.util = util;
    }

    @Override
    @Transactional
    public String createRegistration(RegistrationRequest request) {
        Optional<LoginDetail> responseDetail = loginRepository.findByUserNameORUser_Email(request.getUsername() , request.getEmail());

        RegistrationDetail registrationDetail;
        LoginDetail loginDetail;

        if (responseDetail.isPresent()) {
                throw new RegistrationException(Messages.RECORD_ALREADY_EXISTS.getMessage());
        }

        registrationDetail = new RegistrationDetail(request.getEmail() , request.getFirstName() , request.getLastName() , request.getContact() , request.getAddress());

        RegistrationDetail savedDetail = registrationRepository.save(registrationDetail);

        loginDetail = new LoginDetail(savedDetail , request.getEmail(), request.getPassword());

        loginRepository.save(loginDetail);

        return Messages.REGISTRATION_SUCCESSFUL.getMessage();

    }

    @Override
    @Transactional
    public String updateRegistration(RegistrationRequest request) {
        Optional<LoginDetail> responseDetail = loginRepository.findByUserNameORUser_Email(request.getUsername() , request.getEmail());

        RegistrationDetail registrationDetail;
        LoginDetail loginDetail;

        if (responseDetail.isEmpty()) {
            throw new RegistrationException(Messages.COULD_NOT_UPDATE_RECORD.getMessage());
        }

        registrationDetail = new RegistrationDetail(request.getEmail() , request.getFirstName() , request.getLastName() , request.getContact() , request.getAddress());

        registrationDetail.setId(responseDetail.get().getUser().getId());

        RegistrationDetail savedDetail = registrationRepository.save(registrationDetail);

        loginDetail = new LoginDetail(savedDetail , request.getEmail(), request.getPassword());

        loginDetail.setId(responseDetail.get().getId());

        loginRepository.save(loginDetail);

        return Messages.UPDATE_RECORD_SUCCESSFUL.getMessage();

    }

    @Override
    public RegistrationResponse getRegistration(String userName) {
        Optional<LoginDetail> responseDetail = loginRepository.findByUserNameORUser_Email(userName , userName);

        if (responseDetail.isPresent()) {
            RegistrationResponse response = mapper.map(responseDetail.get().getUser(), RegistrationResponse.class);

            return response;
        } else {
            return new RegistrationResponse();
        }
    }

    @Override
    @Transactional
    public void deleteRegistration(String username) {
        Optional<LoginDetail> responseDetail = loginRepository.findByUserNameORUser_Email(username , username);

        if (responseDetail.isPresent()) {
            loginRepository.delete(responseDetail.get());
            registrationRepository.delete(responseDetail.get().getUser());
        }
    }


}

