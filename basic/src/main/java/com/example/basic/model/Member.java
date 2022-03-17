package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {
  @Id @GeneratedValue
  private Integer id;
  private String userId;
  private String userPassword;
  private String name;
}



