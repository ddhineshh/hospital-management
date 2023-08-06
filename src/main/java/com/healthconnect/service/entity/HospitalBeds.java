package com.healthconnect.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "hospital_beds")
@Entity
@Data
public class HospitalBeds {

    @Id
    @Column(name = "serial_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serial_num;

    @Column(name = "h_id")
    private Long hospitalId;

    @Column(name = "h_regular_beds")
    private Long h_regular_beds;

    @Column(name = "h_icu_beds")
    private Long h_icu_beds;

    @Column(name = "h_pediatric_beds")
    private Long h_pediatric_beds;

    @Column(name = "h_maternity_beds")
    private Long h_maternity_beds;

    @Column(name = "h_birthing_beds")
    private Long h_birthing_beds;

    @Column(name = "h_orthopedic_beds")
    private Long h_orthopedic_beds;

    @Column(name = "h_homecare_beds")
    private Long h_homecare_beds;

    @Column(name = "h_emergency_beds")
    private Long h_emergency_beds;

}




//    CREATE TABLE hospital_beds (
//        serial_num INT NOT NULL AUTO_INCREMENT,
//        h_id INT DEFAULT NULL,
//        h_regular_beds INT DEFAULT NULL,
//        h_icu_beds INT DEFAULT NULL,
//        h_pediatric_beds INT DEFAULT NULL,
//        h_maternity_beds INT DEFAULT NULL,
//        h_birthing_beds INT DEFAULT NULL,
//        h_orthopedic_beds INT DEFAULT NULL,
//        h_homecare_beds INT DEFAULT NULL,
//        h_emergency_beds INT DEFAULT NULL,
//        PRIMARY KEY (`serial_num`)
//);