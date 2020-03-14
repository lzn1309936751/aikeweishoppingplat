package com.dao.fe;

import com.entity.fe.CartEntity;
import com.entity.fe.CollectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface CollectDao {
    void insert(CollectEntity collects);

    List<CollectEntity> getAll(int user_id);

    void delete(@Param("userId") Integer userId,@Param("proId") Integer proId);

}
