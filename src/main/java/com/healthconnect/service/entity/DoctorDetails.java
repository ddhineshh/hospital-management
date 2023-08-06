package com.healthconnect.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="doctor_details")
@Entity
@Data
public class DoctorDetails {
    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;

    @Column(name = "h_id")
    private Long hospitalId;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Long age;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "contact_number")
    private Long contact_number;

    @Column(name = "email_address")
    private String email_address;

    @Column(name = "years_of_experience")
    private Long years_of_experience;

    @Column(name = "languages_known")
    private String languages_known;

    @Column(name = "consultation_hours")
    private String consultation_hours;

    @Column(name = "availability_days")
    private String availability_days;


}

//    CREATE TABLE doctor_details (
//        doctor_id INT NOT NULL AUTO_INCREMENT,
//        h_id INT DEFAULT NULL,
//        first_name VARCHAR(100) DEFAULT NULL,
//    last_name VARCHAR(100) DEFAULT NULL,
//    gender VARCHAR(10) DEFAULT NULL,
//    age INT DEFAULT NULL,
//    specialization VARCHAR(100) DEFAULT NULL,
//    contact_number INT DEFAULT NULL,
//    email_address VARCHAR(100) DEFAULT NULL,
//    years_of_experience INT DEFAULT NULL,
//    languages_known VARCHAR(200) DEFAULT NULL,
//    consultation_hours VARCHAR(100) DEFAULT NULL,
//    availability_days VARCHAR(100) DEFAULT NULL,
//    PRIMARY KEY (`doctor_id`)
//);
