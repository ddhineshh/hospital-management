package com.healthconnect.service.services;

import com.healthconnect.service.request.BedAvailabilityRequest;
import com.healthconnect.service.request.DoctorRequest;
import com.healthconnect.service.request.HospitalAccountRequest;
import com.healthconnect.service.request.LoginUserRequest;
import com.healthconnect.service.request.UserRequest;
import com.healthconnect.service.response.DoctorResponse;
import com.healthconnect.service.response.HospitalResponse;
import com.healthconnect.service.response.UserResponse;

import java.util.List;

public interface HospitalService {


    UserResponse getUserLoginData(LoginUserRequest loginUserRequest);


    HospitalResponse createHospitalAccount(HospitalAccountRequest hospitalAccountRequest);

    HospitalResponse getHospitalLoginData(HospitalAccountRequest hospitalAccountRequest);

    UserResponse createUserAccount(UserRequest userRequest);


    public  void addDoctor(DoctorRequest newDoctor);

    public void updateDoctor(DoctorRequest updateDoctor,Long id);

    public void deleteDoctor(Long id);

     public void updateBedsAvailability(BedAvailabilityRequest updateBedsAvail);

    public void updateHospitalAccount(HospitalAccountRequest updateHospitalAccount);


    List<HospitalResponse> getListOfHospital();

    List<DoctorResponse> getListOfDoctor(Long hospitalId);

}
