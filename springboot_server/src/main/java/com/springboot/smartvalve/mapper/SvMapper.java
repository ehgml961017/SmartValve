package com.springboot.smartvalve.mapper;

import com.springboot.smartvalve.dto.SvDTO;

import java.util.Date;
import java.util.List;

public interface SvMapper {
    public List<SvDTO> getValue() throws Exception;

    public void insertValue(SvDTO svDTO) throws Exception;

    public void sw1_on(SvDTO svDTO) throws Exception;

    public void sw1_off(SvDTO svDTO) throws Exception;

    public void sw2_on(SvDTO svDTO) throws Exception;

    public void sw2_off(SvDTO svDTO) throws Exception;

    public Integer time_sw1(int num) throws Exception;

    public Integer time_sw2(int num) throws Exception;

    public int getThreadCount() throws Exception;

    public int updateThreadCount(int num) throws Exception;
}
