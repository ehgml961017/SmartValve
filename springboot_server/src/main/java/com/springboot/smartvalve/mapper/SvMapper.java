package com.springboot.smartvalve.mapper;

import com.springboot.smartvalve.dto.SvDTO;

import java.util.List;

/**
 * 데이터수집값 DB처리 작업 인터페이스
 */
public interface SvMapper {
    List<SvDTO> getValue() throws Exception;

    void insertValue(SvDTO svDTO) throws Exception;

    void sw1_on(SvDTO svDTO) throws Exception;

    void sw1_off(SvDTO svDTO) throws Exception;

    void sw2_on(SvDTO svDTO) throws Exception;

    void sw2_off(SvDTO svDTO) throws Exception;

    Integer time_sw1(int num) throws Exception;

    Integer time_sw2(int num) throws Exception;
}
