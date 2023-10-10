package com.hastatakip.repositories;

import com.hastatakip.entites.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMeetingRepository extends JpaRepository<Meeting,Long>
{

}
