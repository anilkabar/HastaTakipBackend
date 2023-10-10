package com.hastatakip.repositories;

import com.hastatakip.entites.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City,Long> {
}
