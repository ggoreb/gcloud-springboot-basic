package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class User {
  @Id // Varchar를 PK로 사용하는 것은 좋지 못함
  private String userId;
  
  private String userPw;
  
  @Transient
  private String userConfirmPw;
  
  private String userName;
}