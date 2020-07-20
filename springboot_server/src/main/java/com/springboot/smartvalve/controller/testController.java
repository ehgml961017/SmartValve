package com.springboot.smartvalve.controller;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.service.SvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class testController {

    @Autowired
    SvService svService;
    @GetMapping("/svList")
    public void getList(Model model) throws Exception {
        List<SvDTO> list = null;
        list = svService.getValue();
        model.addAttribute("list", list);
    }
}
