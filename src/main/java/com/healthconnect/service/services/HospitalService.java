package com.healthconnect.service.services;

import com.healthconnect.service.entity.DoctorDetails;
import com.healthconnect.service.entity.HospitalAccount;
import com.healthconnect.service.entity.HospitalBeds;
import com.healthconnect.service.entity.HospitalBedsAvailable;
import com.healthconnect.service.request.BedAvailabilityRequest;
import com.healthconnect.service.request.DoctorRequest;
import com.healthconnect.service.request.HospitalAccountRequest;
import com.healthconnect.service.request.HospitalBedRequest;
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


    public DoctorDetails addDoctor(DoctorRequest newDoctor);

    public DoctorDetails updateDoctor(DoctorRequest updateDoctor,Long id);

    public String  deleteDoctor(Long id);

     public HospitalBedsAvailable updateBedsAvailability(BedAvailabilityRequest updateBedsAvail);

    public HospitalAccount updateHospitalAccount(HospitalAccountRequest updateHospitalAccount, Long hospitalId);


    List<HospitalResponse> getListOfHospital();

    List<DoctorResponse> getListOfDoctor(Long hospitalId);

    public HospitalBeds updateBeds(HospitalBedRequest updateBeds);

}
