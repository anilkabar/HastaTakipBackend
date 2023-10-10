package com.hastatakip.repositories;

import com.hastatakip.entites.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDistrictRepository extends JpaRepository<District,Long> {

    List<District> findAllByCityId(Long id);

}
