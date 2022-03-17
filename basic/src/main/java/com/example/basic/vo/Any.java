package com.example.basic.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Any {
  @Id
  String name;
  int age;

  String search;
}
