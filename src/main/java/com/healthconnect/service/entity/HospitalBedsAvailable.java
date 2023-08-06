package com.healthconnect.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "hospital_beds_availabilty")
@Entity
@Data
public class HospitalBedsAvailable {

    @Id
    @Column(name = "serial_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serial_num;

    @Column(name = "h_id")
    private Long hospitalId;

    @Column(name = "h_regular_beds_avail")
    private Long h_regular_beds_avail;

    @Column(name = "h_icu_beds_avail")
    private Long h_icu_beds_avail;

    @Column(name = "h_pediatric_beds_avail")
    private Long h_pediatric_beds_avail;

    @Column(name = "h_maternity_beds_avail")
    private Long h_maternity_beds_avail;

    @Column(name = "h_birthing_beds_avail")
    private Long h_birthing_beds_avail;

    @Column(name = "h_orthopedic_beds_avail")
    private Long h_orthopedic_beds_avail;

    @Column(name = "h_homecare_beds_avail")
    private Long h_homecare_beds_avail;

    @Column(name = "h_emergency_beds_avail")
    private Long h_emergency_beds_avail;

}


//    CREATE TABLE hospital_beds_availabilty (
//        serial_num INT NOT NULL AUTO_INCREMENT,
//        h_id INT DEFAULT NULL,
//        h_regular_beds_avail INT DEFAULT NULL,
//        h_icu_beds_avail INT DEFAULT NULL,
//        h_pediatric_beds_avail INT DEFAULT NULL,
//        h_maternity_beds_avail INT DEFAULT NULL,
//        h_birthing_beds_avail INT DEFAULT NULL,
//        h_orthopedic_beds_avail INT DEFAULT NULL,
//        h_homecare_beds_avail INT DEFAULT NULL,
//        h_emergency_beds_avail INT DEFAULT NULL,
//        PRIMARY KEY (`serial_num`)
//);