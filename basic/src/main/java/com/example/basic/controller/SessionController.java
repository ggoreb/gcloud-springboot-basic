package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.model.Member;
import com.example.basic.model.User;
import com.example.basic.repository.MemberRepository;
import com.example.basic.repository.UserRepository;

@Controller
public class SessionController {
  @Autowired
  UserRepository userRepository;
  
  @Autowired
  MemberRepository memberRepository;
  
  @GetMapping("/member")
  public String member() {
    return "member";
  }

  @PostMapping("/member")
  public String memberPost(
      @ModelAttribute Member member) {
    memberRepository.save(member);
    
    return "redirect:/signin";
  }
  
  @GetMapping("/signin")
  public String signin() {
    return "signin";
  }
  
  @PostMapping("/signin")
  public String signinPost(
      @ModelAttribute Member member,
      HttpSession session) {
    Member dbMember = memberRepository.findByUserIdAndUserPassword(
        member.getUserId(), member.getUserPassword());
    if(dbMember != null) {
      session.setAttribute("member", member);
    }
    
    return "redirect:/main";
  }
  
  @GetMapping("/join")
  public String join() {
    return "join";
  }
  
  @PostMapping("/join")
  public String joinPost(@ModelAttribute User user) {
    // 아래 코드를 위해서 UserRepository 생성 먼저!
    userRepository.save(user);
    
    return "redirect:/login";
  }
  
  @GetMapping("/login")
  public String login() {
    return "login";
  }
  
  @PostMapping("/login")
  @ResponseBody
  public Map<String, Object> loginPost(User user, HttpSession session) {
    System.out.println(user);
    session.setAttribute("user", user);

    Map<String, Object> map = new HashMap<>();
    if(user.getUserId().equals("a")) {
      map.put("result", "로그인 성공");
      map.put("code", 200);
    } else {
      map.put("result", "로그인 실패");      
      map.put("code", 300);
    }
    return map;
  }

  @GetMapping("/main")
  public String main() {
    return "main";
  }
}
