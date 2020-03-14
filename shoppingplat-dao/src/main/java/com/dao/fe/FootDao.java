package com.dao.fe;

import com.entity.fe.CollectEntity;
import com.entity.fe.FootEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface FootDao {
    void insert(FootEntity collects);

    List<FootEntity> getAll(int user_id);

    void delete(@Param("userId") Integer userId, @Param("proId") Integer proId);

}
