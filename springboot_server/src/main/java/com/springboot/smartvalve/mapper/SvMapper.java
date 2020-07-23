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
    public Integer time(int num) throws Exception;

}
