package com.springboot.smartvalve.mapper;

import com.springboot.smartvalve.dto.SvDTO;

import java.util.List;

public interface SvMapper {
    public List<SvDTO> getValue() throws Exception;
    public void insertValue(SvDTO svDTO) throws Exception;

}
