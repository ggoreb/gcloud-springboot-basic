package com.example.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity      // N
@ToString(exclude="team")
public class Player {
  @Id @GeneratedValue
  private Long id;
  
  @Column(name = "USERNAME")
  private String name;
  
  private int age;
  
  @ManyToOne
//  @JoinColumn(name = "TEAM_ID")
//  @ToString.Exclude
  private Team team;

}


