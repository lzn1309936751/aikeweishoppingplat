package com.service;

import com.dao.OrderDao;
import com.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzn
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao dao;


    public void insert(OrderEntity orderEntity) {
         dao.insert(orderEntity);
    }

    public List<OrderEntity> getAll(int pageNum, int pageSize,int uid) {
        return dao.getAll(pageNum,pageSize,uid);
    }

    public List<OrderEntity> getByStatus( int pageNum, int pageSize,String status,int uid) {
        return dao.getByStatus(pageNum,pageSize,status,uid);
    }
}
