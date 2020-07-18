package com.springboot.smartvalve.service;

import com.springboot.smartvalve.dto.SvDTO;
import com.springboot.smartvalve.mapper.SvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class SvService {
    @Autowired
    SvMapper svMapper;

    public List<SvDTO> getValue() throws Exception {
        return svMapper.getValue();
    }

    public void insertValue(SvDTO dto) throws Exception {
        svMapper.insertValue(dto);
    }
}
