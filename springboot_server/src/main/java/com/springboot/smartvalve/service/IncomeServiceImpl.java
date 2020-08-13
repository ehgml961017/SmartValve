package com.springboot.smartvalve.service;

import com.springboot.smartvalve.dto.IncomeVO;
import com.springboot.smartvalve.mapper.IncomeMapper;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IncomeServiceImpl implements IncomeService { //6.
    //서비스 구현부
    @Setter(onMethod_ = @Autowired)
    //onMethod : setter 메서드 생성 시 메서드에 추가할 어노테이션을 지정합니다.
    private IncomeMapper mapper;

    /**
     * 
     * @return 차트구현부
     */
    @Override
    public List<IncomeVO> getIncome() {

        return mapper.getIncome();
    }
}

//@Autowired : 인스턴스 변수(mapper)에 알맞은 타입의 객체(IncomeMapper)를 자동으로 주입해달라는 어노테이션