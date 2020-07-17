package com.springboot.smartvalve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class testController {
    @GetMapping("/")
    public String test() {
        System.out.println("test");
        return "test";
    }
}
