package com.example.basic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

@Repository
public class SunbyulDAO {
  @Autowired
  JdbcTemplate jt;

  public List<Map<String, Object>> select(int startRow) {
    return jt.queryForList(
      "select * from sunbyul limit ?, 10", startRow);
  }
}
