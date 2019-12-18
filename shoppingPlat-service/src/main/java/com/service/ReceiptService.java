package com.service;

import com.dao.ReceiptDao;
import com.entity.ReceiptEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class ReceiptService {
    @Autowired
    private ReceiptDao dao;

    public ReceiptEntity insert(ReceiptEntity receiptEntity) {
        return dao.insert(receiptEntity);
    }

    public void update(int status, int id) {
        dao.update(status,id);
    }

    public List<ReceiptEntity> getAll(int id){
        return dao.getAll(id);
    }

    public ReceiptEntity getById(int rid,int uid){
        return dao.getById(rid,uid);
    }
}
