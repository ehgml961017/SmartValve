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
}
