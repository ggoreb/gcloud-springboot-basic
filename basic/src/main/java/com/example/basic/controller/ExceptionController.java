package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.basic.exception.CustomException;

@Controller
public class ExceptionController {
  @GetMapping("exception1")
  public String exception1() throws Exception {
    boolean isError = true;
    if (isError)
      throw new Exception("exception!");
    return "exception1";
  }

  @GetMapping("exception2")
  public String exception2() {
    boolean isError = true;
    if (isError)
      throw new CustomException("runtime exception!");
    return "exception2";
  }
}
