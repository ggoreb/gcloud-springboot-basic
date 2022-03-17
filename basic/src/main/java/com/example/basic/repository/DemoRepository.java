package com.example.basic.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Demo;

@Repository
public interface DemoRepository 
		extends JpaRepository<Demo, Long>{
	
	List<Demo> findByOrderByUserDesc(Pageable pageable);

	//	List<Demo> findAllByOrderByUserDesc(Pageable pageable);
	
	
	List<Demo> findByUser(String user);
	
	List<Demo> findByUserContaining(String user);
}



