package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.Player;

public interface PlayerRepository 
    extends JpaRepository<Player, Long>{

}
