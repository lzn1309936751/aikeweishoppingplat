package com.dao.fe;

import com.entity.fe.AppriseEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzn
 */
public interface AppriseDao {
    List<AppriseEntity> getByApprise(@Param("grade") String grade);

    void insert(AppriseEntity entity);
}
