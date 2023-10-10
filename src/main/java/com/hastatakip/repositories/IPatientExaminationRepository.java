package com.hastatakip.repositories;

import com.hastatakip.entites.model.PatientExamination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPatientExaminationRepository extends JpaRepository<PatientExamination,Long> {

    List<PatientExamination> findAllByPatientId(Long id);

}
