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
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();
        log.info(auth.getPrincipal().toString());
        return "main";
    }

}
/*
  클래스를 생성할 때마다 항상 로그를 남기기 위해 Logger변수를 선언해야 하는데
  Lombok의 @Slf4j 어노테이션을 사용하면 편하다.
*/