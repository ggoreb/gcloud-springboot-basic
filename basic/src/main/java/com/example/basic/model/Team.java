package com.example.basic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity      // 1
public class Team {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  
  // OneToMany를 사용할 때의 문제점 -> players 호출 시 오류!
  // 해결방법 1. Eager Loading 으로 변경
  // 해결방법 2. Session이 계속 살아있도록 변경
  @OneToMany(mappedBy="team", fetch=FetchType.EAGER)
  List<Player> players = new ArrayList<>();
  
}





