package com.healthconnect.service.controller;


import com.healthconnect.service.request.DoctorRequest;
import com.healthconnect.service.request.HospitalAccountRequest;
import com.healthconnect.service.request.LoginUserRequest;
import com.healthconnect.service.request.UserRequest;
import com.healthconnect.service.response.HospitalResponse;
import com.healthconnect.service.response.UserResponse;
import com.healthconnect.service.services.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
@Validated
public class HospitalController {

        @Autowired
        private HospitalService hospitalService;


        @PostMapping("/login-user")
        public UserResponse loginRequest(@RequestBody LoginUserRequest loginUserRequest) {
                return hospitalService.getUserLoginData(loginUserRequest);
        }

        @PostMapping("/create-hospital-account")
        public HospitalResponse createHospitalAccount(@RequestBody HospitalAccountRequest hospitalAccountRequest){
                return hospitalService.createHospitalAccount(hospitalAccountRequest);
        }

        @PostMapping("/login-hospital")
        public HospitalResponse hospitalLoginRequest(@RequestBody HospitalAccountRequest hospitalAccountRequest){
                return hospitalService.getHospitalLoginData(hospitalAccountRequest);
        }

        @PostMapping("/create-user-account")
        public UserResponse createUserAccount(@RequestBody UserRequest userRequest){
                return hospitalService.createUserAccount(userRequest);
        }

        @PostMapping("/doctor")
        public HospitalResponse doctorAdd(@RequestBody DoctorRequest newDoctor){
              HospitalService.addDoctor(newDoctor);
              return null;
        }

        @PutMapping("/doctor/{id}")
        public HospitalResponse doctorAdd(@RequestBody DoctorRequest updateDoctor, @PathVariable Long id){
                HospitalService.updateDoctor(updateDoctor,id);
                return null;
        }


}
