package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "any2")
public class Any {
	@Id 
	String name;
	Integer age;
	String search;
}
