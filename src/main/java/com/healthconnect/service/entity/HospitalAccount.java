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
    private Long hospitalId;

    @Column(name = "h_password")
    private String hPassword;

    @Column(name = "h_name")
    private String hName;

    @Column(name = "h_street")
    private String hStreet;

    @Column(name = "h_zip_code")
    private Long hZipCode;

    @Column(name = "h_city")
    private Long hCity;

    @Column(name = "h_state")
    private String hState;

    @Column(name = "h_contact_number")
    private Long hContactNumber;

    @Column(name = "h_email")
    private String hEmail;

    @Column(name = "h_website")
    private String hWebsite;

    @Column(name = "h_lab_facility")
    private String hLabFacility;

    @Column(name = "h_insurance_acceptance")
    private String hInsuranceAcceptance;

    @Column(name = "h_scanning_facility")
    private String hScanningFacility;


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