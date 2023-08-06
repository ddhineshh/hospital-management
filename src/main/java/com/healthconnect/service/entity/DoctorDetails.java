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

@Table(name="doctor_details")
@Entity
@Data
@Getter
@Setter
public class DoctorDetails {

    @Id
    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "h_id")
    private Long hospitalId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Long age;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "contact_number")
    private Long contactNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "years_of_experience")
    private Long yearsOfExperience;

    @Column(name = "languages_known")
    private String languagesKnown;

    @Column(name = "consultation_hours")
    private String consultationHours;

    @Column(name = "availability_days")
    private String availabilityDays;


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
