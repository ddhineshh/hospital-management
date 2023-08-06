package com.healthconnect.service.services.impl;

import com.healthconnect.service.repository.UserRepository;
import com.healthconnect.service.request.LoginUserRequest;
import com.healthconnect.service.response.UserResponse;
import com.healthconnect.service.services.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class HospitalServiceImpl implements HospitalService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse getUserLoginData(LoginUserRequest loginUserRequest) {

    }
}