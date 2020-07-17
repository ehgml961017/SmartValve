package com.springboot.smartvalve.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ValveController {
    @GetMapping("/")
    public String test() {
        System.out.println("test");
        return "test";
    }
}

