package com.hastatakip.repositories;

import com.hastatakip.entites.model.PatientDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPatientDocumentRepository extends JpaRepository<PatientDocument,Long> {

    List<PatientDocument> findAllByPatientId(Long id);
}
