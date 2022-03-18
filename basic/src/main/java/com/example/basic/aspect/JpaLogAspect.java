package com.example.basic.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class JpaLogAspect {
  @AfterReturning(
      value = "execution (* com.example.basic.controller.*.jpa*(..))", 
      returning = "data")
  public void onAfterReturningHandler(JoinPoint joinPoint, Object data) {
    if (data != null) {
      log.warn(data.toString());
    }
    log.debug("@AfterReturning run");
  }
}
