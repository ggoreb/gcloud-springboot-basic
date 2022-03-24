package com.example.basic.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestTemplateController {
  
  @GetMapping("/getNaverRoma")
  public ResponseEntity<Map> getNaverRoma(
      String query) {
    RestTemplate rt = new RestTemplate();
    RequestEntity requestEntity = null;
    try {
      requestEntity = RequestEntity
          .get(
            new URI(
            "https://openapi.naver.com/v1/krdict/romanization?query=" + 
                      URLEncoder.encode(query, "utf-8")))
          .header("X-Naver-Client-Id", "R07YjSsPeO846YoVTd5P")
          .header("X-Naver-Client-Secret", "4J2kcTlDku")

          .build();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
    
    System.out.println(entity.getBody());
    
    return entity;
  }

  @GetMapping("/getKakaoTrans")
  public ResponseEntity<Map> getKakaoTrans(
      String query) {
    RestTemplate rt = new RestTemplate();
    RequestEntity requestEntity = null;
    try {
      requestEntity = RequestEntity
          .post(
              new URI(
                  "https://dapi.kakao.com/v2/translation/translate?src_lang=kr&target_lang=en&query=" + 
                      URLEncoder.encode(query, "utf-8")))
          .header("Authorization", "KakaoAK 0aefe54864be4783209dd90475cedfcc")
          .build();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
    return entity;
  }
  

  @GetMapping("/getKakao")
  public ResponseEntity<Map> getKakao(
      String address) {
    RestTemplate rt = new RestTemplate();
    RequestEntity requestEntity = null;
    try {
      // RequestEntity.get(주소).headers(헤더값).build();
      requestEntity = RequestEntity
          .get(
            new URI(
            "https://dapi.kakao.com/v2/local/search/address.json?query=" + 
                      URLEncoder.encode(address, "utf-8")))
          .header("Authorization", "KakaoAK 0aefe54864be4783209dd90475cedfcc")
          .build();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
    System.out.println(entity.getStatusCode());
    System.out.println(entity.getHeaders());
    System.out.println(entity.getBody());
    System.out.println(entity);
    return entity;
  }


  @GetMapping("/getNaver")
  public ResponseEntity<Map> getNaver(
      String text) {
    RestTemplate rt = new RestTemplate();
    RequestEntity<Map> requestEntity = null;
    try {
      Map<String, String> body = new HashMap<>();
      body.put("source", "ko");
      body.put("target", "en");
      body.put("text", text);
      
      requestEntity = RequestEntity.post(
          new URI("https://openapi.naver.com/v1/papago/n2mt"))
          .header("X-Naver-Client-Id", "R07YjSsPeO846YoVTd5P")
          .header("X-Naver-Client-Secret", "4J2kcTlDku")
          .body(body);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
    
    return entity;
  }
  
  @GetMapping("/getList")
  public List getList() {
    RestTemplate rt = new RestTemplate();
    List result = rt.getForObject(
        "http://ggoreb.com/http/json2.jsp", List.class);
    return result;
  }

  @GetMapping("/getMap")
  public Map getMap() {
    RestTemplate rt = new RestTemplate();
    Map result = rt.getForObject("http://ggoreb.com/http/json1.jsp", Map.class);
    return result;
  }

  @GetMapping("/getString")
  public String getString() {
    RestTemplate rt = new RestTemplate();
    String result = rt.getForObject("http://ggoreb.com/http/json1.jsp", String.class);
    return result;
  }
}