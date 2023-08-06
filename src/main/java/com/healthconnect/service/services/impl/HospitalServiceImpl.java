package com.healthconnect.service.services.impl;

import com.healthconnect.service.entity.GeneralPublicUser;
import com.healthconnect.service.exception.InvalidUserLoginAccessException;
import com.healthconnect.service.repository.UserRepository;
import com.healthconnect.service.request.HospitalAccountRequest;
import com.healthconnect.service.request.LoginUserRequest;
import com.healthconnect.service.response.HospitalResponse;
import com.healthconnect.service.response.UserResponse;
import com.healthconnect.service.services.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
public class HospitalServiceImpl implements HospitalService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse getUserLoginData(LoginUserRequest loginUserRequest) {

        Optional<GeneralPublicUser> generalPublicUser = userRepository.findByEmailIdAndPassword(loginUserRequest.getEmailId(), loginUserRequest.getPassword());

        UserResponse userResponse = new UserResponse();

        if(generalPublicUser.isEmpty()){
            throw new InvalidUserLoginAccessException("no user is present with this email an password");
        }

        if(generalPublicUser.isPresent()){
            GeneralPublicUser generalPublicUserEntity = generalPublicUser.get();
            userResponse.setUserId(generalPublicUserEntity.getUserId());
            userResponse.setEmailId(generalPublicUserEntity.getEmailId());
            userResponse.setFirstName(generalPublicUserEntity.getFirstName());
            userResponse.setMiddleName(generalPublicUserEntity.getMiddleName());
            userResponse.setLastName(generalPublicUserEntity.getLastName());
            userResponse.setContactNumber(generalPublicUserEntity.getContactNumber());
            userResponse.setStreetName(generalPublicUserEntity.getStreetName());
            userResponse.setCity(generalPublicUserEntity.getCity());
            userResponse.setZipCode(generalPublicUserEntity.getZipCode());
            userResponse.setState(generalPublicUserEntity.getState());
            userResponse.setEmergencyContactName(generalPublicUserEntity.getEmergencyContactName());
            userResponse.setEmergencyContactNumber(generalPublicUserEntity.getEmergencyContactNumber());
            userResponse.setUserCreatedData(generalPublicUserEntity.getUserCreatedData());
        }

        return userResponse;
    }

    @Override
    public HospitalResponse createHospitalResponse(HospitalAccountRequest hospitalAccountRequest) {



        return null;

    }


}
