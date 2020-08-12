package com.springboot.smartvalve.service;

import com.springboot.smartvalve.dto.IncomeVO;

import java.util.List;

//본격적인 사용을 위한 서비스 작업
public interface IncomeService {    //5.
    public List<IncomeVO> getIncome();
}
