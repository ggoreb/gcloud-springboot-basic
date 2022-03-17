package com.example.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CollectionId;

import lombok.Data;

@Data  // toString() - Override
       // setter(), getter()
@Entity
public class Demo {
	@Id 
//	@GeneratedValue 
	Long seq;

	String user;

//	@Override
//	public String toString() {
//		return "Demo [seq=" + seq + ", user=" + user + "]";
//	}
	
}
