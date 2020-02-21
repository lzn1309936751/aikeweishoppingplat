package com.dao.fe;

import com.entity.fe.OrderEntity;
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

    List<OrderEntity> getByOrderStatus(@Param("pageNum") int pageNum,
                             @Param("pageSize") int pageSize,
                             @Param("order_status") String status,
                             @Param("uid") int uid);

    List<OrderEntity> getByAppriseStatus(@Param("pageNum") int pageNum,
                                       @Param("pageSize") int pageSize,
                                       @Param("order_status") String order_status,
                                       @Param("apprise_status") int apprise_status,
                                       @Param("uid") int uid);

    void deleteByAid(@Param("pid") int pid, @Param("uid") int uid);
}
