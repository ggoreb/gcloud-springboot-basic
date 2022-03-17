package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Json1Controller {
  @GetMapping("json/exam")
  @ResponseBody
  public Map<String, Object> jsonExam() {
    Map<String, Object> map = new HashMap<>();
    
    map.put("count", 2);

    List<Map<String, String>> list = new ArrayList<>();
    Map<String, String> m1 = new HashMap<>();
    m1.put("name", "가");
    m1.put("userId", "A");
    list.add(m1);
    Map<String, String> m2 = new HashMap<>();
    m2.put("name", "나");
    m2.put("userId", "B");
    list.add(m2);

    map.put("list", list);

    return map;
  }

  @GetMapping("json/string")
  @ResponseBody
  public String json() {
    return "json/string";
  }

  @GetMapping("json/map")
  @ResponseBody
  public Map<String, Object> jsonMap(Map<String, Object> map) {
    Map<String, Object> map2 = new HashMap<String, Object>();
    map2.put("key1", "value");
    map2.put("key2", 2324);
    map2.put("key3", true);
    return map2;
  }

  @GetMapping("json/list")
  @ResponseBody
  public List<String> jsonList() {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    return list;
  }
}
