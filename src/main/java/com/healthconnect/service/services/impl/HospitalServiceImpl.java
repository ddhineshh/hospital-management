package com.healthconnect.service.services.impl;

import com.healthconnect.service.entity.GeneralPublicUser;
import com.healthconnect.service.entity.HospitalAccount;
import com.healthconnect.service.exception.InvalidUserLoginAccessException;
import com.healthconnect.service.repository.BedsOfHospitalRepository;
import com.healthconnect.service.repository.DoctorDetailsRepository;
import com.healthconnect.service.repository.HospitalBedsAvailabilityRepository;
import com.healthconnect.service.repository.HospitalRepository;
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

    @Autowired
    private BedsOfHospitalRepository bedsOfHospitalRepository;

    @Autowired
    private DoctorDetailsRepository doctorDetailsRepository;

    @Autowired
    private HospitalBedsAvailabilityRepository hospitalBedsAvailabilityRepository;

    @Autowired
    private HospitalRepository hospitalRepository;


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

        HospitalAccount hospitalAccount = new HospitalAccount();
        hospitalAccount.setHPassword(hospitalAccountRequest.getPassword());
        hospitalAccount.setHName(hospitalAccountRequest.getName());
        hospitalAccount.setHStreet(hospitalAccountRequest.getStreet());
        hospitalAccount.setHZipCode(hospitalAccountRequest.getZipCode());
        hospitalAccount.setHCity(hospitalAccountRequest.getCity());
        hospitalAccount.setHState(hospitalAccountRequest.getState());
        hospitalAccount.setHContactNumber(hospitalAccountRequest.getContactNumber());
        hospitalAccount.setHEmail(hospitalAccountRequest.getEmail());
        hospitalAccount.setHWebsite(hospitalAccountRequest.getWebsite());
        hospitalAccount.setHLabFacility(hospitalAccountRequest.getLabFacility());
        hospitalAccount.setHInsuranceAcceptance(hospitalAccountRequest.getInsuranceAcceptance());
        hospitalAccount.setHScanningFacility(hospitalAccountRequest.getScanningFacility());

        HospitalAccount hospitalEntity = hospitalRepository.saveAndFlush(hospitalAccount);

        HospitalResponse hospitalResponse = constructHospitalResponse(hospitalEntity.getHospitalId());

        return hospitalResponse;

    }

    public HospitalResponse constructHospitalResponse(Long hospitalId){
        HospitalAccount hospitalAccount = hospitalRepository.findByHospitalId(hospitalId);

        HospitalResponse hospitalResponse = new HospitalResponse();
        hospitalResponse.setHospitalId(hospitalAccount.getHospitalId());
        hospitalResponse.setName(hospitalAccount.getHName());
        hospitalResponse.setStreet(hospitalAccount.getHStreet());
        hospitalResponse.setZipCode(hospitalAccount.getHZipCode());
        hospitalResponse.setCity(hospitalAccount.getHCity());
        hospitalResponse.setState(hospitalAccount.getHState());
        hospitalResponse.setContactNumber(hospitalAccount.getHContactNumber());
        hospitalResponse.setEmail(hospitalAccount.getHEmail());
        hospitalResponse.setWebsite(hospitalAccount.getHWebsite());
        hospitalResponse.setLabFacility(hospitalAccount.getHLabFacility());
        hospitalResponse.setInsuranceAcceptance(hospitalAccount.getHInsuranceAcceptance());
        hospitalResponse.setScanningFacility(hospitalAccount.getHScanningFacility());

        return hospitalResponse;
    }


}
