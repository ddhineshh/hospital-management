package com.healthconnect.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "general_public_user")
@Entity
@Data
public class GeneralPublicUser {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user_id;

    @Column(name = "password")
    private String password;

    @Column(name = "email_id")
    private String email_id;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "contact_number")
    private Long contact_number;

    @Column(name = "street_name")
    private String street_name;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private Long zip_code;

    @Column(name = "state")
    private String state;

    @Column(name = "emergency_contact_name")
    private String emergency_contact_name;

    @Column(name = "emergency_contact_number")
    private Long emergency_contact_number;

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