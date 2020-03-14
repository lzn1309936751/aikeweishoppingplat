package com.service.fe;

import com.dao.fe.ReceiptDao;
import com.entity.fe.ReceiptEntity;
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

    public void insert(ReceiptEntity receiptEntity) {
         dao.insert(receiptEntity);
    }

    public void update(ReceiptEntity receiptEntity, int id) {
        dao.update(receiptEntity,id);
    }

    public List<ReceiptEntity> getAll(int id){
        return dao.getAll(id);
    }

    public ReceiptEntity getById(int rid,int uid){
        return dao.getById(rid,uid);
    }
}
