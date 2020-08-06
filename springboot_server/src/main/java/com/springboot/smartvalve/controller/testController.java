package com.springboot.smartvalve.controller;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.service.SvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    //modelAndView 사용가능

    @GetMapping("/onSw1")
    public String onSw1(SvDTO svDTO, RedirectAttributes rttr) throws Exception {
        svService.onSw1(svDTO);
        return "redirect:/svList";
    }

    @GetMapping("/offSw1")
    public String offSw1(SvDTO svDTO, RedirectAttributes rttr) throws Exception {
        svService.offSw1(svDTO);
        return "redirect:/svList";
    }

    @GetMapping("/onSw2")
    public String onSw2(SvDTO svDTO, RedirectAttributes rttr) throws Exception {
        svService.onSw2(svDTO);
        System.out.println(svDTO.getSw2());
        return "redirect:/svList";
    }

    @GetMapping("/offSw2")
    public String offSw2(SvDTO svDTO, RedirectAttributes rttr) throws Exception {
        svService.offSw2(svDTO);
        return "redirect:/svList";
    }

<<<<<<< HEAD
=======
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

>>>>>>> e21e952baf4d7eee3afe412415e6aa779426e7b2
}
