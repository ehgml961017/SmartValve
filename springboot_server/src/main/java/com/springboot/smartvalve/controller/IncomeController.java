package com.springboot.smartvalve.controller;

import com.google.gson.Gson;
import com.springboot.smartvalve.dto.IncomeVO;
import com.springboot.smartvalve.service.IncomeService;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

@Controller
@Log
public class IncomeController { //2.

    @Setter(onMethod_ = @Autowired)
    private IncomeService service;

    //$.getJson으로 넘어올 때 처리해주는 메소드 생성
    @RequestMapping(value = "incomeList", method = RequestMethod.GET,
            produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String incomeList(Locale locale, Model model) {
        //Gson : json구조를 띄는 직렬화된 데이터를 JAVA의 객체로 역직렬화, 직렬화 해주는
        //자바 라이브러리 입니다. 즉 json Object -> JAVA Object 또는 그 반대의 행위를
        //돕는 라이브러리입니다.
        Gson gson = new Gson();
        List<IncomeVO> list = service.getIncome();
        return gson.toJson(list); //자바 객체를 json화

    }
}

//@ResponseBody :자바 객체를 HTTP 요청의 body 내용으로 매핑하는 역할을 합니다.
//서버에서 클라이언트로 응답 데이터를 전송하기 위해서 @ResponseBody 를 사용하여
// 자바 객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송시키는 역할을 합니다.