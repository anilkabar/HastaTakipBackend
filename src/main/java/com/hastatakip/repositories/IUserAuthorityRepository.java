package com.hastatakip.repositories;

import com.hastatakip.entites.model.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserAuthorityRepository extends JpaRepository<UserAuthority,Long> {
    List<UserAuthority> findAllByUsersId(Long id);
    UserAuthority findByPageAdminIdAndUsersId(Long pageAdminId,Long userId);


}
