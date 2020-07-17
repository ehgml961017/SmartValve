package com.springboot.smartvalve.dao;

import com.springboot.smartvalve.dto.SvDTO;

import java.util.List;

public interface Svdao {
    public List<SvDTO> getValue();
    public List<SvDTO> insertValue();
}
