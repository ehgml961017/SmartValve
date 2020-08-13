package com.springboot.smartvalve.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
/**
 * SNSLoginController구글연동 로그인하는 클래스
 */
//TODO: 깃허브,페이스북,네이버,카카오 등 연동,
// disqus댓글기능도 요구사항 들어오면 추가예정
// 유저 DB를 따로 생성해서 벤 기능 예정 현재는 SSO만 구현

//Single Sign-On의 약자로 여러 개의 사이트에서 한번의 로그인으로 여러가지 다른 사이트들을 자동적으로 접속하여 이용하는
// 방법을 말합니다.


public class SNSLoginContoller {
    /**
     * @return mainPage
     */
    @GetMapping("/")
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