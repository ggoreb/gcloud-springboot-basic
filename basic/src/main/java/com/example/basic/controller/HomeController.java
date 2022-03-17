package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  // 방금 주소 중복으로 오류 발생한다는 것
  // 취소입니다.
  @RequestMapping("/") // 모든 method 지원
  public String home() {
    return "home";
  }
}
