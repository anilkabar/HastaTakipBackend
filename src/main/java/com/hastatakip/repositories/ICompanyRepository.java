package com.hastatakip.repositories;

import com.hastatakip.entites.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company,Long> {
}
