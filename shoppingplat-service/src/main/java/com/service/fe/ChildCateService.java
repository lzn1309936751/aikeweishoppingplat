package com.service.fe;

import com.dao.fe.ChildCateDao;
import com.entity.fe.ChildCateEntity;
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

    public List<ChildCateEntity> getAll() {
        return dao.getAll();
    }
}
