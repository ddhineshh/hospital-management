package com.healthconnect.service.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "general_public_user")
@Entity
@Data
@Getter
@Setter
public class GeneralPublicUser {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "contact_number")
    private Long contactNumber;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private Long zipCode;

    @Column(name = "state")
    private String state;

    @Column(name = "emergency_contact_name")
    private String emergencyContactName;

    @Column(name = "emergency_contact_number")
    private Long emergencyContactNumber;

    @Column(name = "user_created_data")
    private LocalDateTime userCreatedData;



}




//    CREATE TABLE general_public_user (
//        user_id VARCHAR(100) DEFAULT NULL,
//    password VARCHAR(100) DEFAULT NULL,
//    email_id VARCHAR(100) DEFAULT NULL,
//    last_name VARCHAR(100) DEFAULT NULL,
//    middle_name VARCHAR(100) DEFAULT NULL,
//    first_name VARCHAR(100) DEFAULT NULL,
//    contact_number INT DEFAULT NULL,
//    street_name VARCHAR(200) DEFAULT NULL,
//    city VARCHAR(100) DEFAULT NULL,
//    zip_code INT DEFAULT NULL,
//    state VARCHAR(100) DEFAULT NULL,
//    emergency_contact_name VARCHAR(200) DEFAULT NULL,
//    emergency_contact_number INT DEFAULT NULL,
//    user_created_data datetime DEFAULT NULL
//
//);