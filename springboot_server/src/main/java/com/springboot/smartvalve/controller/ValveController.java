package com.springboot.smartvalve.controller;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.service.SvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ValveController {
    @Autowired
    SvService SvService;

    @GetMapping("/query")
    public List<SvDTO> svDTOList() throws Exception{
        return SvService.getValue();
    }


}

