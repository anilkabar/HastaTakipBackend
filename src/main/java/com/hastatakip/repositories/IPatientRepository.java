package com.hastatakip.repositories;

import com.hastatakip.entites.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPatientRepository extends JpaRepository<Patient,Long> {

    //List<Patient> findAllByOrderByDateAsc();

    List<Patient> findAllByCompanyId(Long id);

}
