package com.example.basic.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {
  @GetMapping("/upload1")
  public String upload1() {
    return "upload1";
  }

  @PostMapping("/upload1")
  @ResponseBody
  public String upload1Post(MultipartHttpServletRequest mRequest) {
    String result = "";
    MultipartFile mFile = mRequest.getFile("file");
    
    String oName = mFile.getOriginalFilename();
    result += oName + "\n";
    
    File f = new File("c:/study/" + oName);
    String sName = "";
    
    if(f.isFile()) { // 파일이 존재하는가?
      String fileName = oName.substring( 0, oName.lastIndexOf(".") );
      String fileExt = oName.substring( oName.lastIndexOf(".") );
      sName = fileName + System.currentTimeMillis() + fileExt;
    } else {
      sName = oName;
    }
    
    try {
      mFile.transferTo(new File("c:/study/" + sName));
    } catch (IllegalStateException e) { e.printStackTrace();
    } catch (IOException e) { e.printStackTrace();
    }
    
    return result;
  }
}







