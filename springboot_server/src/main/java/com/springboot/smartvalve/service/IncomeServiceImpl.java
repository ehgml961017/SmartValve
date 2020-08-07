package com.springboot.smartvalve.service;

import com.springboot.smartvalve.dto.IncomeVO;
import com.springboot.smartvalve.mapper.IncomeMapper;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class IncomeServiceImpl implements IncomeService {

    @Setter(onMethod_=@Autowired)
    private IncomeMapper mapper;

    @Override
    public List<IncomeVO> getIncome() {
        return mapper.getIncome();
    }
}