package com.example.basic;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
  public static void main(String[] args) throws UnsupportedEncodingException {
    String s = "안녕";
    System.out.println(s);
    
    String encodeUtf8 = URLEncoder.encode(s, "utf-8");
    System.out.println(  encodeUtf8  );

    String encodeEuckr = URLEncoder.encode(s, "euc-kr");
    System.out.println(  encodeEuckr  );
    
    System.out.println(  URLDecoder.decode(encodeUtf8, "utf-8")  );
    System.out.println(  URLDecoder.decode(encodeEuckr, "euc-kr")  );
    
    System.out.println(  URLDecoder.decode(s, "euc-kr")  );
    
  }
}
