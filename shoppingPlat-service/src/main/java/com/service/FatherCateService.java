package com.service;

import com.dao.FatherCateDao;
import com.entity.FatherCateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class FatherCateService  {
    @Autowired
    private FatherCateDao dao;

    public List<FatherCateEntity> getAll() {
        return dao.getAll();
    }
}
