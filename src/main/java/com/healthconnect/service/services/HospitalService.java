package com.healthconnect.service.services;

import com.healthconnect.service.request.LoginUserRequest;
import com.healthconnect.service.response.UserResponse;

public interface HospitalService {


    UserResponse getUserLoginData(LoginUserRequest loginUserRequest);
}
