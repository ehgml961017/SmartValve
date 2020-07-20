package com.springboot.smartvalve.controller;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.service.SvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
public class ValveController {
    @Autowired
    SvService SvService;

    @GetMapping("/query")
    public List<SvDTO> svDTOList() throws Exception{
        return SvService.getValue();
    }

    @PostMapping("/???")
    public String testDataInput(SvDTO svDTO, RedirectAttributes rttr) throws Exception {
        SvService.insertValue(svDTO);
        rttr.addFlashAttribute("result", "registerOK");
        return "redirect://query";
        //리다이렉트 속성 준이유: 까리하게 보이게하는 이벤트 발생위해
        //테스트용으로 뷰페이지 만들어서 값 입력 후 전송 or
        //버튼입력시마다 or 일정시간마다 특정 데이터 입력 or
        // 비즈니스 로직 구현해야함.
    }
}
/*
* RedirectAttributes의 addFlashAttribute를 이용하여
* post방식처럼 url뒤에 parameter를 추가하지 않아도
* 화면에 값을 받을 수 있다.
* */
