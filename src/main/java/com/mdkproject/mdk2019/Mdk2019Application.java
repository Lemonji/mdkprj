package com.mdkproject.mdk2019;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: lizhen
 * @date: 2019-03-27 14:07
 * 功能描述: 启动类
 */


@SpringBootApplication(scanBasePackages = {"com.mdkproject.mdk2019"})
@RestController
@MapperScan("com.mdkproject.mdk2019.dao")

public class Mdk2019Application {

    private static Logger logger = LoggerFactory.getLogger(Mdk2019Application.class);

    //测试启动
    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "hello world";
    }



    public static void main(String[] args) {
        System.err.println("hello world");
        SpringApplication.run(Mdk2019Application.class, args);
        logger.info("springboot success");
    }

}
