package com.service;

import com.dao.ChildCateDao;
import com.entity.ChildCateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class ChildCateService {
    @Autowired
    private ChildCateDao dao;

    public List<ChildCateEntity> getById(int father_id) {
        return dao.getById(father_id);
    }
}
