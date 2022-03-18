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
public class ControllerAspect {
  @Before(value = "execution (* com.example.basic.controller.*.*(..))")
  public void onBeforeHandler(JoinPoint joinPoint) {
    log.debug("@Before run");
  }

  @After(value = "execution (* com.example.basic.controller.*.*(..))")
  public void onAfterHandler(JoinPoint joinPoint) {
    log.debug("@After run");
  }

  @AfterReturning(value = "execution (* com.example.basic.controller.*.*(..))", returning = "data")
  public void onAfterReturningHandler(JoinPoint joinPoint, Object data) {
    if (data != null) {
      log.debug(data.toString());
    }
    log.debug("@AfterReturning run");
  }

//  @Pointcut("execution (* com.example.basic.controller.*.*(..))")
//  public void pointCut() {}
//  
//  @Around("pointCut()")
//  public Object trace(ProceedingJoinPoint joinPoint) {
//    Object obj = null;
//    System.currentTimeMillis(); // mili sec  -3
//    System.nanoTime(); // nano sec  -9
//    System.out.println("로그인 아이디 검사");
//    try {
//      obj = joinPoint.proceed();
//    } catch (Throwable e) {
//      e.printStackTrace();
//    }
//    System.out.println("메소드 실행 완료");
//    return obj;
//  }
}
