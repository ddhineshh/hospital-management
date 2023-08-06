package com.healthconnect.service.repository;

import com.healthconnect.service.entity.HospitalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalAccount, Long> {

    HospitalAccount findByHospitalId(Long hospitalId);


}
