package com.dao;

import com.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface OrderDao {
    void insert(OrderEntity orderEntity);

    List<OrderEntity> getAll(@Param("pageNum") int pageNum,
                             @Param("pageSize") int pageSize,
                             @Param("uid") int uid);

    List<OrderEntity> getByStatus(@Param("pageNum") int pageNum,
                             @Param("pageSize") int pageSize,
                             @Param("status") String status,
                             @Param("uid") int uid);
}
