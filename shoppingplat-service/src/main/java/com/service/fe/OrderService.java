package com.service.fe;

import com.dao.fe.OrderDao;
import com.entity.fe.OrderEntity;
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

    public List<OrderEntity> getByOrderStatus( int pageNum, int pageSize,String status,int uid) {
        return dao.getByOrderStatus(pageNum,pageSize,status,uid);
    }

    public List<OrderEntity> getByAppriseStatus( int pageNum, int pageSize,String order_status,int apprise_status,int uid) {
        return dao.getByAppriseStatus(pageNum,pageSize,order_status,apprise_status,uid);
    }

//    public void deleteByAid(int pid,int uid){
//        dao.deleteByAid(pid,uid);
//    }
}
