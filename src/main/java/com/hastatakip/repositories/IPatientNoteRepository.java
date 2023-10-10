package com.hastatakip.repositories;
import com.hastatakip.entites.model.Patient;
import com.hastatakip.entites.model.PatientNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPatientNoteRepository extends JpaRepository<PatientNote,Long> {
    //List<PatientNote> findByContent(String content);
    List<PatientNote> findAllByPatientId(Long id);


}
