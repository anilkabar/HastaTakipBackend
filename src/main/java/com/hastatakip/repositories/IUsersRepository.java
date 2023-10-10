package com.hastatakip.repositories;

import com.hastatakip.entites.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByUsername(String username);
    List<Users> findAllByCompanyId(Long id);
}
