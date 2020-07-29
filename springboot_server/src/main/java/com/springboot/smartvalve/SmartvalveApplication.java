package com.springboot.smartvalve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
public class SmartvalveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartvalveApplication.class, args);
    }

}
