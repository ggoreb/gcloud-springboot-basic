package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.basic.model.Member;

@Repository
public interface MemberRepository 
		extends JpaRepository<Member, String>{
	Member findByUserIdAndUserPassword(
	    String userId, String userPassword);
}



