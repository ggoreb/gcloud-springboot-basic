package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.Team;

public interface TeamRepository 
    extends JpaRepository<Team, Long>{

}
