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
public class IncomeController {

    @Setter(onMethod_ = @Autowired)
    private IncomeService service;

    @RequestMapping(value = "dateIncome", method = RequestMethod.GET)
    public String dateIncome(Locale locale, Model model) {
        return "svList";
    }

    @RequestMapping(value = "incomeList", method = RequestMethod.GET,
            produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String incomeList(Locale locale, Model model) {
        Gson gson = new Gson();
        List<IncomeVO> list = service.getIncome();
        return gson.toJson(list);

    }
}
