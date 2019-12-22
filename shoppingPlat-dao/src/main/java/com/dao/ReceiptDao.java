package com.dao;

import com.entity.ReceiptEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface ReceiptDao {
    void insert(ReceiptEntity receiptEntity);

    void update(@Param("status") int status,@Param("id") int id);

    List<ReceiptEntity> getAll(@Param("uid") int id);

    ReceiptEntity getById(@Param("rid") int rid,@Param("uid") int uid);

}
