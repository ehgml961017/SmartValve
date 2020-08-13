package com.springboot.smartvalve.controller;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.service.SvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//소켓포트 , http 프로토콜 포트 각각 한개씩 보유.
//android /bulb/on을 날려주면
//라즈베리파이에서 led on 이 된다.

@RestController
public class ValveController {
    @Autowired
    SvService SvService;

    /**
     * @return 데이터 수집값 json형태 리턴
     * @throws Exception
     */
    @GetMapping("/query")
    public List<SvDTO> svDTOList() throws Exception {
        return SvService.getValue();
    }

    /**
     * @param num
     * @return 가스밸브의 사용시간 json리턴
     * @throws Exception
     */
    @GetMapping("/time_sw1")
    public Integer time_sw1(@RequestParam int num) throws Exception {
        return SvService.time_sw1(num);
    }

    /**
     * @param num
     * @return 가스콕크의 사용시간
     * @throws Exception
     */
    @GetMapping("/time_sw2")
    public Integer time_sw2(@RequestParam int num) throws Exception {
        return SvService.time_sw2(num);
    }

}
/*
 * RedirectAttributes의 addFlashAttribute를 이용하여
 * post방식처럼 url뒤에 parameter를 추가하지 않아도
 * 화면에 값을 받을 수 있다.
 * */
