package com.healthconnect.service.request;


import lombok.Data;

@Data
public class CreateUser {

    private String userId;
    private String password;
    private String emailId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer contactNumber;

}
