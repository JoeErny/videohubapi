package org.cnam.videohub.domain.service;


import org.cnam.videohub.controller.dto.browsingvideos.VideoRequest;
import org.cnam.videohub.controller.dto.browsingvideos.VideoResponse;
import org.cnam.videohub.controller.dto.customermanagement.UserRegistrationRequest;
import org.cnam.videohub.controller.dto.customermanagement.UserRegistrationWithSponsorRequest;
import org.cnam.videohub.controller.dto.customermanagement.UserResponse;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerRegistrationService {
    private final static String registerNewUserUrl = "http://localhost:8080/videohub/rest/registration/user";
    private final static String registerNewUserWithSponsorUrl = "http://localhost:8080/videohub/rest/registration/user/with_sponsor";


    public UserResponse registerNewUser(UserRegistrationRequest userToRegisterRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<UserRegistrationRequest> userRequestHttp = new HttpEntity<>(userToRegisterRequest);
        return restTemplate.postForObject(registerNewUserUrl, userRequestHttp, UserResponse.class);
    }

    public UserResponse registerNewUserWithSponsor(UserRegistrationWithSponsorRequest userToRegisterRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<UserRegistrationWithSponsorRequest> userRequestHttp = new HttpEntity<>(userToRegisterRequest);
        return restTemplate.postForObject(registerNewUserWithSponsorUrl, userRequestHttp, UserResponse.class);
    }
}
