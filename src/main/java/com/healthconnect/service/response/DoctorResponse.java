package com.healthconnect.service.response;

import lombok.Data;

@Data
public class DoctorResponse {
        private Long hospitalId;
        private String firstName;
        private String lastName;
        private String gender;
        private Long age;
        private String specialization;
        private Long contactNumber;
        private String emailAddress;
        private Long yearsOfExperience;
        private String languagesKnown;
        private String consultationHours;
        private String availabilityDays;
}
