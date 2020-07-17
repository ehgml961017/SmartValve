package com.springboot.smartvalve.dao;

import com.springboot.smartvalve.dto.SvDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SvdaoImpl implements Svdao{
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<SvDTO> getValue() {
        return null;
    }

    @Override
    public List<SvDTO> insertValue(SvDTO svDTO) {
        return null;
    }
}
