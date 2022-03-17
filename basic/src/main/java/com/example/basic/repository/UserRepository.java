package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.User;

@Repository
public interface UserRepository 
		extends JpaRepository<User, String>{
	
}



