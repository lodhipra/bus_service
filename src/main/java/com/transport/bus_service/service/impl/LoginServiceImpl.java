package com.transport.bus_service.service.impl;

import com.transport.bus_service.entity.LoginDetail;
import com.transport.bus_service.repository.LoginRepository;
import com.transport.bus_service.service.LoginService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<LoginDetail> responseDetail =  loginRepository.findByUserNameORUser_Email(username , username);

        if (responseDetail.isPresent()){
            return responseDetail.get();
        }

        return null;
    }
}
