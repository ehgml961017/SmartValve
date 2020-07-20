package com.springboot.smartvalve.controller;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.service.SvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
//소켓포트 , http 프로토콜 포트 각각 한개씩 보유.
//android /bulb/on을 날려주면
//라즈베리파이에서 led on 이 된다.
public class ValveController {
    @Autowired
    SvService SvService;

    @GetMapping("/query")
    public List<SvDTO> svDTOList() throws Exception{
        return SvService.getValue();
    }





}

