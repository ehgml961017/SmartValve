package com.springboot.smartvalve.mapper;

import com.springboot.smartvalve.dto.IncomeVO;

import java.util.List;

//Mybatis
/**
 * 차트관련 작업 인터페이스
 */
public interface IncomeMapper { //3.
    List<IncomeVO> getIncome();
}
