package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class NightPharmacy3 {
	@Id
	@GeneratedValue
	int id;
	String name;
	String tel;
	String roadAddress;
	String jibunAddres;
	String pubDay;
}
