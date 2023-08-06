package com.healthconnect.service.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {

    private String userId;
    private String emailId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Long contactNumber;
    private String streetName;
    private String city;
    private Long zipCode;
    private String state;
    private String emergencyContactName;
    private Long emergencyContactNumber;
    private LocalDateTime userCreatedData;
}
