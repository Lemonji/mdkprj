package com.mdkproject.mdk2019.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mdkproject.mdk2019.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(
    origins = {"*"},
    allowCredentials = "true")
public class HospitalController {
  @Autowired private HospitalService hospitalService;

  @PostMapping("/gethos")
  public List getallhos(@RequestBody String qunum) {
    System.out.println(qunum);
    JSONObject jsonObject= JSON.parseObject(qunum);
    System.out.println(jsonObject);
    String quname=null;
    System.out.println(jsonObject.getInteger("qunum"));
    switch (jsonObject.getInteger("qunum")){
      case 0: quname="武昌区";break;
      case 1: quname="洪山区";break;
      case 2: quname="东湖高新区";break;
      case 3: quname="江夏区";break;
      case 4: quname="东湖风景区";break;
      case 5: quname="江岸区";break;
      case 6: quname="江汉区";break;
      case 7: quname="硚口区";break;
      case 8: quname="汉阳区";break;
      case 9: quname="青山区";break;
      case 10: quname="东西湖区";break;
      case 11: quname="新洲区";break;
      case 12: quname="黄陂区";break;
      case 13: quname="蔡甸区";break;
      case 14: quname="汉南区";break;
    }
    System.out.println(quname);
    if (quname != null) {
      return hospitalService.findbyqu(quname);
    }else {
      return null;
    }
  }
}
