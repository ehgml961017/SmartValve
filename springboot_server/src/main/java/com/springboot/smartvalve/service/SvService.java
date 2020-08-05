package com.springboot.smartvalve.service;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.mapper.SvMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SvService {
    @Autowired
    SvMapper svMapper;

    public List<SvDTO> getValue() throws Exception {
        return svMapper.getValue();
    }

    public void insertValue(SvDTO svDTO) throws Exception {
        // sw 1 sw2가 둘다 0일때만 인서트 되게
        int valveS = svDTO.getSw1();
        int corkS = svDTO.getSw2();
        System.out.println(valveS);
        System.out.println(corkS);
        svMapper.insertValue(svDTO);
    }

    public void onSw1(SvDTO svDTO) throws Exception {
        svMapper.sw1_on(svDTO);
    }
    public void offSw1(SvDTO svDTO) throws Exception {
        System.out.println("아나 진짜 :"+svDTO);
        svMapper.sw1_off(svDTO);
        svDTO.setSw1(0);
        if((svDTO.getSw1()==0) && (svDTO.getSw2()==0)){
            insertValue(svDTO);
        }


    }

    public void onSw2(SvDTO svDTO) throws Exception {
        System.out.println(svDTO.getSw2());
        System.out.println(svDTO.getCork_time());
        svMapper.sw2_on(svDTO);
    }
    public void offSw2(SvDTO svDTO) throws Exception {
        log.debug("확인용"+svDTO);
        svMapper.sw2_off(svDTO);
        svDTO.setSw2(0);
        if((svDTO.getSw1()==0) && (svDTO.getSw2()==0)){
            insertValue(svDTO);
        }


    }


    public Integer time_sw1(int num) throws Exception {
            return svMapper.time_sw1(num);
    }

    public Integer time_sw2(int num) throws Exception {
        return svMapper.time_sw2(num);
    }

    public int getThreadCount() throws Exception {
        return svMapper.getThreadCount() ;
    }

    public int updateThreadCount(int num) throws Exception {
        return svMapper.updateThreadCount(num) ;
    }
}
