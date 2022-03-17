package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.vo.Any;

@Repository
public interface AnyRepository 
		extends JpaRepository<Any, String>{

	List<Any> findBySearch(String search);
	
	List<Any> findBySearchContaining(String search);
	
}




