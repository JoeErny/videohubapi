package org.cnam.videohub.controller.restcontroller;

import org.cnam.videohub.controller.dto.customermanagement.UserRegistrationRequest;
import org.cnam.videohub.controller.dto.customermanagement.UserRegistrationWithSponsorRequest;
import org.cnam.videohub.controller.dto.customermanagement.UserResponse;
import org.cnam.videohub.domain.service.BrowsingVideoService;
import org.cnam.videohub.domain.service.CustomerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
public class CustomerRegistrationController {


    @Autowired
    CustomerRegistrationService customerRegistrationService;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRegistrationRequest userToRegisterRequest) {
        UserResponse userResponse =customerRegistrationService.registerNewUser(userToRegisterRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/register/with_sponsor")
    @ResponseBody
    public ResponseEntity<UserResponse> registerUserWithSponsor(@RequestBody UserRegistrationWithSponsorRequest userToRegisterRequest) {

        UserResponse userResponse = customerRegistrationService.registerNewUserWithSponsor(userToRegisterRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
