package com.springboot.smartvalve.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class SNSLoginContoller {
    @RequestMapping("/")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info(auth.getPrincipal().toString());
        return "main";
    }

//    @RequestMapping("/callback")
//    public String callback() {
//        System.out.println("redirecting to home page");
//        return "home";
//    }
}
