package com.service.fe;

import com.dao.fe.FatherCateDao;
import com.entity.fe.FatherCateEntity;
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
