package com.healthconnect.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "hospital_account")
@Entity
@Data
public class HospitalAccount {
    @Id
    @Column(name = "h_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;

    @Column(name = "h_password")
    private String h_password;

    @Column(name = "h_name")
    private String h_name;

    @Column(name = "h_street")
    private String h_street;

    @Column(name = "h_zip_code")
    private Long h_zip_code;

    @Column(name = "h_city")
    private Long h_city;

    @Column(name = "h_state")
    private String h_state;

    @Column(name = "h_contact_number")
    private Long h_contact_number;

    @Column(name = "h_email")
    private String h_email;

    @Column(name = "h_website")
    private String h_website;

    @Column(name = "h_lab_facility")
    private String h_lab_facility;

    @Column(name = "n_insurance_acceptance")
    private String n_insurance_acceptance;

    @Column(name = "h_scanning_facility")
    private String h_scanning_facility;


}

//    CREATE TABLE hospital_account (
//        h_id INT NOT NULL AUTO_INCREMENT,
//        h_password VARCHAR(100) DEFAULT NULL,
//    h_name VARCHAR(200) DEFAULT NULL,
//    h_street VARCHAR(200) DEFAULT NULL,
//    h_zip_code INT DEFAULT NULL,
//    h_city VARCHAR(100) DEFAULT NULL,
//    h_state VARCHAR(100) DEFAULT NULL,
//    h_contact_number INT DEFAULT NULL,
//    h_email VARCHAR(100) DEFAULT NULL,
//    h_website VARCHAR(200) DEFAULT NULL,
//    h_lab_facility VARCHAR(100) DEFAULT NULL,
//    n_insurance_acceptance VARCHAR(100) DEFAULT NULL,
//    h_scanning_facility VARCHAR(100) DEFAULT NULL,
//    PRIMARY KEY (`h_id`)
//);