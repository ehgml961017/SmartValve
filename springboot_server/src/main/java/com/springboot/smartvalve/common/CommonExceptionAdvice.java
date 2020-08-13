package com.springboot.smartvalve.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice //컨트롤러를 보조하는 클래스에 사용하는 어노테이션.
@Slf4j
public class CommonExceptionAdvice {

    // @Controller, @RestController가 적용된 Bean내에서 발생하는
    // 예외를 잡아서 하나의 메서드에서 처리해주는 기능을 합니다.
    @ExceptionHandler(Exception.class)
    public ModelAndView errorModelAndView(Exception e) {
        log.info(e.toString());

        //ModelAndView 객체 생성
        ModelAndView modelAndView = new ModelAndView();

        //View 이름 설정 (error_common.jsp)
        modelAndView.setViewName("error_common");

        //Exception 객체 modelAndView의 속성으로 추가
        modelAndView.addObject("exception", e);

        return modelAndView;
    }
}
/*
@ControllerAdvice:
    컨트롤러를 보조하는 클래스에 사용하는 어노테이션.
    컨트롤러에서 쓰이는 공통기능들을 모듈화하여 전역으로 사용한다.
    spring boot에서 예외 처리하는 방법.
    클래스의 경로를 검색해서 오류를 캐치할 구현 클래스를 만들게 도와줍니다.
*/

/*
Log :
    프로그램 개발이나 운영시 발생하는 문제점을 추적하거나
    운영 상태를 모니터링 하는 정보를 기록하기 위해 사용합니다.
*/

/*
@ExceptionHandler :
    @Controller, @RestController가 적용된 Bean내에서
    발생하는 예외를 잡아서 하나의 메서드에서 처리해주는 기능을 합니다.
*/

/*
ModelAndView :
    Model과 View를 동시에 설정이 가능하며 컨트롤러는 ModelAndView객체만 리턴하지만
    Model과 View가 모두 리턴 가능
    -addObject("key",value)데이터 입력

Model vs ModelMap
    model.addAttribute()와 modelmap.addAttribute()함수를 사용하여
    Model에 데이터를 지정 후 View에서 데이터 접근 가능
    차이점 - Model은 인터페이스이며 ModelMap은 구현체
    Spring에서 내부적으로 사용하는 객체의 타입은 동일하며 사용의 구분은 개발자의 취향
    즉, 같은 기능
*/

