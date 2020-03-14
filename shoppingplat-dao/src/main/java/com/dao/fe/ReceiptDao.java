package com.dao.fe;

import com.entity.fe.ReceiptEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface ReceiptDao {
    void insert(ReceiptEntity receiptEntity);

    void update(@Param("receipt") ReceiptEntity receiptEntity,@Param("id") int id);

    List<ReceiptEntity> getAll(@Param("uid") int id);

    ReceiptEntity getById(@Param("rid") int rid,@Param("uid") int uid);

    void delete(@Param("rid") int rid,@Param("uid") int uid);

}
