package com.hastatakip.repositories;

import com.hastatakip.entites.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Long> {

    /*
    @Query("from Doctor  d inner join d.company c")
 List<Doctor> getDoctorWhiteCompany();

*/

    List<Doctor> findAllByCompanyId(Long id);
}
