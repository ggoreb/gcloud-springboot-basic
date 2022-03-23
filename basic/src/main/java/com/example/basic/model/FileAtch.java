package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FileAtch {  // file_atch
  @Id
  @GeneratedValue
  Long id;
  
  String originalName;  // original_name 255자
}
