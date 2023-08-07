package com.healthconnect.service.services.impl;

import com.healthconnect.service.entity.DoctorDetails;
import com.healthconnect.service.entity.GeneralPublicUser;
import com.healthconnect.service.entity.HospitalAccount;
import com.healthconnect.service.entity.HospitalBeds;
import com.healthconnect.service.entity.HospitalBedsAvailable;
import com.healthconnect.service.exception.InvalidUserLoginAccessException;
import com.healthconnect.service.repository.BedsOfHospitalRepository;
import com.healthconnect.service.repository.DoctorDetailsRepository;
import com.healthconnect.service.repository.HospitalBedsAvailabilityRepository;
import com.healthconnect.service.repository.HospitalRepository;
import com.healthconnect.service.repository.UserRepository;
import com.healthconnect.service.request.BedAvailabilityRequest;
import com.healthconnect.service.request.DoctorRequest;
import com.healthconnect.service.request.HospitalAccountRequest;
import com.healthconnect.service.request.LoginUserRequest;
import com.healthconnect.service.request.UserRequest;
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
    public HospitalResponse createHospitalAccount(HospitalAccountRequest hospitalAccountRequest) {

        HospitalAccount hospitalAccount = new HospitalAccount();
        hospitalAccount.setPassword(hospitalAccountRequest.getPassword());
        hospitalAccount.setName(hospitalAccountRequest.getName());
        hospitalAccount.setStreet(hospitalAccountRequest.getStreet());
        hospitalAccount.setZipCode(hospitalAccountRequest.getZipCode());
        hospitalAccount.setCity(hospitalAccountRequest.getCity());
        hospitalAccount.setState(hospitalAccountRequest.getState());
        hospitalAccount.setContactNumber(hospitalAccountRequest.getContactNumber());
        hospitalAccount.setEmail(hospitalAccountRequest.getEmail());
        hospitalAccount.setWebsite(hospitalAccountRequest.getWebsite());
        hospitalAccount.setLabFacility(hospitalAccountRequest.getLabFacility());
        hospitalAccount.setInsuranceAcceptance(hospitalAccountRequest.getInsuranceAcceptance());
        hospitalAccount.setScanningFacility(hospitalAccountRequest.getScanningFacility());

        HospitalAccount hospitalEntity = hospitalRepository.saveAndFlush(hospitalAccount);

        HospitalBeds hospitalBeds = new HospitalBeds();
        hospitalBeds.setHospitalId(hospitalEntity.getHospitalId());
        bedsOfHospitalRepository.saveAndFlush(hospitalBeds);

        HospitalBedsAvailable hospitalBedsAvailable = new HospitalBedsAvailable();
        hospitalBedsAvailable.setHospitalId(hospitalEntity.getHospitalId());
        hospitalBedsAvailabilityRepository.saveAndFlush(hospitalBedsAvailable);

        HospitalResponse hospitalResponse = constructHospitalResponse(hospitalEntity.getHospitalId());

        return hospitalResponse;

    }

    @Override
    public HospitalResponse getHospitalLoginData(HospitalAccountRequest hospitalAccountRequest) {

        Optional<HospitalAccount> hospitalAccount = hospitalRepository.findByEmailAndPassword(hospitalAccountRequest.getEmail(), hospitalAccountRequest.getPassword());

        if(hospitalAccount.isEmpty()){
            throw new InvalidUserLoginAccessException("no hospital is present with this email an password");
        }

        if(hospitalAccount.isPresent()){
            HospitalAccount hospitalAccountEntity = hospitalAccount.get();
            return constructHospitalResponse(hospitalAccountEntity.getHospitalId());

        }
        return null;
    }

    @Override
    public UserResponse createUserAccount(UserRequest userRequest) {
        GeneralPublicUser generalPublicUser = new GeneralPublicUser();

        generalPublicUser.setUserId(userRequest.getUserId());
        generalPublicUser.setPassword(userRequest.getPassword());
        generalPublicUser.setEmailId(userRequest.getEmailId());
        generalPublicUser.setFirstName(userRequest.getFirstName());
        generalPublicUser.setMiddleName(userRequest.getMiddleName());
        generalPublicUser.setLastName(userRequest.getLastName());
        generalPublicUser.setContactNumber(userRequest.getContactNumber());
        generalPublicUser.setStreetName(userRequest.getStreetName());
        generalPublicUser.setCity(userRequest.getCity());
        generalPublicUser.setZipCode(userRequest.getZipCode());
        generalPublicUser.setState(userRequest.getState());
        generalPublicUser.setEmergencyContactName(userRequest.getEmergencyContactName());
        generalPublicUser.setEmergencyContactNumber(userRequest.getEmergencyContactNumber());
        generalPublicUser.setUserCreatedData(userRequest.getUserCreatedData());

        GeneralPublicUser generalPublicUserEntity = userRepository.saveAndFlush(generalPublicUser);

        return constructUserResponse(generalPublicUserEntity.getEmailId());

    }

    public void  addDoctor(DoctorRequest doctorRequest){
        DoctorDetails doctorDetails = new DoctorDetails();
        doctorDetails.setHospitalId(doctorRequest.getHospitalId());
        doctorDetails.setFirstName(doctorRequest.getFirstName());
        doctorDetails.setLastName(doctorRequest.getLastName());
        doctorDetails.setGender(doctorRequest.getGender());
        doctorDetails.setAge(doctorRequest.getAge());
        doctorDetails.setSpecialization(doctorRequest.getSpecialization());
        doctorDetails.setContactNumber(doctorRequest.getContactNumber());
        doctorDetails.setEmailAddress(doctorRequest.getEmailAddress());
        doctorDetails.setYearsOfExperience(doctorRequest.getYearsOfExperience());
        doctorDetails.setLanguagesKnown(doctorRequest.getLanguagesKnown());
        doctorDetails.setConsultationHours(doctorRequest.getConsultationHours());
        doctorDetails.setAvailabilityDays(doctorRequest.getAvailabilityDays());

        doctorDetailsRepository.saveAndFlush(doctorDetails);

    }


    public void updateDoctor(DoctorRequest updateDoctor,Long id){
        DoctorDetails doctorDetails = doctorDetailsRepository.findByDoctorId(id);
        doctorDetails.setHospitalId(updateDoctor.getHospitalId());
        doctorDetails.setFirstName(updateDoctor.getFirstName());
        doctorDetails.setLastName(updateDoctor.getLastName());
        doctorDetails.setGender(updateDoctor.getGender());
        doctorDetails.setAge(updateDoctor.getAge());
        doctorDetails.setSpecialization(updateDoctor.getSpecialization());
        doctorDetails.setContactNumber(updateDoctor.getContactNumber());
        doctorDetails.setEmailAddress(updateDoctor.getEmailAddress());
        doctorDetails.setYearsOfExperience(updateDoctor.getYearsOfExperience());
        doctorDetails.setLanguagesKnown(updateDoctor.getLanguagesKnown());
        doctorDetails.setConsultationHours(updateDoctor.getConsultationHours());
        doctorDetails.setAvailabilityDays(updateDoctor.getAvailabilityDays());

        doctorDetailsRepository.saveAndFlush(doctorDetails);
    }

    public void deleteDoctor(Long id){
        doctorDetailsRepository.deleteById(id);
    }

    public HospitalResponse constructHospitalResponse(Long hospitalId){
        HospitalAccount hospitalAccount = hospitalRepository.findByHospitalId(hospitalId);

        HospitalResponse hospitalResponse = new HospitalResponse();
        hospitalResponse.setHospitalId(hospitalAccount.getHospitalId());
        hospitalResponse.setName(hospitalAccount.getName());
        hospitalResponse.setStreet(hospitalAccount.getStreet());
        hospitalResponse.setZipCode(hospitalAccount.getZipCode());
        hospitalResponse.setCity(hospitalAccount.getCity());
        hospitalResponse.setState(hospitalAccount.getState());
        hospitalResponse.setContactNumber(hospitalAccount.getContactNumber());
        hospitalResponse.setEmail(hospitalAccount.getEmail());
        hospitalResponse.setWebsite(hospitalAccount.getWebsite());
        hospitalResponse.setLabFacility(hospitalAccount.getLabFacility());
        hospitalResponse.setInsuranceAcceptance(hospitalAccount.getInsuranceAcceptance());
        hospitalResponse.setScanningFacility(hospitalAccount.getScanningFacility());

        return hospitalResponse;
    }

    public UserResponse constructUserResponse(String emailId){
        GeneralPublicUser generalPublicUserEntity = userRepository.findByEmailId(emailId);
        UserResponse userResponse = new UserResponse();
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

        return userResponse;

    }



    public void updateBedsAvailability(BedAvailabilityRequest bedAvailabilityRequest){

        Optional<HospitalBedsAvailable> optionalHospitalBedsAvailable = hospitalBedsAvailabilityRepository.findById(bedAvailabilityRequest.getHospitalId());

            HospitalBedsAvailable hospitalBedsAvailable = optionalHospitalBedsAvailable.get();
            hospitalBedsAvailable.setHospitalId(bedAvailabilityRequest.getHospitalId());
            hospitalBedsAvailable.setRegularBedsAvail(bedAvailabilityRequest.getRegularBedAvail());
            hospitalBedsAvailable.setIcuBedsAvail(bedAvailabilityRequest.getIcuBedAvail());
            hospitalBedsAvailable.setPediatricBedsAvail(bedAvailabilityRequest.getPediatricBedAvail());
            hospitalBedsAvailable.setMaternityBedsAvail(bedAvailabilityRequest.getMaternityBedAvail());
            hospitalBedsAvailable.setBirthingBedsAvail(bedAvailabilityRequest.getBirthingBedAvail());
            hospitalBedsAvailable.setOrthopedicBedsAvail(bedAvailabilityRequest.getOrthopedicBedAvail());
            hospitalBedsAvailable.setHomecareBedsAvail(bedAvailabilityRequest.getHomeCareBedAvail());
            hospitalBedsAvailable.setEmergencyBedsAvail(bedAvailabilityRequest.getEmergencyBedAvail());
            hospitalBedsAvailabilityRepository.saveAndFlush(hospitalBedsAvailable);
        }

    public void updateHospitalAccount(HospitalAccountRequest updateHospitalAccount){
//        Optional<HospitalBedsAvailable> optionalHospitalBedsAvailable = hospitalRepository.findById(bedAvailabilityRequest.getHospitalId());
//
//        HospitalAccount hospitalAccount = new HospitalAccount();
//
//        hospitalAccount.setHPassword(updateHospitalAccount.getPassword());
//        hospitalAccount.setHName(updateHospitalAccount.getName());
//        hospitalAccount.setHStreet(updateHospitalAccount.getStreet());
//        hospitalAccount.setHZipCode(updateHospitalAccount.getZipCode());
//        hospitalAccount.setHCity(updateHospitalAccount.getCity());
//        hospitalAccount.setHState(updateHospitalAccount.getState());
//        hospitalAccount.setHContactNumber(updateHospitalAccount.getContactNumber());
//        hospitalAccount.setHEmail(updateHospitalAccount.getEmail());
//        hospitalAccount.setHWebsite(updateHospitalAccount.getWebsite());
//        hospitalAccount.setHLabFacility(updateHospitalAccount.getLabFacility());
//        hospitalAccount.setHInsuranceAcceptance(updateHospitalAccount.getInsuranceAcceptance());
//        hospitalAccount.setHScanningFacility(updateHospitalAccount.getScanningFacility());

    }

}
