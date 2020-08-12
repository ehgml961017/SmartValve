package com.springboot.smartvalve.mapper;

import com.springboot.smartvalve.dto.IncomeVO;

import java.util.List;

//Mybatis
//DB관련 작업 인터페이스
public interface IncomeMapper { //3.
    List<IncomeVO> getIncome();
}
