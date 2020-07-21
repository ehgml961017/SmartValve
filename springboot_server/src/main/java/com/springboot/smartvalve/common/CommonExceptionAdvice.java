package com.springboot.smartvalve.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
    private static final Logger logger = LoggerFactory
            .getLogger(CommonExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView errorModelAndView(Exception e) {
        logger.info(e.toString());

        //ModelAndView 객체 생성
        ModelAndView modelAndView = new ModelAndView();

        //View 이름 설정 (error_common.jsp)
        modelAndView.setViewName("error_common");

        //Exception 객체 modelAndView의 속성으로 추가
        modelAndView.addObject("exception",e);

        return modelAndView;
    }
}