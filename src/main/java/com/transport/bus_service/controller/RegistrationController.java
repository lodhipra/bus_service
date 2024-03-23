package com.transport.bus_service.controller;

import com.transport.bus_service.model.request.RegistrationRequest;
import com.transport.bus_service.model.response.RegistrationResponse;
import com.transport.bus_service.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.Set;

public class RegistrationController {

    private final RegistrationService service;

    @Autowired
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    // @ModelAttributes
    @GetMapping("/registration")
    public String formGetRegistration(Model model) {

        RegistrationResponse registration = service.getRegistration();

        model.addAttribute("registrationrequest", registration);
        model.addAttribute("subscriptions", getSubscriptions());
        model.addAttribute("pageTitle", "Login Page");

        return WebPage.REGISTRATION_PAGE.getPage();
    }

    @GetMapping("/api/registration")
    public ResponseEntity<RegistrationResponse> apiGetRegistration() {
        RegistrationResponse response = service.getRegistration();


        if(response !=null)
        {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/registration/save")
    public ResponseEntity<RegistrationResponse> apiSaveRegistration(RegistrationRequest registrationRequest) {

        log.info("Registration details received :{}", registrationRequest);
        RegistrationResponse response = service.createOrUpdateRegistration(registrationRequest);
        if (response!=null){
            return ResponseEntity.accepted().body(response);
        }

        throw new RegistrationException(Messages.REGISTRATION_ERROR.getMessage());
    }

    @PostMapping("/registration/save")
    public String formSaveRegistration(RegistrationRequest registrationRequest , Model model) {

        log.info("Registration details received :{}", registrationRequest);
        RegistrationResponse response = service.createOrUpdateRegistration(registrationRequest);

        if (response!=null){

            model.addAttribute("response", Messages.REGISTRATION_SUCCESSFUL.getMessage());
            return WebPage.CONFIRM_REGISTRATION.getPage();
        }

        model.addAttribute("response", Messages.REGISTRATION_SUCCESSFUL.getMessage());
        return WebPage.ERROR_PAGE.getPage();
    }

    @GetMapping(value = "/subscriptions")
    public Set<Map.Entry<String, String>> getSubscriptions() {
        return Subscription.getSubscriptions().entrySet();
    }



}
