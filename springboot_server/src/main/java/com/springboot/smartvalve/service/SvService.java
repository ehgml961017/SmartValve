package com.springboot.smartvalve.service;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.mapper.SvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        if (valveS == 0 && corkS == 0) {
            svMapper.insertValue(svDTO);
        }
    }

    public void onSw1(SvDTO svDTO) throws Exception {
        System.out.println(svDTO.getSw1());
        System.out.println(svDTO.getValve_time());
        svMapper.sw1_on(svDTO);
    }
    public void offSw1(SvDTO svDTO) throws Exception {
        System.out.println(svDTO.getSw1());
        System.out.println(svDTO.getValve_time());
        svMapper.sw1_off(svDTO);
    }

    public void onSw2(SvDTO svDTO) throws Exception {
        System.out.println(svDTO.getSw2());
        System.out.println(svDTO.getCork_time());
        svMapper.sw2_on(svDTO);
    }
    public void offSw2(SvDTO svDTO) throws Exception {
        System.out.println(svDTO.getSw2());
        System.out.println(svDTO.getCork_time());
        svMapper.sw2_off(svDTO);
    }


    public Integer time(int num) throws Exception {
            return svMapper.time(num);
    }
}
