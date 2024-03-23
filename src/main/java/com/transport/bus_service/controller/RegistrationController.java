package com.transport.bus_service.controller;

import com.transport.bus_service.model.request.RegistrationRequest;
import com.transport.bus_service.model.response.RegistrationResponse;
import com.transport.bus_service.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

public class RegistrationController {

    private final RegistrationService service;

    @Autowired
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    // @ModelAttributes
    @GetMapping("/registration/{username}")
    public String formGetRegistration(Model model , String username) {

        RegistrationResponse registration = service.getRegistration(username);

        model.addAttribute("registrationrequest", registration);
        model.addAttribute("pageTitle", "Login Page");

        return "";
    }

    @GetMapping("/api/registration /{username}")
    public ResponseEntity<RegistrationResponse> apiGetRegistration(@RequestParam String username) {
        RegistrationResponse response = service.getRegistration(username);

        if(response !=null)
        {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

}
