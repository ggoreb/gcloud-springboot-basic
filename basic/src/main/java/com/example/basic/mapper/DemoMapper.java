package com.example.basic.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {
  public List<Map<String, Object>> select();
  
  public Integer insert(
		  Map<String, Object> map);
  
}
// Shift + Ctrl + R : 파일 열기