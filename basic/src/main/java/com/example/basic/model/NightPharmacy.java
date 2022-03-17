package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class NightPharmacy {
	@Id 
	@GeneratedValue 
	int id;
	String name;
	String tel;
	String roadAddress;
	String jibunAddress;
	String mon;
	String tue;
	String wed;
	String thu;
	String fri;
	String sat;
	String sun;
	String pubDay;
}











